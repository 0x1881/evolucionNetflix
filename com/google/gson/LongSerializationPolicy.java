// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

public enum LongSerializationPolicy
{
    DEFAULT("DEFAULT", 0) {
        LongSerializationPolicy$1(final String s, final int n) {
        }
        
        @Override
        public JsonElement serialize(final Long n) {
            return new JsonPrimitive(n);
        }
    }, 
    STRING("STRING", 1) {
        LongSerializationPolicy$2(final String s, final int n) {
        }
        
        @Override
        public JsonElement serialize(final Long n) {
            return new JsonPrimitive(String.valueOf(n));
        }
    };
    
    public abstract JsonElement serialize(final Long p0);
}
