// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.os.RemoteException;
import android.os.IInterface;

public interface cv extends IInterface
{
    void onAdClicked() throws RemoteException;
    
    void onAdClosed() throws RemoteException;
    
    void onAdFailedToLoad(final int p0) throws RemoteException;
    
    void onAdLeftApplication() throws RemoteException;
    
    void onAdLoaded() throws RemoteException;
    
    void onAdOpened() throws RemoteException;
    
    public abstract static class a extends Binder implements cv
    {
        public a() {
            this.attachInterface((IInterface)this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        }
        
        public static cv n(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            if (queryLocalInterface != null && queryLocalInterface instanceof cv) {
                return (cv)queryLocalInterface;
            }
            return new cv.a.a(binder);
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
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdClicked();
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdClosed();
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdFailedToLoad(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdLeftApplication();
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdOpened();
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdLoaded();
                    parcel2.writeNoException();
                    return true;
                }
            }
        }
        
        private static class a implements cv
        {
            private IBinder lb;
            
            a(final IBinder lb) {
                this.lb = lb;
            }
            
            public IBinder asBinder() {
                return this.lb;
            }
            
            @Override
            public void onAdClicked() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void onAdClosed() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void onAdFailedToLoad(final int n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    obtain.writeInt(n);
                    this.lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void onAdLeftApplication() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void onAdLoaded() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void onAdOpened() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.lb.transact(5, obtain, obtain2, 0);
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
