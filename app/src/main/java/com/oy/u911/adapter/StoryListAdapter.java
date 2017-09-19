package com.oy.u911.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.u911.DrawUtil;
import com.oy.u911.R;
import com.oy.u911.m.DailyNewsJson;

import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/18 9:13
 * Describe :
 */

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.MyHolder> {

    private List<DailyNewsJson.Story> mListData;
    private List<DailyNewsJson.Story> mTopData;
    private Context mContext;

    public StoryListAdapter(Context ctx, DailyNewsJson listData) {
        mContext = ctx;
        mListData = listData.getDailyStories();
        mTopData = listData.getDailyTopStories();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;// indicate this is header view
        }
        return 1; // indicate this is item view
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    @Override
    public StoryListAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            ViewPager viewPager = new ViewPager(parent.getContext());
            viewPager.setBackgroundResource(R.drawable.page_bottom_mask);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DrawUtil.dip2px(250));
            viewPager.setLayoutParams(params);
            return new MyHolder(viewPager, viewType);
        } else {
            View itemView = View.inflate(parent.getContext().getApplicationContext(), R.layout.item_story, null);
            return new MyHolder(itemView, viewType);
        }
    }

    @Override
    public void onBindViewHolder(final StoryListAdapter.MyHolder holder, int position) {
        if (holder.holderType == 0) {
            holder.viewPager.setAdapter(new TopVPAdapter(mTopData));
        } else {
            DailyNewsJson.Story story = mListData.get(position);
            List<String> storyImgUrls = story.getStoryImgUrls();
            if (storyImgUrls != null && storyImgUrls.size() > 0) {
                Glide.with(mContext).load(storyImgUrls.get(0)).into(holder.itemIcon);
            }
            holder.itemTitle.setText(story.getStoryTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnChildClickListener != null) {
                        int adapterPosition = holder.getAdapterPosition();
                        if (adapterPosition == RecyclerView.NO_POSITION) return;
                        mOnChildClickListener.onChildClick(view, adapterPosition);
                    }
                }
            });
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {

        // item
        ImageView itemIcon;
        TextView itemTitle;
        int holderType;
        // header
        ViewPager viewPager;

        MyHolder(View itemView, int type) {
            super(itemView);
            holderType = type;
            if (type == 0) {
                // header
                viewPager = (ViewPager) itemView;
            } else {
                // item
                itemIcon = itemView.findViewById(R.id.item_icon);
                itemTitle = itemView.findViewById(R.id.item_name);
            }
        }
    }

    public interface OnChildClickListener {
        void onChildClick(View v, int position);
    }

    private OnChildClickListener mOnChildClickListener;

    public void setOnChildClickListener(OnChildClickListener listener) {
        mOnChildClickListener = listener;
    }

}
