// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.BaseImplementation$b;
import com.google.android.gms.common.api.Api$a;
import com.google.android.gms.fitness.request.i;
import com.google.android.gms.fitness.result.DataTypeResult;

class kx$2 extends kj$a<DataTypeResult>
{
    final /* synthetic */ kx Tv;
    final /* synthetic */ i Tw;
    
    kx$2(final kx tv, final i tw) {
        this.Tv = tv;
        this.Tw = tw;
    }
    
    @Override
    protected void a(final kj kj) {
        kj.iT().a(this.Tw, new kx$a(this, null), kj.getContext().getPackageName());
    }
    
    protected DataTypeResult x(final Status status) {
        return DataTypeResult.F(status);
    }
}
