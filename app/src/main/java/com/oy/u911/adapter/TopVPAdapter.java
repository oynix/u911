package com.oy.u911.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.u911.R;
import com.oy.u911.m.DailyNewsJson;

import java.util.List;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/18 11:34
 * Describe : 主页面顶部轮播Adapter
 */

public class TopVPAdapter extends PagerAdapter {

    private List<DailyNewsJson.Story> mStories;

    public TopVPAdapter(List<DailyNewsJson.Story> stories) {
        for (DailyNewsJson.Story story : stories) {
            Log.e("Adapter", "story:" + story.toString());
        }
        mStories = stories;
    }

    @Override
    public int getCount() {
        return mStories.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View pageView = View.inflate(container.getContext().getApplicationContext(), R.layout.item_page, null);

        ImageView pageImage = pageView.findViewById(R.id.page_image);
        final DailyNewsJson.Story story = mStories.get(position);
        Glide.with(container.getContext()).load(story.getStoryImgUrl()).into(pageImage);

        TextView pageTitle = pageView.findViewById(R.id.page_title);
        pageTitle.setText(story.getStoryTitle());
        container.addView(pageView);
        pageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onChildClick(story);
                }
            }
        });
        return pageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    private StoryListAdapter.OnChildClickListener mListener;
    public void setOnChildClickListener(StoryListAdapter.OnChildClickListener l) {
        mListener = l;
    }
}
