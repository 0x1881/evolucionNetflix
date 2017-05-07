// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.search;

import android.os.Bundle;
import android.util.Pair;
import com.netflix.mediaclient.service.logging.search.utils.SearchLogUtils;
import android.widget.ScrollView;
import com.netflix.mediaclient.servicemgr.ManagerStatusListener;
import java.io.Serializable;
import com.netflix.mediaclient.android.widget.LoggingScrollView$OnScrollStopListener;
import android.widget.AbsListView$OnScrollListener;
import android.content.Intent;
import com.netflix.mediaclient.util.StringUtils;
import android.widget.ListAdapter;
import android.widget.GridView;
import android.app.Activity;
import android.content.Context;
import com.netflix.mediaclient.util.gfx.AnimationUtils;
import com.netflix.mediaclient.servicemgr.ManagerCallback;
import com.netflix.mediaclient.Log;
import android.widget.TextView;
import com.netflix.mediaclient.servicemgr.IClientLogging$ModalView;
import com.netflix.mediaclient.servicemgr.ServiceManager;
import com.netflix.mediaclient.android.widget.LoadingAndErrorWrapper;
import com.netflix.mediaclient.android.widget.ErrorWrapper$Callback;
import com.netflix.mediaclient.android.widget.StaticGridView;
import com.netflix.mediaclient.android.widget.LoggingScrollView;
import com.netflix.mediaclient.ui.common.SearchSimilarItemsGridViewAdapter;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import android.view.View;
import com.netflix.mediaclient.util.ViewUtils;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;

class SearchQueryDetailsActivity$1 implements ViewTreeObserver$OnGlobalLayoutListener
{
    final /* synthetic */ SearchQueryDetailsActivity this$0;
    
    SearchQueryDetailsActivity$1(final SearchQueryDetailsActivity this$0) {
        this.this$0 = this$0;
    }
    
    public void onGlobalLayout() {
        this.this$0.fireImpressionEvents();
        if (this.this$0.gridView.getCount() > 0) {
            ViewUtils.removeGlobalLayoutListener((View)this.this$0.gridView, (ViewTreeObserver$OnGlobalLayoutListener)this);
        }
    }
}
