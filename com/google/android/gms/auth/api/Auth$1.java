// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.auth.api;

import com.google.android.gms.common.api.Api$zzb;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.internal.zzf;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.common.api.Api$zza;

final class Auth$1 extends Api$zza<zzjw, Auth$zza>
{
    @Override
    public zzjw zza(final Context context, final Looper looper, final zzf zzf, final Auth$zza auth$zza, final GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, final GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        return new zzjw(context, looper, zzf, auth$zza, googleApiClient$ConnectionCallbacks, googleApiClient$OnConnectionFailedListener);
    }
}
