// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.configuration.persistent;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig$Cell;
import com.netflix.mediaclient.service.ServiceAgent$ConfigurationAgentInterface;

public class PhoneOrientation extends PersistentConfigurable
{
    private static final String PERSISTENT_PHONE_ORIENTATION_CONFIG_PREFS_KEY = "persistent_phone_orientation_key";
    
    @Override
    public ABTestConfig$Cell getCell(final ServiceAgent$ConfigurationAgentInterface serviceAgent$ConfigurationAgentInterface) {
        return serviceAgent$ConfigurationAgentInterface.getPhoneOrientationConfig();
    }
    
    @Override
    public String getPrefKey() {
        return "persistent_phone_orientation_key";
    }
}
