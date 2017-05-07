// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.social.notifications;

import com.netflix.mediaclient.util.log.UIViewLogUtils;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import com.netflix.mediaclient.util.SocialUtils;
import android.os.Bundle;
import android.app.Activity;
import java.util.List;
import java.util.ArrayList;
import android.content.IntentFilter;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.ui.player.PlayerActivity;
import com.netflix.mediaclient.ui.common.PlayContextImp;
import org.json.JSONException;
import com.netflix.model.leafs.social.SocialNotificationsListSummary;
import com.netflix.mediaclient.service.logging.error.ErrorLoggingManager;
import com.netflix.mediaclient.servicemgr.ManagerCallback;
import android.widget.ListAdapter;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.StatusCode;
import org.json.JSONObject;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlayContext;
import com.netflix.mediaclient.android.app.Status;
import android.view.View$OnClickListener;
import java.util.HashSet;
import android.content.BroadcastReceiver;
import com.netflix.mediaclient.servicemgr.ServiceManager;
import com.netflix.model.leafs.social.SocialNotificationSummary;
import java.util.Set;
import com.netflix.mediaclient.android.widget.StaticListView;
import com.netflix.mediaclient.servicemgr.interface_.search.SocialNotificationsList;
import com.netflix.mediaclient.android.widget.ErrorWrapper$Callback;
import com.netflix.mediaclient.android.fragment.NetflixFrag;

public class NotificationsFrag extends NetflixFrag
{
    private static final String BUNDLE_EXTRA_HAS_LOAD_MORE = "has_load_more_list";
    private static final String BUNDLE_EXTRA_NOTIFICATIONS_LIST = "notifications_list";
    private static final String BUNDLE_EXTRA_NOTIFICATIONS_LIST_TO_BE_READ = "notifications_list_to_be_read";
    private static final String BUNDLE_EXTRA_NOTIFICATIONS_WERE_FETCHED = "were_notifications_fetched";
    private static final String BUNDLE_EXTRA_NOTIFICATIONS_WERE_FOUND = "are_there_noitifcations";
    private static final String TAG;
    private final ErrorWrapper$Callback errorCallback;
    private NotificationsFrag$NotificationsListAdapter mAdapter;
    private boolean mAreNotificationsPresent;
    private boolean mAreReceiversRegistered;
    private boolean mAreViewsCreated;
    private boolean mIsLoadingData;
    private NotificationsFrag$NotificationsListStatusListener mListener;
    private boolean mLoadMoreAvailable;
    private boolean mNetworkErrorOccured;
    private SocialNotificationsList mNotifications;
    protected StaticListView mNotificationsList;
    private final Set<SocialNotificationSummary> mNotificationsToBeRead;
    private ServiceManager mServiceManager;
    private boolean mWasRefreshForTopViewScheduled;
    private boolean mWereNotificationsFetched;
    private final BroadcastReceiver socialNotificationsListUpdateReceiver;
    
    static {
        TAG = NotificationsFrag.class.getSimpleName();
    }
    
    public NotificationsFrag() {
        this.mLoadMoreAvailable = true;
        this.mNotificationsToBeRead = new HashSet<SocialNotificationSummary>();
        this.errorCallback = new NotificationsFrag$1(this);
        this.socialNotificationsListUpdateReceiver = new NotificationsFrag$6(this);
    }
    
    private boolean areMoreNotificationsAvailable() {
        return this.canLoadMultiplePages() && this.mLoadMoreAvailable;
    }
    
    private boolean checkForNetworkError(final Status status) {
        this.mIsLoadingData = false;
        if (status.getStatusCode() == StatusCode.NETWORK_ERROR) {
            this.mNetworkErrorOccured = true;
            if (this.mAdapter != null) {
                this.mAdapter.notifyDataSetChanged();
            }
            return true;
        }
        return this.mNetworkErrorOccured = false;
    }
    
    private void completeInitIfPossible() {
        if (!this.mAreViewsCreated) {
            Log.v(NotificationsFrag.TAG, "Can't complete init - views not created");
            return;
        }
        if (this.mServiceManager == null) {
            Log.v(NotificationsFrag.TAG, "Can't complete init - manager not ready");
            return;
        }
        this.mAdapter = new NotificationsFrag$NotificationsListAdapter(this, null);
        this.mNotificationsList.setAdapter((ListAdapter)this.mAdapter);
        if (this.mNotifications == null) {
            this.fetchNotificationsList(true);
            return;
        }
        this.mIsLoadingData = false;
        this.mAdapter.notifyDataSetChanged();
    }
    
    private void fetchNotificationsList(final boolean b) {
        if (this.mServiceManager != null) {
            this.mIsLoadingData = true;
            this.mServiceManager.getBrowse().fetchNotificationsList(0, this.getNumNotificationsPerPage() - 1, new NotificationsFrag$4(this, NotificationsFrag.TAG));
        }
    }
    
    private View$OnClickListener getClickListener(String string, final SocialNotificationSummary socialNotificationSummary, final int n) {
        if (string == null) {
            Log.w(NotificationsFrag.TAG, "SPY-8161 - Got null target value");
            ErrorLoggingManager.logHandledException("SPY-8161 - Got null target value");
            return this.getDisplayListener(socialNotificationSummary, n);
        }
        final String upperCase = string.toUpperCase();
        switch (upperCase) {
            default: {
                string = "SPY-8161 - Got unsupported target value: " + string;
                Log.w(NotificationsFrag.TAG, string);
                ErrorLoggingManager.logHandledException(string);
                return this.getDisplayListener(socialNotificationSummary, n);
            }
            case "PLAYBACK": {
                return this.getPlaybackListener(socialNotificationSummary, n);
            }
            case "DISPLAY": {
                return this.getDisplayListener(socialNotificationSummary, n);
            }
        }
    }
    
    private View$OnClickListener getDisplayListener(final SocialNotificationSummary socialNotificationSummary, final int n) {
        final String videoId = socialNotificationSummary.getVideoId();
        final VideoType videoType = socialNotificationSummary.getVideoType();
        final SocialNotificationsListSummary socialNotificationsListSummary = this.mNotifications.getSocialNotificationsListSummary();
        return (View$OnClickListener)new NotificationsFrag$3(this, socialNotificationSummary, socialNotificationsListSummary.getRequestId(), socialNotificationsListSummary, videoType, videoId, n);
    }
    
    private JSONObject getModelObject(final SocialNotificationSummary socialNotificationSummary, final int n) {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("position", n);
            jsonObject.put("trackId", this.mNotifications.getSocialNotificationsListSummary().getBaseTrackId());
            jsonObject.put("messageGuid", (Object)socialNotificationSummary.getId());
            jsonObject.put("titleId", (Object)socialNotificationSummary.getVideoId());
            return jsonObject;
        }
        catch (JSONException ex) {
            Log.w(NotificationsFrag.TAG, "getModelObject() got an exception", (Throwable)ex);
            return jsonObject;
        }
    }
    
    private View$OnClickListener getPlaybackListener(final SocialNotificationSummary socialNotificationSummary, final int n) {
        final String videoId = socialNotificationSummary.getVideoId();
        final VideoType videoType = socialNotificationSummary.getVideoType();
        final SocialNotificationsListSummary socialNotificationsListSummary = this.mNotifications.getSocialNotificationsListSummary();
        return (View$OnClickListener)new NotificationsFrag$2(this, videoId, new PlayContextImp(socialNotificationsListSummary.getRequestId(), socialNotificationsListSummary.getPlayerTrackId(), 0, 0), videoType, socialNotificationSummary, n);
    }
    
    private int getVisibleNotificationsNumber() {
        if (this.mNotifications == null || this.mNotifications.getSocialNotifications() == null) {
            return 0;
        }
        if (this.getNumNotificationsPerPage() < this.mNotifications.getSocialNotifications().size()) {
            return this.getNumNotificationsPerPage();
        }
        return this.mNotifications.getSocialNotifications().size();
    }
    
    private void loadMoreNotifications() {
        if (this.mServiceManager != null && this.mNotifications != null && this.mNotifications.getSocialNotifications() != null) {
            this.mIsLoadingData = true;
            this.mServiceManager.getBrowse().fetchNotificationsList(this.mNotifications.getSocialNotifications().size(), this.mNotifications.getSocialNotifications().size() + this.getNumNotificationsPerPage() - 1, new NotificationsFrag$5(this, NotificationsFrag.TAG));
        }
    }
    
    private void playVideo(final String s, final PlayContext playContext, final VideoType videoType) {
        this.startActivity(PlayerActivity.createColdStartIntent(this.getActivity(), s, videoType, playContext));
    }
    
    private void refreshNotificationMyListButtons() {
        if (this.mServiceManager != null) {
            for (int i = this.mNotificationsList.getFirstVisiblePosition(); i <= this.mNotificationsList.getLastVisiblePosition(); ++i) {
                if (this.mAdapter != null && this.mAdapter.getItem(i) != null) {
                    final SocialNotificationSummary item = this.mAdapter.getItem(i);
                    this.mServiceManager.updateMyListState(item.getVideoId(), item.getInQueueValue());
                }
                else if (Log.isLoggable()) {
                    Log.e(NotificationsFrag.TAG, "refreshNotificationMyListButtons() got null details for position: " + i);
                }
            }
        }
    }
    
    private void refreshNotificationsListStatus() {
        this.mAreNotificationsPresent = (this.mNotifications != null && this.mNotifications.getSocialNotifications() != null && this.mNotifications.getSocialNotifications().size() > 0);
        if (this.mListener != null) {
            this.mListener.onNotificationsListUpdated(this.mAreNotificationsPresent);
        }
    }
    
    private void registerReceivers() {
        if (this.isAdded() && !this.mAreReceiversRegistered) {
            this.mAreReceiversRegistered = true;
            LocalBroadcastManager.getInstance((Context)this.getActivity()).registerReceiver(this.socialNotificationsListUpdateReceiver, new IntentFilter("com.netflix.mediaclient.intent.action.BA_NOTIFICATION_LIST_UPDATED"));
        }
    }
    
    private void unregisterReceivers() {
        if (this.mAreReceiversRegistered) {
            LocalBroadcastManager.getInstance((Context)this.getActivity()).unregisterReceiver(this.socialNotificationsListUpdateReceiver);
        }
    }
    
    public boolean areNotificationsPresent() {
        return this.mAreNotificationsPresent;
    }
    
    protected boolean canLoadMultiplePages() {
        return true;
    }
    
    protected int computeRowCount() {
        if (!this.mAreNotificationsPresent) {
            return 0;
        }
        if (this.areMoreNotificationsAvailable()) {
            return this.mNotifications.getSocialNotifications().size() + 1;
        }
        return this.mNotifications.getSocialNotifications().size();
    }
    
    protected int getNumNotificationsPerPage() {
        return 20;
    }
    
    protected int getRowLayoutResourceId() {
        return 2130903234;
    }
    
    protected boolean isListViewStatic() {
        return false;
    }
    
    public boolean isLoadingData() {
        return this.mIsLoadingData;
    }
    
    public void markNotificationsAsRead() {
        if (this.mNotifications != null && this.mNotifications.getSocialNotifications() != null && this.mNotifications.getSocialNotifications().size() > 0) {
            final ArrayList<SocialNotificationSummary> list = new ArrayList<SocialNotificationSummary>();
            for (int visibleNotificationsNumber = this.getVisibleNotificationsNumber(), i = 0; i < visibleNotificationsNumber; ++i) {
                final SocialNotificationSummary socialNotificationSummary = this.mNotifications.getSocialNotifications().get(i);
                if (!socialNotificationSummary.getWasRead()) {
                    list.add(socialNotificationSummary);
                }
            }
            if (list.size() > 0) {
                this.mServiceManager.getBrowse().markNotificationsAsRead(list);
            }
        }
    }
    
    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        this.registerReceivers();
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("notifications_list")) {
            this.mLoadMoreAvailable = bundle.getBoolean("has_load_more_list");
            this.mNotifications = (SocialNotificationsList)bundle.getParcelable("notifications_list");
            SocialUtils.castArrayToSet(bundle.getParcelableArray("notifications_list_to_be_read"), this.mNotificationsToBeRead);
            this.mWereNotificationsFetched = bundle.getBoolean("were_notifications_fetched");
            this.mAreNotificationsPresent = bundle.getBoolean("are_there_noitifcations");
            this.refreshNotificationsListStatus();
        }
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        Log.v(NotificationsFrag.TAG, "Creating new frag view...");
        this.mAreViewsCreated = true;
        final View inflate = layoutInflater.inflate(2130903233, viewGroup, false);
        (this.mNotificationsList = (StaticListView)inflate.findViewById(2131624535)).setItemsCanFocus(true);
        this.mNotificationsList.setAsStatic(this.isListViewStatic());
        this.mIsLoadingData = true;
        this.completeInitIfPossible();
        return inflate;
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        this.unregisterReceivers();
    }
    
    @Override
    public void onManagerReady(final ServiceManager mServiceManager, final Status status) {
        super.onManagerReady(mServiceManager, status);
        this.mServiceManager = mServiceManager;
        this.completeInitIfPossible();
    }
    
    public void onPause() {
        super.onPause();
    }
    
    public void onResume() {
        super.onResume();
        this.refreshNotificationMyListButtons();
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mNotifications != null) {
            bundle.putBoolean("has_load_more_list", this.areMoreNotificationsAvailable());
            bundle.putParcelable("notifications_list", this.mNotifications.getParcelable());
            bundle.putParcelableArray("notifications_list_to_be_read", (Parcelable[])this.mNotificationsToBeRead.toArray((Parcelable[])new SocialNotificationSummary[this.mNotificationsToBeRead.size()]));
            bundle.putBoolean("were_notifications_fetched", this.mWereNotificationsFetched);
        }
        bundle.putBoolean("are_there_noitifcations", this.mAreNotificationsPresent);
    }
    
    public void refresh() {
        this.fetchNotificationsList(true);
    }
    
    public void reportNotificationsImpression(final boolean b) {
        int i = 0;
    Label_0100_Outer:
        while (i < this.getVisibleNotificationsNumber()) {
            final SocialNotificationSummary socialNotificationSummary = this.mNotifications.getSocialNotifications().get(i);
            while (true) {
                Label_0115: {
                    if (!b) {
                        break Label_0115;
                    }
                    final JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("position", i);
                        jsonObject.put("isRead", socialNotificationSummary.getWasRead());
                        jsonObject.put("messageGuid", (Object)socialNotificationSummary.getId());
                        jsonObject.put("titleId", (Object)socialNotificationSummary.getVideoId());
                        UIViewLogUtils.reportNotificationImpressionStarted((Context)this.getActivity(), jsonObject);
                        ++i;
                        continue Label_0100_Outer;
                    }
                    catch (JSONException ex) {
                        ex.printStackTrace();
                        continue;
                    }
                }
                UIViewLogUtils.reportNotificationImpressionEnded((Context)this.getActivity(), true);
                continue;
            }
        }
    }
    
    public void setNotificationsListStatusListener(final NotificationsFrag$NotificationsListStatusListener mListener) {
        this.mListener = mListener;
    }
    
    protected boolean shouldShowPlayButtonFromNotifications() {
        return true;
    }
}
