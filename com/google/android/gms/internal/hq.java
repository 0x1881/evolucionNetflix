// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hq implements SafeParcelable
{
    public static final hr CREATOR;
    final int BR;
    public final String Co;
    public final boolean Cp;
    public final boolean Cq;
    public final String Cr;
    public final hk[] Cs;
    final int[] Ct;
    public final String Cu;
    public final String name;
    public final int weight;
    
    static {
        CREATOR = new hr();
    }
    
    hq(final int br, final String name, final String co, final boolean cp, final int weight, final boolean cq, final String cr, final hk[] cs, final int[] ct, final String cu) {
        this.BR = br;
        this.name = name;
        this.Co = co;
        this.Cp = cp;
        this.weight = weight;
        this.Cq = cq;
        this.Cr = cr;
        this.Cs = cs;
        this.Ct = ct;
        this.Cu = cu;
    }
    
    hq(final String s, final String s2, final boolean b, final int n, final boolean b2, final String s3, final hk[] array, final int[] array2, final String s4) {
        this(2, s, s2, b, n, b2, s3, array, array2, s4);
    }
    
    public int describeContents() {
        final hr creator = hq.CREATOR;
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof hq) {
            final hq hq = (hq)o;
            b2 = b;
            if (this.name.equals(hq.name)) {
                b2 = b;
                if (this.Co.equals(hq.Co)) {
                    b2 = b;
                    if (this.Cp == hq.Cp) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hr creator = hq.CREATOR;
        hr.a(this, parcel, n);
    }
}
