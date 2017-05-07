// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.games;

import com.google.android.gms.common.api.GoogleApiClient;

public interface Notifications
{
    public static final int NOTIFICATION_TYPES_ALL = 31;
    public static final int NOTIFICATION_TYPES_MULTIPLAYER = 3;
    public static final int NOTIFICATION_TYPE_INVITATION = 1;
    public static final int NOTIFICATION_TYPE_LEVEL_UP = 16;
    public static final int NOTIFICATION_TYPE_MATCH_UPDATE = 2;
    public static final int NOTIFICATION_TYPE_QUEST = 8;
    public static final int NOTIFICATION_TYPE_REQUEST = 4;
    
    void clear(final GoogleApiClient p0, final int p1);
    
    void clearAll(final GoogleApiClient p0);
}
