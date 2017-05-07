// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.pushnotification;

import android.annotation.SuppressLint;
import com.netflix.mediaclient.servicemgr.IClientLogging$AssetType;
import com.netflix.mediaclient.util.StringUtils;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.servicemgr.ErrorLogging;
import android.content.Context;
import android.app.Notification$Builder;
import com.netflix.mediaclient.util.gfx.ImageLoader$ImageLoaderListener;

final class NotificationBuilderHoneycomb$1 implements ImageLoader$ImageLoaderListener
{
    final /* synthetic */ Notification$Builder val$builder;
    final /* synthetic */ Context val$context;
    final /* synthetic */ ErrorLogging val$errorLogger;
    final /* synthetic */ int val$msgId;
    final /* synthetic */ Payload val$payload;
    
    NotificationBuilderHoneycomb$1(final Payload val$payload, final Notification$Builder val$builder, final Context val$context, final int val$msgId, final ErrorLogging val$errorLogger) {
        this.val$payload = val$payload;
        this.val$builder = val$builder;
        this.val$context = val$context;
        this.val$msgId = val$msgId;
        this.val$errorLogger = val$errorLogger;
    }
    
    @Override
    public void onErrorResponse(final String s) {
        if (Log.isLoggable("nf_push", 6)) {
            Log.e("nf_push", "Failed to downlod " + this.val$payload.largeIcon + ". Reason: " + s);
        }
    }
    
    @Override
    public void onResponse(final Bitmap largeIcon, final String s) {
        if (Log.isLoggable("nf_push", 3)) {
            Log.d("nf_push", "Image is downloaded " + this.val$payload.largeIcon + " from " + s);
        }
        if (largeIcon != null) {
            this.val$builder.setLargeIcon(largeIcon);
        }
        send(this.val$context, this.val$builder, this.val$msgId, this.val$errorLogger);
        Log.d("nf_push", "Image set!");
    }
}
