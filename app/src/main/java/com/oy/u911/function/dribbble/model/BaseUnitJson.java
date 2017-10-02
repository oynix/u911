package com.oy.u911.function.dribbble.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 15:02
 * Describe :
 */

public class BaseUnitJson implements Serializable {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("username")
    private String mUsername;

    @SerializedName("html_url")
    private String mHtmlUrl;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("bio")
    private String mBio;

    @SerializedName("location")
    private String mLocation;

    @SerializedName("links")
    private LinkJson mLinkJson;

    @SerializedName("buckets_count")
    private int mBucketCount;

    @SerializedName("comments_received_count")
    private int mCommentRecCount;

    @SerializedName("followers_count")
    private int mFollowerCount;

    @SerializedName("followings_count")
    private int mFollowingCount;

    @SerializedName("likes_count")
    private int mLikeCount;

    @SerializedName("likes_received_count")
    private int mLikeRecCount;

    @SerializedName("shots_count")
    private int mShotCount;

    @SerializedName("teams_count")
    private int mTeamCount;

    @SerializedName("can_upload_shot")
    private boolean mCanUploadShot;

    @SerializedName("type")
    private String mType;

    @SerializedName("pro")
    private boolean mPro;

    @SerializedName("buckets_url")
    private String mBucketUrl;

    @SerializedName("followers_url")
    private String mFollowerUrl;

    @SerializedName("following_url")
    private String mFollowingUrl;

    @SerializedName("likes_url")
    private String mLikeUrl;

    @SerializedName("projects_url")
    private String mProjectUrl;

    @SerializedName("shots_url")
    private String mShotUrl;

    @SerializedName("created_at")
    private Date mCreatedTime;

    @SerializedName("updated_time")
    private Date mUpdatedTime;

    @Override
    public String toString() {
        return "BaseUnitJson{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mUsername='" + mUsername + '\'' +
                ", mHtmlUrl='" + mHtmlUrl + '\'' +
                ", mAvatarUrl='" + mAvatarUrl + '\'' +
                ", mBio='" + mBio + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mLinkJson=" + mLinkJson +
                ", mBucketCount=" + mBucketCount +
                ", mCommentRecCount=" + mCommentRecCount +
                ", mFollowerCount=" + mFollowerCount +
                ", mFollowingCount=" + mFollowingCount +
                ", mLikeCount=" + mLikeCount +
                ", mLikeRecCount=" + mLikeRecCount +
                ", mShotCount=" + mShotCount +
                ", mTeamCount=" + mTeamCount +
                ", mCanUploadShot=" + mCanUploadShot +
                ", mType='" + mType + '\'' +
                ", mPro=" + mPro +
                ", mBucketUrl='" + mBucketUrl + '\'' +
                ", mFollowerUrl='" + mFollowerUrl + '\'' +
                ", mFollowingUrl='" + mFollowingUrl + '\'' +
                ", mLikeUrl='" + mLikeUrl + '\'' +
                ", mProjectUrl='" + mProjectUrl + '\'' +
                ", mShotUrl='" + mShotUrl + '\'' +
                ", mCreatedTime=" + mCreatedTime +
                ", mUpdatedTime=" + mUpdatedTime +
                '}';
    }
}
