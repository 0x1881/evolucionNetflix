// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.analytics;

import android.os.Build$VERSION;
import java.io.File;

class o
{
    static boolean ag(final String s) {
        if (version() < 9) {
            return false;
        }
        final File file = new File(s);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
    
    public static int version() {
        try {
            return Integer.parseInt(Build$VERSION.SDK);
        }
        catch (NumberFormatException ex) {
            z.T("Invalid version number: " + Build$VERSION.SDK);
            return 0;
        }
    }
}
