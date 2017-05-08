// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.player;

import android.annotation.SuppressLint;

public class PlayScreenICS extends PlayScreen
{
    @SuppressLint({ "InlinedApi" })
    private static final int BASE_FLAGS = 4;
    private static final int HIDE_FLAGS = 1;
    private static final int SHOW_FLAGS = 0;
    
    PlayScreenICS(final PlayerFragment playerFragment, final PlayScreen$Listeners playScreen$Listeners, final PostPlayFactory$PostPlayType postPlayFactory$PostPlayType) {
        super(playerFragment, playScreen$Listeners, postPlayFactory$PostPlayType);
    }
    
    @Override
    void hideNavigationBar() {
        if (!this.mController.isInPortrait()) {
            this.mController.getWindow().getDecorView().setSystemUiVisibility(5);
        }
    }
    
    @Override
    protected void playerOverlayVisibility(final boolean b) {
        super.playerOverlayVisibility(b);
        if (this.mController.isInPortrait()) {
            return;
        }
        if (b) {
            this.showNavigationBar();
            return;
        }
        this.hideNavigationBar();
    }
    
    @Override
    void showNavigationBar() {
        this.mController.getWindow().getDecorView().setSystemUiVisibility(4);
    }
}
