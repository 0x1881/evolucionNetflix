// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

class Streams$AppendableWriter$CurrentWrite implements CharSequence
{
    char[] chars;
    
    @Override
    public char charAt(final int n) {
        return this.chars[n];
    }
    
    @Override
    public int length() {
        return this.chars.length;
    }
    
    @Override
    public CharSequence subSequence(final int n, final int n2) {
        return new String(this.chars, n, n2 - n);
    }
}
