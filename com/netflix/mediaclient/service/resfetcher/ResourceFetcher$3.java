// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.resfetcher;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import com.netflix.mediaclient.Log;
import com.android.volley.VolleyError;
import com.android.volley.Response$ErrorListener;

class ResourceFetcher$3 implements Response$ErrorListener
{
    final /* synthetic */ ResourceFetcher this$0;
    final /* synthetic */ ResourceFetcherCallback val$realCallback;
    final /* synthetic */ String val$resourceUrl;
    
    ResourceFetcher$3(final ResourceFetcher this$0, final ResourceFetcherCallback val$realCallback, final String val$resourceUrl) {
        this.this$0 = this$0;
        this.val$realCallback = val$realCallback;
        this.val$resourceUrl = val$resourceUrl;
    }
    
    @Override
    public void onErrorResponse(final VolleyError volleyError) {
        Log.e("nf_service_resourcefetcher", "fetchAndCacheResource failed: ", volleyError);
        if (this.val$realCallback != null) {
            this.val$realCallback.onResourceCached(this.val$resourceUrl, null, 0L, 0L, new NetworkErrorStatus(volleyError));
        }
    }
}
