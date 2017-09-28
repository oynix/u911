package com.oy.u911.function.gank.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/28 10:08
 * Describe :
 */

public class GankResponseBean implements Serializable{

    @SerializedName("error")
    private boolean mError;

    @SerializedName("results")
    private List<GankNewsBean> mResults;

    public boolean isError() {
        return mError;
    }

    public List<GankNewsBean> getResults() {
        return mResults;
    }

    @Override
    public String toString() {
        return "GankResponseBean{" +
                "mError=" + mError +
                ", mResults=" + mResults +
                '}';
    }
}
