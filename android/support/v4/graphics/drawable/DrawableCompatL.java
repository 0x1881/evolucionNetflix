// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

class DrawableCompatL
{
    public static void setHotspot(final Drawable drawable, final float n, final float n2) {
        drawable.setHotspot(n, n2);
    }
    
    public static void setHotspotBounds(final Drawable drawable, final int n, final int n2, final int n3, final int n4) {
        drawable.setHotspotBounds(n, n2, n3, n4);
    }
    
    public static void setTint(final Drawable drawable, final int tint) {
        drawable.setTint(tint);
    }
    
    public static void setTintList(final Drawable drawable, final ColorStateList tintList) {
        drawable.setTintList(tintList);
    }
    
    public static void setTintMode(final Drawable drawable, final PorterDuff$Mode tintMode) {
        drawable.setTintMode(tintMode);
    }
}
