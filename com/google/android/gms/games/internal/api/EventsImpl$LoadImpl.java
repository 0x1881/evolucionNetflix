// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.event.Events$LoadEventsResult;
import com.google.android.gms.games.Games$BaseGamesApiMethodImpl;

abstract class EventsImpl$LoadImpl extends Games$BaseGamesApiMethodImpl<Events$LoadEventsResult>
{
    public Events$LoadEventsResult O(final Status status) {
        return new EventsImpl$LoadImpl$1(this, status);
    }
}
