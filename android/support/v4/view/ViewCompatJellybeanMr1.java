// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;

class ViewCompatJellybeanMr1
{
    public static int getLayoutDirection(final View view) {
        return view.getLayoutDirection();
    }
    
    public static int getPaddingEnd(final View view) {
        return view.getPaddingEnd();
    }
    
    public static int getPaddingStart(final View view) {
        return view.getPaddingStart();
    }
    
    public static int getWindowSystemUiVisibility(final View view) {
        return view.getWindowSystemUiVisibility();
    }
    
    public static boolean isPaddingRelative(final View view) {
        return view.isPaddingRelative();
    }
    
    public static void setPaddingRelative(final View view, final int n, final int n2, final int n3, final int n4) {
        view.setPaddingRelative(n, n2, n3, n4);
    }
}
