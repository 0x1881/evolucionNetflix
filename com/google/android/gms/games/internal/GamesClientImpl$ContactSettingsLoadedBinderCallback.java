// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.games.Notifications$ContactSettingLoadResult;
import com.google.android.gms.common.api.BaseImplementation$b;

final class GamesClientImpl$ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks
{
    private final BaseImplementation$b<Notifications$ContactSettingLoadResult> De;
    final /* synthetic */ GamesClientImpl Wr;
    
    GamesClientImpl$ContactSettingsLoadedBinderCallback(final GamesClientImpl wr, final BaseImplementation$b<Notifications$ContactSettingLoadResult> baseImplementation$b) {
        this.Wr = wr;
        this.De = n.b(baseImplementation$b, "Holder must not be null");
    }
    
    @Override
    public void D(final DataHolder dataHolder) {
        this.De.b(new GamesClientImpl$ContactSettingLoadResultImpl(dataHolder));
    }
}
