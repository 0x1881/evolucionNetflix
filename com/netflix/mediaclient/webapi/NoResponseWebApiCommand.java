// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.webapi;

public abstract class NoResponseWebApiCommand extends WebApiGetCommand
{
    public NoResponseWebApiCommand(final String s, final AuthorizationCredentials authorizationCredentials, final CommonRequestParameters commonRequestParameters) {
        super(s, authorizationCredentials, commonRequestParameters);
    }
    
    public void execute() {
        this.doExecute();
    }
}
