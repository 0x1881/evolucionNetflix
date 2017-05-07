// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;
import android.view.ViewGroup$MarginLayoutParams;

class DrawerLayoutCompatApi21
{
    public static void applyMarginInsets(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final Object o, final int n) {
        final WindowInsets windowInsets = (WindowInsets)o;
        WindowInsets windowInsets2;
        if (n == 3) {
            windowInsets2 = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
        }
        else {
            windowInsets2 = windowInsets;
            if (n == 5) {
                windowInsets2 = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
        }
        viewGroup$MarginLayoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
        viewGroup$MarginLayoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
        viewGroup$MarginLayoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
        viewGroup$MarginLayoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
    }
    
    public static void configureApplyInsets(final View view) {
        if (view instanceof DrawerLayoutImpl) {
            view.setOnApplyWindowInsetsListener((View$OnApplyWindowInsetsListener)new DrawerLayoutCompatApi21$InsetsListener());
            view.setSystemUiVisibility(1280);
        }
    }
    
    public static void dispatchChildInsets(final View view, final Object o, final int n) {
        final WindowInsets windowInsets = (WindowInsets)o;
        WindowInsets windowInsets2;
        if (n == 3) {
            windowInsets2 = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
        }
        else {
            windowInsets2 = windowInsets;
            if (n == 5) {
                windowInsets2 = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
        }
        view.dispatchApplyWindowInsets(windowInsets2);
    }
    
    public static int getTopInset(final Object o) {
        if (o != null) {
            return ((WindowInsets)o).getSystemWindowInsetTop();
        }
        return 0;
    }
}
