// 
// Decompiled by Procyon v0.5.30
// 

package com.vailsys.whistleengine;

import android.os.Build$VERSION;
import android.os.IBinder;
import android.content.Intent;
import java.util.Iterator;
import java.util.Map;
import android.os.Handler;
import android.content.Context;
import android.app.Service;

class WhistleEngine$9 implements Runnable
{
    final /* synthetic */ WhistleEngine this$0;
    
    WhistleEngine$9(final WhistleEngine this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        if (this.this$0.eventListener != null) {
            this.this$0.eventListener.registrationSuccessful();
        }
    }
}
