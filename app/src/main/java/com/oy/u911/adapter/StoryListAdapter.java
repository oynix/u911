package com.oy.u911.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
 * Date     : 2017/9/18 9:13
 * Describe :
 */

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.MyHolder> {

    private List<DailyNewsJson.Story> mListData;
    private Context mContext;

    public StoryListAdapter(Context ctx, List<DailyNewsJson.Story> listData) {
        mContext = ctx;
        mListData = listData;
    }

    @Override
    public StoryListAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(parent.getContext().getApplicationContext(), R.layout.item_story, null));
    }

    @Override
    public void onBindViewHolder(StoryListAdapter.MyHolder holder, int position) {
        DailyNewsJson.Story story = mListData.get(position);

        List<String> storyImgUrls = story.getStoryImgUrls();
        if (storyImgUrls != null && storyImgUrls.size() > 0) {
            Glide.with(mContext).load(storyImgUrls.get(0)).into(holder.icon);
        }

        holder.name.setText(story.getStoryTitle());
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name;

        MyHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.item_icon);
            name = itemView.findViewById(R.id.item_name);
        }
    }

}
