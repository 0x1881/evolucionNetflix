// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.tagmanager;

import java.security.NoSuchAlgorithmException;
import com.google.android.gms.internal.d$a;
import java.util.Map;
import java.security.MessageDigest;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.a;

class ao extends aj
{
    private static final String ID;
    private static final String aoU;
    private static final String aoW;
    private static final String apa;
    
    static {
        ID = a.ac.toString();
        aoU = b.bw.toString();
        apa = b.bn.toString();
        aoW = b.de.toString();
    }
    
    public ao() {
        super(ao.ID, new String[] { ao.aoU });
    }
    
    private byte[] d(final String s, final byte[] array) {
        final MessageDigest instance = MessageDigest.getInstance(s);
        instance.update(array);
        return instance.digest();
    }
    
    @Override
    public d$a C(final Map<String, d$a> map) {
        final d$a d$a = map.get(ao.aoU);
        if (d$a == null || d$a == di.pI()) {
            return di.pI();
        }
        final String j = di.j(d$a);
        Object i = map.get(ao.apa);
        Label_0102: {
            if (i != null) {
                break Label_0102;
            }
            i = "MD5";
        Label_0073_Outer:
            while (true) {
                final d$a d$a2 = map.get(ao.aoW);
                Label_0110: {
                    if (d$a2 != null) {
                        break Label_0110;
                    }
                    String k = "text";
                    while (true) {
                        Label_0118: {
                            if (!"text".equals(k)) {
                                break Label_0118;
                            }
                            byte[] array = j.getBytes();
                            try {
                                return di.u(com.google.android.gms.tagmanager.j.d(this.d((String)i, array)));
                                k = di.j(d$a2);
                                continue;
                                i = di.j((d$a)i);
                                continue Label_0073_Outer;
                                // iftrue(Label_0135:, !"base16".equals((Object)k))
                                array = com.google.android.gms.tagmanager.j.cj(j);
                                return di.u(com.google.android.gms.tagmanager.j.d(this.d((String)i, array)));
                                Label_0135: {
                                    bh.T("Hash: unknown input format: " + k);
                                }
                                return di.pI();
                            }
                            catch (NoSuchAlgorithmException ex) {
                                bh.T("Hash: unknown algorithm: " + (String)i);
                                return di.pI();
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
    
    @Override
    public boolean nL() {
        return true;
    }
}
