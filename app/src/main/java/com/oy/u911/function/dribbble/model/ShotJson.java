package com.oy.u911.function.dribbble.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 12:40
 * Describe :
 */

public class ShotJson implements Serializable {

    @SerializedName("id")
    private int mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("width")
    private int mWidth;

    @SerializedName("height")
    private int mHeight;

    @SerializedName("images")
    private ImageJson mImages;

    @SerializedName("views_count")
    private int mViewCount;

    @SerializedName("likes_count")
    private int mLikeCount;

    @SerializedName("comments_count")
    private int mCommentCount;

    @SerializedName("attachments_count")
    private int mAttachmentCount;

    @SerializedName("rebounds_count")
    private int mReboundCount;

    @SerializedName("buckets_count")
    private int mBucketCount;

    @SerializedName("created_at")
    private Date mCreatedTime;

    @SerializedName("updated_at")
    private Date mUpdatedTime;

    @SerializedName("html_url")
    private String mHtmlUrl;

    @SerializedName("attachments_url")
    private String mAttachmentUrl;

    @SerializedName("buckets_url")
    private String mBucketUrl;

    @SerializedName("comments_url")
    private String mCommentUrl;

    @SerializedName("likes_url")
    private String mLikeUrl;

    @SerializedName("projects_url")
    private String mProjectUrl;

    @SerializedName("rebounds_url")
    private String mReboundUrl;

    @SerializedName("animated")
    private boolean mAnimated;

    @SerializedName("tags")
    private List<String> mTags;

    @SerializedName("user")
    private UserJson mUserJson;

    @SerializedName("team")
    private TeamJson mTeamJson;

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public ImageJson getImages() {
        return mImages;
    }

    public int getViewCount() {
        return mViewCount;
    }

    public int getLikeCount() {
        return mLikeCount;
    }

    public int getCommentCount() {
        return mCommentCount;
    }

    public int getAttachmentCount() {
        return mAttachmentCount;
    }

    public int getReboundCount() {
        return mReboundCount;
    }

    public int getBucketCount() {
        return mBucketCount;
    }

    public Date getCreatedTime() {
        return mCreatedTime;
    }

    public Date getUpdatedTime() {
        return mUpdatedTime;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getAttachmentUrl() {
        return mAttachmentUrl;
    }

    public String getBucketUrl() {
        return mBucketUrl;
    }

    public String getCommentUrl() {
        return mCommentUrl;
    }

    public String getLikeUrl() {
        return mLikeUrl;
    }

    public String getProjectUrl() {
        return mProjectUrl;
    }

    public String getReboundUrl() {
        return mReboundUrl;
    }

    public boolean isAnimated() {
        return mAnimated;
    }

    public List<String> getTags() {
        return mTags;
    }

    public UserJson getUserJson() {
        return mUserJson;
    }

    public TeamJson getTeamJson() {
        return mTeamJson;
    }

    @Override
    public String toString() {
        return "ShotJson{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mWidth=" + mWidth +
                ", mHeight=" + mHeight +
                ", mImages=" + mImages +
                ", mViewCount=" + mViewCount +
                ", mLikeCount=" + mLikeCount +
                ", mCommentCount=" + mCommentCount +
                ", mAttachmentCount=" + mAttachmentCount +
                ", mReboundCount=" + mReboundCount +
                ", mBucketCount=" + mBucketCount +
                ", mCreatedTime=" + mCreatedTime +
                ", mUpdatedTime=" + mUpdatedTime +
                ", mHtmlUrl='" + mHtmlUrl + '\'' +
                ", mAttachmentUrl='" + mAttachmentUrl + '\'' +
                ", mBucketUrl='" + mBucketUrl + '\'' +
                ", mCommentUrl='" + mCommentUrl + '\'' +
                ", mLikeUrl='" + mLikeUrl + '\'' +
                ", mProjectUrl='" + mProjectUrl + '\'' +
                ", mReboundUrl='" + mReboundUrl + '\'' +
                ", mAnimated=" + mAnimated +
                ", mTags=" + mTags +
                ", mUserJson=" + mUserJson +
                ", mTeamJson=" + mTeamJson +
                '}';
    }
}
