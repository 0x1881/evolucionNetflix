// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.logging.uiaction;

import com.netflix.mediaclient.service.logging.uiaction.model.AddToPlaylistEndedEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging$CompletionReason;
import com.netflix.mediaclient.servicemgr.IClientLogging$ModalView;
import com.netflix.mediaclient.servicemgr.UserActionLogging$CommandName;

public final class AddToPlaylistSession extends BaseUIActionSession
{
    public static final String NAME = "addToPlaylist";
    
    public AddToPlaylistSession(final UserActionLogging$CommandName userActionLogging$CommandName, final IClientLogging$ModalView clientLogging$ModalView) {
        super(userActionLogging$CommandName, clientLogging$ModalView);
    }
    
    public AddToPlaylistEndedEvent createEndedEvent(final IClientLogging$CompletionReason clientLogging$CompletionReason, final UIError uiError, final int n) {
        final AddToPlaylistEndedEvent addToPlaylistEndedEvent = new AddToPlaylistEndedEvent(this.mId, System.currentTimeMillis() - this.mStarted, this.mView, this.mAction, clientLogging$CompletionReason, uiError, n);
        addToPlaylistEndedEvent.setCategory(this.getCategory());
        addToPlaylistEndedEvent.setSessionId(this.mId);
        return addToPlaylistEndedEvent;
    }
    
    @Override
    public String getName() {
        return "addToPlaylist";
    }
}
