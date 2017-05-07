// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.android.widget;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.MenuItem;
import android.app.Activity;
import com.netflix.mediaclient.util.DeviceUtils;
import com.netflix.mediaclient.ui.home.HomeActivity;
import com.netflix.mediaclient.ui.kids.KidsUtils;
import java.security.InvalidParameterException;
import com.netflix.mediaclient.Log;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import com.netflix.mediaclient.android.activity.NetflixActivity;

public class NetflixActionBar
{
    private static final int HIDE_ANIMATION_DURATION = 300;
    private static final String TAG = "NetflixActionBar";
    protected final NetflixActivity activity;
    protected boolean hasUpAction;
    private View homeView;
    protected ActionBar systemActionBar;
    protected Toolbar toolBar;
    
    public NetflixActionBar(final NetflixActivity netflixActivity, final boolean hasUpAction) {
        this.hasUpAction = hasUpAction;
        this.activity = netflixActivity;
        this.attachToolBarToViewHierarchy();
        this.setToolBarAsActionBar(netflixActivity);
        this.init(netflixActivity, hasUpAction);
        this.setHomeView();
    }
    
    private void attachToolBarToViewHierarchy() {
        this.toolBar = (Toolbar)LayoutInflater.from((Context)this.activity).inflate(this.getLayoutId(), (ViewGroup)null);
        final ViewGroup viewGroup = (ViewGroup)this.activity.findViewById(16908290);
        if (viewGroup != null && this.toolBar != null) {
            viewGroup.addView((View)this.toolBar, new ViewGroup$LayoutParams(-1, this.activity.getActionBarHeight()));
        }
    }
    
    private void init(final NetflixActivity netflixActivity, final boolean displayHomeAsUpEnabled) {
        this.systemActionBar.setDisplayShowTitleEnabled(true);
        this.systemActionBar.setDisplayShowHomeEnabled(true);
        this.systemActionBar.setDisplayUseLogoEnabled(true);
        this.systemActionBar.setHomeButtonEnabled(true);
        this.systemActionBar.setLogo(2130837504);
        this.setupFocusability();
        this.setLogoType(NetflixActionBar$LogoType.FULL_SIZE);
        this.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
    }
    
    private boolean performUpAction() {
        if (this.activity != null && this.hasUpAction) {
            Log.v("NetflixActionBar", "performing up action");
            this.activity.performUpAction();
            return true;
        }
        return false;
    }
    
    private void setHomeView() {
        if (this.toolBar != null && this.toolBar.getChildCount() > 1) {
            for (int i = 0; i < this.toolBar.getChildCount(); ++i) {
                final View child = this.toolBar.getChildAt(i);
                final String s = (String)child.getContentDescription();
                if (s != null && (s.toLowerCase().contains("nav") || s.toLowerCase().contains("toggle"))) {
                    this.homeView = child;
                    break;
                }
            }
        }
    }
    
    private void setToolBarAsActionBar(final NetflixActivity netflixActivity) {
        if (this.toolBar != null) {
            netflixActivity.setSupportActionBar(this.toolBar);
        }
        this.systemActionBar = netflixActivity.getSupportActionBar();
        if (this.systemActionBar == null) {
            throw new InvalidParameterException("ActionBar is null");
        }
    }
    
    private void setupFocusability() {
        final View viewById = this.activity.findViewById(16908332);
        if (viewById != null) {
            final ViewGroup viewGroup = (ViewGroup)viewById.getParent();
            viewGroup.setFocusable(false);
            final View view = (View)viewGroup.getParent();
            if (view != null) {
                view.setFocusable(false);
            }
        }
    }
    
    protected void configureBackButtonIfNecessary(final boolean b) {
        if (KidsUtils.shouldShowBackNavigationAffordance(this.activity) && !(this.activity instanceof HomeActivity)) {
            final ActionBar supportActionBar = this.activity.getSupportActionBar();
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowHomeEnabled(false);
            if (b && DeviceUtils.getScreenResolutionDpi(this.activity) < 320) {
                return;
            }
        }
    }
    
    protected Activity getActivity() {
        return this.activity;
    }
    
    protected int getFullSizeLogoId() {
        return 2130837504;
    }
    
    public View getHomeView() {
        return this.homeView;
    }
    
    protected int getLayoutId() {
        return 2130903063;
    }
    
    public boolean handleHomeButtonSelected(final MenuItem menuItem) {
        Log.v("NetflixActionBar", "handleHomeButtonSelected, id: " + menuItem.getItemId());
        return menuItem.getItemId() == 16908332 && this.performUpAction();
    }
    
    public void hide(final boolean b) {
        if (b) {
            final TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float)(-this.activity.getActionBarHeight()));
            translateAnimation.setDuration(300L);
            this.toolBar.startAnimation((Animation)translateAnimation);
        }
        this.systemActionBar.hide();
    }
    
    public boolean isShowing() {
        return this.systemActionBar != null && this.systemActionBar.isShowing();
    }
    
    public void onManagerReady() {
    }
    
    public void setBackgroundResource(final int n) {
        this.systemActionBar.setBackgroundDrawable(this.activity.getResources().getDrawable(n));
    }
    
    public void setDisplayHomeAsUpEnabled(final boolean b) {
        this.hasUpAction = b;
        this.systemActionBar.setDisplayHomeAsUpEnabled(b);
        this.setHomeView();
    }
    
    public void setLogoType(final NetflixActionBar$LogoType netflixActionBar$LogoType) {
        if (this.systemActionBar == null) {
            return;
        }
        if (netflixActionBar$LogoType == NetflixActionBar$LogoType.GONE) {
            this.systemActionBar.setDisplayUseLogoEnabled(false);
            this.systemActionBar.setDisplayShowTitleEnabled(true);
            return;
        }
        this.systemActionBar.setDisplayShowTitleEnabled(false);
        int fullSizeLogoId = -1;
        if (netflixActionBar$LogoType == NetflixActionBar$LogoType.FULL_SIZE) {
            fullSizeLogoId = this.getFullSizeLogoId();
        }
        Log.v("NetflixActionBar", "set logo: " + fullSizeLogoId);
        this.systemActionBar.setDisplayUseLogoEnabled(true);
        this.systemActionBar.setLogo(fullSizeLogoId);
    }
    
    public void setTitle(final String title) {
        Log.v("NetflixActionBar", "set title: " + title);
        if (this.systemActionBar == null) {
            Log.e("NetflixActionBar", "system actionBar is null");
            return;
        }
        this.systemActionBar.setTitle(title);
    }
    
    public void show(final boolean b) {
        if (b) {
            final TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float)(-this.activity.getActionBarHeight()), 0.0f);
            translateAnimation.setDuration(300L);
            this.toolBar.startAnimation((Animation)translateAnimation);
        }
        this.systemActionBar.show();
    }
}
