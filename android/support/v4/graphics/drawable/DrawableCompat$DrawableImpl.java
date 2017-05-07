// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

interface DrawableCompat$DrawableImpl
{
    boolean isAutoMirrored(final Drawable p0);
    
    void jumpToCurrentState(final Drawable p0);
    
    void setAutoMirrored(final Drawable p0, final boolean p1);
    
    void setHotspot(final Drawable p0, final float p1, final float p2);
    
    void setHotspotBounds(final Drawable p0, final int p1, final int p2, final int p3, final int p4);
    
    void setTint(final Drawable p0, final int p1);
    
    void setTintList(final Drawable p0, final ColorStateList p1);
    
    void setTintMode(final Drawable p0, final PorterDuff$Mode p1);
}
