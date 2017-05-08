// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.player;

public class PlayScreenKindleFire extends PlayScreen
{
    public static final int AMAZON_FLAG_NOSOFTKEYS = Integer.MIN_VALUE;
    private static final int FLAG_SUPER_FULLSCREEN = -2147482624;
    
    PlayScreenKindleFire(final PlayerFragment playerFragment, final PlayScreen$Listeners playScreen$Listeners, final PostPlayFactory$PostPlayType postPlayFactory$PostPlayType) {
        super(playerFragment, playScreen$Listeners, postPlayFactory$PostPlayType);
    }
    
    @Override
    void hideNavigationBar() {
        if (!this.mController.isInPortrait()) {
            this.mController.getWindow().addFlags(-2147482624);
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
        this.mController.getWindow().clearFlags(-2147482624);
    }
}
