package com.oy.u911.function.dribbble.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 14:39
 * Describe :
 */

public class ImageJson implements Serializable {

    @SerializedName("hidpi")
    private String hidpi;

    @SerializedName("normal")
    private String normal;

    @SerializedName("teaser")
    private String teaser;

    public String getHidpi() {
        return hidpi;
    }

    public String getNormal() {
        return normal;
    }

    public String getTeaser() {
        return teaser;
    }

    @Override
    public String toString() {
        return "ImageJson{" +
                "hidpi='" + hidpi + '\'' +
                ", normal='" + normal + '\'' +
                ", teaser='" + teaser + '\'' +
                '}';
    }
}
