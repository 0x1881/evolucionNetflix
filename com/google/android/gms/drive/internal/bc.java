// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class bc implements Parcelable$Creator<TrashResourceRequest>
{
    static void a(final TrashResourceRequest trashResourceRequest, final Parcel parcel, final int n) {
        final int d = b.D(parcel);
        b.c(parcel, 1, trashResourceRequest.BR);
        b.a(parcel, 2, (Parcelable)trashResourceRequest.NV, n, false);
        b.H(parcel, d);
    }
    
    public TrashResourceRequest aC(final Parcel parcel) {
        final int c = a.C(parcel);
        int g = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < c) {
            final int b = a.B(parcel);
            switch (a.aD(b)) {
                default: {
                    a.b(parcel, b);
                    continue;
                }
                case 1: {
                    g = a.g(parcel, b);
                    continue;
                }
                case 2: {
                    driveId = a.a(parcel, b, DriveId.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != c) {
            throw new a$a("Overread allowed size end=" + c, parcel);
        }
        return new TrashResourceRequest(g, driveId);
    }
    
    public TrashResourceRequest[] bO(final int n) {
        return new TrashResourceRequest[n];
    }
}
