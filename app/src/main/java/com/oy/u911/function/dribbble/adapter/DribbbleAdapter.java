package com.oy.u911.function.dribbble.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.u911.R;
import com.oy.u911.function.dribbble.model.ShotJson;
import com.oy.u911.util.Loger;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author   : xiaoyu
 * Date     : 2017/10/3 22:48
 * Describe :
 */

public class DribbbleAdapter extends RecyclerView.Adapter<DribbbleAdapter.MyHolder> {

    private static final String TAG = DribbbleAdapter.class.getSimpleName();

    private List<ShotJson> mListData;
    private Context mAty;

    public DribbbleAdapter(Context aty, List<ShotJson> data) {
        mAty = aty;
        mListData = data;
    }

    public void updateListData(List<ShotJson> data) {
        mListData = data;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext().getApplicationContext();
        View itemView = View.inflate(context, R.layout.item_dribbble, null);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        ShotJson item = mListData.get(position);
        Loger.d(TAG, item.getTitle());
        holder.mDes.setText(item.getTitle());

//        ViewGroup.LayoutParams params = holder.mImageView.getLayoutParams();
//        params.width = DrawUtil.dip2px(item.getWidth());
//        params.height = DrawUtil.dip2px(item.getHeight());
//        holder.mImageView.setLayoutParams(params);
        if (item.isAnimated()) {
            Glide.with(mAty).load(item.getImages().getHidpi()).asGif().placeholder(R.drawable.ic_default_image).error(R.drawable.ic_error).into(holder.mImageView);
        } else {
            Glide.with(mAty).load(item.getImages().getHidpi()).asBitmap().placeholder(R.drawable.ic_default_image).error(R.drawable.ic_error).into(holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.dribbble_item_image)
        ImageView mImageView;

        @InjectView(R.id.dribbble_item_des)
        TextView mDes;

        MyHolder(View itemView) {
            super(itemView);

            ButterKnife.inject(this, itemView);
        }
    }
}
