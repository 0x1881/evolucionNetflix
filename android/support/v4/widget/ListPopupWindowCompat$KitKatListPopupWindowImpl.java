// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View$OnTouchListener;
import android.view.View;

class ListPopupWindowCompat$KitKatListPopupWindowImpl extends ListPopupWindowCompat$BaseListPopupWindowImpl
{
    @Override
    public View$OnTouchListener createDragToOpenListener(final Object o, final View view) {
        return ListPopupWindowCompatKitKat.createDragToOpenListener(o, view);
    }
}
