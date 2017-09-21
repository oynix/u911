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
import com.oy.u911.v.DotIndicator;

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
            View itemView = View.inflate(parent.getContext().getApplicationContext(), R.layout.header, null);
            // ViewPager可能加载不到宽和高
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DrawUtil.dip2px(250));
            itemView.setLayoutParams(params);
            return new MyHolder(itemView, viewType);
        } else {
            View itemView = View.inflate(parent.getContext().getApplicationContext(), R.layout.item_story, null);
            return new MyHolder(itemView, viewType);
        }
    }

    @Override
    public void onBindViewHolder(final StoryListAdapter.MyHolder holder, int position) {
        if (holder.holderType == 0) {
            TopVPAdapter adapter = new TopVPAdapter(mTopData);
            holder.viewPager.setAdapter(adapter);
            adapter.setOnChildClickListener(mOnChildClickListener);
            holder.indicator.setDotCount(adapter.getRealCount());
        } else {
            final DailyNewsJson.Story story = mListData.get(position);
            List<String> storyImgUrls = story.getStoryImgUrls();
            if (storyImgUrls != null && storyImgUrls.size() > 0) {
                Glide.with(mContext).load(storyImgUrls.get(0)).asBitmap().into(holder.itemIcon);
            }
            holder.itemTitle.setText(story.getStoryTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnChildClickListener != null) {
                        int adapterPosition = holder.getAdapterPosition();
                        if (adapterPosition == RecyclerView.NO_POSITION) return;
                        mOnChildClickListener.onChildClick(story);
                    }
                }
            });
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {

        // header
        ViewPager viewPager;
        DotIndicator indicator;

        // item
        ImageView itemIcon;
        TextView itemTitle;

        int holderType;

        MyHolder(View itemView, int type) {
            super(itemView);
            holderType = type;
            if (type == 0) {
                // header
                viewPager = itemView.findViewById(R.id.header_view_pager);
                indicator = itemView.findViewById(R.id.header_dot_indicator);
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        indicator.setCurrentDot(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            } else {
                // item
                itemIcon = itemView.findViewById(R.id.item_icon);
                itemTitle = itemView.findViewById(R.id.item_name);
            }
        }
    }

    public interface OnChildClickListener {
        void onChildClick(DailyNewsJson.Story story);
    }

    private OnChildClickListener mOnChildClickListener;

    public void setOnChildClickListener(OnChildClickListener listener) {
        mOnChildClickListener = listener;
    }

}
