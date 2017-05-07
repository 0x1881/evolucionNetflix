// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.javabridge.invoke.mdx.pair;

import org.json.JSONException;
import com.netflix.mediaclient.Log;
import org.json.JSONObject;
import com.netflix.mediaclient.javabridge.invoke.BaseInvoke;

public class PairingRequest extends BaseInvoke
{
    private static final String METHOD = "pairingRequest";
    private static final String PROPERTY_uuid = "uuid";
    private static final String TARGET = "mdx";
    
    public PairingRequest(final String arguments) {
        super("mdx", "pairingRequest");
        this.setArguments(arguments);
    }
    
    private void setArguments(final String s) {
        try {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("uuid", (Object)s);
            this.arguments = jsonObject.toString();
        }
        catch (JSONException ex) {
            Log.e("nf_invoke", "Failed to create JSON object", (Throwable)ex);
        }
    }
}
