// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;

public interface zzj
{
    void begin();
    
    void connect();
    
    void disconnect();
    
    String getName();
    
    void onConnected(final Bundle p0);
    
    void onConnectionSuspended(final int p0);
    
     <A extends Api$zzb, R extends Result, T extends zzc$zza<R, A>> T zza(final T p0);
    
    void zza(final ConnectionResult p0, final Api<?> p1, final int p2);
    
     <A extends Api$zzb, T extends zzc$zza<? extends Result, A>> T zzb(final T p0);
}
