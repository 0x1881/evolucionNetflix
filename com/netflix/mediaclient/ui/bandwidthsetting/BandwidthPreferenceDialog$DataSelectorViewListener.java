// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.bandwidthsetting;

import android.widget.CompoundButton$OnCheckedChangeListener;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.support.v7.widget.SwitchCompat;
import android.widget.TextView;
import android.preference.DialogPreference;
import com.netflix.mediaclient.Log;
import android.view.View;
import android.view.View$OnClickListener;

class BandwidthPreferenceDialog$DataSelectorViewListener implements View$OnClickListener
{
    final /* synthetic */ BandwidthPreferenceDialog this$0;
    
    BandwidthPreferenceDialog$DataSelectorViewListener(final BandwidthPreferenceDialog this$0) {
        this.this$0 = this$0;
    }
    
    public void onClick(final View view) {
        if (this.this$0.isAutoSelectorViewOn()) {
            Log.d("nf_bw", "ignore manual selection - in auto mode");
        }
        else {
            final BandwidthPreferenceDialog$ManualBwChoice undefined = BandwidthPreferenceDialog$ManualBwChoice.UNDEFINED;
            BandwidthPreferenceDialog$ManualBwChoice bandwidthPreferenceDialog$ManualBwChoice = null;
            switch (view.getId()) {
                default: {
                    Log.d("nf_bw", "Ignoring click on unknown view");
                    bandwidthPreferenceDialog$ManualBwChoice = undefined;
                    break;
                }
                case 2131624573:
                case 2131624574: {
                    bandwidthPreferenceDialog$ManualBwChoice = BandwidthPreferenceDialog$ManualBwChoice.OFF;
                    break;
                }
                case 2131624577:
                case 2131624578: {
                    bandwidthPreferenceDialog$ManualBwChoice = BandwidthPreferenceDialog$ManualBwChoice.LOW;
                    break;
                }
                case 2131624581:
                case 2131624582: {
                    bandwidthPreferenceDialog$ManualBwChoice = BandwidthPreferenceDialog$ManualBwChoice.MEDIUM;
                    break;
                }
                case 2131624585:
                case 2131624586: {
                    bandwidthPreferenceDialog$ManualBwChoice = BandwidthPreferenceDialog$ManualBwChoice.HIGH;
                    break;
                }
                case 2131624589:
                case 2131624590: {
                    bandwidthPreferenceDialog$ManualBwChoice = BandwidthPreferenceDialog$ManualBwChoice.UNLIMITED;
                    break;
                }
            }
            if (bandwidthPreferenceDialog$ManualBwChoice != BandwidthPreferenceDialog$ManualBwChoice.UNDEFINED) {
                this.this$0.unselectManualChoices();
                this.this$0.selectManualChoice(bandwidthPreferenceDialog$ManualBwChoice);
            }
        }
    }
}
