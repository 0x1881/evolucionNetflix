// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DisconnectRequest implements SafeParcelable
{
    public static final Parcelable$Creator<DisconnectRequest> CREATOR;
    final int BR;
    
    static {
        CREATOR = (Parcelable$Creator)new n();
    }
    
    public DisconnectRequest() {
        this(1);
    }
    
    DisconnectRequest(final int br) {
        this.BR = br;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        n.a(this, parcel, n);
    }
}
