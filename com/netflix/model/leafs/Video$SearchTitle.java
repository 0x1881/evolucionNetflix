// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.model.leafs;

import java.util.Iterator;
import com.google.gson.JsonObject;
import java.util.Map;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.service.falkor.Falkor;
import com.google.gson.JsonElement;
import com.netflix.mediaclient.servicemgr.interface_.JsonPopulator;

public final class Video$SearchTitle implements JsonPopulator
{
    private static final String TAG = "SearchTitle";
    public String certification;
    public String horzDispUrl;
    public boolean isOriginal;
    public boolean isPreRelease;
    public int releaseYear;
    public String title;
    
    @Override
    public void populate(final JsonElement jsonElement) {
        final JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (Falkor.ENABLE_VERBOSE_LOGGING) {
            Log.v("SearchTitle", "Populating with: " + asJsonObject);
        }
        for (final Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            final JsonElement jsonElement2 = entry.getValue();
            final String s = entry.getKey();
            int n = 0;
            Label_0154: {
                switch (s.hashCode()) {
                    case 110371416: {
                        if (s.equals("title")) {
                            n = 0;
                            break Label_0154;
                        }
                        break;
                    }
                    case -644524870: {
                        if (s.equals("certification")) {
                            n = 1;
                            break Label_0154;
                        }
                        break;
                    }
                    case -1217996834: {
                        if (s.equals("horzDispUrl")) {
                            n = 2;
                            break Label_0154;
                        }
                        break;
                    }
                    case 213502180: {
                        if (s.equals("releaseYear")) {
                            n = 3;
                            break Label_0154;
                        }
                        break;
                    }
                    case 585773339: {
                        if (s.equals("isOriginal")) {
                            n = 4;
                            break Label_0154;
                        }
                        break;
                    }
                    case 135683246: {
                        if (s.equals("isPreRelease")) {
                            n = 5;
                            break Label_0154;
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
                    this.title = jsonElement2.getAsString();
                    continue;
                }
                case 1: {
                    this.certification = jsonElement2.getAsString();
                    continue;
                }
                case 2: {
                    this.horzDispUrl = jsonElement2.getAsString();
                    continue;
                }
                case 3: {
                    this.releaseYear = jsonElement2.getAsInt();
                    continue;
                }
                case 4: {
                    this.isOriginal = jsonElement2.getAsBoolean();
                    continue;
                }
                case 5: {
                    this.isPreRelease = jsonElement2.getAsBoolean();
                    continue;
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return this.title;
    }
}
