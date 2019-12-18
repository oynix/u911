package com.oy.u911.function.dribbble;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.dribbble.adapter.DribbbleAdapter;
import com.oy.u911.function.dribbble.model.ShotJson;
import com.oy.u911.function.dribbble.presenter.DribbbleContract;
import com.oy.u911.function.dribbble.presenter.DribbblePresenter;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 11:45
 * Describe :
 */

public class DribbbleActivity extends BaseActivity implements DribbbleContract.View {

    private DribbblePresenter mPresenter = new DribbblePresenter(this);

    @BindView(R.id.dribbble_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.dribbble_loading_pb)
    ProgressBar mProgressBar;

    @BindView(R.id.dribbble_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dribbble);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        mPresenter.loadData();
    }

    @Override
    public void setWidgetState(boolean isLoading) {
        mProgressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        mRecyclerView.setVisibility(isLoading ? View.GONE : View.VISIBLE);
    }

    @Override
    public void setListData(List<ShotJson> data) {
        DribbbleAdapter adapter = new DribbbleAdapter(this, data);
        mRecyclerView.setAdapter(adapter);
    }
}
