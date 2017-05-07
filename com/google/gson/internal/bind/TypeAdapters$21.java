// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import java.util.UUID;
import com.google.gson.TypeAdapter;

final class TypeAdapters$21 extends TypeAdapter<UUID>
{
    @Override
    public UUID read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return UUID.fromString(jsonReader.nextString());
    }
    
    @Override
    public void write(final JsonWriter jsonWriter, final UUID uuid) {
        String string;
        if (uuid == null) {
            string = null;
        }
        else {
            string = uuid.toString();
        }
        jsonWriter.value(string);
    }
}
