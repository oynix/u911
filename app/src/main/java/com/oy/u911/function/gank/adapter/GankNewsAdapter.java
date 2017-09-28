package com.oy.u911.function.gank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oy.u911.R;
import com.oy.u911.function.gank.bean.GankNewsBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/28 15:06
 * Describe :
 */

public class GankNewsAdapter extends RecyclerView.Adapter<GankNewsAdapter.MyViewHolder> {

    private final List<GankNewsBean> mListData;

    public GankNewsAdapter(List<GankNewsBean> data) {
        mListData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext().getApplicationContext();
        return new MyViewHolder(View.inflate(context, R.layout.item_gank_news, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GankNewsBean item = mListData.get(position);
        holder.name.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.gank_item_name)
        TextView name;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
