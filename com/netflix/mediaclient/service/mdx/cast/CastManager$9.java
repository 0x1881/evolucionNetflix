// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.mdx.cast;

import com.netflix.mediaclient.service.configuration.SettingsConfiguration;
import android.support.v7.media.MediaRouter$ProviderInfo;
import com.netflix.mediaclient.util.StringUtils;
import org.json.JSONException;
import com.netflix.mediaclient.Log;
import org.json.JSONObject;
import com.google.android.gms.cast.CastDevice;
import java.util.ArrayList;
import org.json.JSONArray;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouteSelector;
import com.netflix.mediaclient.service.mdx.MdxNrdpLogger;
import android.os.Handler;
import android.support.v7.media.MediaRouter$RouteInfo;
import java.util.List;
import android.content.Context;
import android.support.v7.media.MediaRouter$Callback;

class CastManager$9 implements Runnable
{
    final /* synthetic */ CastManager this$0;
    final /* synthetic */ String val$msg;
    final /* synthetic */ String val$reqUrl;
    final /* synthetic */ String val$uuid;
    
    CastManager$9(final CastManager this$0, final String val$msg, final String val$uuid, final String val$reqUrl) {
        this.this$0 = this$0;
        this.val$msg = val$msg;
        this.val$uuid = val$uuid;
        this.val$reqUrl = val$reqUrl;
    }
    
    @Override
    public void run() {
        this.this$0.nativeMessageReceived(this.val$msg, this.val$uuid, this.val$reqUrl);
    }
}
