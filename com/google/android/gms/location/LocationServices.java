// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.location;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lt;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.internal.ly;
import com.google.android.gms.common.api.Api;

public class LocationServices
{
    public static final Api<Api.ApiOptions.NoOptions> API;
    private static final Api.c<ly> CU;
    private static final Api.b<ly, Api.ApiOptions.NoOptions> CV;
    public static FusedLocationProviderApi FusedLocationApi;
    public static GeofencingApi GeofencingApi;
    
    static {
        CU = new Api.c();
        CV = new Api.b<ly, Api.ApiOptions.NoOptions>() {
            public ly d(final Context context, final Looper looper, final ClientSettings clientSettings, final NoOptions noOptions, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
                return new ly(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, "locationServices", clientSettings.getAccountName());
            }
            
            @Override
            public int getPriority() {
                return Integer.MAX_VALUE;
            }
        };
        API = new Api<Api.ApiOptions.NoOptions>((Api.b<C, Api.ApiOptions.NoOptions>)LocationServices.CV, (Api.c<C>)LocationServices.CU, new Scope[0]);
        LocationServices.FusedLocationApi = new lt();
        LocationServices.GeofencingApi = new lu();
    }
    
    public static ly e(final GoogleApiClient googleApiClient) {
        final boolean b = true;
        n.b(googleApiClient != null, (Object)"GoogleApiClient parameter is required.");
        final ly ly = googleApiClient.a(LocationServices.CU);
        n.a(ly != null && b, (Object)"GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return ly;
    }
    
    public abstract static class a<R extends Result> extends BaseImplementation.a<R, ly>
    {
        public a() {
            super(LocationServices.CU);
        }
    }
}
