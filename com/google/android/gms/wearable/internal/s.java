// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.wearable.c;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class s implements Parcelable$Creator<r>
{
    static void a(final r r, final Parcel parcel, final int n) {
        final int d = b.D(parcel);
        b.c(parcel, 1, r.versionCode);
        b.c(parcel, 2, r.statusCode);
        b.a(parcel, 3, (Parcelable)r.avm, n, false);
        b.H(parcel, d);
    }
    
    public r dW(final Parcel parcel) {
        int g = 0;
        final int c = a.C(parcel);
        c c2 = null;
        int g2 = 0;
        while (parcel.dataPosition() < c) {
            final int b = a.B(parcel);
            switch (a.aD(b)) {
                default: {
                    a.b(parcel, b);
                    continue;
                }
                case 1: {
                    g2 = a.g(parcel, b);
                    continue;
                }
                case 2: {
                    g = a.g(parcel, b);
                    continue;
                }
                case 3: {
                    c2 = a.a(parcel, b, com.google.android.gms.wearable.c.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != c) {
            throw new a$a("Overread allowed size end=" + c, parcel);
        }
        return new r(g2, g, c2);
    }
    
    public r[] fY(final int n) {
        return new r[n];
    }
}
