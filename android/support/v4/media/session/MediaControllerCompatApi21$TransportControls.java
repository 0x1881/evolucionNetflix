// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.media.Rating;
import android.media.session.MediaController$TransportControls;

public class MediaControllerCompatApi21$TransportControls
{
    public static void fastForward(final Object o) {
        ((MediaController$TransportControls)o).fastForward();
    }
    
    public static void pause(final Object o) {
        ((MediaController$TransportControls)o).pause();
    }
    
    public static void play(final Object o) {
        ((MediaController$TransportControls)o).play();
    }
    
    public static void rewind(final Object o) {
        ((MediaController$TransportControls)o).rewind();
    }
    
    public static void seekTo(final Object o, final long n) {
        ((MediaController$TransportControls)o).seekTo(n);
    }
    
    public static void setRating(final Object o, final Object o2) {
        ((MediaController$TransportControls)o).setRating((Rating)o2);
    }
    
    public static void skipToNext(final Object o) {
        ((MediaController$TransportControls)o).skipToNext();
    }
    
    public static void skipToPrevious(final Object o) {
        ((MediaController$TransportControls)o).skipToPrevious();
    }
    
    public static void stop(final Object o) {
        ((MediaController$TransportControls)o).stop();
    }
}
