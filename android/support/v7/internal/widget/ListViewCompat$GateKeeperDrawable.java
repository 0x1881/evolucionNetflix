// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

class ListViewCompat$GateKeeperDrawable extends DrawableWrapper
{
    private boolean mEnabled;
    
    public ListViewCompat$GateKeeperDrawable(final Drawable drawable) {
        super(drawable);
        this.mEnabled = true;
    }
    
    @Override
    public void draw(final Canvas canvas) {
        if (this.mEnabled) {
            super.draw(canvas);
        }
    }
    
    void setEnabled(final boolean mEnabled) {
        this.mEnabled = mEnabled;
    }
    
    @Override
    public void setHotspot(final float n, final float n2) {
        if (this.mEnabled) {
            super.setHotspot(n, n2);
        }
    }
    
    @Override
    public void setHotspotBounds(final int n, final int n2, final int n3, final int n4) {
        if (this.mEnabled) {
            super.setHotspotBounds(n, n2, n3, n4);
        }
    }
    
    @Override
    public boolean setState(final int[] state) {
        return this.mEnabled && super.setState(state);
    }
    
    @Override
    public boolean setVisible(final boolean b, final boolean b2) {
        return this.mEnabled && super.setVisible(b, b2);
    }
}
