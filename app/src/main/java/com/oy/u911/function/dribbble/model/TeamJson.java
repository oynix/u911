package com.oy.u911.function.dribbble.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 14:58
 * Describe :
 */

public class TeamJson extends BaseUnitJson implements Serializable {

    @SerializedName("members_count")
    private int mMemberCount;

    @SerializedName("members_url")
    private String mMemberUrl;

    @SerializedName("team_shots_url")
    private String mTeamShotUrl;

    public int getMemberCount() {
        return mMemberCount;
    }

    public String getMemberUrl() {
        return mMemberUrl;
    }

    public String getTeamShotUrl() {
        return mTeamShotUrl;
    }

    @Override
    public String toString() {
        return "TeamJson{" +
                "mMemberCount=" + mMemberCount +
                ", mMemberUrl='" + mMemberUrl + '\'' +
                ", mTeamShotUrl='" + mTeamShotUrl + '\'' +
                "} " + super.toString();
    }
}
