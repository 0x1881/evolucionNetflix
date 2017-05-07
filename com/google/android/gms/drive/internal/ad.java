// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.os.RemoteException;
import android.os.IInterface;

public interface ad extends IInterface
{
    void c(final OnEventResponse p0) throws RemoteException;
    
    public abstract static class a extends Binder implements ad
    {
        public a() {
            this.attachInterface((IInterface)this, "com.google.android.gms.drive.internal.IEventCallback");
        }
        
        public static ad W(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
            if (queryLocalInterface != null && queryLocalInterface instanceof ad) {
                return (ad)queryLocalInterface;
            }
            return new ad.a.a(binder);
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            switch (n) {
                default: {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.drive.internal.IEventCallback");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
                    OnEventResponse onEventResponse;
                    if (parcel.readInt() != 0) {
                        onEventResponse = (OnEventResponse)OnEventResponse.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        onEventResponse = null;
                    }
                    this.c(onEventResponse);
                    parcel2.writeNoException();
                    return true;
                }
            }
        }
        
        private static class a implements ad
        {
            private IBinder lb;
            
            a(final IBinder lb) {
                this.lb = lb;
            }
            
            public IBinder asBinder() {
                return this.lb;
            }
            
            @Override
            public void c(final OnEventResponse onEventResponse) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IEventCallback");
                    if (onEventResponse != null) {
                        obtain.writeInt(1);
                        onEventResponse.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
