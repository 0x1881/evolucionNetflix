// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.media;

import java.util.Arrays;
import android.text.TextUtils;
import java.util.Collections;
import android.content.IntentFilter;
import java.util.List;
import android.os.Bundle;

public final class MediaRouteDescriptor
{
    private static final String KEY_CONNECTING = "connecting";
    private static final String KEY_CONTROL_FILTERS = "controlFilters";
    private static final String KEY_DESCRIPTION = "status";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PLAYBACK_STREAM = "playbackStream";
    private static final String KEY_PLAYBACK_TYPE = "playbackType";
    private static final String KEY_PRESENTATION_DISPLAY_ID = "presentationDisplayId";
    private static final String KEY_VOLUME = "volume";
    private static final String KEY_VOLUME_HANDLING = "volumeHandling";
    private static final String KEY_VOLUME_MAX = "volumeMax";
    private final Bundle mBundle;
    private List<IntentFilter> mControlFilters;
    
    private MediaRouteDescriptor(final Bundle mBundle, final List<IntentFilter> mControlFilters) {
        this.mBundle = mBundle;
        this.mControlFilters = mControlFilters;
    }
    
    private void ensureControlFilters() {
        if (this.mControlFilters == null) {
            this.mControlFilters = (List<IntentFilter>)this.mBundle.getParcelableArrayList("controlFilters");
            if (this.mControlFilters == null) {
                this.mControlFilters = Collections.emptyList();
            }
        }
    }
    
    public static MediaRouteDescriptor fromBundle(final Bundle bundle) {
        if (bundle != null) {
            return new MediaRouteDescriptor(bundle, null);
        }
        return null;
    }
    
    public Bundle asBundle() {
        return this.mBundle;
    }
    
    public List<IntentFilter> getControlFilters() {
        this.ensureControlFilters();
        return this.mControlFilters;
    }
    
    public String getDescription() {
        return this.mBundle.getString("status");
    }
    
    public Bundle getExtras() {
        return this.mBundle.getBundle("extras");
    }
    
    public String getId() {
        return this.mBundle.getString("id");
    }
    
    public String getName() {
        return this.mBundle.getString("name");
    }
    
    public int getPlaybackStream() {
        return this.mBundle.getInt("playbackStream", -1);
    }
    
    public int getPlaybackType() {
        return this.mBundle.getInt("playbackType", 1);
    }
    
    public int getPresentationDisplayId() {
        return this.mBundle.getInt("presentationDisplayId", -1);
    }
    
    public int getVolume() {
        return this.mBundle.getInt("volume");
    }
    
    public int getVolumeHandling() {
        return this.mBundle.getInt("volumeHandling", 0);
    }
    
    public int getVolumeMax() {
        return this.mBundle.getInt("volumeMax");
    }
    
    public boolean isConnecting() {
        return this.mBundle.getBoolean("connecting", false);
    }
    
    public boolean isEnabled() {
        return this.mBundle.getBoolean("enabled", true);
    }
    
    public boolean isValid() {
        this.ensureControlFilters();
        return !TextUtils.isEmpty((CharSequence)this.getId()) && !TextUtils.isEmpty((CharSequence)this.getName()) && !this.mControlFilters.contains(null);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MediaRouteDescriptor{ ");
        sb.append("id=").append(this.getId());
        sb.append(", name=").append(this.getName());
        sb.append(", description=").append(this.getDescription());
        sb.append(", isEnabled=").append(this.isEnabled());
        sb.append(", isConnecting=").append(this.isConnecting());
        sb.append(", controlFilters=").append(Arrays.toString(this.getControlFilters().toArray()));
        sb.append(", playbackType=").append(this.getPlaybackType());
        sb.append(", playbackStream=").append(this.getPlaybackStream());
        sb.append(", volume=").append(this.getVolume());
        sb.append(", volumeMax=").append(this.getVolumeMax());
        sb.append(", volumeHandling=").append(this.getVolumeHandling());
        sb.append(", presentationDisplayId=").append(this.getPresentationDisplayId());
        sb.append(", extras=").append(this.getExtras());
        sb.append(", isValid=").append(this.isValid());
        sb.append(" }");
        return sb.toString();
    }
}
