// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.servicemgr.model.genre;

import com.netflix.mediaclient.servicemgr.model.BasicLoMo;
import android.os.Parcelable;

public interface GenreList extends Parcelable, BasicLoMo
{
    int getNumVideos();
    
    boolean isKidsGenre();
}
