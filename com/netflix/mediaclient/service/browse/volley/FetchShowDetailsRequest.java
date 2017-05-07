// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.browse.volley;

import com.netflix.mediaclient.service.webclient.model.branches.Video$Bookmark;
import com.google.gson.JsonObject;
import com.netflix.mediaclient.service.webclient.model.branches.Episode$Detail;
import com.netflix.mediaclient.service.webclient.model.leafs.social.SocialEvidence;
import com.netflix.mediaclient.service.webclient.model.branches.Video$InQueue;
import com.netflix.mediaclient.service.webclient.model.branches.Video$UserRating;
import com.netflix.mediaclient.service.webclient.model.branches.Video$Detail;
import com.netflix.mediaclient.service.webclient.model.branches.Video$Summary;
import com.netflix.mediaclient.service.webclient.volley.FalcorParseException;
import com.netflix.mediaclient.service.webclient.volley.FalcorParseUtils;
import com.netflix.mediaclient.android.app.CommonStatus;
import com.netflix.mediaclient.android.app.Status;
import java.util.Arrays;
import java.util.List;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.util.StringUtils;
import android.content.Context;
import com.netflix.mediaclient.service.browse.BrowseAgentCallback;
import com.netflix.mediaclient.service.browse.cache.BrowseWebClientCache;
import com.netflix.mediaclient.servicemgr.model.details.ShowDetails;
import com.netflix.mediaclient.service.webclient.volley.FalcorVolleyWebClientRequest;

public class FetchShowDetailsRequest extends FalcorVolleyWebClientRequest<ShowDetails>
{
    private static final String FIELD_VIDEOS = "videos";
    private static final String TAG = "nf_service_browse_fetchshowdetailsrequest";
    private BrowseWebClientCache browseCache;
    private final boolean isCurrentEpisodeLocal;
    private final String mReqEpisodeId;
    private final String mShowId;
    private final String pqlQuery;
    private final String pqlQuery2;
    private final BrowseAgentCallback responseCallback;
    private final boolean userConnectedToFacebook;
    
    public FetchShowDetailsRequest(final Context context, final BrowseWebClientCache browseCache, final String mShowId, final String mReqEpisodeId, final boolean userConnectedToFacebook, final BrowseAgentCallback responseCallback) {
        super(context);
        this.responseCallback = responseCallback;
        this.mShowId = mShowId;
        this.mReqEpisodeId = mReqEpisodeId;
        this.isCurrentEpisodeLocal = StringUtils.isNotEmpty(this.mReqEpisodeId);
        this.userConnectedToFacebook = userConnectedToFacebook;
        this.browseCache = browseCache;
        this.pqlQuery = String.format("['videos','%s',['summary','detail', 'rating', 'inQueue', 'socialEvidence']]", this.mShowId);
        if (this.isCurrentEpisodeLocal) {
            this.pqlQuery2 = String.format("['episodes','%s', ['detail', 'bookmark']]", this.mReqEpisodeId);
        }
        else {
            this.pqlQuery2 = String.format("['videos','%s','episodes', 'current', ['detail', 'bookmark']]", this.mShowId);
        }
        if (Log.isLoggable("nf_service_browse_fetchshowdetailsrequest", 2)) {
            Log.v("nf_service_browse_fetchshowdetailsrequest", "PQL = " + this.pqlQuery + this.pqlQuery2);
        }
    }
    
    @Override
    protected List<String> getPQLQueries() {
        return Arrays.asList(this.pqlQuery, this.pqlQuery2);
    }
    
    @Override
    protected void onFailure(final Status status) {
        if (this.responseCallback != null) {
            this.responseCallback.onShowDetailsFetched(null, status);
        }
    }
    
    @Override
    protected void onSuccess(final ShowDetails showDetails) {
        if (this.responseCallback != null) {
            this.responseCallback.onShowDetailsFetched(showDetails, CommonStatus.OK);
        }
    }
    
    @Override
    protected ShowDetails parseFalcorResponse(String s) {
        if (Log.isLoggable("nf_service_browse_fetchshowdetailsrequest", 2)) {
            Log.v("nf_service_browse_fetchshowdetailsrequest", "String response to parse = " + s);
        }
        final com.netflix.mediaclient.service.webclient.model.ShowDetails showDetails = new com.netflix.mediaclient.service.webclient.model.ShowDetails();
        final JsonObject dataObj = FalcorParseUtils.getDataObj("nf_service_browse_fetchshowdetailsrequest", s);
        if (FalcorParseUtils.isEmpty(dataObj)) {
            throw new FalcorParseException("ShowDetails empty!!!");
        }
        while (true) {
            while (true) {
                try {
                    final JsonObject asJsonObject = dataObj.getAsJsonObject("videos").getAsJsonObject(this.mShowId);
                    showDetails.summary = FalcorParseUtils.getPropertyObject(asJsonObject, "summary", Video$Summary.class);
                    showDetails.detail = FalcorParseUtils.getPropertyObject(asJsonObject, "detail", Video$Detail.class);
                    showDetails.rating = FalcorParseUtils.getPropertyObject(asJsonObject, "rating", Video$UserRating.class);
                    showDetails.inQueue = FalcorParseUtils.getPropertyObject(asJsonObject, "inQueue", Video$InQueue.class);
                    showDetails.socialEvidence = FalcorParseUtils.getPropertyObject(asJsonObject, "socialEvidence", SocialEvidence.class);
                    if (!this.isCurrentEpisodeLocal) {
                        if (asJsonObject.has("episodes")) {
                            s = (String)asJsonObject.getAsJsonObject("episodes");
                            if (((JsonObject)s).has("current")) {
                                s = (String)((JsonObject)s).getAsJsonObject("current");
                                showDetails.currentEpisode = FalcorParseUtils.getPropertyObject((JsonObject)s, "detail", Episode$Detail.class);
                                showDetails.currentEpisodeBookmark = FalcorParseUtils.getPropertyObject((JsonObject)s, "bookmark", Video$Bookmark.class);
                            }
                        }
                        showDetails.userConnectedToFacebook = this.userConnectedToFacebook;
                        showDetails.inQueue = this.browseCache.updateInQueueCacheRecord(showDetails.getId(), showDetails.inQueue);
                        return showDetails;
                    }
                }
                catch (Exception ex) {
                    Log.v("nf_service_browse_fetchshowdetailsrequest", "String response to parse = " + s);
                    throw new FalcorParseException("response missing expected json objects", ex);
                }
                if (!dataObj.has("episodes")) {
                    continue;
                }
                final JsonObject asJsonObject2 = dataObj.getAsJsonObject("episodes");
                try {
                    final JsonObject asJsonObject3 = asJsonObject2.getAsJsonObject(this.mReqEpisodeId);
                    showDetails.currentEpisode = FalcorParseUtils.getPropertyObject(asJsonObject3, "detail", Episode$Detail.class);
                    showDetails.currentEpisodeBookmark = FalcorParseUtils.getPropertyObject(asJsonObject3, "bookmark", Video$Bookmark.class);
                    continue;
                }
                catch (Exception ex2) {
                    Log.v("nf_service_browse_fetchshowdetailsrequest", "String response to parse = " + s);
                    throw new FalcorParseException("response missing expected json objects", ex2);
                }
                break;
            }
        }
    }
}
