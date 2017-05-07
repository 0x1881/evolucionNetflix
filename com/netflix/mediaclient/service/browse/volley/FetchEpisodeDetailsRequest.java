// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.browse.volley;

import com.google.gson.JsonObject;
import com.netflix.mediaclient.service.webclient.model.branches.Video$UserRating;
import com.netflix.mediaclient.service.webclient.model.leafs.social.SocialEvidence;
import com.netflix.mediaclient.service.webclient.model.branches.Video$Bookmark;
import com.netflix.mediaclient.service.webclient.model.branches.Episode$Detail;
import com.netflix.mediaclient.service.webclient.volley.FalcorParseException;
import com.netflix.mediaclient.service.webclient.volley.FalcorParseUtils;
import com.netflix.mediaclient.android.app.CommonStatus;
import com.netflix.mediaclient.android.app.Status;
import java.util.Arrays;
import java.util.List;
import com.netflix.mediaclient.Log;
import android.content.Context;
import com.netflix.mediaclient.service.browse.BrowseAgentCallback;
import com.netflix.mediaclient.servicemgr.model.details.EpisodeDetails;
import com.netflix.mediaclient.service.webclient.volley.FalcorVolleyWebClientRequest;

public class FetchEpisodeDetailsRequest extends FalcorVolleyWebClientRequest<EpisodeDetails>
{
    private static final String FIELD_EPISODES = "episodes";
    private static final String TAG = "nf_service_browse_fetchepisodedetailsrequest";
    private final String mEpisodeId;
    private final String pqlQuery;
    private final BrowseAgentCallback responseCallback;
    private final boolean userConnectedToFacebook;
    
    public FetchEpisodeDetailsRequest(final Context context, final String mEpisodeId, final boolean userConnectedToFacebook, final BrowseAgentCallback responseCallback) {
        super(context);
        this.responseCallback = responseCallback;
        this.mEpisodeId = mEpisodeId;
        this.userConnectedToFacebook = userConnectedToFacebook;
        this.pqlQuery = String.format("['episodes','%s',['detail', 'summary', 'bookmark', 'socialEvidence', 'rating']]", this.mEpisodeId);
        if (Log.isLoggable("nf_service_browse_fetchepisodedetailsrequest", 2)) {
            Log.v("nf_service_browse_fetchepisodedetailsrequest", "PQL = " + this.pqlQuery);
        }
    }
    
    @Override
    protected List<String> getPQLQueries() {
        return Arrays.asList(this.pqlQuery);
    }
    
    @Override
    protected void onFailure(final Status status) {
        if (this.responseCallback != null) {
            this.responseCallback.onEpisodeDetailsFetched(null, status);
        }
    }
    
    @Override
    protected void onSuccess(final EpisodeDetails episodeDetails) {
        if (this.responseCallback != null) {
            this.responseCallback.onEpisodeDetailsFetched(episodeDetails, CommonStatus.OK);
        }
    }
    
    @Override
    protected EpisodeDetails parseFalcorResponse(final String s) {
        if (Log.isLoggable("nf_service_browse_fetchepisodedetailsrequest", 2)) {
            Log.v("nf_service_browse_fetchepisodedetailsrequest", "String response to parse = " + s);
        }
        final com.netflix.mediaclient.service.webclient.model.EpisodeDetails episodeDetails = new com.netflix.mediaclient.service.webclient.model.EpisodeDetails();
        final JsonObject dataObj = FalcorParseUtils.getDataObj("nf_service_browse_fetchepisodedetailsrequest", s);
        if (FalcorParseUtils.isEmpty(dataObj)) {
            throw new FalcorParseException("EpisodeDetails empty!!!");
        }
        try {
            final JsonObject asJsonObject = dataObj.getAsJsonObject("episodes").getAsJsonObject(this.mEpisodeId);
            episodeDetails.detail = FalcorParseUtils.getPropertyObject(asJsonObject, "detail", Episode$Detail.class);
            episodeDetails.bookmark = FalcorParseUtils.getPropertyObject(asJsonObject, "bookmark", Video$Bookmark.class);
            episodeDetails.showSocialEvidence = FalcorParseUtils.getPropertyObject(asJsonObject, "socialEvidence", SocialEvidence.class);
            episodeDetails.rating = FalcorParseUtils.getPropertyObject(asJsonObject, "rating", Video$UserRating.class);
            episodeDetails.userConnectedToFacebook = this.userConnectedToFacebook;
            return episodeDetails;
        }
        catch (Exception ex) {
            Log.v("nf_service_browse_fetchepisodedetailsrequest", "String response to parse = " + s);
            throw new FalcorParseException("response missing expected json objects", ex);
        }
    }
}
