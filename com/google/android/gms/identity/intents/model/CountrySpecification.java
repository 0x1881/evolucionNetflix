// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable
{
    public static final Parcelable$Creator<CountrySpecification> CREATOR;
    private final int BR;
    String uW;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    CountrySpecification(final int br, final String uw) {
        this.BR = br;
        this.uW = uw;
    }
    
    public CountrySpecification(final String uw) {
        this.BR = 1;
        this.uW = uw;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getCountryCode() {
        return this.uW;
    }
    
    public int getVersionCode() {
        return this.BR;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        a.a(this, parcel, n);
    }
}
