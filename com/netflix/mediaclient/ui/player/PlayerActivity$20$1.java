// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.player;

import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.SimpleManagerCallback;

class PlayerActivity$20$1 extends SimpleManagerCallback
{
    final /* synthetic */ PlayerActivity$20 this$1;
    
    PlayerActivity$20$1(final PlayerActivity$20 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void onVideoHide(final Status status) {
        if (Log.isLoggable("PlayerActivity", 3)) {
            Log.d("PlayerActivity", "Video is hidden status code " + status.getStatusCode());
        }
    }
}
