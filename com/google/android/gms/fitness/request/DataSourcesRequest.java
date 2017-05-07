// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.n;
import android.os.Parcel;
import com.google.android.gms.common.internal.m$a;
import com.google.android.gms.common.internal.m;
import java.util.Collections;
import java.util.Arrays;
import com.google.android.gms.internal.jr;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DataSourcesRequest implements SafeParcelable
{
    public static final Parcelable$Creator<DataSourcesRequest> CREATOR;
    private final int BR;
    private final List<DataType> Su;
    private final List<Integer> Ul;
    private final boolean Um;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
    }
    
    DataSourcesRequest(final int br, final List<DataType> su, final List<Integer> ul, final boolean um) {
        this.BR = br;
        this.Su = su;
        this.Ul = ul;
        this.Um = um;
    }
    
    private DataSourcesRequest(final DataSourcesRequest$Builder dataSourcesRequest$Builder) {
        this.BR = 2;
        this.Su = jr.b(dataSourcesRequest$Builder.Un);
        this.Ul = Arrays.asList(jr.a(dataSourcesRequest$Builder.Uo));
        this.Um = dataSourcesRequest$Builder.Um;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList((List<? extends DataType>)this.Su);
    }
    
    int getVersionCode() {
        return this.BR;
    }
    
    public boolean ji() {
        return this.Um;
    }
    
    List<Integer> jj() {
        return this.Ul;
    }
    
    @Override
    public String toString() {
        final m$a a = m.h(this).a("dataTypes", this.Su).a("sourceTypes", this.Ul);
        if (this.Um) {
            a.a("includeDbOnlySources", "true");
        }
        return a.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        g.a(this, parcel, n);
    }
}
