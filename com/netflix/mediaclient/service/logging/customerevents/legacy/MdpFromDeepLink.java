// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.logging.customerevents.legacy;

import com.netflix.mediaclient.Log;
import org.json.JSONObject;
import org.json.JSONArray;
import com.netflix.mediaclient.webapi.AuthorizationCredentials;
import com.netflix.mediaclient.webapi.CommonRequestParameters;
import com.netflix.mediaclient.service.logging.UserData;
import android.content.Context;

public class MdpFromDeepLink extends BaseCustomerEvent implements Runnable
{
    private static final String NAME = "Mobile UI MDP Opened from Deeplink";
    private Context mContext;
    private String mDepplinkParams;
    
    public MdpFromDeepLink(final Context mContext, final UserData userData, final String mDepplinkParams) {
        super(userData);
        this.mContext = mContext;
        this.mDepplinkParams = mDepplinkParams;
    }
    
    private JSONArray getEvents(final String s, final CommonRequestParameters commonRequestParameters, final AuthorizationCredentials authorizationCredentials, final String s2) {
        final JSONArray jsonArray = new JSONArray();
        final JSONObject jsonObject = new JSONObject();
        jsonArray.put((Object)jsonObject);
        final long currentTimeMillis = System.currentTimeMillis();
        jsonObject.put("EventName", (Object)"Mobile UI MDP Opened from Deeplink");
        jsonObject.put("EventTime", currentTimeMillis);
        jsonObject.put("Esn", (Object)s);
        jsonObject.put("data", (Object)this.getEvent(s, commonRequestParameters, authorizationCredentials, currentTimeMillis, s2));
        return jsonArray;
    }
    
    @Override
    public void run() {
        try {
            final AuthorizationCredentials authorizationCredentials = new AuthorizationCredentials(this.mUser.netflixId, this.mUser.secureNetflixId);
            final CustomerEventCommand customerEventCommand = new CustomerEventCommand(this.mUser.esn, authorizationCredentials, this.getEvents(this.mUser.esn, this.getCommonRequestParameters(this.mContext), authorizationCredentials, this.mDepplinkParams).toString());
            Log.d("nf_rest", "Executing MdpFromDeepLink WebAPI call start");
            final String execute = customerEventCommand.execute();
            Log.d("nf_rest", "Executing MdpFromDeepLink WebAPI call done");
            if (Log.isLoggable("nf_rest", 3)) {
                Log.d("nf_rest", "MdpFromDeepLink response: " + execute);
            }
        }
        catch (Throwable t) {
            Log.e("nf_rest", "Failed to execute MdpFromDeepLink call!", t);
        }
    }
}
