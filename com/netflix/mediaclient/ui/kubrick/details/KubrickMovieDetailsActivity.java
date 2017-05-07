// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.kubrick.details;

import com.netflix.mediaclient.ui.mdx.MdxMenu;
import com.netflix.mediaclient.ui.common.DebugMenuItems;
import android.view.Menu;
import android.os.Bundle;
import com.netflix.mediaclient.ui.details.IHandleBackPress;
import android.app.Fragment;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.ui.details.MovieDetailsActivity;

public class KubrickMovieDetailsActivity extends MovieDetailsActivity
{
    private static final String TAG = "KubrickMovieDetailsActivity";
    
    @Override
    protected NetflixActionBar createActionBar() {
        final KubrickDetailActionBar kubrickDetailActionBar = new KubrickDetailActionBar(this, this.hasUpAction());
        kubrickDetailActionBar.setAlpha(0.0f);
        return kubrickDetailActionBar;
    }
    
    @Override
    protected Fragment createPrimaryFrag() {
        return KubrickMovieDetailsFrag.create(this.getVideoId());
    }
    
    @Override
    protected boolean handleBackPressed() {
        return ((IHandleBackPress)this.getPrimaryFrag()).handleBackPressed();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.getNetflixActionBar().hidelogo();
    }
    
    @Override
    protected void onCreateOptionsMenu(final Menu menu, final Menu menu2) {
        if (menu2 != null) {
            new DebugMenuItems("KubrickMovieDetailsActivity", this).addItems(this, menu2);
        }
        MdxMenu.addSelectPlayTarget(this, menu, false);
    }
}
