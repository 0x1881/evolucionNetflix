// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.internal.widget;

import android.os.Bundle;
import android.content.res.AssetFileDescriptor;
import java.io.InputStream;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.graphics.Movie;
import android.content.res.Resources$Theme;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.content.res.Configuration;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.content.res.Resources;

class ResourcesWrapper extends Resources
{
    private final Resources mResources;
    
    public ResourcesWrapper(final Resources mResources) {
        super(mResources.getAssets(), mResources.getDisplayMetrics(), mResources.getConfiguration());
        this.mResources = mResources;
    }
    
    public XmlResourceParser getAnimation(final int n) {
        return this.mResources.getAnimation(n);
    }
    
    public boolean getBoolean(final int n) {
        return this.mResources.getBoolean(n);
    }
    
    public int getColor(final int n) {
        return this.mResources.getColor(n);
    }
    
    public ColorStateList getColorStateList(final int n) {
        return this.mResources.getColorStateList(n);
    }
    
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }
    
    public float getDimension(final int n) {
        return this.mResources.getDimension(n);
    }
    
    public int getDimensionPixelOffset(final int n) {
        return this.mResources.getDimensionPixelOffset(n);
    }
    
    public int getDimensionPixelSize(final int n) {
        return this.mResources.getDimensionPixelSize(n);
    }
    
    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }
    
    public Drawable getDrawable(final int n) {
        return this.mResources.getDrawable(n);
    }
    
    public Drawable getDrawable(final int n, final Resources$Theme resources$Theme) {
        return this.mResources.getDrawable(n, resources$Theme);
    }
    
    public Drawable getDrawableForDensity(final int n, final int n2) {
        return this.mResources.getDrawableForDensity(n, n2);
    }
    
    public Drawable getDrawableForDensity(final int n, final int n2, final Resources$Theme resources$Theme) {
        return this.mResources.getDrawableForDensity(n, n2, resources$Theme);
    }
    
    public float getFraction(final int n, final int n2, final int n3) {
        return this.mResources.getFraction(n, n2, n3);
    }
    
    public int getIdentifier(final String s, final String s2, final String s3) {
        return this.mResources.getIdentifier(s, s2, s3);
    }
    
    public int[] getIntArray(final int n) {
        return this.mResources.getIntArray(n);
    }
    
    public int getInteger(final int n) {
        return this.mResources.getInteger(n);
    }
    
    public XmlResourceParser getLayout(final int n) {
        return this.mResources.getLayout(n);
    }
    
    public Movie getMovie(final int n) {
        return this.mResources.getMovie(n);
    }
    
    public String getQuantityString(final int n, final int n2) {
        return this.mResources.getQuantityString(n, n2);
    }
    
    public String getQuantityString(final int n, final int n2, final Object... array) {
        return this.mResources.getQuantityString(n, n2, array);
    }
    
    public CharSequence getQuantityText(final int n, final int n2) {
        return this.mResources.getQuantityText(n, n2);
    }
    
    public String getResourceEntryName(final int n) {
        return this.mResources.getResourceEntryName(n);
    }
    
    public String getResourceName(final int n) {
        return this.mResources.getResourceName(n);
    }
    
    public String getResourcePackageName(final int n) {
        return this.mResources.getResourcePackageName(n);
    }
    
    public String getResourceTypeName(final int n) {
        return this.mResources.getResourceTypeName(n);
    }
    
    public String getString(final int n) {
        return this.mResources.getString(n);
    }
    
    public String getString(final int n, final Object... array) {
        return this.mResources.getString(n, array);
    }
    
    public String[] getStringArray(final int n) {
        return this.mResources.getStringArray(n);
    }
    
    public CharSequence getText(final int n) {
        return this.mResources.getText(n);
    }
    
    public CharSequence getText(final int n, final CharSequence charSequence) {
        return this.mResources.getText(n, charSequence);
    }
    
    public CharSequence[] getTextArray(final int n) {
        return this.mResources.getTextArray(n);
    }
    
    public void getValue(final int n, final TypedValue typedValue, final boolean b) {
        this.mResources.getValue(n, typedValue, b);
    }
    
    public void getValue(final String s, final TypedValue typedValue, final boolean b) {
        this.mResources.getValue(s, typedValue, b);
    }
    
    public void getValueForDensity(final int n, final int n2, final TypedValue typedValue, final boolean b) {
        this.mResources.getValueForDensity(n, n2, typedValue, b);
    }
    
    public XmlResourceParser getXml(final int n) {
        return this.mResources.getXml(n);
    }
    
    public TypedArray obtainAttributes(final AttributeSet set, final int[] array) {
        return this.mResources.obtainAttributes(set, array);
    }
    
    public TypedArray obtainTypedArray(final int n) {
        return this.mResources.obtainTypedArray(n);
    }
    
    public InputStream openRawResource(final int n) {
        return this.mResources.openRawResource(n);
    }
    
    public InputStream openRawResource(final int n, final TypedValue typedValue) {
        return this.mResources.openRawResource(n, typedValue);
    }
    
    public AssetFileDescriptor openRawResourceFd(final int n) {
        return this.mResources.openRawResourceFd(n);
    }
    
    public void parseBundleExtra(final String s, final AttributeSet set, final Bundle bundle) {
        this.mResources.parseBundleExtra(s, set, bundle);
    }
    
    public void parseBundleExtras(final XmlResourceParser xmlResourceParser, final Bundle bundle) {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }
    
    public void updateConfiguration(final Configuration configuration, final DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
