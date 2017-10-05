package com.oy.u911.function.dribbble;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.function.dribbble.adapter.DribbbleAdapter;
import com.oy.u911.function.dribbble.model.ShotJson;
import com.oy.u911.function.dribbble.presenter.DribbbleContract;
import com.oy.u911.function.dribbble.presenter.DribbblePresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/2 11:45
 * Describe :
 */

public class DribbbleActivity extends BaseActivity implements DribbbleContract.View{

    private DribbblePresenter mPresenter = new DribbblePresenter(this);

    @InjectView(R.id.dribbble_toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.dribbble_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dribbble);

        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        mPresenter.loadData();
    }

    @Override
    public void setListData(List<ShotJson> data) {
        DribbbleAdapter adapter = new DribbbleAdapter(this, data);
        mRecyclerView.setAdapter(adapter);
    }
}
