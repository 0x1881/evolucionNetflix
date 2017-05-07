// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.drive.realtime.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import android.os.Binder;

public abstract class j$a extends Binder implements j
{
    public static j af(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
        if (queryLocalInterface != null && queryLocalInterface instanceof j) {
            return (j)queryLocalInterface;
        }
        return new j$a$a(binder);
    }
    
    public IBinder asBinder() {
        return (IBinder)this;
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        final Status status = null;
        ParcelableEventList list = null;
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.drive.realtime.internal.IEventCallback");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                if (parcel.readInt() != 0) {
                    list = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(parcel);
                }
                this.a(list);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                Status fromParcel = status;
                if (parcel.readInt() != 0) {
                    fromParcel = Status.CREATOR.createFromParcel(parcel);
                }
                this.o(fromParcel);
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
