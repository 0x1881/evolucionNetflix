// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.servicemgr.model;

import com.netflix.model.branches.FalkorObject;

public interface BasicVideo extends FalkorObject
{
    String getId();
    
    String getTitle();
    
    VideoType getType();
}
