// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.games.GamesMetadata$LoadExtendedGamesResult;
import com.google.android.gms.common.api.BaseImplementation$b;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.common.api.Api$a;

class GamesMetadataImpl$11 extends GamesMetadataImpl$LoadExtendedGamesImpl
{
    final /* synthetic */ boolean XU;
    final /* synthetic */ String XW;
    final /* synthetic */ int Yl;
    
    @Override
    protected void a(final GamesClientImpl gamesClientImpl) {
        gamesClientImpl.c((BaseImplementation$b<GamesMetadata$LoadExtendedGamesResult>)this, this.XW, this.Yl, false, this.XU);
    }
}
