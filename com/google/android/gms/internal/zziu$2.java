// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;
import android.content.DialogInterface$OnClickListener;

final class zziu$2 implements DialogInterface$OnClickListener
{
    final /* synthetic */ JsResult zzJx;
    
    zziu$2(final JsResult zzJx) {
        this.zzJx = zzJx;
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        this.zzJx.cancel();
    }
}
