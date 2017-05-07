// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.common;

import android.widget.TabHost$TabSpec;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost$OnTabChangeListener;

public final class LanguageSelectorPhone extends LanguageSelector implements TabHost$OnTabChangeListener
{
    private static final String LIST_AUDIOS_TAB_TAG = "ListAudios";
    private static final String LIST_SUBTITLES_TAB_TAG = "ListSubtitles";
    protected TextView mAudioTabLabel;
    protected TextView mSubtitleTabLabel;
    protected TabHost mTabHost;
    
    public LanguageSelectorPhone(final NetflixActivity netflixActivity, final LanguageSelector$LanguageSelectorCallback languageSelector$LanguageSelectorCallback) {
        super(netflixActivity, languageSelector$LanguageSelectorCallback);
    }
    
    private int calculateMaxNumberOfItems() {
        int i = 0;
        final Language language = this.getLanguage();
        if (language != null) {
            if (language.getAltAudios() == null) {
                if (language.getSubtitles() != null) {
                    return language.getSubtitles().length;
                }
            }
            else {
                if (language.getSubtitles() == null) {
                    return language.getAltAudios().length;
                }
                Log.d("nf_language_selector", "Calculate maximal item number");
                if (language.getAltAudios().length >= language.getSubtitles().length) {
                    if (Log.isLoggable("nf_language_selector", 3)) {
                        Log.d("nf_language_selector", "More audios, max number of items: " + language.getAltAudios().length);
                    }
                    return language.getAltAudios().length;
                }
                if (Log.isLoggable("nf_language_selector", 3)) {
                    Log.d("nf_language_selector", "More subtitles,  audos: " + language.getAltAudios().length + " < subtitles " + language.getSubtitles().length + ". Check dependencies.");
                }
                int length = language.getAltAudios().length;
                while (i < language.getAltAudios().length) {
                    final int n = language.getSubtitles().length - language.getAltAudios()[i].getDisallowedSubtitles().length;
                    int n2;
                    if ((n2 = length) < n) {
                        n2 = n;
                    }
                    ++i;
                    length = n2;
                }
                if (Log.isLoggable("nf_language_selector", 3)) {
                    Log.d("nf_language_selector", "Max number of items: " + length);
                }
                return length;
            }
        }
        return 0;
    }
    
    private View getTabIndicator(final Context context, final TabHost tabHost, final int text, final boolean b) {
        final View inflate = LayoutInflater.from(context).inflate(2130903115, (ViewGroup)null, false);
        final TextView textView = (TextView)inflate.findViewById(2131165441);
        textView.setText(text);
        if (b) {
            Log.d("nf_language_selector", "Set audio tab label");
            this.mAudioTabLabel = textView;
            return inflate;
        }
        Log.d("nf_language_selector", "Set subtitle tab label");
        this.mSubtitleTabLabel = textView;
        return inflate;
    }
    
    private void setNewTab(final Context context, final TabHost tabHost, final String s, final int n, final int content, final boolean b) {
        final TabHost$TabSpec tabSpec = tabHost.newTabSpec(s);
        tabSpec.setIndicator(this.getTabIndicator(tabHost.getContext(), tabHost, n, b));
        tabSpec.setContent(content);
        tabHost.addTab(tabSpec);
    }
    
    @Override
    protected int calculateListViewHeight() {
        Log.d("nf_language_selector", "Phone calculate height");
        final int n = (int)this.mController.getResources().getDimension(2131361891);
        final int n2 = (int)this.mController.getResources().getDimension(2131361890);
        final int n3 = (int)this.mController.getResources().getDimension(2131361916);
        int intrinsicHeight;
        if ((intrinsicHeight = this.mController.getResources().getDrawable(2130837731).getIntrinsicHeight()) == -1) {
            intrinsicHeight = (int)this.mController.getResources().getDimension(2131361917);
        }
        final int n4 = (intrinsicHeight + n3) * this.calculateMaxNumberOfItems();
        if (Log.isLoggable("nf_language_selector", 3)) {
            Log.d("nf_language_selector", "Max height " + n2 + " px, item height " + n3 + " px, proposed list height " + n4 + " px, item divider height" + " px");
        }
        int n5;
        if (n4 <= n) {
            n5 = n;
        }
        else if ((n5 = n4) >= n2) {
            return n2;
        }
        return n5;
    }
    
    @Override
    protected int getDialogLayoutId() {
        Log.d("nf_language_selector", "Phone R.layout.language_selector_dialog");
        return 2130903113;
    }
    
    @Override
    protected void init(final View view, final Language language) {
        super.init(view, language);
        Log.d("nf_language_selector", "Add tabhost");
        (this.mTabHost = (TabHost)view.findViewById(2131165435)).setOnTabChangedListener((TabHost$OnTabChangeListener)this);
        this.mTabHost.setup();
        this.setNewTab((Context)this.mController, this.mTabHost, "ListAudios", 2131493103, 2131165436, true);
        this.setNewTab((Context)this.mController, this.mTabHost, "ListSubtitles", 2131493102, 2131165437, false);
        this.mTabHost.setCurrentTab(0);
        this.mAudioTabLabel.setTypeface(this.mAudioTabLabel.getTypeface(), 1);
        this.mSubtitleTabLabel.setTypeface(this.mSubtitleTabLabel.getTypeface(), 0);
        Log.d("nf_language_selector", "Done with tabhost");
    }
    
    public void onTabChanged(final String s) {
        if (Log.isLoggable("nf_language_selector", 3)) {
            Log.d("nf_language_selector", "Switched to " + s);
        }
        if ("ListAudios".equals(s)) {
            if (this.mAudioTabLabel != null) {
                this.mAudioTabLabel.setTypeface(this.mAudioTabLabel.getTypeface(), 1);
            }
            else {
                Log.d("nf_language_selector", "audio label is NULL!");
            }
            if (this.mSubtitleTabLabel != null) {
                this.mSubtitleTabLabel.setTypeface(this.mSubtitleTabLabel.getTypeface(), 0);
                return;
            }
            Log.d("nf_language_selector", "subtitle label is NULL!");
        }
        else {
            if (this.mAudioTabLabel != null) {
                this.mAudioTabLabel.setTypeface(this.mAudioTabLabel.getTypeface(), 0);
            }
            else {
                Log.d("nf_language_selector", "audio label is NULL!");
            }
            if (this.mSubtitleTabLabel != null) {
                this.mSubtitleTabLabel.setTypeface(this.mSubtitleTabLabel.getTypeface(), 1);
                return;
            }
            Log.d("nf_language_selector", "subtitle label is NULL!");
        }
    }
}
