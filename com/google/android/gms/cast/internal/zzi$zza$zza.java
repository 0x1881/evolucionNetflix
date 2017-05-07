// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.LaunchOptions;
import android.os.Parcel;
import android.os.IBinder;

class zzi$zza$zza implements zzi
{
    private IBinder zznI;
    
    zzi$zza$zza(final IBinder zznI) {
        this.zznI = zznI;
    }
    
    public IBinder asBinder() {
        return this.zznI;
    }
    
    @Override
    public void disconnect() {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.zznI.transact(1, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zza(final double n, final double n2, final boolean b) {
        int n3 = 1;
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeDouble(n);
            obtain.writeDouble(n2);
            if (!b) {
                n3 = 0;
            }
            obtain.writeInt(n3);
            this.zznI.transact(7, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zza(final String s, final LaunchOptions launchOptions) {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(s);
            if (launchOptions != null) {
                obtain.writeInt(1);
                launchOptions.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.zznI.transact(13, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zza(final String s, final String s2, final long n) {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(s);
            obtain.writeString(s2);
            obtain.writeLong(n);
            this.zznI.transact(9, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zza(final String s, final byte[] array, final long n) {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(s);
            obtain.writeByteArray(array);
            obtain.writeLong(n);
            this.zznI.transact(10, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zza(final boolean b, final double n, final boolean b2) {
        final boolean b3 = true;
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            int n2;
            if (b) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            obtain.writeInt(n2);
            obtain.writeDouble(n);
            int n3;
            if (b2) {
                n3 = (b3 ? 1 : 0);
            }
            else {
                n3 = 0;
            }
            obtain.writeInt(n3);
            this.zznI.transact(8, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zzbO(final String s) {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(s);
            this.zznI.transact(5, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zzbP(final String s) {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(s);
            this.zznI.transact(11, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zzbQ(final String s) {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(s);
            this.zznI.transact(12, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zzf(final String s, final boolean b) {
        int n = 1;
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(s);
            if (!b) {
                n = 0;
            }
            obtain.writeInt(n);
            this.zznI.transact(2, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zzmI() {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.zznI.transact(4, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zzmx() {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.zznI.transact(6, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void zzt(final String s, final String s2) {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            obtain.writeString(s);
            obtain.writeString(s2);
            this.zznI.transact(3, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
}
