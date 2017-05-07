// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.kids;

import android.view.View$OnClickListener;
import java.io.Serializable;
import com.netflix.mediaclient.service.ServiceAgent;
import android.view.MenuItem;
import android.view.Menu;
import com.netflix.mediaclient.ui.profiles.ProfileSelectionActivity;
import android.view.ViewConfiguration;
import android.graphics.drawable.Drawable;
import android.widget.ListView;
import android.content.res.Resources;
import android.content.Context;
import com.netflix.mediaclient.util.DeviceUtils;
import com.netflix.mediaclient.servicemgr.ServiceManager;
import com.netflix.mediaclient.service.configuration.KidsOnPhoneConfiguration;
import com.netflix.mediaclient.ui.lomo.BasePaginatedAdapter;
import android.view.ViewGroup$LayoutParams;
import android.widget.AbsListView$LayoutParams;
import android.view.View;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;
import java.util.Iterator;
import com.netflix.mediaclient.servicemgr.model.user.UserProfile;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import android.content.Intent;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import android.app.Activity;

public class KidsUtils
{
    private static final float LIST_VIEW_FRICTION_SCALE_FACTOR = 7.5f;
    public static final int MAX_NUM_CW_VIDEOS = 3;
    public static final int NUM_LOMOS_TO_FETCH_PER_BATCH = 20;
    public static final int NUM_VIDEOS_PER_BATCH = 5;
    private static final String TAG = "KidsUtils";
    
    private static boolean accountHasKidsProfile(final NetflixActivity netflixActivity) {
        if (netflixActivity == null) {
            Log.w("KidsUtils", "Null activity - can't get profiles");
        }
        else {
            if (netflixActivity.getServiceManager() == null) {
                Log.w("KidsUtils", "Null service man - can't get profiles");
                return false;
            }
            if (netflixActivity.getServiceManager().getAllProfiles() == null) {
                Log.w("KidsUtils", "Null profiles list - can't get profiles");
                return false;
            }
            final Iterator<? extends UserProfile> iterator = netflixActivity.getServiceManager().getAllProfiles().iterator();
            while (iterator.hasNext()) {
                if (((UserProfile)iterator.next()).isKidsProfile()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void addListViewSpacerIfNoHeaders(final StickyListHeadersListView stickyListHeadersListView) {
        if (stickyListHeadersListView.getHeaderViewsCount() == 0) {
            final View view = new View(stickyListHeadersListView.getContext());
            view.setLayoutParams((ViewGroup$LayoutParams)new AbsListView$LayoutParams(-1, stickyListHeadersListView.getResources().getDimensionPixelSize(2131361960)));
            stickyListHeadersListView.addHeaderView(view);
        }
    }
    
    public static int computeCharacterViewSize(final NetflixActivity netflixActivity, final boolean b) {
        return BasePaginatedAdapter.computeViewPagerWidth(netflixActivity, b) / 2;
    }
    
    public static int computeHorizontalRowHeight(final NetflixActivity netflixActivity, final boolean b) {
        return (int)(BasePaginatedAdapter.computeViewPagerWidth(netflixActivity, b) * 0.5625f);
    }
    
    public static int computeRowHeight(final NetflixActivity netflixActivity, final boolean b) {
        final int computeViewPagerWidth;
        final int n = computeViewPagerWidth = BasePaginatedAdapter.computeViewPagerWidth(netflixActivity, b);
        final ServiceManager serviceManager = netflixActivity.getServiceManager();
        if (serviceManager == null) {
            Log.w("KidsUtils", "Null service manager in computeRowHeight()");
            return computeViewPagerWidth;
        }
        int n2 = computeViewPagerWidth;
        if (serviceManager.getConfiguration().getKidsOnPhoneConfiguration().getLolomoImageType() == KidsOnPhoneConfiguration.LolomoImageType.HORIZONTAL) {
            n2 = (int)(computeViewPagerWidth * 0.5625f);
        }
        if (Log.isLoggable("KidsUtils", 2)) {
            Log.v("KidsUtils", "Computed row height as: " + n2 + ", from width of: " + n);
        }
        return n2;
    }
    
    public static int computeSkidmarkCharacterViewSize(final NetflixActivity netflixActivity) {
        final Resources resources = netflixActivity.getResources();
        return resources.getDimensionPixelSize(2131361959) + ((DeviceUtils.getScreenWidthInPixels((Context)netflixActivity) - resources.getDimensionPixelSize(2131361958)) / 2 - resources.getDimensionPixelSize(2131361958));
    }
    
    public static int computeSkidmarkRowHeight(final NetflixActivity netflixActivity, int n, int n2, int n3, final int n4, final boolean b) {
        n3 = (n = DeviceUtils.getScreenWidthInPixels((Context)netflixActivity) - n - n3 + n2 + n4);
        final ServiceManager serviceManager = netflixActivity.getServiceManager();
        if (serviceManager == null) {
            Log.w("KidsUtils", "Null service manager in computeRowHeight()");
            return n;
        }
        Label_0069: {
            if (!b) {
                n2 = n;
                if (serviceManager.getConfiguration().getKidsOnPhoneConfiguration().getLolomoImageType() != KidsOnPhoneConfiguration.LolomoImageType.HORIZONTAL) {
                    break Label_0069;
                }
            }
            n2 = (int)(n * 0.5625f);
        }
        if (Log.isLoggable("KidsUtils", 2)) {
            Log.v("KidsUtils", "Computed row height (with margins) as: " + n2 + ", from width of: " + n3);
        }
        return n2;
    }
    
    public static void configureListViewForKids(final NetflixActivity netflixActivity, final ListView listView) {
        if (netflixActivity.isForKids()) {
            listView.setDivider((Drawable)null);
            listView.setFriction(ViewConfiguration.getScrollFriction() * 7.5f);
        }
    }
    
    public static void configureListViewForKids(final NetflixActivity netflixActivity, final StickyListHeadersListView stickyListHeadersListView) {
        if (netflixActivity.isForKids()) {
            stickyListHeadersListView.setDivider(null);
        }
        configureListViewForKids(netflixActivity, stickyListHeadersListView.getWrappedList());
    }
    
    public static Intent createExitKidsIntent(final Activity activity, final UIViewLogging.UIViewCommandName uiViewCommandName) {
        return ProfileSelectionActivity.createSwitchFromKidsIntent(activity, uiViewCommandName);
    }
    
    public static MenuItem createKidsMenuItem(final NetflixActivity netflixActivity, final Menu menu) {
        final MenuItem add = menu.add(0, 2131165245, 0, 2131492968);
        updateKidsMenuItem(netflixActivity, add);
        return add;
    }
    
    private static Intent createSwitchToKidsIntent(final Activity activity, final UIViewLogging.UIViewCommandName uiViewCommandName) {
        return ProfileSelectionActivity.createSwitchToKidsIntent(activity, uiViewCommandName);
    }
    
    private static KidsOnPhoneConfiguration getConfigSafely(final NetflixActivity netflixActivity) {
        if (netflixActivity == null) {
            Log.w("KidsUtils", "Activity is null - can't get kop config");
            return null;
        }
        if (netflixActivity.getServiceManager() == null) {
            Log.w("KidsUtils", "Service man is null - can't get kop config");
            return null;
        }
        if (netflixActivity.getServiceManager().getConfiguration() == null) {
            Log.w("KidsUtils", "Config is null - can't get kop config");
            return null;
        }
        return netflixActivity.getServiceManager().getConfiguration().getKidsOnPhoneConfiguration();
    }
    
    public static boolean isKidsProfile(final UserProfile userProfile) {
        return userProfile != null && userProfile.isKidsProfile();
    }
    
    public static boolean isKidsWithUpDownScrolling(final NetflixActivity netflixActivity) {
        return netflixActivity.isForKids() && netflixActivity.getServiceManager().getConfiguration().getKidsOnPhoneConfiguration().getScrollBehavior() == KidsOnPhoneConfiguration.ScrollBehavior.UP_DOWN;
    }
    
    public static boolean isKoPExperience(final ServiceAgent.ConfigurationAgentInterface configurationAgentInterface, final UserProfile userProfile) {
        return isKidsProfile(userProfile) && isUserInKopExperience(configurationAgentInterface);
    }
    
    public static boolean isUserInKopExperience(final ServiceAgent.ConfigurationAgentInterface configurationAgentInterface) {
        return configurationAgentInterface != null && configurationAgentInterface.getKidsOnPhoneConfiguration() != null && configurationAgentInterface.getKidsOnPhoneConfiguration().isKidsOnPhoneEnabled();
    }
    
    public static boolean shouldShowBackNavigationAffordance(final NetflixActivity netflixActivity) {
        final KidsOnPhoneConfiguration configSafely = getConfigSafely(netflixActivity);
        return netflixActivity.isForKids() && configSafely != null && configSafely.getActionBarNavType() == KidsOnPhoneConfiguration.ActionBarNavType.BACK;
    }
    
    public static boolean shouldShowHorizontalImages(final NetflixActivity netflixActivity) {
        return netflixActivity.getServiceManager().getConfiguration().getKidsOnPhoneConfiguration().getLolomoImageType() == KidsOnPhoneConfiguration.LolomoImageType.HORIZONTAL;
    }
    
    private static boolean shouldShowKidsEntryInActionBar(final NetflixActivity netflixActivity) {
        final KidsOnPhoneConfiguration configSafely = getConfigSafely(netflixActivity);
        return accountHasKidsProfile(netflixActivity) && configSafely != null && configSafely.shouldShowKidsEntryInActionBar();
    }
    
    public static boolean shouldShowKidsEntryInGenreLomo(final NetflixActivity netflixActivity) {
        final KidsOnPhoneConfiguration configSafely = getConfigSafely(netflixActivity);
        return accountHasKidsProfile(netflixActivity) && configSafely != null && configSafely.shouldShowKidsEntryInGenreLomo();
    }
    
    public static boolean shouldShowKidsEntryInMenu(final NetflixActivity netflixActivity) {
        final KidsOnPhoneConfiguration configSafely = getConfigSafely(netflixActivity);
        return accountHasKidsProfile(netflixActivity) && configSafely != null && configSafely.shouldShowKidsEntryInMenu();
    }
    
    public static boolean shouldShowKidsExperience(final NetflixActivity netflixActivity) {
        if (netflixActivity == null) {
            Log.w("KidsUtils", "Activity is null - should not happen");
            return false;
        }
        if (netflixActivity.isForKids()) {
            Log.v("KidsUtils", "Should show kids experience because we're in a kids activity");
            return true;
        }
        final ServiceManager serviceManager = netflixActivity.getServiceManager();
        final boolean b = serviceManager != null && serviceManager.getCurrentProfile() != null && serviceManager.getCurrentProfile().isKidsProfile() && serviceManager.getConfiguration() != null && serviceManager.getConfiguration().getKidsOnPhoneConfiguration() != null && serviceManager.getConfiguration().getKidsOnPhoneConfiguration().isKidsOnPhoneEnabled();
        if (Log.isLoggable("KidsUtils", 2)) {
            Serializable value;
            if (serviceManager == null) {
                value = "null service";
            }
            else if (serviceManager.getCurrentProfile() == null) {
                value = "null profile";
            }
            else {
                value = serviceManager.getCurrentProfile().isKidsProfile();
            }
            Serializable value2;
            if (serviceManager.getConfiguration() == null) {
                value2 = "null config";
            }
            else {
                value2 = serviceManager.getConfiguration().getKidsOnPhoneConfiguration().isKidsOnPhoneEnabled();
            }
            Log.v("KidsUtils", String.format("Should show kids experience - isKidsProfile: %s, KoP enabled: %s, rtn: %s", value, value2, b));
        }
        return b;
    }
    
    public static void updateKidsMenuItem(final NetflixActivity netflixActivity, final MenuItem menuItem) {
        if (menuItem == null) {
            return;
        }
        if (!netflixActivity.getServiceManager().isReady() || !shouldShowKidsEntryInActionBar(netflixActivity)) {
            menuItem.setVisible(false).setEnabled(false);
            return;
        }
        menuItem.setVisible(true).setEnabled(true);
        if (netflixActivity.isForKids()) {
            menuItem.setTitle(2131492973).setIcon(2130837662).setIntent(createExitKidsIntent(netflixActivity, UIViewLogging.UIViewCommandName.actionBarKidsExit)).setShowAsAction(2);
            return;
        }
        menuItem.setTitle(2131492953).setIcon(2130837699).setIntent(createSwitchToKidsIntent(netflixActivity, UIViewLogging.UIViewCommandName.actionBarKidsEntry)).setShowAsAction(2);
    }
    
    public static class OnSwitchToKidsClickListener implements View$OnClickListener
    {
        private final Activity activity;
        private final UIViewLogging.UIViewCommandName entryName;
        
        public OnSwitchToKidsClickListener(final Activity activity, final UIViewLogging.UIViewCommandName entryName) {
            this.activity = activity;
            this.entryName = entryName;
        }
        
        public void onClick(final View view) {
            this.activity.startActivity(createSwitchToKidsIntent(this.activity, this.entryName));
        }
    }
}
