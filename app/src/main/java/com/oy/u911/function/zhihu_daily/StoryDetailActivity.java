package com.oy.u911.function.zhihu_daily;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.zhihu_daily.model.DailyNewsJson;
import com.oy.u911.function.zhihu_daily.model.NewsDetailJson;
import com.oy.u911.function.zhihu_daily.presenter.StoryDetailContract;
import com.oy.u911.function.zhihu_daily.presenter.StoryDetailPresenter;
import com.oy.u911.util.HtmlUtil;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/25 14:42
 * Describe : Story详情页
 */

public class StoryDetailActivity extends BaseActivity implements StoryDetailContract.View {

    public static final String STORY_DATA_KEY = "story_data";

    @InjectView(R.id.detail_toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.title_bg_iv)
    ImageView mTitleBgIv;

    @InjectView(R.id.title_bg_iv_copyright)
    TextView mTvCopyRight;

    @InjectView(R.id.web_view)
    WebView mWebView;

    @InjectView(R.id.nested_scroll_view)
    NestedScrollView mScrollView;

    @InjectView(R.id.tv_load_error_tip)
    TextView mTvErrorTip;

    private StoryDetailPresenter mPresenter = new StoryDetailPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);

        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        mWebView.getSettings().setDomStorageEnabled(true);

        mPresenter.loadStory(getIntent());
    }

    @Override
    public void setTitleImage(String url) {
        if (mTitleBgIv != null) {
            Glide.with(this).load(url).asBitmap().into(mTitleBgIv);
        }
    }

    @Override
    public void setCopyright(String copyright) {
        if (mTvCopyRight != null) {
            mTvCopyRight.setText(copyright);
        }
    }

    @Override
    public void setContent(NewsDetailJson content) {
        mWebView.loadData(HtmlUtil.createHtmlData(content), HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
    }

    @Override
    public void showError() {
        mScrollView.setVisibility(View.GONE);
        mTvErrorTip.setVisibility(View.VISIBLE);
    }

    public static void loadDetail(Context context, @NonNull DailyNewsJson.Story story) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(STORY_DATA_KEY, story);
        Intent intent = new Intent(context, StoryDetailActivity.class);
        intent.putExtra(STORY_DATA_KEY, bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
