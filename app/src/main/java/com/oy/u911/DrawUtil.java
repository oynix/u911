package com.oy.u911;

import com.oy.u911.application.TheApplication;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/19 16:02
 * Describe :
 */

public final class DrawUtil {

    public static int dip2px(float dip) {
        float density = TheApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (density * dip + 0.5f);
    }
}
