package com.oy.u911.application;

import android.app.Application;
import android.util.Log;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 10:09
 * Describe : app
 */

public class TheApplication extends Application {

    private final static String TAG = "u911-app";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate执行");
    }

}
