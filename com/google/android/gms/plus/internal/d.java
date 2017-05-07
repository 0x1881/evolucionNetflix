// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import com.google.android.gms.internal.jb;
import java.util.List;
import android.os.Bundle;
import android.net.Uri;
import com.google.android.gms.internal.jp;
import android.os.RemoteException;
import com.google.android.gms.common.internal.i;
import android.os.IInterface;

public interface d extends IInterface
{
    i a(final b p0, final int p1, final int p2, final int p3, final String p4) throws RemoteException;
    
    void a(final jp p0) throws RemoteException;
    
    void a(final b p0) throws RemoteException;
    
    void a(final b p0, final int p1, final String p2, final Uri p3, final String p4, final String p5) throws RemoteException;
    
    void a(final b p0, final Uri p1, final Bundle p2) throws RemoteException;
    
    void a(final b p0, final jp p1) throws RemoteException;
    
    void a(final b p0, final String p1) throws RemoteException;
    
    void a(final b p0, final String p1, final String p2) throws RemoteException;
    
    void a(final b p0, final List<String> p1) throws RemoteException;
    
    void a(final String p0, final jb p1, final jb p2) throws RemoteException;
    
    void b(final b p0) throws RemoteException;
    
    void b(final b p0, final String p1) throws RemoteException;
    
    void c(final b p0, final String p1) throws RemoteException;
    
    void clearDefaultAccount() throws RemoteException;
    
    void d(final b p0, final String p1) throws RemoteException;
    
    void e(final b p0, final String p1) throws RemoteException;
    
    String getAccountName() throws RemoteException;
    
    String mZ() throws RemoteException;
    
    boolean na() throws RemoteException;
    
    String nb() throws RemoteException;
    
    void removeMoment(final String p0) throws RemoteException;
    
    public abstract static class a extends Binder implements d
    {
        public static d bG(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            if (queryLocalInterface != null && queryLocalInterface instanceof d) {
                return (d)queryLocalInterface;
            }
            return new d.a.a(binder);
        }
        
        public boolean onTransact(int int1, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
            final jp jp = null;
            jb e = null;
            final IBinder binder = null;
            switch (int1) {
                default: {
                    return super.onTransact(int1, parcel, parcel2, n);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(b.a.bE(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(b.a.bE(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.b(b.a.bE(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    jp m;
                    if (parcel.readInt() != 0) {
                        m = com.google.android.gms.internal.jp.CREATOR.M(parcel);
                    }
                    else {
                        m = null;
                    }
                    this.a(m);
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final String accountName = this.getAccountName();
                    parcel2.writeNoException();
                    parcel2.writeString(accountName);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.clearDefaultAccount();
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(b.a.bE(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final b be = b.a.bE(parcel.readStrongBinder());
                    Uri uri;
                    if (parcel.readInt() != 0) {
                        uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        uri = null;
                    }
                    Bundle bundle;
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        bundle = null;
                    }
                    this.a(be, uri, bundle);
                    parcel2.writeNoException();
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final b be2 = b.a.bE(parcel.readStrongBinder());
                    int1 = parcel.readInt();
                    final String string = parcel.readString();
                    Uri uri2;
                    if (parcel.readInt() != 0) {
                        uri2 = (Uri)Uri.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        uri2 = null;
                    }
                    this.a(be2, int1, string, uri2, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final i a = this.a(b.a.bE(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    IBinder binder2 = binder;
                    if (a != null) {
                        binder2 = a.asBinder();
                    }
                    parcel2.writeStrongBinder(binder2);
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.removeMoment(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 18: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.c(b.a.bE(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 19: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.b(b.a.bE(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 34: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.a(b.a.bE(parcel.readStrongBinder()), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                }
                case 40: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.d(b.a.bE(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 41: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final String mz = this.mZ();
                    parcel2.writeNoException();
                    parcel2.writeString(mz);
                    return true;
                }
                case 42: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final boolean na = this.na();
                    parcel2.writeNoException();
                    if (na) {
                        int1 = 1;
                    }
                    else {
                        int1 = 0;
                    }
                    parcel2.writeInt(int1);
                    return true;
                }
                case 43: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final String nb = this.nb();
                    parcel2.writeNoException();
                    parcel2.writeString(nb);
                    return true;
                }
                case 44: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    this.e(b.a.bE(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 45: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final b be3 = b.a.bE(parcel.readStrongBinder());
                    jp i = jp;
                    if (parcel.readInt() != 0) {
                        i = com.google.android.gms.internal.jp.CREATOR.M(parcel);
                    }
                    this.a(be3, i);
                    parcel2.writeNoException();
                    return true;
                }
                case 46: {
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    final String string2 = parcel.readString();
                    jb e2;
                    if (parcel.readInt() != 0) {
                        e2 = jb.CREATOR.E(parcel);
                    }
                    else {
                        e2 = null;
                    }
                    if (parcel.readInt() != 0) {
                        e = jb.CREATOR.E(parcel);
                    }
                    this.a(string2, e2, e);
                    parcel2.writeNoException();
                    return true;
                }
            }
        }
        
        private static class a implements d
        {
            private IBinder lb;
            
            a(final IBinder lb) {
                this.lb = lb;
            }
            
            @Override
            public i a(final b b, final int n, final int n2, final int n3, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeInt(n2);
                    obtain.writeInt(n3);
                    obtain.writeString(s);
                    this.lb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return i.a.O(obtain2.readStrongBinder());
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final jp jp) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (jp != null) {
                        obtain.writeInt(1);
                        jp.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final b b) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    this.lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final b b, final int n, final String s, final Uri uri, final String s2, final String s3) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(s2);
                    obtain.writeString(s3);
                    this.lb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final b b, final Uri uri, final Bundle bundle) throws RemoteException {
                while (true) {
                    final Parcel obtain = Parcel.obtain();
                    final Parcel obtain2 = Parcel.obtain();
                    while (true) {
                        try {
                            obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                            IBinder binder;
                            if (b != null) {
                                binder = b.asBinder();
                            }
                            else {
                                binder = null;
                            }
                            obtain.writeStrongBinder(binder);
                            if (uri != null) {
                                obtain.writeInt(1);
                                uri.writeToParcel(obtain, 0);
                            }
                            else {
                                obtain.writeInt(0);
                            }
                            if (bundle != null) {
                                obtain.writeInt(1);
                                bundle.writeToParcel(obtain, 0);
                                this.lb.transact(9, obtain, obtain2, 0);
                                obtain2.readException();
                                return;
                            }
                        }
                        finally {
                            obtain2.recycle();
                            obtain.recycle();
                        }
                        obtain.writeInt(0);
                        continue;
                    }
                }
            }
            
            @Override
            public void a(final b b, final jp jp) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    if (jp != null) {
                        obtain.writeInt(1);
                        jp.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final b b, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeString(s);
                    this.lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final b b, final String s, final String s2) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    this.lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final b b, final List<String> list) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeStringList((List)list);
                    this.lb.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final String s, final jb jb, final jb jb2) throws RemoteException {
                while (true) {
                    final Parcel obtain = Parcel.obtain();
                    final Parcel obtain2 = Parcel.obtain();
                    while (true) {
                        try {
                            obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                            obtain.writeString(s);
                            if (jb != null) {
                                obtain.writeInt(1);
                                jb.writeToParcel(obtain, 0);
                            }
                            else {
                                obtain.writeInt(0);
                            }
                            if (jb2 != null) {
                                obtain.writeInt(1);
                                jb2.writeToParcel(obtain, 0);
                                this.lb.transact(46, obtain, obtain2, 0);
                                obtain2.readException();
                                return;
                            }
                        }
                        finally {
                            obtain2.recycle();
                            obtain.recycle();
                        }
                        obtain.writeInt(0);
                        continue;
                    }
                }
            }
            
            public IBinder asBinder() {
                return this.lb;
            }
            
            @Override
            public void b(final b b) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    this.lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void b(final b b, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeString(s);
                    this.lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void c(final b b, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeString(s);
                    this.lb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void clearDefaultAccount() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void d(final b b, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeString(s);
                    this.lb.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void e(final b b, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    IBinder binder;
                    if (b != null) {
                        binder = b.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeString(s);
                    this.lb.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public String getAccountName() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public String mZ() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.lb.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean na() throws RemoteException {
                boolean b = false;
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.lb.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public String nb() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.lb.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void removeMoment(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(s);
                    this.lb.transact(17, obtain, obtain2, 0);
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
