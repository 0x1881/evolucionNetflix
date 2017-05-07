// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.player.subtitles;

import com.netflix.mediaclient.service.player.subtitles.image.ImageSubtitleParser;
import com.netflix.mediaclient.service.player.subtitles.SubtitleScreen;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.javabridge.ui.IMedia$SubtitleProfile;
import java.util.ArrayList;
import com.netflix.mediaclient.service.player.subtitles.SubtitleBlock;
import com.netflix.mediaclient.service.player.subtitles.image.SegmentIndex$ImageDescriptor;
import com.netflix.mediaclient.util.DeviceUtils;
import java.util.Iterator;
import com.netflix.mediaclient.util.StringUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.netflix.mediaclient.util.ViewUtils$ViewComparator;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import java.util.HashMap;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import android.widget.ImageView;
import java.util.Map;
import android.widget.RelativeLayout;
import java.util.List;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.service.player.subtitles.image.ImageSubtitleBlock;

class ImageBasedSubtitleManager$2 implements Runnable
{
    final /* synthetic */ ImageBasedSubtitleManager this$0;
    final /* synthetic */ ImageSubtitleBlock val$block;
    final /* synthetic */ boolean val$show;
    
    ImageBasedSubtitleManager$2(final ImageBasedSubtitleManager this$0, final boolean val$show, final ImageSubtitleBlock val$block) {
        this.this$0 = this$0;
        this.val$show = val$show;
        this.val$block = val$block;
    }
    
    @Override
    public void run() {
        final boolean remove = this.this$0.mPendingActions.remove(this);
        if (Log.isLoggable()) {
            Log.d("nf_subtitles_render", "Delayed show " + this.val$show + " for block " + this.val$block.getId());
            Log.d("nf_subtitles_render", "Removed from pending queue " + remove);
        }
        synchronized (this.this$0) {
            if (this.val$show) {
                Log.w("nf_subtitles_render", "===> showSubtitleBlock was called from pending queue!!");
                this.this$0.showSubtitleBlock(this.val$block, null);
            }
            else {
                this.this$0.removeSubtitleBlock(this.val$block);
            }
        }
    }
}
