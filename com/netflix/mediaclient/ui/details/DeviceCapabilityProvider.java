// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.ui.details;

public interface DeviceCapabilityProvider
{
    boolean is3dSupported();
    
    boolean is5dot1Supported();
    
    boolean isDolbyVisionSupported();
    
    boolean isHdSupported();
    
    boolean isHdr10Supported();
    
    boolean isUltraHdSupported();
}
