// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.BaseImplementation$b;
import com.google.android.gms.internal.ib;
import com.google.android.gms.common.api.Api$a;

final class AppStateManager$4 extends AppStateManager$e
{
    final /* synthetic */ int CX;
    final /* synthetic */ byte[] CY;
    
    AppStateManager$4(final int cx, final byte[] cy) {
        this.CX = cx;
        this.CY = cy;
        super((AppStateManager$1)null);
    }
    
    @Override
    protected void a(final ib ib) {
        ib.a((BaseImplementation$b<AppStateManager$StateResult>)this, this.CX, this.CY);
    }
}
