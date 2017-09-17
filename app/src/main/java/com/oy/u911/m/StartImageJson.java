package com.oy.u911.m;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 14:43
 * Describe : 启动图片json类
 */

public class StartImageJson implements Serializable {

    /** 图片版权所有 */
    @SerializedName("text")
    private String mImageCopyright;

    /** 图片url */
    @SerializedName("img")
    private String mImageUrl;

    public String getImageCopyright() {
        return mImageCopyright;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    @Override
    public String toString() {
        return "StartImageBean{" +
                "mImageCopyright='" + mImageCopyright + '\'' +
                ", mImageUrl='" + mImageUrl + '\'' +
                '}';
    }
}
