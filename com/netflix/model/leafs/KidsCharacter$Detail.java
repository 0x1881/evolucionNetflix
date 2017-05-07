// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.model.leafs;

import java.util.Iterator;
import com.google.gson.JsonObject;
import java.util.Map;
import com.netflix.mediaclient.Log;
import com.google.gson.JsonElement;
import com.netflix.mediaclient.servicemgr.interface_.JsonPopulator;

public final class KidsCharacter$Detail implements JsonPopulator
{
    private static final String TAG = "KidsCharacter.Detail";
    public boolean hasWatchedRecently;
    
    @Override
    public void populate(final JsonElement jsonElement) {
        final JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (Log.isLoggable()) {
            Log.v("KidsCharacter.Detail", "Populating with: " + asJsonObject);
        }
        for (final Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            final JsonElement jsonElement2 = entry.getValue();
            final String s = entry.getKey();
            int n = 0;
            Label_0114: {
                switch (s.hashCode()) {
                    case -2011547908: {
                        if (s.equals("hasWatchedRecently")) {
                            n = 0;
                            break Label_0114;
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
                    this.hasWatchedRecently = jsonElement2.getAsBoolean();
                    continue;
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return "Detail{hasWatchedRecently=" + this.hasWatchedRecently + '}';
    }
}
