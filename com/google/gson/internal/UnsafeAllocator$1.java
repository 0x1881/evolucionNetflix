// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$1 extends UnsafeAllocator
{
    final /* synthetic */ Method val$allocateInstance;
    final /* synthetic */ Object val$unsafe;
    
    UnsafeAllocator$1(final Method val$allocateInstance, final Object val$unsafe) {
        this.val$allocateInstance = val$allocateInstance;
        this.val$unsafe = val$unsafe;
    }
    
    @Override
    public <T> T newInstance(final Class<T> clazz) {
        return (T)this.val$allocateInstance.invoke(this.val$unsafe, clazz);
    }
}
