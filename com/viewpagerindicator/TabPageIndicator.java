// 
// Decompiled by Procyon v0.5.30
// 

package com.viewpagerindicator;

import android.widget.TextView;
import android.view.View$MeasureSpec;
import android.support.v4.view.PagerAdapter;
import android.widget.LinearLayout$LayoutParams;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import com.viewpagerindicator.android.osp.ViewPager;
import android.view.View$OnClickListener;
import com.viewpagerindicator.android.osp.ViewPager$OnPageChangeListener;
import android.widget.HorizontalScrollView;

public class TabPageIndicator extends HorizontalScrollView implements PageIndicator
{
    private static final CharSequence EMPTY_TITLE;
    private ViewPager$OnPageChangeListener mListener;
    private int mMaxTabWidth;
    private int mSelectedTabIndex;
    private final View$OnClickListener mTabClickListener;
    private final IcsLinearLayout mTabLayout;
    private TabPageIndicator$OnTabReselectedListener mTabReselectedListener;
    private Runnable mTabSelector;
    private ViewPager mViewPager;
    
    static {
        EMPTY_TITLE = "";
    }
    
    public TabPageIndicator(final Context context) {
        this(context, null);
    }
    
    public TabPageIndicator(final Context context, final AttributeSet set) {
        super(context, set);
        this.mTabClickListener = (View$OnClickListener)new TabPageIndicator$1(this);
        this.setHorizontalScrollBarEnabled(false);
        this.addView((View)(this.mTabLayout = new IcsLinearLayout(context, R$attr.vpiTabPageIndicatorStyle)), new ViewGroup$LayoutParams(-2, -1));
    }
    
    private void addTab(final int n, final CharSequence text, final int n2) {
        final TabPageIndicator$TabView tabPageIndicator$TabView = new TabPageIndicator$TabView(this, this.getContext());
        tabPageIndicator$TabView.mIndex = n;
        tabPageIndicator$TabView.setFocusable(true);
        tabPageIndicator$TabView.setOnClickListener(this.mTabClickListener);
        tabPageIndicator$TabView.setText(text);
        if (n2 != 0) {
            tabPageIndicator$TabView.setCompoundDrawablesWithIntrinsicBounds(n2, 0, 0, 0);
        }
        this.mTabLayout.addView((View)tabPageIndicator$TabView, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -1, 1.0f));
    }
    
    private void animateToTab(final int n) {
        final View child = this.mTabLayout.getChildAt(n);
        if (this.mTabSelector != null) {
            this.removeCallbacks(this.mTabSelector);
        }
        this.post(this.mTabSelector = new TabPageIndicator$2(this, child));
    }
    
    public void notifyDataSetChanged() {
        this.mTabLayout.removeAllViews();
        final PagerAdapter adapter = this.mViewPager.getAdapter();
        IconPagerAdapter iconPagerAdapter = null;
        if (adapter instanceof IconPagerAdapter) {
            iconPagerAdapter = (IconPagerAdapter)adapter;
        }
        final int count = adapter.getCount();
        for (int i = 0; i < count; ++i) {
            CharSequence charSequence = adapter.getPageTitle(i);
            if (charSequence == null) {
                charSequence = TabPageIndicator.EMPTY_TITLE;
            }
            int iconResId;
            if (iconPagerAdapter != null) {
                iconResId = iconPagerAdapter.getIconResId(i);
            }
            else {
                iconResId = 0;
            }
            this.addTab(i, charSequence, iconResId);
        }
        if (this.mSelectedTabIndex > count) {
            this.mSelectedTabIndex = count - 1;
        }
        this.setCurrentItem(this.mSelectedTabIndex);
        this.requestLayout();
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mTabSelector != null) {
            this.post(this.mTabSelector);
        }
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mTabSelector != null) {
            this.removeCallbacks(this.mTabSelector);
        }
    }
    
    public void onMeasure(int measuredWidth, final int n) {
        final int mode = View$MeasureSpec.getMode(measuredWidth);
        final boolean fillViewport = mode == 1073741824;
        this.setFillViewport(fillViewport);
        final int childCount = this.mTabLayout.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.mMaxTabWidth = (int)(View$MeasureSpec.getSize(measuredWidth) * 0.4f);
            }
            else {
                this.mMaxTabWidth = View$MeasureSpec.getSize(measuredWidth) / 2;
            }
        }
        else {
            this.mMaxTabWidth = -1;
        }
        final int measuredWidth2 = this.getMeasuredWidth();
        super.onMeasure(measuredWidth, n);
        measuredWidth = this.getMeasuredWidth();
        if (fillViewport && measuredWidth2 != measuredWidth) {
            this.setCurrentItem(this.mSelectedTabIndex);
        }
    }
    
    public void onPageScrollStateChanged(final int n) {
        if (this.mListener != null) {
            this.mListener.onPageScrollStateChanged(n);
        }
    }
    
    public void onPageScrolled(final int n, final float n2, final int n3) {
        if (this.mListener != null) {
            this.mListener.onPageScrolled(n, n2, n3);
        }
    }
    
    public void onPageSelected(final int currentItem) {
        this.setCurrentItem(currentItem);
        if (this.mListener != null) {
            this.mListener.onPageSelected(currentItem);
        }
    }
    
    public void setCurrentItem(final int n) {
        if (this.mViewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.mSelectedTabIndex = n;
        this.mViewPager.setCurrentItem(n);
        for (int childCount = this.mTabLayout.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.mTabLayout.getChildAt(i);
            final boolean selected = i == n;
            child.setSelected(selected);
            if (selected) {
                this.animateToTab(n);
            }
        }
    }
    
    public void setOnPageChangeListener(final ViewPager$OnPageChangeListener mListener) {
        this.mListener = mListener;
    }
    
    public void setOnTabReselectedListener(final TabPageIndicator$OnTabReselectedListener mTabReselectedListener) {
        this.mTabReselectedListener = mTabReselectedListener;
    }
    
    public void setViewPager(final ViewPager mViewPager) {
        if (this.mViewPager == mViewPager) {
            return;
        }
        if (this.mViewPager != null) {
            this.mViewPager.setOnPageChangeListener(null);
        }
        if (mViewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        (this.mViewPager = mViewPager).setOnPageChangeListener(this);
        this.notifyDataSetChanged();
    }
    
    public void setViewPager(final ViewPager viewPager, final int currentItem) {
        this.setViewPager(viewPager);
        this.setCurrentItem(currentItem);
    }
}
