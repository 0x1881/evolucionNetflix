// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Parcel;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;
import com.google.android.gms.games.multiplayer.Participant;
import android.database.CharArrayBuffer;
import android.os.Bundle;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.common.data.d;

public final class TurnBasedMatchRef extends d implements TurnBasedMatch
{
    private final int aaz;
    private final Game abm;
    
    TurnBasedMatchRef(final DataHolder dataHolder, final int n, final int aaz) {
        super(dataHolder, n);
        this.abm = new GameRef(dataHolder, n);
        this.aaz = aaz;
    }
    
    @Override
    public boolean canRematch() {
        return this.getTurnStatus() == 3 && this.getRematchId() == null && this.getParticipants().size() > 1;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return TurnBasedMatchEntity.a(this, o);
    }
    
    public TurnBasedMatch freeze() {
        return new TurnBasedMatchEntity(this);
    }
    
    @Override
    public Bundle getAutoMatchCriteria() {
        if (!this.getBoolean("has_automatch_criteria")) {
            return null;
        }
        return TurnBasedMatchConfig.createAutoMatchCriteria(this.getInteger("automatch_min_players"), this.getInteger("automatch_max_players"), this.getLong("automatch_bit_mask"));
    }
    
    @Override
    public int getAvailableAutoMatchSlots() {
        if (!this.getBoolean("has_automatch_criteria")) {
            return 0;
        }
        return this.getInteger("automatch_max_players");
    }
    
    @Override
    public long getCreationTimestamp() {
        return this.getLong("creation_timestamp");
    }
    
    @Override
    public String getCreatorId() {
        return this.getString("creator_external");
    }
    
    @Override
    public byte[] getData() {
        return this.getByteArray("data");
    }
    
    @Override
    public String getDescription() {
        return this.getString("description");
    }
    
    @Override
    public void getDescription(final CharArrayBuffer charArrayBuffer) {
        this.a("description", charArrayBuffer);
    }
    
    @Override
    public Participant getDescriptionParticipant() {
        final String descriptionParticipantId = this.getDescriptionParticipantId();
        if (descriptionParticipantId == null) {
            return null;
        }
        return this.getParticipant(descriptionParticipantId);
    }
    
    @Override
    public String getDescriptionParticipantId() {
        return this.getString("description_participant_id");
    }
    
    @Override
    public Game getGame() {
        return this.abm;
    }
    
    @Override
    public long getLastUpdatedTimestamp() {
        return this.getLong("last_updated_timestamp");
    }
    
    @Override
    public String getLastUpdaterId() {
        return this.getString("last_updater_external");
    }
    
    @Override
    public String getMatchId() {
        return this.getString("external_match_id");
    }
    
    @Override
    public int getMatchNumber() {
        return this.getInteger("match_number");
    }
    
    @Override
    public Participant getParticipant(final String s) {
        return TurnBasedMatchEntity.c(this, s);
    }
    
    @Override
    public String getParticipantId(final String s) {
        return TurnBasedMatchEntity.b(this, s);
    }
    
    @Override
    public ArrayList<String> getParticipantIds() {
        return TurnBasedMatchEntity.c(this);
    }
    
    @Override
    public int getParticipantStatus(final String s) {
        return TurnBasedMatchEntity.a(this, s);
    }
    
    public ArrayList<Participant> getParticipants() {
        final ArrayList<ParticipantRef> list = (ArrayList<ParticipantRef>)new ArrayList<Participant>(this.aaz);
        for (int i = 0; i < this.aaz; ++i) {
            list.add(new ParticipantRef(this.IC, this.JQ + i));
        }
        return (ArrayList<Participant>)list;
    }
    
    @Override
    public String getPendingParticipantId() {
        return this.getString("pending_participant_external");
    }
    
    @Override
    public byte[] getPreviousMatchData() {
        return this.getByteArray("previous_match_data");
    }
    
    @Override
    public String getRematchId() {
        return this.getString("rematch_id");
    }
    
    @Override
    public int getStatus() {
        return this.getInteger("status");
    }
    
    @Override
    public int getTurnStatus() {
        return this.getInteger("user_match_status");
    }
    
    @Override
    public int getVariant() {
        return this.getInteger("variant");
    }
    
    @Override
    public int getVersion() {
        return this.getInteger("version");
    }
    
    @Override
    public int hashCode() {
        return TurnBasedMatchEntity.a(this);
    }
    
    @Override
    public boolean isLocallyModified() {
        return this.getBoolean("upsync_required");
    }
    
    @Override
    public String toString() {
        return TurnBasedMatchEntity.b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((TurnBasedMatchEntity)this.freeze()).writeToParcel(parcel, n);
    }
}
