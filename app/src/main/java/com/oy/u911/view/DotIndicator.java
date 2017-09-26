package com.oy.u911.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.oy.u911.util.DrawUtil;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/21 16:33
 * Describe : ViewPager圆点指示器
 */

public class DotIndicator extends LinearLayout {

    private int mCount = 0;
    private List<DotView> mDotViews = new ArrayList<>();

    public DotIndicator(Context context) {
        super(context);
    }

    public DotIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {
        setOrientation(HORIZONTAL);
        mDotViews.clear();
        for (int i = 0; i < mCount; i++) {
            DotView dotView = new DotView(getContext());
            LinearLayout.LayoutParams params = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            params.leftMargin = DrawUtil.dip2px(5);
            params.gravity = Gravity.CENTER_VERTICAL;
            addView(dotView, params);
            mDotViews.add(dotView);
        }
        // 初始化默认第一个被选中
        setCurrentDot(0);
    }

    /** 设置指示点的数量 */
    public void setDotCount(int count) {
        if (mCount != count) {
            mCount = count;
            init();
        }
    }

    /** 设置当前被选中的指示点 */
    public void setCurrentDot(int position) {
        position = position % mCount;
        if (position < 0) {
            position += mCount;
        }
        for (int i = 0; i < mCount; i++) {
            mDotViews.get(i).setSelected(i == position);
        }
    }
}
