package com.oy.u911.function.zhihu_daily;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.zhihu_daily.adapter.StoryListAdapter;
import com.oy.u911.function.zhihu_daily.model.DailyNewsJson;
import com.oy.u911.function.zhihu_daily.presenter.MainContract;
import com.oy.u911.function.zhihu_daily.presenter.MainPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ZhihuIndexActivity extends BaseActivity implements MainContract.View, StoryListAdapter.OnChildClickListener {

    MainPresenter mPresenter = new MainPresenter(this);

    @InjectView(R.id.story_list)
    RecyclerView mRecyclerView;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.tv_load_error_tip)
    TextView mErrorTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu_index);
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mPresenter.loadLatestNews();
    }

    @Override
    public void setDailyListData(DailyNewsJson dailyData) {
        StoryListAdapter adapter = new StoryListAdapter(this, dailyData);
        adapter.setOnChildClickListener(this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showError() {
        mRecyclerView.setVisibility(View.GONE);
        mErrorTip.setVisibility(View.VISIBLE);
    }


    /** RecyclerView 点击监听 */
    @Override
    public void onChildClick(DailyNewsJson.Story story) {
        if (story != null) {
            StoryDetailActivity.loadDetail(this, story);
        }
    }
}
