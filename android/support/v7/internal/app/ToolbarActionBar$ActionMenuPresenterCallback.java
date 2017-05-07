// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.internal.app;

import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;
import android.support.v7.internal.widget.AdapterViewCompat$OnItemSelectedListener;
import android.support.v7.app.ActionBar$OnNavigationListener;
import android.widget.SpinnerAdapter;
import android.support.v7.internal.view.menu.y;
import android.view.ViewGroup$LayoutParams;
import android.support.v7.app.ActionBar$LayoutParams;
import android.view.LayoutInflater;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar$Tab;
import android.support.v7.internal.view.menu.j;
import android.view.ViewGroup;
import android.view.View;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.view.Window;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar$OnMenuVisibilityListener;
import java.util.ArrayList;
import android.support.v7.widget.Toolbar$OnMenuItemClickListener;
import android.support.v7.internal.view.menu.g;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.z;

final class ToolbarActionBar$ActionMenuPresenterCallback implements z
{
    private boolean mClosingActionMenu;
    final /* synthetic */ ToolbarActionBar this$0;
    
    private ToolbarActionBar$ActionMenuPresenterCallback(final ToolbarActionBar this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void onCloseMenu(final i i, final boolean b) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.this$0.mToolbar.dismissPopupMenus();
        if (this.this$0.mWindowCallback != null) {
            this.this$0.mWindowCallback.onPanelClosed(8, (Menu)i);
        }
        this.mClosingActionMenu = false;
    }
    
    @Override
    public boolean onOpenSubMenu(final i i) {
        if (this.this$0.mWindowCallback != null) {
            this.this$0.mWindowCallback.onMenuOpened(8, (Menu)i);
            return true;
        }
        return false;
    }
}
