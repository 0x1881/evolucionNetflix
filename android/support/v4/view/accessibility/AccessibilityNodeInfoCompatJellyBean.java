// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatJellyBean
{
    public static boolean isAccessibilityFocused(final Object o) {
        return ((AccessibilityNodeInfo)o).isAccessibilityFocused();
    }
    
    public static boolean isVisibleToUser(final Object o) {
        return ((AccessibilityNodeInfo)o).isVisibleToUser();
    }
    
    public static boolean performAction(final Object o, final int n, final Bundle bundle) {
        return ((AccessibilityNodeInfo)o).performAction(n, bundle);
    }
    
    public static void setAccesibilityFocused(final Object o, final boolean accessibilityFocused) {
        ((AccessibilityNodeInfo)o).setAccessibilityFocused(accessibilityFocused);
    }
    
    public static void setVisibleToUser(final Object o, final boolean visibleToUser) {
        ((AccessibilityNodeInfo)o).setVisibleToUser(visibleToUser);
    }
}
