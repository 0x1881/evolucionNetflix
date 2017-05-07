// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.details;

import com.netflix.mediaclient.servicemgr.ManagerCallback;
import android.content.Context;
import android.widget.Toast;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.LoggingManagerCallback;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.servicemgr.model.details.VideoDetails;
import android.view.MenuItem$OnMenuItemClickListener;
import com.netflix.mediaclient.servicemgr.ServiceManager;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.search.SearchMenu;
import android.view.Menu;
import android.view.MenuItem;

public class DetailsMenu
{
    private static final String TAG = "DetailsMenu";
    private final DetailsActivity activity;
    private final MenuItem shareItem;
    
    public DetailsMenu(final DetailsActivity activity, final Menu menu, final String s) {
        SearchMenu.addSearchNavigation(this.activity = activity, menu);
        this.shareItem = this.createShareItem(menu);
    }
    
    private MenuItem createShareItem(final Menu menu) {
        final MenuItem add = menu.add((CharSequence)"");
        add.setShowAsAction(0);
        add.setVisible(false);
        return add;
    }
    
    private void updateShareItemAsUnshared() {
        this.shareItem.setTitle(2131493135).setEnabled(false).setVisible(true);
    }
    
    private void updateShareItemToUnshare(final ServiceManager serviceManager, final String s) {
        this.shareItem.setTitle(2131493134).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new UnshareClickHandler(serviceManager, s)).setEnabled(true).setVisible(true);
    }
    
    public void updateShareItem(final ServiceManager serviceManager, final VideoDetails videoDetails) {
        if (serviceManager == null) {
            Log.w("DetailsMenu", "Service manager is null");
            return;
        }
        if (videoDetails.getPlayable().canBeSharedOnFacebook()) {
            this.updateShareItemToUnshare(serviceManager, videoDetails.getId());
            return;
        }
        this.updateShareItemAsUnshared();
    }
    
    private class OnVideoHideCallback extends LoggingManagerCallback
    {
        public OnVideoHideCallback() {
            super("DetailsMenu");
        }
        
        @Override
        public void onVideoHide(final Status status) {
            super.onVideoHide(status);
            DetailsMenu.this.shareItem.setEnabled(true);
            if (status.isError()) {
                Log.w("DetailsMenu", "Invalid status code");
                Toast.makeText((Context)DetailsMenu.this.activity, 2131493136, 1).show();
                return;
            }
            Toast.makeText((Context)DetailsMenu.this.activity, 2131493133, 1).show();
            DetailsMenu.this.updateShareItemAsUnshared();
        }
    }
    
    private class UnshareClickHandler implements MenuItem$OnMenuItemClickListener
    {
        private final ServiceManager serviceMan;
        private final String videoId;
        
        public UnshareClickHandler(final ServiceManager serviceMan, final String videoId) {
            this.serviceMan = serviceMan;
            this.videoId = videoId;
        }
        
        public boolean onMenuItemClick(final MenuItem menuItem) {
            menuItem.setEnabled(false);
            if (this.serviceMan != null) {
                this.serviceMan.getBrowse().hideVideo(this.videoId, new OnVideoHideCallback());
            }
            return true;
        }
    }
}
