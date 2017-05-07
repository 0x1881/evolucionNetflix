// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.protocol.netflixcom;

import com.netflix.mediaclient.service.logging.client.model.DataContext;
import android.content.Context;
import com.netflix.mediaclient.util.log.UIViewLogUtils;
import com.netflix.mediaclient.servicemgr.IClientLogging$ModalView;
import com.netflix.mediaclient.servicemgr.UIViewLogging$UIViewCommandName;
import com.netflix.mediaclient.protocol.nflx.NflxHandler$Response;
import com.netflix.mediaclient.service.logging.error.ErrorLoggingManager;
import com.netflix.mediaclient.Log;
import com.netflix.mediaclient.util.NflxProtocolUtils;
import com.netflix.mediaclient.util.StringUtils;
import java.util.Map;
import android.net.Uri;
import java.util.List;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import android.app.Activity;
import android.content.Intent;

public class NetflixComHandlerFactory
{
    protected static final String ADD_TO_MY_LIST_SUFFIX = "add";
    protected static final String BROWSE_SUFFIX = "browse";
    protected static final String DETAILS_PAGE_SUFFIX = "title";
    protected static final String EXTRA_SOURCE = "source";
    public static final String FUTURE_HANDLER_SCHEME = "https";
    public static final String HANDLER_PREFIX = "www.netflix.com";
    public static final String HANDLER_SCHEME = "http";
    private static final String HOME_SUFFIX = "";
    protected static final String SEARCH_SUFFIX = "search";
    protected static final String SYNC_SUFFIX = "sync";
    private static final String TAG = "NetflixComHandlerFactory";
    protected static final String WATCH_SUFFIX = "watch";
    
    public static boolean canHandle(final Intent intent) {
        return intent != null && intent.getData() != null && ("http".equalsIgnoreCase(intent.getData().getScheme()) || "https".equalsIgnoreCase(intent.getData().getScheme())) && "www.netflix.com".equalsIgnoreCase(intent.getData().getAuthority());
    }
    
    public static boolean finishMeAndLaunchBrowserIfNeeded(final Activity activity, final Intent intent) {
        final boolean b = true;
        final List<String> actionParts = getActionParts(intent.getData());
        final NetflixComHandler handler = getHandler(null, actionParts, NetflixComUtils.getParameters(intent.getData()));
        boolean b2 = b;
        if (handler != null) {
            b2 = (!handler.canHandle(actionParts) && b);
        }
        if (b2) {
            NetflixComUtils.launchBrowser(activity, intent.getData());
            activity.finish();
        }
        return b2;
    }
    
    private static List<String> getActionParts(final Uri uri) {
        final List pathSegments = uri.getPathSegments();
        if (pathSegments.size() > 1 && pathSegments.get(0).length() == 2) {
            return pathSegments.subList(1, pathSegments.size());
        }
        return (List<String>)pathSegments;
    }
    
    private static NetflixComHandler getHandler(final NetflixActivity netflixActivity, final List<String> list, final Map<String, String> map) {
        String s;
        if (list.size() > 0) {
            s = list.get(0);
        }
        else {
            s = "";
        }
        if (netflixActivity != null) {
            String s2;
            if (StringUtils.isNotEmpty(s)) {
                s2 = s;
            }
            else {
                s2 = "home";
            }
            NflxProtocolUtils.reportApplicationLaunchedFromDeepLinking(netflixActivity, map, s2);
        }
        switch (s) {
            default: {
                final String string = "SPY-7518 - got unsupported suffix: " + s;
                Log.e("NetflixComHandlerFactory", string);
                ErrorLoggingManager.logHandledException(string);
                return null;
            }
            case "": {
                return new NetflixComHomeHandler();
            }
            case "title": {
                return new NetflixComVideoDetailsHandler();
            }
            case "watch": {
                return new NetflixComWatchHandler();
            }
            case "browse": {
                return new NetflixComBrowseHandler();
            }
            case "add": {
                return new NetflixComAddToListHandler();
            }
            case "search": {
                return new NetflixComSearchHandler();
            }
            case "sync": {
                return new NetflixComSyncHandler();
            }
        }
    }
    
    public static NflxHandler$Response handle(final NetflixActivity netflixActivity, final Intent intent) {
        final Uri data = intent.getData();
        final String stringExtra = intent.getStringExtra("source");
        final List<String> actionParts = getActionParts(data);
        final Map<String, String> parameters = NetflixComUtils.getParameters(data);
        if (StringUtils.isNotEmpty(stringExtra)) {
            parameters.put("source", stringExtra);
        }
        final NetflixComHandler handler = getHandler(netflixActivity, actionParts, parameters);
        if (handler == null) {
            Log.w("NetflixComHandlerFactory", "Got null creator for data: " + data.toString() + ". Redirecting user to browser.");
        }
        else {
            final NflxHandler$Response tryHandle = handler.tryHandle(netflixActivity, actionParts, NetflixComUtils.getTrackId(data));
            if (tryHandle != NflxHandler$Response.NOT_HANDLING) {
                UIViewLogUtils.reportUIViewCommand((Context)netflixActivity, UIViewLogging$UIViewCommandName.deepLink, IClientLogging$ModalView.homeScreen, null, data.toString());
                return tryHandle;
            }
            ErrorLoggingManager.logHandledException("SPY-7518 - couldn't handle the following data: " + data.toString());
        }
        NetflixComUtils.launchBrowser(netflixActivity, data);
        return NflxHandler$Response.HANDLING;
    }
}
