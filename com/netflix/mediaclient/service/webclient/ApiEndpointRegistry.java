// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.webclient;

public interface ApiEndpointRegistry
{
    String getApiUrlFull(final ApiEndpointRegistry$ResponsePathFormat p0);
    
    String getClientLoggingUrlFull();
    
    String getConfigUrlFull();
    
    String getPresentationTrackingUrlFull();
    
    void updateApiEndpointHost(final String p0);
}
