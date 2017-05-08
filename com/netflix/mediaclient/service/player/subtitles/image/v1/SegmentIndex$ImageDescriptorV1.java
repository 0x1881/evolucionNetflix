// 
// Decompiled by Procyon v0.5.30
// 

package com.netflix.mediaclient.service.player.subtitles.image.v1;

import java.io.DataInputStream;
import com.netflix.mediaclient.service.player.subtitles.image.BaseImageDescriptor;

public class SegmentIndex$ImageDescriptorV1 extends BaseImageDescriptor
{
    public static final int SIZE = 28;
    
    private SegmentIndex$ImageDescriptorV1(final DataInputStream dataInputStream) {
        this.mStartTime = dataInputStream.readInt();
        this.mDuration = dataInputStream.readInt();
        this.mEndTime = this.mStartTime + this.mDuration;
        this.mOriginX = dataInputStream.readShort();
        this.mOriginY = dataInputStream.readShort();
        this.mWidth = dataInputStream.readShort();
        this.mHeight = dataInputStream.readShort();
        this.mImageStartPosition = dataInputStream.readLong();
        this.mSize = dataInputStream.readInt();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            if (this.mTotalIndex != ((SegmentIndex$ImageDescriptorV1)o).mTotalIndex) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.mTotalIndex + 31;
    }
    
    @Override
    public String toString() {
        return "ImageDescriptorV1 [mStartTime=" + this.mStartTime + ", mDuration=" + this.mDuration + ", mEndTime=" + this.mEndTime + ", mOriginX=" + this.mOriginX + ", mOriginY=" + this.mOriginY + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mImageStartPosition=" + this.mImageStartPosition + ", mSize=" + this.mSize + ", mLocalImagePath=" + this.mLocalImagePath + ", mName=" + this.mName + ", mTotalIndex=" + this.mTotalIndex + "]";
    }
}
