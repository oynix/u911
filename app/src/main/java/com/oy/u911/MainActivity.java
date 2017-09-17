package com.oy.u911;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.u911.base.BaseActivity;
import com.oy.u911.m.DailyNewsJson;
import com.oy.u911.p.Contract;
import com.oy.u911.p.Presenter;

import java.util.List;

public class MainActivity extends BaseActivity implements Contract.View {

    Presenter mPresenter = new Presenter(this);
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.story_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mPresenter.loadStartImage();
        mPresenter.loadLatestNews();
    }

    @Override
    public void setListData(List<DailyNewsJson.Story> storyList) {
        mRecyclerView.setAdapter(new StoryAdapter(storyList));
    }

    class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyHolder> {

        private List<DailyNewsJson.Story> mListData;

        StoryAdapter(List<DailyNewsJson.Story> listData) {
            mListData = listData;
        }

        @Override
        public StoryAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(parent.getContext().getApplicationContext(), R.layout.item_story, null));
        }

        @Override
        public void onBindViewHolder(StoryAdapter.MyHolder holder, int position) {
            DailyNewsJson.Story story = mListData.get(position);

            List<String> storyImgUrls = story.getStoryImgUrls();
            if (storyImgUrls != null && storyImgUrls.size() > 0) {
                Glide.with(MainActivity.this).load(storyImgUrls.get(0)).into(holder.icon);
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
}
