package com.oy.u911.function.dribbble.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.u911.R;
import com.oy.u911.function.dribbble.model.ShotJson;
import com.oy.u911.util.DrawUtil;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.mTitle.setText(item.getTitle());
        holder.mViews.setText(String.valueOf(item.getViewCount()));
        holder.mComments.setText(String.valueOf(item.getCommentCount()));
        holder.mLikes.setText(String.valueOf(item.getLikeCount()));

        String avatarUrl = item.getUserJson().getAvatarUrl();
        Glide.with(mAty).asBitmap().load(avatarUrl).into(holder.mAvatar);
        holder.mUsername.setText(item.getUserJson().getName());

        if (item.isAnimated()) {
            Glide.with(mAty).asGif().load(item.getImages().getHidpi()).placeholder(R.drawable.ic_default_image).error(R.drawable.ic_error).into(holder.mImageView);
        } else {
            Glide.with(mAty).asBitmap().load(item.getImages().getHidpi()).placeholder(R.drawable.ic_default_image).error(R.drawable.ic_error).into(holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dribbble_card_view)
        CardView mCardView;

        @BindView(R.id.dribbble_item_image)
        ImageView mImageView;

        @BindView(R.id.dribbble_item_title)
        TextView mTitle;

        @BindView(R.id.dribbble_item_avatar)
        ImageView mAvatar;

        @BindView(R.id.dribbble_item_username)
        TextView mUsername;

        @BindView(R.id.dribbble_item_views)
        TextView mViews;

        @BindView(R.id.dribbble_item_comment)
        TextView mComments;

        @BindView(R.id.dribbble_item_like)
        TextView mLikes;

        MyHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            int width = Resources.getSystem().getDisplayMetrics().widthPixels - DrawUtil.dip2px(10);
            ViewGroup.LayoutParams params = mCardView.getLayoutParams();
            params.width = width;
            mCardView.setLayoutParams(params);

            ViewGroup.LayoutParams iVparams = mImageView.getLayoutParams();
            iVparams.width = width - DrawUtil.dip2px(16);
            iVparams.height = (int) (iVparams.width / 4.0f * 3);// 图片宽高比为4:3
            mImageView.setLayoutParams(iVparams);
        }
    }
}
