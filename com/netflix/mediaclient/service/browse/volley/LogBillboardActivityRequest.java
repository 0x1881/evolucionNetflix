// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.browse.volley;

import com.google.gson.JsonObject;
import com.netflix.mediaclient.service.webclient.volley.FalcorParseException;
import com.netflix.mediaclient.service.webclient.volley.FalcorParseUtils;
import com.netflix.mediaclient.android.app.Status;
import java.util.Arrays;
import java.util.List;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.service.browse.BrowseAgent$BillboardActivityType;
import com.netflix.mediaclient.servicemgr.model.Video;
import android.content.Context;
import com.netflix.mediaclient.service.webclient.volley.FalcorVolleyWebClientRequest;

public class LogBillboardActivityRequest extends FalcorVolleyWebClientRequest<String>
{
    private static final String TAG = "LogBillboardActivityRequest";
    private final String pqlQuery;
    
    public LogBillboardActivityRequest(final Context context, final Video video, final BrowseAgent$BillboardActivityType browseAgent$BillboardActivityType) {
        super(context);
        this.pqlQuery = String.format("['logBillboardActivity', '%s', '%s']", video.getId(), browseAgent$BillboardActivityType.getName());
        if (Log.isLoggable("LogBillboardActivityRequest", 2)) {
            Log.v("LogBillboardActivityRequest", "PQL = " + this.pqlQuery);
        }
    }
    
    @Override
    protected List<String> getPQLQueries() {
        return Arrays.asList(this.pqlQuery);
    }
    
    @Override
    protected void onFailure(final Status status) {
        if (Log.isLoggable("LogBillboardActivityRequest", 2)) {
            Log.v("LogBillboardActivityRequest", "onFailure, statusCode:" + status);
        }
    }
    
    @Override
    protected void onSuccess(final String s) {
        Log.v("LogBillboardActivityRequest", "onSuccess");
    }
    
    @Override
    protected String parseFalcorResponse(final String s) {
        if (Log.isLoggable("LogBillboardActivityRequest", 2)) {
            Log.v("LogBillboardActivityRequest", "parseFalcorResponse: " + s);
        }
        final JsonObject dataObj = FalcorParseUtils.getDataObj("LogBillboardActivityRequest", s);
        if (FalcorParseUtils.isEmpty(dataObj)) {
            throw new FalcorParseException("Empty value");
        }
        return dataObj.toString();
    }
}
