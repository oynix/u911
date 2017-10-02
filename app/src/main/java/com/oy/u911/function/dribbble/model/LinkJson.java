package com.oy.u911.function.dribbble.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 14:53
 * Describe :
 */

public class LinkJson implements Serializable {

    @SerializedName("web")
    private String mWeb;

    @SerializedName("twitter")
    private String mTwitter;

    public String getWeb() {
        return mWeb;
    }

    public String getTwitter() {
        return mTwitter;
    }

    @Override
    public String toString() {
        return "LinkJson{" +
                "mWeb='" + mWeb + '\'' +
                ", mTwitter='" + mTwitter + '\'' +
                '}';
    }
}
