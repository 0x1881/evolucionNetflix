// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.internal.view.StandaloneActionMode;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.view.ActionMode$Callback;
import android.support.v7.internal.app.ToolbarActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.support.v7.internal.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;
import android.support.v7.internal.widget.FitWindowsViewGroup;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.view.LayoutInflater;
import android.support.v7.internal.widget.TintCheckedTextView;
import android.support.v7.internal.widget.TintRadioButton;
import android.support.v7.internal.widget.TintCheckBox;
import android.support.v7.internal.widget.TintSpinner;
import android.support.v7.internal.widget.TintEditText;
import android.os.Build$VERSION;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.view.ViewGroup$LayoutParams;
import android.support.v7.appcompat.R$color;
import android.support.v7.internal.widget.ViewUtils;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.KeyCharacterMap;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.ViewConfiguration;
import android.support.v4.view.ViewCompat;
import android.content.res.Resources$Theme;
import android.support.v7.appcompat.R$id;
import android.support.v7.internal.widget.ProgressBarCompat;
import android.support.v7.appcompat.R$layout;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.support.v7.appcompat.R$style;
import android.support.v7.appcompat.R$attr;
import android.view.KeyEvent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.internal.view.menu.g;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.View;
import android.support.v7.internal.widget.DecorContentParent;
import android.support.v7.internal.widget.ActionBarContextView;
import android.widget.PopupWindow;
import android.support.v7.view.ActionMode;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.app.WindowCallback;
import android.view.Menu;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.z;

final class ActionBarActivityDelegateBase$ActionMenuPresenterCallback implements z
{
    final /* synthetic */ ActionBarActivityDelegateBase this$0;
    
    private ActionBarActivityDelegateBase$ActionMenuPresenterCallback(final ActionBarActivityDelegateBase this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void onCloseMenu(final i i, final boolean b) {
        this.this$0.checkCloseActionMenu(i);
    }
    
    @Override
    public boolean onOpenSubMenu(final i i) {
        final WindowCallback windowCallback = this.this$0.getWindowCallback();
        if (windowCallback != null) {
            windowCallback.onMenuOpened(8, (Menu)i);
        }
        return true;
    }
}
