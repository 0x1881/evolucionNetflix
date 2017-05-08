// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.iko.kong.postplay;

import com.netflix.mediaclient.ui.common.PlayContext;
import com.netflix.mediaclient.service.logging.error.ErrorLoggingManager;
import com.netflix.mediaclient.ui.common.PlayContextImp;
import com.netflix.mediaclient.ui.iko.kong.model.KongInteractivePostPlayModel$KongSound;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.MediaPlayerWrapper$PlaybackEventsListener;
import android.view.TextureView;
import android.view.LayoutInflater;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.mediaclient.android.widget.AdvancedImageView;
import com.netflix.mediaclient.android.widget.PressAnimationFrameLayout;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.io.IOException;
import android.graphics.BitmapFactory;
import com.netflix.mediaclient.util.FileUtils;
import java.io.File;
import com.netflix.mediaclient.util.ThreadUtils;
import android.graphics.Bitmap;
import com.netflix.mediaclient.servicemgr.ManagerCallback;
import com.netflix.mediaclient.servicemgr.IClientLogging$AssetType;
import com.netflix.mediaclient.servicemgr.ServiceManager;
import com.netflix.mediaclient.util.StringUtils;
import com.netflix.mediaclient.android.osp.AsyncTaskCompat;
import android.content.Context;
import com.facebook.device.yearclass.YearClass;
import java.util.Collections;
import com.netflix.mediaclient.ui.iko.kong.model.KongInteractivePostPlayModel;
import com.netflix.mediaclient.service.resfetcher.volley.LocalCachedFileMetadata;
import java.util.Map;
import java.util.List;
import com.netflix.mediaclient.ui.player.PostPlay;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import android.graphics.BitmapFactory$Options;
import com.netflix.mediaclient.ui.common.MediaPlayerWrapper;
import android.view.View;
import android.os.Handler;
import android.animation.Animator;
import android.widget.ImageView;
import com.netflix.mediaclient.servicemgr.interface_.details.VideoDetails;
import android.view.ViewGroup;
import com.netflix.mediaclient.ui.iko.InteractivePostPlayManager;
import com.netflix.mediaclient.Log;

class KongInteractivePostPlayManager$1 implements Runnable
{
    final /* synthetic */ KongInteractivePostPlayManager this$0;
    
    KongInteractivePostPlayManager$1(final KongInteractivePostPlayManager this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        if (Log.isLoggable()) {
            Log.d("KongInteractivePostPlayManager", "Default to standard post play");
        }
        this.this$0.postPlay.isInteractivePostPlay = false;
        this.this$0.hide();
        this.this$0.cleanup();
        if (this.this$0.playerFragment != null) {
            this.this$0.playerFragment.showNavigationBar();
        }
        this.this$0.postPlay.transitionToPostPlay();
    }
}
