// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Binder;
import android.os.IBinder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.IInterface;

public interface k extends IInterface
{
    void a(final j p0, final int p1) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final IBinder p3, final Bundle p4) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final String p3) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final String p3, final String p4, final String[] p5) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final String p3, final String[] p4) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final String p3, final String[] p4, final Bundle p5) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final String p3, final String[] p4, final String p5, final Bundle p6) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final String p3, final String[] p4, final String p5, final IBinder p6, final String p7, final Bundle p8) throws RemoteException;
    
    void a(final j p0, final int p1, final String p2, final String[] p3, final String p4, final Bundle p5) throws RemoteException;
    
    void b(final j p0, final int p1, final String p2) throws RemoteException;
    
    void b(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void b(final j p0, final int p1, final String p2, final String p3, final String[] p4) throws RemoteException;
    
    void c(final j p0, final int p1, final String p2) throws RemoteException;
    
    void c(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void d(final j p0, final int p1, final String p2) throws RemoteException;
    
    void d(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void e(final j p0, final int p1, final String p2) throws RemoteException;
    
    void e(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void f(final j p0, final int p1, final String p2) throws RemoteException;
    
    void f(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void g(final j p0, final int p1, final String p2) throws RemoteException;
    
    void g(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void h(final j p0, final int p1, final String p2) throws RemoteException;
    
    void h(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void i(final j p0, final int p1, final String p2) throws RemoteException;
    
    void i(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void j(final j p0, final int p1, final String p2) throws RemoteException;
    
    void j(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void k(final j p0, final int p1, final String p2) throws RemoteException;
    
    void k(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void l(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void m(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void n(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void o(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void p(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void q(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void r(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void s(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    void t(final j p0, final int p1, final String p2, final Bundle p3) throws RemoteException;
    
    public abstract static class a extends Binder implements k
    {
        public static k Q(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface != null && queryLocalInterface instanceof k) {
                return (k)queryLocalInterface;
            }
            return new k.a.a(binder);
        }
        
        public boolean onTransact(int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            final Bundle bundle = null;
            final Bundle bundle2 = null;
            final Bundle bundle3 = null;
            final Bundle bundle4 = null;
            final Bundle bundle5 = null;
            final Bundle bundle6 = null;
            final Bundle bundle7 = null;
            final Bundle bundle8 = null;
            final Bundle bundle9 = null;
            final Bundle bundle10 = null;
            final Bundle bundle11 = null;
            final Bundle bundle12 = null;
            final Bundle bundle13 = null;
            final Bundle bundle14 = null;
            final Bundle bundle15 = null;
            final Bundle bundle16 = null;
            final Bundle bundle17 = null;
            final Bundle bundle18 = null;
            final Bundle bundle19 = null;
            Bundle bundle20 = null;
            switch (n) {
                default: {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p4 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string = parcel.readString();
                    final String string2 = parcel.readString();
                    final String[] stringArray = parcel.createStringArray();
                    final String string3 = parcel.readString();
                    Bundle bundle21;
                    if (parcel.readInt() != 0) {
                        bundle21 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        bundle21 = null;
                    }
                    this.a(p4, n, string, string2, stringArray, string3, bundle21);
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p5 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string4 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle20 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.a(p5, n, string4, bundle20);
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.a(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.a(j.a.P(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p6 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string5 = parcel.readString();
                    Bundle bundle22 = bundle;
                    if (parcel.readInt() != 0) {
                        bundle22 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.b(p6, n, string5, bundle22);
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p7 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string6 = parcel.readString();
                    Bundle bundle23 = bundle2;
                    if (parcel.readInt() != 0) {
                        bundle23 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.c(p7, n, string6, bundle23);
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p8 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string7 = parcel.readString();
                    Bundle bundle24 = bundle3;
                    if (parcel.readInt() != 0) {
                        bundle24 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.d(p8, n, string7, bundle24);
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p9 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string8 = parcel.readString();
                    Bundle bundle25 = bundle4;
                    if (parcel.readInt() != 0) {
                        bundle25 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.e(p9, n, string8, bundle25);
                    parcel2.writeNoException();
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p10 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string9 = parcel.readString();
                    final String string10 = parcel.readString();
                    final String[] stringArray2 = parcel.createStringArray();
                    final String string11 = parcel.readString();
                    final IBinder strongBinder = parcel.readStrongBinder();
                    final String string12 = parcel.readString();
                    Bundle bundle26;
                    if (parcel.readInt() != 0) {
                        bundle26 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        bundle26 = null;
                    }
                    this.a(p10, n, string9, string10, stringArray2, string11, strongBinder, string12, bundle26);
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.a(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p11 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string13 = parcel.readString();
                    Bundle bundle27 = bundle5;
                    if (parcel.readInt() != 0) {
                        bundle27 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.f(p11, n, string13, bundle27);
                    parcel2.writeNoException();
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p12 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string14 = parcel.readString();
                    Bundle bundle28 = bundle6;
                    if (parcel.readInt() != 0) {
                        bundle28 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.g(p12, n, string14, bundle28);
                    parcel2.writeNoException();
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p13 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string15 = parcel.readString();
                    Bundle bundle29 = bundle7;
                    if (parcel.readInt() != 0) {
                        bundle29 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.h(p13, n, string15, bundle29);
                    parcel2.writeNoException();
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p14 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string16 = parcel.readString();
                    Bundle bundle30 = bundle8;
                    if (parcel.readInt() != 0) {
                        bundle30 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.i(p14, n, string16, bundle30);
                    parcel2.writeNoException();
                    return true;
                }
                case 15: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p15 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string17 = parcel.readString();
                    Bundle bundle31 = bundle9;
                    if (parcel.readInt() != 0) {
                        bundle31 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.j(p15, n, string17, bundle31);
                    parcel2.writeNoException();
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p16 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string18 = parcel.readString();
                    Bundle bundle32 = bundle10;
                    if (parcel.readInt() != 0) {
                        bundle32 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.k(p16, n, string18, bundle32);
                    parcel2.writeNoException();
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p17 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string19 = parcel.readString();
                    Bundle bundle33 = bundle11;
                    if (parcel.readInt() != 0) {
                        bundle33 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.l(p17, n, string19, bundle33);
                    parcel2.writeNoException();
                    return true;
                }
                case 18: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p18 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string20 = parcel.readString();
                    Bundle bundle34 = bundle12;
                    if (parcel.readInt() != 0) {
                        bundle34 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.m(p18, n, string20, bundle34);
                    parcel2.writeNoException();
                    return true;
                }
                case 19: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p19 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string21 = parcel.readString();
                    final IBinder strongBinder2 = parcel.readStrongBinder();
                    Bundle bundle35;
                    if (parcel.readInt() != 0) {
                        bundle35 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        bundle35 = null;
                    }
                    this.a(p19, n, string21, strongBinder2, bundle35);
                    parcel2.writeNoException();
                    return true;
                }
                case 20: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p20 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string22 = parcel.readString();
                    final String[] stringArray3 = parcel.createStringArray();
                    final String string23 = parcel.readString();
                    Bundle bundle36;
                    if (parcel.readInt() != 0) {
                        bundle36 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        bundle36 = null;
                    }
                    this.a(p20, n, string22, stringArray3, string23, bundle36);
                    parcel2.writeNoException();
                    return true;
                }
                case 21: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.b(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 22: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.c(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 23: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p21 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string24 = parcel.readString();
                    Bundle bundle37 = bundle13;
                    if (parcel.readInt() != 0) {
                        bundle37 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.n(p21, n, string24, bundle37);
                    parcel2.writeNoException();
                    return true;
                }
                case 24: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.d(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 25: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p22 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string25 = parcel.readString();
                    Bundle bundle38 = bundle14;
                    if (parcel.readInt() != 0) {
                        bundle38 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.o(p22, n, string25, bundle38);
                    parcel2.writeNoException();
                    return true;
                }
                case 26: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.e(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 27: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p23 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string26 = parcel.readString();
                    Bundle bundle39 = bundle15;
                    if (parcel.readInt() != 0) {
                        bundle39 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.p(p23, n, string26, bundle39);
                    parcel2.writeNoException();
                    return true;
                }
                case 28: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.b(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 30: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p24 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string27 = parcel.readString();
                    final String string28 = parcel.readString();
                    final String[] stringArray4 = parcel.createStringArray();
                    Bundle bundle40;
                    if (parcel.readInt() != 0) {
                        bundle40 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        bundle40 = null;
                    }
                    this.a(p24, n, string27, string28, stringArray4, bundle40);
                    parcel2.writeNoException();
                    return true;
                }
                case 31: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.f(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 32: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.g(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 33: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.a(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 34: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.a(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 35: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.h(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 36: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.i(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 37: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p25 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string29 = parcel.readString();
                    Bundle bundle41 = bundle16;
                    if (parcel.readInt() != 0) {
                        bundle41 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.q(p25, n, string29, bundle41);
                    parcel2.writeNoException();
                    return true;
                }
                case 38: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p26 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string30 = parcel.readString();
                    Bundle bundle42 = bundle17;
                    if (parcel.readInt() != 0) {
                        bundle42 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.r(p26, n, string30, bundle42);
                    parcel2.writeNoException();
                    return true;
                }
                case 40: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.j(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 41: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p27 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string31 = parcel.readString();
                    Bundle bundle43 = bundle18;
                    if (parcel.readInt() != 0) {
                        bundle43 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.s(p27, n, string31, bundle43);
                    parcel2.writeNoException();
                    return true;
                }
                case 42: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.k(j.a.P(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 43: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    final j p28 = j.a.P(parcel.readStrongBinder());
                    n = parcel.readInt();
                    final String string32 = parcel.readString();
                    Bundle bundle44 = bundle19;
                    if (parcel.readInt() != 0) {
                        bundle44 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.t(p28, n, string32, bundle44);
                    parcel2.writeNoException();
                    return true;
                }
            }
        }
        
        private static class a implements k
        {
            private IBinder lb;
            
            a(final IBinder lb) {
                this.lb = lb;
            }
            
            @Override
            public void a(final j j, final int n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    this.lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
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
            public void a(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final j j, final int n, final String s, final IBinder binder, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder2;
                    if (j != null) {
                        binder2 = j.asBinder();
                    }
                    else {
                        binder2 = null;
                    }
                    obtain.writeStrongBinder(binder2);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeStrongBinder(binder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final j j, final int n, final String s, final String s2) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    this.lb.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final j j, final int n, final String s, final String s2, final String s3, final String[] array) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    obtain.writeString(s3);
                    obtain.writeStringArray(array);
                    this.lb.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final j j, final int n, final String s, final String s2, final String[] array) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    obtain.writeStringArray(array);
                    this.lb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final j j, final int n, final String s, final String s2, final String[] array, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    obtain.writeStringArray(array);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final j j, final int n, final String s, final String s2, final String[] array, final String s3, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    obtain.writeStringArray(array);
                    obtain.writeString(s3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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
            
            @Override
            public void a(final j j, final int n, final String s, final String s2, final String[] array, final String s3, final IBinder binder, final String s4, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder2;
                    if (j != null) {
                        binder2 = j.asBinder();
                    }
                    else {
                        binder2 = null;
                    }
                    obtain.writeStrongBinder(binder2);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    obtain.writeStringArray(array);
                    obtain.writeString(s3);
                    obtain.writeStrongBinder(binder);
                    obtain.writeString(s4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void a(final j j, final int n, final String s, final String[] array, final String s2, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeStringArray(array);
                    obtain.writeString(s2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            public IBinder asBinder() {
                return this.lb;
            }
            
            @Override
            public void b(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void b(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void b(final j j, final int n, final String s, final String s2, final String[] array) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    obtain.writeStringArray(array);
                    this.lb.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void c(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void c(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void d(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void d(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void e(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void e(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void f(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void f(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void g(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void g(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void h(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void h(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void i(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void i(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void j(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
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
            public void j(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void k(final j j, final int n, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    this.lb.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void k(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void l(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void m(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void n(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void o(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void p(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void q(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void r(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void s(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void t(final j j, final int n, final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    IBinder binder;
                    if (j != null) {
                        binder = j.asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    this.lb.transact(43, obtain, obtain2, 0);
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
