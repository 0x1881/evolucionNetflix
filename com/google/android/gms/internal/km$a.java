// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.internal;

import com.google.android.gms.fitness.result.DataSourcesResult;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract class km$a extends Binder implements km
{
    public km$a() {
        this.attachInterface((IInterface)this, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
    }
    
    public static km aq(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
        if (queryLocalInterface != null && queryLocalInterface instanceof km) {
            return (km)queryLocalInterface;
        }
        return new km$a$a(binder);
    }
    
    public IBinder asBinder() {
        return (IBinder)this;
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                DataSourcesResult dataSourcesResult;
                if (parcel.readInt() != 0) {
                    dataSourcesResult = (DataSourcesResult)DataSourcesResult.CREATOR.createFromParcel(parcel);
                }
                else {
                    dataSourcesResult = null;
                }
                this.a(dataSourcesResult);
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
