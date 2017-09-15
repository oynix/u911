package com.oy.u911.m;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 14:57
 * Describe : 某日的所有新闻概览Json
 */

public class DailyNewsJson {

    /** 日期 */
    @SerializedName("date")
    private String mDate;

    /** 当天的新闻 */
    @SerializedName("stories")
    private List<Story> mDailyStories;

    /** 当天顶部轮播新闻 */
    @SerializedName("top_stories")
    private List<Story> mDailyTopStories;

    public String getDate() {
        return mDate;
    }

    public List<Story> getDailyStories() {
        return mDailyStories;
    }

    public List<Story> getDailyTopStories() {
        return mDailyTopStories;
    }

    @Override
    public String toString() {
        return "DailyNewsJson{" +
                "mDate='" + mDate + '\'' +
                ", mDailyStories=" + mDailyStories +
                ", mDailyTopStories=" + mDailyTopStories +
                '}';
    }

    /////////////////////////////////////////////////////////////////////////////////

    /**
     * 每条新闻概览信息Json
     */
    private static class Story {

        /** 新闻标题 */
        @SerializedName("title")
        private String mStoryTitle;

        /** 新闻图片 官方采用数组形式, 可能为空, 使用时注意判断 */
        @SerializedName("images")
        private List<String> mStoryImgUrls;

        /** 供Google Analytics */
        @SerializedName("ga_prefix")
        private String mStoryGA;

        /** 作用未知 */
        @SerializedName("type")
        private String mStoryType;

        /** url和share_url后的id */
        @SerializedName("id")
        private String mStoryId;

        /** 消息是否含有多张图片 */
        @SerializedName("multipic")
        private boolean mStoryMultiPic;

        public String getStoryTitle() {
            return mStoryTitle;
        }

        public List<String> getStoryImgUrls() {
            return mStoryImgUrls;
        }

        public String getStoryGA() {
            return mStoryGA;
        }

        public String getStoryType() {
            return mStoryType;
        }

        public String getStoryId() {
            return mStoryId;
        }

        public boolean isStoryMultiPic() {
            return mStoryMultiPic;
        }

        @Override
        public String toString() {
            return "Story{" +
                    "mStoryTitle='" + mStoryTitle + '\'' +
                    ", mStoryImgUrls=" + mStoryImgUrls +
                    ", mStoryGA='" + mStoryGA + '\'' +
                    ", mStoryType='" + mStoryType + '\'' +
                    ", mStoryId='" + mStoryId + '\'' +
                    ", mStoryMultiPic=" + mStoryMultiPic +
                    '}';
        }
    }
}
