package com.oy.u911.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.u911.R;
import com.oy.u911.m.DailyNewsJson;
import com.oy.u911.util.DrawUtil;
import com.oy.u911.util.Loger;
import com.oy.u911.v.DotIndicator;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/18 9:13
 * Describe :
 */

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.MyHolder> {

    private final static String TAG = StoryListAdapter.class.getSimpleName();

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
            TopViewPagerAdapter adapter = new TopViewPagerAdapter(mTopData);
            holder.viewPager.setAdapter(adapter);
            // TopViewPagerItem 和 StoryListItem 共用同一个点击事件监听, 供外部调用
            adapter.setOnChildClickListener(mOnChildClickListener);
            holder.indicator.setDotCount(mTopData.size());
            holder.viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % mTopData.size());
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
        MyHandler handler;

        int holderType;

        MyHolder(View itemView, int type) {
            super(itemView);
            holderType = type;
            // header
            if (type == 0) {
                viewPager = itemView.findViewById(R.id.header_view_pager);
                indicator = itemView.findViewById(R.id.header_dot_indicator);
                handler = new MyHandler(viewPager);
                // 滑动监听
                viewPager.addOnPageChangeListener(new OnPageChangeAdapter() {
                    @Override
                    public void onPageSelected(int position) {
                        indicator.setCurrentDot(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        switch (state) {
                            case ViewPager.SCROLL_STATE_IDLE:
                                handler.sendEmptyMessage(MESSAGE_CONTINUE);
                                break;
                            case ViewPager.SCROLL_STATE_DRAGGING:
                                handler.sendEmptyMessage(MESSAGE_PAUSE);
                                break;
                            case ViewPager.SCROLL_STATE_SETTLING:
                                handler.sendEmptyMessage(MESSAGE_PAUSE);
                                break;
                        }
                    }
                });
                // 轮播的开始和停止控制
                viewPager.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                    @Override
                    public void onViewAttachedToWindow(View view) {
                        if (handler != null) {
                            handler.sendEmptyMessage(MESSAGE_CONTINUE);
                        }
                    }

                    @Override
                    public void onViewDetachedFromWindow(View view) {
                        if (handler != null) {
                            handler.sendEmptyMessage(MESSAGE_PAUSE);
                        }
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

    ///////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////
    // 轮播控制部分

    private static final int MESSAGE_PAUSE = 0x01;
    private static final int MESSAGE_CONTINUE = 0x02;
    private static final int MESSAGE_NEXT = 0x03;

    private static final long MESSAGE_DELAYED = 4500;

    private static class MyHandler extends Handler {

        private WeakReference<ViewPager> mReference;

        MyHandler(ViewPager viewPager) {
            mReference = new WeakReference<>(viewPager);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_PAUSE:
                    Loger.d(TAG, "接收消息: MESSAGE_PAUSE" + msg.what);
                    removeCallbacksAndMessages(null);
                    break;
                case MESSAGE_NEXT:
                    Loger.d(TAG, "接收消息: MESSAGE_NEXT" + msg.what);
                    if (mReference.get() != null) {
                        int currentItem = mReference.get().getCurrentItem();
                        mReference.get().setCurrentItem(currentItem + 1);
                    }
                    sendEmptyMessageDelayed(MESSAGE_NEXT, MESSAGE_DELAYED);
                    break;
                case MESSAGE_CONTINUE:
                    Loger.d(TAG, "接收消息: MESSAGE_CONTINUE" + msg.what);
                    sendEmptyMessageDelayed(MESSAGE_NEXT, MESSAGE_DELAYED);
                    break;
            }
        }
    }
}
