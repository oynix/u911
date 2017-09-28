package com.oy.u911.function.gank.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/28 9:58
 * Describe :
 */

public class GankNewsBean implements Serializable {

    @SerializedName("_id")
    private String mId;

    @SerializedName("createdAt")
    private String mCreatedAt;

    @SerializedName("desc")
    private String mDesc;

    @SerializedName("images")
    private List<String> mImages;

    @SerializedName("publishedAt")
    private String mPublishedAt;

    // chrome
    @SerializedName("source")
    private String mSource;

    @SerializedName("type")
    private String mType;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("used")
    private boolean mUsed;

    @SerializedName("who")
    private String mWho;

    public String getId() {
        return mId;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getDesc() {
        return mDesc;
    }

    public List<String> getImages() {
        return mImages;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public String getSource() {
        return mSource;
    }

    public String getType() {
        return mType;
    }

    public String getUrl() {
        return mUrl;
    }

    public boolean isUsed() {
        return mUsed;
    }

    public String getWho() {
        return mWho;
    }

    @Override
    public String toString() {
        return "GankNewsBean{" +
                "mId='" + mId + '\'' +
                ", mCreatedAt='" + mCreatedAt + '\'' +
                ", mDesc='" + mDesc + '\'' +
                ", mImages=" + mImages +
                ", mPublishedAt='" + mPublishedAt + '\'' +
                ", mSource='" + mSource + '\'' +
                ", mType='" + mType + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mUsed=" + mUsed +
                ", mWho='" + mWho + '\'' +
                '}';
    }
}
