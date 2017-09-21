package com.oy.u911.v;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.oy.u911.DrawUtil;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/21 21:52
 * Describe : 指示器中的小圆点
 */

public class DotView extends View {

    public static final int STATE_TYPE_NORMAL = 0x01;
    public static final int STATE_TYPE_SELECTED = 0x02;

    private int mState;

    public DotView(Context context) {
        super(context);
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(DrawUtil.dip2px(8), DrawUtil.dip2px(8));
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        if (mSelected) {
            mPaint.setColor(0xffffffff);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, DrawUtil.dip2px(4), mPaint);
        } else {
            mPaint.setColor(Color.GRAY);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, DrawUtil.dip2px(2), mPaint);
        }
    }

    public boolean mSelected = false;

    public void setSelected(boolean selected) {
        if (mSelected != selected) {
            mSelected = selected;
            invalidate();
        }
    }
}
