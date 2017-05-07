// 
// Decompiled by Procyon v0.5.30
// 

package com.google.android.gms.common;

import android.app.FragmentManager;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.DialogInterface$OnDismissListener;
import com.google.android.gms.common.internal.n;
import android.app.Dialog;
import android.content.DialogInterface$OnCancelListener;
import android.app.DialogFragment;

public class ErrorDialogFragment extends DialogFragment
{
    private DialogInterface$OnCancelListener HG;
    private Dialog mDialog;
    
    public ErrorDialogFragment() {
        this.mDialog = null;
        this.HG = null;
    }
    
    public static ErrorDialogFragment newInstance(final Dialog dialog) {
        return newInstance(dialog, null);
    }
    
    public static ErrorDialogFragment newInstance(Dialog mDialog, final DialogInterface$OnCancelListener hg) {
        final ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        mDialog = n.b(mDialog, "Cannot display null dialog");
        mDialog.setOnCancelListener((DialogInterface$OnCancelListener)null);
        mDialog.setOnDismissListener((DialogInterface$OnDismissListener)null);
        errorDialogFragment.mDialog = mDialog;
        if (hg != null) {
            errorDialogFragment.HG = hg;
        }
        return errorDialogFragment;
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        if (this.HG != null) {
            this.HG.onCancel(dialogInterface);
        }
    }
    
    public Dialog onCreateDialog(final Bundle bundle) {
        if (this.mDialog == null) {
            this.setShowsDialog(false);
        }
        return this.mDialog;
    }
    
    public void show(final FragmentManager fragmentManager, final String s) {
        super.show(fragmentManager, s);
    }
}
