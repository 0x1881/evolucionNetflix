// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.drive.DriveId;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDriveIdResponse implements SafeParcelable
{
    public static final Parcelable$Creator<OnDriveIdResponse> CREATOR;
    final int BR;
    DriveId NV;
    
    static {
        CREATOR = (Parcelable$Creator)new ak();
    }
    
    OnDriveIdResponse(final int br, final DriveId nv) {
        this.BR = br;
        this.NV = nv;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public DriveId getDriveId() {
        return this.NV;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ak.a(this, parcel, n);
    }
}
