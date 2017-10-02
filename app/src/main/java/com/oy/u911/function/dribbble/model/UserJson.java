package com.oy.u911.function.dribbble.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 14:41
 * Describe :
 */

public class UserJson implements Serializable {

    @SerializedName("teams_url")
    private String mTeamUrl;

    public String getTeamUrl() {
        return mTeamUrl;
    }

    @Override
    public String toString() {
        return "UserJson{" +
                "mTeamUrl='" + mTeamUrl + '\'' +
                '}';
    }
}
