// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.drive.realtime.internal.event;

import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class g implements Parcelable$Creator<ValueChangedDetails>
{
    static void a(final ValueChangedDetails valueChangedDetails, final Parcel parcel, int d) {
        d = b.D(parcel);
        b.c(parcel, 1, valueChangedDetails.BR);
        b.c(parcel, 2, valueChangedDetails.RE);
        b.H(parcel, d);
    }
    
    public ValueChangedDetails be(final Parcel parcel) {
        int g = 0;
        final int c = a.C(parcel);
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
            }
        }
        if (parcel.dataPosition() != c) {
            throw new a.a("Overread allowed size end=" + c, parcel);
        }
        return new ValueChangedDetails(g2, g);
    }
    
    public ValueChangedDetails[] cr(final int n) {
        return new ValueChangedDetails[n];
    }
}
