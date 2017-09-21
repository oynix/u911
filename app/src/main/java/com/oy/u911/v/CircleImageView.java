package com.oy.u911.v;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/21 11:24
 * Describe : 圆角ImageView
 */

public class CircleImageView extends ImageView {

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null || !drawable.getClass().equals(BitmapDrawable.class) || getWidth() == 0 || getHeight() == 0)
            return;
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        if (bitmap != null) {
            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            if (bitmap != null) {
                canvas.drawBitmap(getCircleBitmap(bitmap), 0, 0, null);
            }
        }
    }

    private Bitmap getCircleBitmap(Bitmap bitmap) {
        Bitmap target = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas cvs = new Canvas(target);
        Paint paint = new Paint();
        cvs.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        cvs.drawBitmap(bitmap, 0, 0, paint);
        return target;
    }
}
