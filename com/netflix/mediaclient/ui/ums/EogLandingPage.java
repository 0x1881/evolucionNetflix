// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.ums;

import com.netflix.mediaclient.ui.home.HomeActivity;
import com.netflix.mediaclient.Log;
import android.view.View;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.servicemgr.IClientLogging$AssetType;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.text.Html;
import com.netflix.mediaclient.util.StringUtils;
import android.text.SpannableString;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import android.widget.LinearLayout;
import com.netflix.mediaclient.android.widget.AdvancedImageView;
import android.widget.TextView;

public class EogLandingPage
{
    private static final String TAG = "eog_landing";
    private TextView mAccount;
    private TextView mBody;
    private TextView mContinue;
    private AdvancedImageView mImage1;
    private AdvancedImageView mImage2;
    private EndOfGrandfatheringActivity mOwner;
    private TextView mPlans;
    private TextView mSkip;
    private LinearLayout mSkipNowButton;
    private TextView mTitle;
    
    EogLandingPage(final EndOfGrandfatheringActivity mOwner) {
        this.mOwner = mOwner;
        this.mTitle = (TextView)mOwner.findViewById(2131624197);
        this.mBody = (TextView)mOwner.findViewById(2131624198);
        this.mContinue = (TextView)mOwner.findViewById(2131624200);
        this.mPlans = (TextView)mOwner.findViewById(2131624202);
        this.mSkip = (TextView)mOwner.findViewById(2131624203);
        this.mAccount = (TextView)mOwner.findViewById(2131624204);
        this.mSkipNowButton = (LinearLayout)mOwner.findViewById(2131624193);
    }
    
    public static SpannableString buildAccountString(final NetflixActivity netflixActivity, final EogAlert eogAlert) {
        if (StringUtils.isEmpty(eogAlert.footerText) || StringUtils.isEmpty(eogAlert.footerLinkText)) {
            return null;
        }
        final SpannableString spannableString = new SpannableString((CharSequence)(eogAlert.footerText + eogAlert.footerLinkText + eogAlert.footerSuffix));
        spannableString.setSpan((Object)new EogLandingPage$1(netflixActivity), eogAlert.footerText.length(), spannableString.length() - 1, 0);
        return spannableString;
    }
    
    public void initUi() {
        if (this.mOwner.canProceed()) {
            final EogAlert eogAlert = this.mOwner.getEogAlert();
            this.mTitle.setText((CharSequence)eogAlert.title);
            if (StringUtils.isNotEmpty(eogAlert.body)) {
                this.mBody.setText((CharSequence)Html.fromHtml(eogAlert.body));
            }
            this.mContinue.setText((CharSequence)eogAlert.continueBtnText);
            this.mPlans.setText((CharSequence)eogAlert.seeOtherPlansText);
            this.mSkip.setText((CharSequence)eogAlert.skipBtnText);
            this.mAccount.setText((CharSequence)buildAccountString(this.mOwner, eogAlert));
            this.mAccount.setMovementMethod(LinkMovementMethod.getInstance());
            final EndOfGrandfatheringActivity mOwner = this.mOwner;
            if (EndOfGrandfatheringActivity.shouldBlockUser(eogAlert.isBlocking)) {
                this.mSkipNowButton.setVisibility(8);
            }
            if (EogUtils.shouldUseLayoutWithImages(eogAlert)) {
                this.mImage1 = (AdvancedImageView)this.mOwner.findViewById(2131624194);
                this.mImage2 = (AdvancedImageView)this.mOwner.findViewById(2131624195);
                if (StringUtils.isNotEmpty(eogAlert.urlImage1) && this.mImage1 != null) {
                    NetflixActivity.getImageLoader((Context)this.mOwner).showImg(this.mImage1, eogAlert.urlImage1, IClientLogging$AssetType.boxArt, "", BrowseExperience.getImageLoaderConfig(), true);
                }
                if (StringUtils.isNotEmpty(eogAlert.urlImage2) && this.mImage2 != null) {
                    NetflixActivity.getImageLoader((Context)this.mOwner).showImg(this.mImage2, eogAlert.urlImage2, IClientLogging$AssetType.boxArt, "", BrowseExperience.getImageLoaderConfig(), true);
                }
            }
        }
    }
    
    public boolean performAction(final View view) {
        if (view == null) {
            Log.e("eog_landing", "EogLandingPage:: null view? This should never happen!");
            return true;
        }
        switch (view.getId()) {
            default: {
                if (Log.isLoggable()) {
                    Log.w("eog_landing", "Uknown view, unable to handle: " + view.getId());
                }
                return false;
            }
            case 2131624201: {
                this.mOwner.goToPlanPage();
                return true;
            }
            case 2131624193: {
                this.mOwner.backPressed();
                return true;
            }
            case 2131624199: {
                this.mOwner.recordPlanSelection();
                if (EndOfGrandfatheringActivity.shouldBlockUser(this.mOwner.getEogAlert().isBlocking)) {
                    this.mOwner.startActivity(HomeActivity.createStartIntent(this.mOwner));
                }
                this.mOwner.finish();
                return true;
            }
        }
    }
}
