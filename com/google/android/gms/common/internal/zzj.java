// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.common.internal;

import java.util.Collection;
import android.os.RemoteException;
import android.os.DeadObjectException;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.ServiceConnection;
import android.util.Log;
import java.util.Iterator;
import java.util.ArrayList;
import com.google.android.gms.common.api.GoogleApiClient$zza;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import com.google.android.gms.common.GoogleApiAvailability;
import android.os.Looper;
import android.accounts.Account;
import android.os.Handler;
import android.content.Context;
import com.google.android.gms.common.api.Api$zzb;
import android.os.IInterface;

public abstract class zzj<T extends IInterface> implements Api$zzb, zzk$zza
{
    public static final String[] zzadF;
    private final Context mContext;
    final Handler mHandler;
    private final Account zzOY;
    private final Looper zzYV;
    private final zzf zzZH;
    private final GoogleApiAvailability zzZi;
    private final Set<Scope> zzZp;
    private int zzadA;
    private final GoogleApiClient$ConnectionCallbacks zzadB;
    private final GoogleApiClient$OnConnectionFailedListener zzadC;
    private final int zzadD;
    protected AtomicInteger zzadE;
    private final zzl zzadu;
    private zzs zzadv;
    private GoogleApiClient$zza zzadw;
    private T zzadx;
    private final ArrayList<zzj$zzc<?>> zzady;
    private zzj$zze zzadz;
    private final Object zzpc;
    
    static {
        zzadF = new String[] { "service_esmobile", "service_googleme" };
    }
    
    protected zzj(final Context context, final Looper looper, final int n, final zzf zzf, final GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, final GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        this(context, looper, zzl.zzak(context), GoogleApiAvailability.getInstance(), n, zzf, zzx.zzv(googleApiClient$ConnectionCallbacks), zzx.zzv(googleApiClient$OnConnectionFailedListener));
    }
    
    protected zzj(final Context context, final Looper looper, final zzl zzl, final GoogleApiAvailability googleApiAvailability, final int zzadD, final zzf zzf, final GoogleApiClient$ConnectionCallbacks zzadB, final GoogleApiClient$OnConnectionFailedListener zzadC) {
        this.zzpc = new Object();
        this.zzady = new ArrayList<zzj$zzc<?>>();
        this.zzadA = 1;
        this.zzadE = new AtomicInteger(0);
        this.mContext = zzx.zzb(context, "Context must not be null");
        this.zzYV = zzx.zzb(looper, "Looper must not be null");
        this.zzadu = zzx.zzb(zzl, "Supervisor must not be null");
        this.zzZi = zzx.zzb(googleApiAvailability, "API availability must not be null");
        this.mHandler = new zzj$zzb(this, looper);
        this.zzadD = zzadD;
        this.zzZH = zzx.zzv(zzf);
        this.zzOY = zzf.getAccount();
        this.zzZp = this.zzb(zzf.zzoj());
        this.zzadB = zzadB;
        this.zzadC = zzadC;
    }
    
    private boolean zza(final int n, final int n2, final T t) {
        synchronized (this.zzpc) {
            if (this.zzadA != n) {
                return false;
            }
            this.zzb(n2, t);
            return true;
        }
    }
    
    private Set<Scope> zzb(final Set<Scope> set) {
        final Set<Scope> zza = this.zza(set);
        if (zza == null) {
            return zza;
        }
        final Iterator<Scope> iterator = zza.iterator();
        while (iterator.hasNext()) {
            if (!set.contains(iterator.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zza;
    }
    
    private void zzb(final int zzadA, final T zzadx) {
        boolean b = true;
        int n;
        if (zzadA == 3) {
            n = 1;
        }
        else {
            n = 0;
        }
        int n2;
        if (zzadx != null) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        if (n != n2) {
            b = false;
        }
        while (true) {
            zzx.zzZ(b);
            Label_0104: {
                synchronized (this.zzpc) {
                    this.zzc(this.zzadA = zzadA, this.zzadx = zzadx);
                    switch (zzadA) {
                        case 2: {
                            this.zzov();
                            return;
                        }
                        case 3: {
                            break;
                        }
                        case 1: {
                            break Label_0104;
                        }
                        default: {
                            return;
                        }
                    }
                }
                this.zzou();
                return;
            }
            this.zzow();
        }
    }
    
    private void zzov() {
        if (this.zzadz != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + this.zzfA());
            this.zzadu.zzb(this.zzfA(), (ServiceConnection)this.zzadz, this.zzot());
            this.zzadE.incrementAndGet();
        }
        this.zzadz = new zzj$zze(this, this.zzadE.get());
        if (!this.zzadu.zza(this.zzfA(), (ServiceConnection)this.zzadz, this.zzot())) {
            Log.e("GmsClient", "unable to connect to service: " + this.zzfA());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzadE.get(), 9));
        }
    }
    
    private void zzow() {
        if (this.zzadz != null) {
            this.zzadu.zzb(this.zzfA(), (ServiceConnection)this.zzadz, this.zzot());
            this.zzadz = null;
        }
    }
    
    @Override
    public void disconnect() {
        this.zzadE.incrementAndGet();
        synchronized (this.zzady) {
            for (int size = this.zzady.size(), i = 0; i < size; ++i) {
                this.zzady.get(i).zzoG();
            }
            this.zzady.clear();
            // monitorexit(this.zzady)
            this.zzb(1, null);
        }
    }
    
    @Override
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, String[] zzadx) {
    Label_0137:
        while (true) {
            while (true) {
                Label_0127: {
                    Label_0117: {
                        Label_0107: {
                            synchronized (this.zzpc) {
                                final int zzadA = this.zzadA;
                                zzadx = (String[])(Object)this.zzadx;
                                // monitorexit(this.zzpc)
                                printWriter.append(s).append("mConnectState=");
                                switch (zzadA) {
                                    default: {
                                        printWriter.print("UNKNOWN");
                                        printWriter.append(" mService=");
                                        if (zzadx == null) {
                                            printWriter.println("null");
                                            return;
                                        }
                                        break Label_0137;
                                    }
                                    case 2: {
                                        break;
                                    }
                                    case 3: {
                                        break Label_0107;
                                    }
                                    case 4: {
                                        break Label_0117;
                                    }
                                    case 1: {
                                        break Label_0127;
                                    }
                                }
                            }
                            printWriter.print("CONNECTING");
                            continue;
                        }
                        printWriter.print("CONNECTED");
                        continue;
                    }
                    printWriter.print("DISCONNECTING");
                    continue;
                }
                printWriter.print("DISCONNECTED");
                continue;
            }
        }
        printWriter.append(this.zzfB()).append("@").println(Integer.toHexString(System.identityHashCode(((IInterface)(Object)zzadx).asBinder())));
    }
    
    public final Context getContext() {
        return this.mContext;
    }
    
    public final Looper getLooper() {
        return this.zzYV;
    }
    
    @Override
    public boolean isConnected() {
        while (true) {
            synchronized (this.zzpc) {
                if (this.zzadA == 3) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public boolean isConnecting() {
        while (true) {
            synchronized (this.zzpc) {
                if (this.zzadA == 2) {
                    return true;
                }
            }
            return false;
        }
    }
    
    protected void onConnectionFailed(final ConnectionResult connectionResult) {
    }
    
    protected void onConnectionSuspended(final int n) {
    }
    
    protected abstract T zzV(final IBinder p0);
    
    protected Set<Scope> zza(final Set<Scope> set) {
        return set;
    }
    
    protected void zza(final int p0, final Bundle p1, final int p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/android/gms/common/internal/zzj.mHandler:Landroid/os/Handler;
        //     4: aload_0        
        //     5: getfield        com/google/android/gms/common/internal/zzj.mHandler:Landroid/os/Handler;
        //     8: iconst_5       
        //     9: iload_3        
        //    10: iconst_m1      
        //    11: new             new            !!! ERROR
        //    14: dup            
        //    15: aload_0        
        //    16: iload_1        
        //    17: aload_2        
        //    18: invokespecial   invokespecial  !!! ERROR
        //    21: invokevirtual   android/os/Handler.obtainMessage:(IIILjava/lang/Object;)Landroid/os/Message;
        //    24: invokevirtual   android/os/Handler.sendMessage:(Landroid/os/Message;)Z
        //    27: pop            
        //    28: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalArgumentException: Argument 'typeArguments' must not have any null elements.
        //     at com.strobel.core.VerifyArgument.noNullElementsAndNotEmpty(VerifyArgument.java:145)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.makeGenericType(CoreMetadataFactory.java:570)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory.makeParameterizedType(CoreMetadataFactory.java:156)
        //     at com.strobel.assembler.metadata.signatures.Reifier.visitClassTypeSignature(Reifier.java:125)
        //     at com.strobel.assembler.metadata.signatures.ClassTypeSignature.accept(ClassTypeSignature.java:46)
        //     at com.strobel.assembler.metadata.MetadataParser.parseClassSignature(MetadataParser.java:394)
        //     at com.strobel.assembler.metadata.ClassFileReader.populateBaseTypes(ClassFileReader.java:665)
        //     at com.strobel.assembler.metadata.ClassFileReader.readClass(ClassFileReader.java:438)
        //     at com.strobel.assembler.metadata.ClassFileReader.readClass(ClassFileReader.java:366)
        //     at com.strobel.assembler.metadata.MetadataSystem.resolveType(MetadataSystem.java:124)
        //     at com.strobel.decompiler.NoRetryMetadataSystem.resolveType(DecompilerDriver.java:463)
        //     at com.strobel.assembler.metadata.MetadataSystem.resolveCore(MetadataSystem.java:76)
        //     at com.strobel.assembler.metadata.MetadataResolver.resolve(MetadataResolver.java:104)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.resolve(CoreMetadataFactory.java:589)
        //     at com.strobel.assembler.metadata.MetadataResolver.resolve(MetadataResolver.java:128)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.resolve(CoreMetadataFactory.java:599)
        //     at com.strobel.assembler.metadata.MethodReference.resolve(MethodReference.java:172)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2428)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:655)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:365)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    protected void zza(final int p0, final IBinder p1, final Bundle p2, final int p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/android/gms/common/internal/zzj.mHandler:Landroid/os/Handler;
        //     4: aload_0        
        //     5: getfield        com/google/android/gms/common/internal/zzj.mHandler:Landroid/os/Handler;
        //     8: iconst_1       
        //     9: iload           4
        //    11: iconst_m1      
        //    12: new             new            !!! ERROR
        //    15: dup            
        //    16: aload_0        
        //    17: iload_1        
        //    18: aload_2        
        //    19: aload_3        
        //    20: invokespecial   invokespecial  !!! ERROR
        //    23: invokevirtual   android/os/Handler.obtainMessage:(IIILjava/lang/Object;)Landroid/os/Message;
        //    26: invokevirtual   android/os/Handler.sendMessage:(Landroid/os/Message;)Z
        //    29: pop            
        //    30: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalArgumentException: Argument 'typeArguments' must not have any null elements.
        //     at com.strobel.core.VerifyArgument.noNullElementsAndNotEmpty(VerifyArgument.java:145)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.makeGenericType(CoreMetadataFactory.java:570)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory.makeParameterizedType(CoreMetadataFactory.java:156)
        //     at com.strobel.assembler.metadata.signatures.Reifier.visitClassTypeSignature(Reifier.java:125)
        //     at com.strobel.assembler.metadata.signatures.ClassTypeSignature.accept(ClassTypeSignature.java:46)
        //     at com.strobel.assembler.metadata.MetadataParser.parseClassSignature(MetadataParser.java:394)
        //     at com.strobel.assembler.metadata.ClassFileReader.populateBaseTypes(ClassFileReader.java:665)
        //     at com.strobel.assembler.metadata.ClassFileReader.readClass(ClassFileReader.java:438)
        //     at com.strobel.assembler.metadata.ClassFileReader.readClass(ClassFileReader.java:366)
        //     at com.strobel.assembler.metadata.MetadataSystem.resolveType(MetadataSystem.java:124)
        //     at com.strobel.decompiler.NoRetryMetadataSystem.resolveType(DecompilerDriver.java:463)
        //     at com.strobel.assembler.metadata.MetadataSystem.resolveCore(MetadataSystem.java:76)
        //     at com.strobel.assembler.metadata.MetadataResolver.resolve(MetadataResolver.java:104)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.resolve(CoreMetadataFactory.java:589)
        //     at com.strobel.assembler.metadata.MetadataResolver.resolve(MetadataResolver.java:128)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.resolve(CoreMetadataFactory.java:599)
        //     at com.strobel.assembler.metadata.MethodReference.resolve(MethodReference.java:172)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2428)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:655)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:365)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void zza(final GoogleApiClient$zza googleApiClient$zza) {
        this.zzadw = zzx.zzb(googleApiClient$zza, "Connection progress callbacks cannot be null.");
        this.zzb(2, null);
    }
    
    @Override
    public void zza(final zzp zzp) {
        final ValidateAccountRequest validateAccountRequest = new ValidateAccountRequest(zzp, this.zzZp.toArray(new Scope[this.zzZp.size()]), this.mContext.getPackageName(), this.zzoB());
        try {
            this.zzadv.zza(new zzj$zzd(this, this.zzadE.get()), validateAccountRequest);
        }
        catch (DeadObjectException ex2) {
            Log.w("GmsClient", "service died");
            this.zzbz(1);
        }
        catch (RemoteException ex) {
            Log.w("GmsClient", "Remote exception occurred", (Throwable)ex);
        }
    }
    
    @Override
    public void zza(final zzp zzp, final Set<Scope> set) {
        try {
            final GetServiceRequest zzg = new GetServiceRequest(this.zzadD).zzck(this.mContext.getPackageName()).zzg(this.zzli());
            if (set != null) {
                zzg.zzd(set);
            }
            if (this.zzlm()) {
                zzg.zzb(this.zzog()).zzc(zzp);
            }
            else if (this.zzoC()) {
                zzg.zzb(this.zzOY);
            }
            this.zzadv.zza(new zzj$zzd(this, this.zzadE.get()), zzg);
        }
        catch (DeadObjectException ex2) {
            Log.w("GmsClient", "service died");
            this.zzbz(1);
        }
        catch (RemoteException ex) {
            Log.w("GmsClient", "Remote exception occurred", (Throwable)ex);
        }
    }
    
    protected void zzbA(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/android/gms/common/internal/zzj.mHandler:Landroid/os/Handler;
        //     4: aload_0        
        //     5: getfield        com/google/android/gms/common/internal/zzj.mHandler:Landroid/os/Handler;
        //     8: bipush          6
        //    10: iload_1        
        //    11: iconst_m1      
        //    12: new             new            !!! ERROR
        //    15: dup            
        //    16: aload_0        
        //    17: invokespecial   invokespecial  !!! ERROR
        //    20: invokevirtual   android/os/Handler.obtainMessage:(IIILjava/lang/Object;)Landroid/os/Message;
        //    23: invokevirtual   android/os/Handler.sendMessage:(Landroid/os/Message;)Z
        //    26: pop            
        //    27: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalArgumentException: Argument 'typeArguments' must not have any null elements.
        //     at com.strobel.core.VerifyArgument.noNullElementsAndNotEmpty(VerifyArgument.java:145)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.makeGenericType(CoreMetadataFactory.java:570)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory.makeParameterizedType(CoreMetadataFactory.java:156)
        //     at com.strobel.assembler.metadata.signatures.Reifier.visitClassTypeSignature(Reifier.java:125)
        //     at com.strobel.assembler.metadata.signatures.ClassTypeSignature.accept(ClassTypeSignature.java:46)
        //     at com.strobel.assembler.metadata.MetadataParser.parseClassSignature(MetadataParser.java:394)
        //     at com.strobel.assembler.metadata.ClassFileReader.populateBaseTypes(ClassFileReader.java:665)
        //     at com.strobel.assembler.metadata.ClassFileReader.readClass(ClassFileReader.java:438)
        //     at com.strobel.assembler.metadata.ClassFileReader.readClass(ClassFileReader.java:366)
        //     at com.strobel.assembler.metadata.MetadataSystem.resolveType(MetadataSystem.java:124)
        //     at com.strobel.decompiler.NoRetryMetadataSystem.resolveType(DecompilerDriver.java:463)
        //     at com.strobel.assembler.metadata.MetadataSystem.resolveCore(MetadataSystem.java:76)
        //     at com.strobel.assembler.metadata.MetadataResolver.resolve(MetadataResolver.java:104)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.resolve(CoreMetadataFactory.java:589)
        //     at com.strobel.assembler.metadata.MetadataResolver.resolve(MetadataResolver.java:128)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.resolve(CoreMetadataFactory.java:599)
        //     at com.strobel.assembler.metadata.MethodReference.resolve(MethodReference.java:172)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2428)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1029)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:803)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:672)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:655)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:365)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void zzbz(final int n) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzadE.get(), n));
    }
    
    protected void zzc(final int n, final T t) {
    }
    
    protected abstract String zzfA();
    
    protected abstract String zzfB();
    
    protected Bundle zzli() {
        return new Bundle();
    }
    
    @Override
    public boolean zzlm() {
        return false;
    }
    
    @Override
    public Bundle zzmw() {
        return null;
    }
    
    public final T zzoA() {
        synchronized (this.zzpc) {
            if (this.zzadA == 4) {
                throw new DeadObjectException();
            }
        }
        this.zzoz();
        zzx.zza(this.zzadx != null, "Client is connected but service is null");
        final IInterface zzadx = this.zzadx;
        // monitorexit(o)
        return (T)zzadx;
    }
    
    protected Bundle zzoB() {
        return null;
    }
    
    public boolean zzoC() {
        return false;
    }
    
    public final Account zzog() {
        if (this.zzOY != null) {
            return this.zzOY;
        }
        return new Account("<<default account>>", "com.google");
    }
    
    protected final String zzot() {
        return this.zzZH.zzom();
    }
    
    protected void zzou() {
    }
    
    protected final zzf zzoy() {
        return this.zzZH;
    }
    
    protected final void zzoz() {
        if (!this.isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }
}
