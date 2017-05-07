// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient;

import android.util.DisplayMetrics;
import android.content.res.Resources;
import com.netflix.mediaclient.util.StringUtils;
import java.util.Locale;
import com.netflix.mediaclient.repository.UserLocale;
import com.netflix.mediaclient.event.UIEvent;
import android.app.Application$ActivityLifecycleCallbacks;
import com.netflix.mediaclient.service.pservice.PServiceWidgetProvider;
import com.netflix.mediaclient.util.AndroidUtils;
import android.content.res.Configuration;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat$Builder;
import com.netflix.mediaclient.util.IntentUtils;
import com.netflix.mediaclient.util.AndroidManifestUtils;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.ui.launch.LaunchActivity;
import com.netflix.mediaclient.android.app.UserInputManager;
import java.util.concurrent.atomic.AtomicBoolean;
import com.netflix.mediaclient.util.gfx.BitmapLruCache;
import java.util.TimerTask;
import java.util.Timer;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.google.gson.Gson;
import android.app.Application;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class NetflixApplication$1 extends BroadcastReceiver
{
    final /* synthetic */ NetflixApplication this$0;
    
    NetflixApplication$1(final NetflixApplication this$0) {
        this.this$0 = this$0;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        if (Log.isLoggable()) {
            Log.v("NetflixApplication", "Received intent " + intent);
        }
        final String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.NETFLIX_SERVICE_DESTROYED".equals(action)) {
            Log.d("NetflixApplication", "Netflix service is destroyed");
            this.this$0.mIsNetflixServiceReady.set(false);
        }
        else if ("com.netflix.mediaclient.intent.action.NETFLIX_SERVICE_INIT_COMPLETE".equals(action)) {
            final StatusCode statusCode = (StatusCode)intent.getSerializableExtra("status_code");
            if (Log.isLoggable()) {
                Log.d("NetflixApplication", "Netflix service is ready with status " + statusCode);
            }
            if (statusCode.isSucess()) {
                Log.d("NetflixApplication", " Netflix application is ready");
                this.this$0.mIsNetflixServiceReady.set(true);
                return;
            }
            Log.d("NetflixApplication", " Netflix application is NOT ready");
            this.this$0.mIsNetflixServiceReady.set(false);
        }
        else if (Log.isLoggable()) {
            Log.d("NetflixApplication", "We do not support action " + action);
        }
    }
}
