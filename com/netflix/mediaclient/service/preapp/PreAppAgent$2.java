// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.preapp;

import android.content.ComponentName;
import com.netflix.mediaclient.ui.homescreen.NetflixAppWidgetProvider;
import android.appwidget.AppWidgetManager;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.app.CommonStatus;
import com.netflix.mediaclient.service.user.UserAgentBroadcastIntents;
import android.support.v4.content.LocalBroadcastManager;
import android.content.IntentFilter;
import com.netflix.mediaclient.service.ServiceAgent$PreAppAgentInterface;
import com.netflix.mediaclient.service.ServiceAgent;
import com.netflix.mediaclient.Log;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class PreAppAgent$2 extends BroadcastReceiver
{
    final /* synthetic */ PreAppAgent this$0;
    
    PreAppAgent$2(final PreAppAgent this$0) {
        this.this$0 = this$0;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        if (intent != null && "com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_DEACTIVE".equals(intent.getAction())) {
            Log.i("nf_preappagent", "UserAgentIntentReceiver inovoked and received Intent with Action NOTIFY_USER_PROFILE_DEACTIVE");
            this.this$0.handleProfileDeactive();
        }
    }
}
