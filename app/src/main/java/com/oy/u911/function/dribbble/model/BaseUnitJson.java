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

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getBio() {
        return mBio;
    }

    public String getLocation() {
        return mLocation;
    }

    public LinkJson getLinkJson() {
        return mLinkJson;
    }

    public int getBucketCount() {
        return mBucketCount;
    }

    public int getCommentRecCount() {
        return mCommentRecCount;
    }

    public int getFollowerCount() {
        return mFollowerCount;
    }

    public int getFollowingCount() {
        return mFollowingCount;
    }

    public int getLikeCount() {
        return mLikeCount;
    }

    public int getLikeRecCount() {
        return mLikeRecCount;
    }

    public int getShotCount() {
        return mShotCount;
    }

    public int getTeamCount() {
        return mTeamCount;
    }

    public boolean isCanUploadShot() {
        return mCanUploadShot;
    }

    public String getType() {
        return mType;
    }

    public boolean isPro() {
        return mPro;
    }

    public String getBucketUrl() {
        return mBucketUrl;
    }

    public String getFollowerUrl() {
        return mFollowerUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public String getLikeUrl() {
        return mLikeUrl;
    }

    public String getProjectUrl() {
        return mProjectUrl;
    }

    public String getShotUrl() {
        return mShotUrl;
    }

    public Date getCreatedTime() {
        return mCreatedTime;
    }

    public Date getUpdatedTime() {
        return mUpdatedTime;
    }

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
