// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.lomo;

import com.netflix.mediaclient.android.widget.ObjectRecycler;
import com.netflix.mediaclient.servicemgr.model.trackable.Trackable;
import android.view.View;
import com.netflix.mediaclient.servicemgr.model.BasicLoMo;
import java.util.List;
import com.netflix.mediaclient.android.widget.ObjectRecycler$ViewRecycler;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.util.DeviceUtils;
import com.netflix.mediaclient.util.UiUtils;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import android.content.Context;
import com.netflix.mediaclient.servicemgr.model.CWVideo;

public class PaginatedCwAdapter extends BasePaginatedAdapter<CWVideo>
{
    private static final String TAG = "PaginatedCwAdapter";
    
    public PaginatedCwAdapter(final Context context) {
        super(context);
    }
    
    public static int computeNumVideosToFetchPerBatch(final NetflixActivity netflixActivity, final int n) {
        if (netflixActivity.isForKids()) {
            return 3;
        }
        return UiUtils.computeNumCWVideosToFetchPerBatch(n);
    }
    
    @Override
    protected int computeNumItemsPerPage(final int n, final int n2) {
        return UiUtils.computeNumCWItemsPerPage(n, n2);
    }
    
    @Override
    protected int computeNumVideosToFetchPerBatch(final Context context) {
        return computeNumVideosToFetchPerBatch(this.activity, DeviceUtils.getScreenSizeCategory(context));
    }
    
    @Override
    public int getRowHeightInPx() {
        final int n = (int)(BasePaginatedAdapter.computeViewPagerWidth(this.activity, true) / this.computeNumItemsPerPage(DeviceUtils.getBasicScreenOrientation((Context)this.activity), DeviceUtils.getScreenSizeCategory((Context)this.activity)) * 0.5625f + 0.5f) + this.activity.getResources().getDimensionPixelOffset(2131361910);
        Log.v("PaginatedCwAdapter", "Computed view height: " + n);
        return n;
    }
    
    @Override
    protected View getView(final ObjectRecycler$ViewRecycler objectRecycler$ViewRecycler, final List<CWVideo> list, final int n, final int n2, final BasicLoMo basicLoMo) {
        CwViewGroup cwViewGroup;
        if ((cwViewGroup = ((ObjectRecycler<CwViewGroup>)objectRecycler$ViewRecycler).pop(CwViewGroup.class)) == null) {
            cwViewGroup = new CwViewGroup((Context)this.getActivity());
            cwViewGroup.init(n);
        }
        ((VideoViewGroup<CWVideo, V>)cwViewGroup).updateDataThenViews(list, n, n2, this.getListViewPos(), basicLoMo);
        return (View)cwViewGroup;
    }
}
