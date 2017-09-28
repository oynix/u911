package com.oy.u911.function.gank.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oy.u911.R;
import com.oy.u911.base.BaseFragment;
import com.oy.u911.function.gank.adapter.GankNewsAdapter;
import com.oy.u911.function.gank.bean.GankNewsBean;
import com.oy.u911.function.gank.presenter.GankContract;
import com.oy.u911.function.gank.presenter.GankPresenter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/27 21:43
 * Describe :
 * 1. Android
 * 2. iOS
 * 3. 前端
 * 4. 福利
 * 5. 休息视频
 * 6. 拓展资源
 * 7. 瞎推荐
 * 8. all
 */

public class GankFragment extends BaseFragment implements GankContract.View {

    private static final String TAG = GankFragment.class.getSimpleName();

    private static final String GANK_FRAGMENT_DATA_KEY = "gank_fragment_data_key";

    public static final String GANK_FRAGMENT_TYPE_ANDROID = "Android";
    public static final String GANK_FRAGMENT_TYPE_IOS = "iOS";
    public static final String GANK_FRAGMENT_TYPE_QIANDUAN = "前端";
    public static final String GANK_FRAGMENT_TYPE_FULI = "福利";
    public static final String GANK_FRAGMENT_TYPE_XIATUIJIAN = "瞎推荐";
    public static final String GANK_FRAGMENT_TYPE_XIUXISHIPIN = "休息视频";
    public static final String GANK_FRAGMENT_TYPE_TUOZHANZIYUAN = "拓展资源";

    @StringDef({GANK_FRAGMENT_TYPE_ANDROID, GANK_FRAGMENT_TYPE_IOS, GANK_FRAGMENT_TYPE_QIANDUAN,
            GANK_FRAGMENT_TYPE_FULI, GANK_FRAGMENT_TYPE_XIATUIJIAN,
            GANK_FRAGMENT_TYPE_XIUXISHIPIN, GANK_FRAGMENT_TYPE_TUOZHANZIYUAN})
    @Retention(RetentionPolicy.SOURCE)
    @interface GrankFragmentType {

    }

    /** 创建instance */
    public static GankFragment newInstance(@NonNull @GrankFragmentType String type) {
        Bundle bundle = new Bundle();
        bundle.putString(GANK_FRAGMENT_DATA_KEY, type);
        GankFragment gankFragment = new GankFragment();
        gankFragment.setArguments(bundle);
        return gankFragment;
    }

    private final GankPresenter mPresenter = new GankPresenter(this);

    private String mFragmentType;

    @InjectView(R.id.gank_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentType = getArguments().getString(GANK_FRAGMENT_DATA_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gank, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.inject(this, view);
        if (mFragmentType.equals(GANK_FRAGMENT_TYPE_FULI)) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false));
            // 福利页面一次请求60条数据
            mPresenter.onViewCreate(mFragmentType, 60);
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            // 其他页面一次请求默认的40条数据
            mPresenter.onViewCreate(mFragmentType);
        }
    }

    @Override
    public void setPageState(boolean isLoading) {

    }

    @Override
    public void setListData(List<GankNewsBean> listData) {
        if (mFragmentType.equals(GANK_FRAGMENT_TYPE_FULI)) {
            mRecyclerView.setAdapter(new GankNewsAdapter(this, listData, true));
        } else {
            mRecyclerView.setAdapter(new GankNewsAdapter(this, listData));
        }
    }
}
