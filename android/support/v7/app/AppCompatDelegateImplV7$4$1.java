// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View$MeasureSpec;
import android.support.v7.internal.widget.ViewUtils;
import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.internal.view.menu.x;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.internal.view.menu.i;
import android.view.View$OnClickListener;
import android.support.v7.internal.widget.ActionBarContextView$1;
import android.support.v7.view.ActionMode;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.text.TextUtils;
import android.support.v7.appcompat.R$id;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v7.appcompat.R$layout;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.internal.widget.AbsActionBarView;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class AppCompatDelegateImplV7$4$1 extends ViewPropertyAnimatorListenerAdapter
{
    final /* synthetic */ AppCompatDelegateImplV7$4 this$1;
    
    AppCompatDelegateImplV7$4$1(final AppCompatDelegateImplV7$4 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        ViewCompat.setAlpha((View)this.this$1.this$0.mActionModeView, 1.0f);
        this.this$1.this$0.mFadeAnim.setListener(null);
        this.this$1.this$0.mFadeAnim = null;
    }
    
    @Override
    public void onAnimationStart(final View view) {
        this.this$1.this$0.mActionModeView.setVisibility(0);
    }
}
