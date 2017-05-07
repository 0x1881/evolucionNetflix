// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.model.leafs;

import java.util.Iterator;
import com.google.gson.JsonObject;
import java.util.Map;
import com.netflix.mediaclient.Log;
import com.google.gson.JsonElement;

public final class Season$Detail extends Video$Summary
{
    private static final String TAG = "Season.Detail";
    public int currentEpisodeNumber;
    public int episodeCount;
    public int number;
    public int year;
    
    @Override
    public void populate(final JsonElement jsonElement) {
        super.populate(jsonElement);
        final JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (Log.isLoggable("Season.Detail", 2)) {
            Log.v("Season.Detail", "Populating with: " + asJsonObject);
        }
        for (final Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            final JsonElement jsonElement2 = entry.getValue();
            final String s = entry.getKey();
            int n = 0;
            Label_0146: {
                switch (s.hashCode()) {
                    case -1034364087: {
                        if (s.equals("number")) {
                            n = 0;
                            break Label_0146;
                        }
                        break;
                    }
                    case 1590765524: {
                        if (s.equals("episodeCount")) {
                            n = 1;
                            break Label_0146;
                        }
                        break;
                    }
                    case -1200833493: {
                        if (s.equals("currentEpisodeNumber")) {
                            n = 2;
                            break Label_0146;
                        }
                        break;
                    }
                    case 3704893: {
                        if (s.equals("year")) {
                            n = 3;
                            break Label_0146;
                        }
                        break;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    continue;
                }
                case 0: {
                    this.number = jsonElement2.getAsInt();
                    continue;
                }
                case 1: {
                    this.episodeCount = jsonElement2.getAsInt();
                    continue;
                }
                case 2: {
                    this.currentEpisodeNumber = jsonElement2.getAsInt();
                    continue;
                }
                case 3: {
                    this.year = jsonElement2.getAsInt();
                    continue;
                }
            }
        }
    }
}
