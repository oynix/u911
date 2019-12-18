package com.oy.u911.function.zhihu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.zhihu.model.DailyNewsJson;
import com.oy.u911.function.zhihu.model.NewsDetailJson;
import com.oy.u911.function.zhihu.presenter.StoryDetailContract;
import com.oy.u911.function.zhihu.presenter.StoryDetailPresenter;
import com.oy.u911.util.HtmlUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/25 14:42
 * Describe : Story详情页
 */

public class StoryDetailActivity extends BaseActivity implements StoryDetailContract.View {

    public static final String STORY_DATA_KEY = "story_data";

    @BindView(R.id.detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.title_bg_iv)
    ImageView mTitleBgIv;

    @BindView(R.id.title_bg_iv_copyright)
    TextView mTvCopyRight;

    @BindView(R.id.web_view)
    WebView mWebView;

    @BindView(R.id.nested_scroll_view)
    NestedScrollView mScrollView;

    @BindView(R.id.tv_load_error_tip)
    TextView mTvErrorTip;

    private StoryDetailPresenter mPresenter = new StoryDetailPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        mWebView.getSettings().setDomStorageEnabled(true);

        mPresenter.loadStory(getIntent());
    }

    @Override
    public void setTitleImage(String url) {
        if (mTitleBgIv != null) {
            Glide.with(this).asBitmap().load(url).into(mTitleBgIv);
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
