// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.util;

import android.graphics.Rect;
import java.util.Comparator;

final class ViewUtils$ViewComparator$2 implements Comparator<ViewUtils$ViewComparator>
{
    @Override
    public int compare(final ViewUtils$ViewComparator viewUtils$ViewComparator, final ViewUtils$ViewComparator viewUtils$ViewComparator2) {
        int n = 1;
        final Rect rect = ViewUtils.getRect(viewUtils$ViewComparator.getView(), true);
        final Rect rect2 = ViewUtils.getRect(viewUtils$ViewComparator2.getView(), true);
        if (rect.top < rect2.top) {
            n = -1;
        }
        else if (rect.top <= rect2.top) {
            return 0;
        }
        return n;
    }
}
