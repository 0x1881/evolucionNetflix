// 
// Decompiled by Procyon v0.5.30
// 

package com.facebook.widget;

import android.util.Log;
import java.util.Collection;
import java.util.Collections;
import com.facebook.internal.SessionAuthorizationType;
import android.app.Activity;
import android.content.Intent;
import com.facebook.FacebookException;
import java.util.List;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionDefaultAudience;
import com.facebook.android.R$string;
import android.content.res.TypedArray;
import com.facebook.android.R$styleable;
import com.facebook.internal.Utility;
import com.facebook.Session$StatusCallback;
import android.view.View$OnClickListener;
import com.facebook.Request$GraphUserCallback;
import com.facebook.Request;
import com.facebook.android.R$drawable;
import com.facebook.android.R$dimen;
import com.facebook.android.R$color;
import android.util.AttributeSet;
import android.content.Context;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.facebook.internal.SessionTracker;
import android.support.v4.app.Fragment;
import android.widget.Button;

public class LoginButton extends Button
{
    private static final String TAG;
    private String applicationId;
    private boolean confirmLogout;
    private boolean fetchUserInfo;
    private String loginText;
    private String logoutText;
    private Fragment parentFragment;
    private LoginButton$LoginButtonProperties properties;
    private SessionTracker sessionTracker;
    private GraphUser user;
    private LoginButton$UserInfoChangedCallback userInfoChangedCallback;
    private Session userInfoSession;
    
    static {
        TAG = LoginButton.class.getName();
    }
    
    public LoginButton(final Context context) {
        super(context);
        this.applicationId = null;
        this.user = null;
        this.userInfoSession = null;
        this.properties = new LoginButton$LoginButtonProperties();
        this.initializeActiveSessionWithCachedToken(context);
        this.finishInit();
    }
    
    public LoginButton(final Context context, final AttributeSet set) {
        super(context, set);
        this.applicationId = null;
        this.user = null;
        this.userInfoSession = null;
        this.properties = new LoginButton$LoginButtonProperties();
        if (set.getStyleAttribute() == 0) {
            this.setTextColor(this.getResources().getColor(R$color.com_facebook_loginview_text_color));
            this.setTextSize(0, this.getResources().getDimension(R$dimen.com_facebook_loginview_text_size));
            this.setPadding(this.getResources().getDimensionPixelSize(R$dimen.com_facebook_loginview_padding_left), this.getResources().getDimensionPixelSize(R$dimen.com_facebook_loginview_padding_top), this.getResources().getDimensionPixelSize(R$dimen.com_facebook_loginview_padding_right), this.getResources().getDimensionPixelSize(R$dimen.com_facebook_loginview_padding_bottom));
            this.setWidth(this.getResources().getDimensionPixelSize(R$dimen.com_facebook_loginview_width));
            this.setHeight(this.getResources().getDimensionPixelSize(R$dimen.com_facebook_loginview_height));
            this.setGravity(17);
            if (this.isInEditMode()) {
                this.setBackgroundColor(this.getResources().getColor(R$color.com_facebook_blue));
                this.loginText = "Log in";
            }
            else {
                this.setBackgroundResource(R$drawable.com_facebook_loginbutton_blue);
            }
        }
        this.parseAttributes(set);
        if (!this.isInEditMode()) {
            this.initializeActiveSessionWithCachedToken(context);
        }
    }
    
    public LoginButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.applicationId = null;
        this.user = null;
        this.userInfoSession = null;
        this.properties = new LoginButton$LoginButtonProperties();
        this.parseAttributes(set);
        this.initializeActiveSessionWithCachedToken(context);
    }
    
    private void fetchUserInfo() {
        if (this.fetchUserInfo) {
            final Session openSession = this.sessionTracker.getOpenSession();
            if (openSession != null) {
                if (openSession != this.userInfoSession) {
                    Request.executeBatchAsync(Request.newMeRequest(openSession, new LoginButton$1(this, openSession)));
                    this.userInfoSession = openSession;
                }
            }
            else {
                this.user = null;
                if (this.userInfoChangedCallback != null) {
                    this.userInfoChangedCallback.onUserInfoFetched(this.user);
                }
            }
        }
    }
    
    private void finishInit() {
        this.setOnClickListener((View$OnClickListener)new LoginButton$LoginClickListener(this, null));
        this.setButtonText();
        if (!this.isInEditMode()) {
            this.sessionTracker = new SessionTracker(this.getContext(), new LoginButton$LoginButtonCallback(this, null), null, false);
            this.fetchUserInfo();
        }
    }
    
    private boolean initializeActiveSessionWithCachedToken(final Context context) {
        if (context != null) {
            final Session activeSession = Session.getActiveSession();
            if (activeSession != null) {
                return activeSession.isOpened();
            }
            if (Utility.getMetadataApplicationId(context) != null && Session.openActiveSessionFromCache(context) != null) {
                return true;
            }
        }
        return false;
    }
    
    private void parseAttributes(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, R$styleable.com_facebook_login_view);
        this.confirmLogout = obtainStyledAttributes.getBoolean(0, true);
        this.fetchUserInfo = obtainStyledAttributes.getBoolean(1, true);
        this.loginText = obtainStyledAttributes.getString(2);
        this.logoutText = obtainStyledAttributes.getString(3);
        obtainStyledAttributes.recycle();
    }
    
    private void setButtonText() {
        if (this.sessionTracker != null && this.sessionTracker.getOpenSession() != null) {
            String text;
            if (this.logoutText != null) {
                text = this.logoutText;
            }
            else {
                text = this.getResources().getString(R$string.com_facebook_loginview_log_out_button);
            }
            this.setText((CharSequence)text);
            return;
        }
        String text2;
        if (this.loginText != null) {
            text2 = this.loginText;
        }
        else {
            text2 = this.getResources().getString(R$string.com_facebook_loginview_log_in_button);
        }
        this.setText((CharSequence)text2);
    }
    
    public void clearPermissions() {
        this.properties.clearPermissions();
    }
    
    public SessionDefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }
    
    public SessionLoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }
    
    public LoginButton$OnErrorListener getOnErrorListener() {
        return this.properties.getOnErrorListener();
    }
    
    List<String> getPermissions() {
        return this.properties.getPermissions();
    }
    
    public Session$StatusCallback getSessionStatusCallback() {
        return this.properties.getSessionStatusCallback();
    }
    
    public LoginButton$UserInfoChangedCallback getUserInfoChangedCallback() {
        return this.userInfoChangedCallback;
    }
    
    void handleError(final Exception ex) {
        if (this.properties.onErrorListener != null) {
            if (!(ex instanceof FacebookException)) {
                this.properties.onErrorListener.onError(new FacebookException(ex));
                return;
            }
            this.properties.onErrorListener.onError((FacebookException)ex);
        }
    }
    
    public boolean onActivityResult(final int n, final int n2, final Intent intent) {
        final Session session = this.sessionTracker.getSession();
        return session != null && session.onActivityResult((Activity)this.getContext(), n, n2, intent);
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.sessionTracker != null && !this.sessionTracker.isTracking()) {
            this.sessionTracker.startTracking();
            this.fetchUserInfo();
            this.setButtonText();
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.sessionTracker != null) {
            this.sessionTracker.stopTracking();
        }
    }
    
    public void onFinishInflate() {
        super.onFinishInflate();
        this.finishInit();
    }
    
    public void setApplicationId(final String applicationId) {
        this.applicationId = applicationId;
    }
    
    public void setDefaultAudience(final SessionDefaultAudience defaultAudience) {
        this.properties.setDefaultAudience(defaultAudience);
    }
    
    public void setFragment(final Fragment parentFragment) {
        this.parentFragment = parentFragment;
    }
    
    public void setLoginBehavior(final SessionLoginBehavior loginBehavior) {
        this.properties.setLoginBehavior(loginBehavior);
    }
    
    public void setOnErrorListener(final LoginButton$OnErrorListener onErrorListener) {
        this.properties.setOnErrorListener(onErrorListener);
    }
    
    void setProperties(final LoginButton$LoginButtonProperties properties) {
        this.properties = properties;
    }
    
    public void setPublishPermissions(final List<String> list) {
        this.properties.setPublishPermissions(list, this.sessionTracker.getSession());
    }
    
    public void setReadPermissions(final List<String> list) {
        this.properties.setReadPermissions(list, this.sessionTracker.getSession());
    }
    
    public void setSession(final Session session) {
        this.sessionTracker.setSession(session);
        this.fetchUserInfo();
        this.setButtonText();
    }
    
    public void setSessionStatusCallback(final Session$StatusCallback sessionStatusCallback) {
        this.properties.setSessionStatusCallback(sessionStatusCallback);
    }
    
    public void setUserInfoChangedCallback(final LoginButton$UserInfoChangedCallback userInfoChangedCallback) {
        this.userInfoChangedCallback = userInfoChangedCallback;
    }
}
