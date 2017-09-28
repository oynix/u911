package com.oy.u911.function.zhihu.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 15:11
 * Describe : 每条新闻的详情Json
 */

public class NewsDetailJson {

    /** HTML格式的新闻 */
    @SerializedName("body")
    private String mBody;

    /** 图片的内容提供方. 最好附上来避免版权问题 */
    @SerializedName("image_source")
    private String mImageSource;

    /** 新闻标题 */
    @SerializedName("title")
    private String mTitle;

    /** 获得的图片 同{@link DailyNewsJson.Story#getStoryImgUrls()}获取的图片分辨率不同, 这里浏览文章时的大图 */
    @SerializedName("image")
    private String mImage;

    /** 供在线查看内容与分享至SNS用的URL */
    @SerializedName("share_url")
    private String mShareUrl;

    /** 供手机端的WebView(UIWebView)使用 */
    @SerializedName("js")
    private List<String> mJs;

    /** 这篇文章的推荐作者 */
    @SerializedName("recommenders")
    private List<Recommender> mRecommenders;

    /** Google Analytics使用 */
    @SerializedName("ga_prefix")
    private String mGa;

    /** 栏目信息 */
    @SerializedName("section")
    private Section mSection;

    /** 新闻类型 */
    @SerializedName("type")
    private String mType;

    /** 新闻的id */
    @SerializedName("id")
    private String mId;

    /** 供手机端WebView(UIWebView)使用 */
    @SerializedName("css")
    private List<String> mCss;

    // 在较为特殊的情况下, 知乎日报可能将某个主体日报的站外文章推送至知乎日报首页
    // 此时返回的JSON数据缺少body, image-source, image, js属性.
    // 多出theme_name, editor_name, theme_id三个属性
    // type由0变为1

    /** 主题名称 */
    @SerializedName("theme_name")
    private String mThemeName;

    /** 编辑名字 */
    @SerializedName("editor_name")
    private String mEditorName;

    /** 主题id */
    @SerializedName("theme_id")
    private String mThemeId;

    public String getBody() {
        return mBody;
    }

    public String getImageSource() {
        return mImageSource;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getImage() {
        return mImage;
    }

    public String getShareUrl() {
        return mShareUrl;
    }

    public List<String> getJs() {
        return mJs;
    }

    public List<Recommender> getRecommenders() {
        return mRecommenders;
    }

    public String getGa() {
        return mGa;
    }

    public Section getSection() {
        return mSection;
    }

    public String getType() {
        return mType;
    }

    public String getId() {
        return mId;
    }

    public List<String> getCss() {
        return mCss;
    }

    public String getThemeName() {
        return mThemeName;
    }

    public String getEditorName() {
        return mEditorName;
    }

    public String getThemeId() {
        return mThemeId;
    }

    @Override
    public String toString() {
        return "NewsDetailJson{" +
                "mBody='" + mBody + '\'' +
                ", mImageSource='" + mImageSource + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mImage='" + mImage + '\'' +
                ", mShareUrl='" + mShareUrl + '\'' +
                ", mJs=" + mJs +
                ", mRecommenders=" + mRecommenders +
                ", mGa='" + mGa + '\'' +
                ", mSection=" + mSection +
                ", mType='" + mType + '\'' +
                ", mId='" + mId + '\'' +
                ", mCss=" + mCss +
                ", mThemeName='" + mThemeName + '\'' +
                ", mEditorName='" + mEditorName + '\'' +
                ", mThemeId='" + mThemeId + '\'' +
                '}';
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 文章推荐者JSON
     */
    private static class Recommender {

        /** 推荐者头像url */
        @SerializedName("avatar")
        private String mAvatarUrl;

        public String getAvatarUrl() {
            return mAvatarUrl;
        }

        @Override
        public String toString() {
            return "Recommender{" +
                    "mAvatarUrl='" + mAvatarUrl + '\'' +
                    '}';
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 新闻栏目JSON
     */
    private static class Section {

        /** 栏目缩略图url */
        @SerializedName("thumbnail")
        private String mThumbnailUrl;

        /** 该栏目id */
        @SerializedName("id")
        private String mId;

        /** 该栏目名字 */
        @SerializedName("name")
        private String mName;

        public String getThumbnailUrl() {
            return mThumbnailUrl;
        }

        public String getId() {
            return mId;
        }

        public String getName() {
            return mName;
        }

        @Override
        public String toString() {
            return "Section{" +
                    "mThumbnailUrl='" + mThumbnailUrl + '\'' +
                    ", mId='" + mId + '\'' +
                    ", mName='" + mName + '\'' +
                    '}';
        }
    }

}
