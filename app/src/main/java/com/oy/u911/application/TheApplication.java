package com.oy.u911.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/15 10:09
 * Describe : app
 */

public class TheApplication extends Application {

    private final static String TAG = "u911-app";
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Log.e(TAG, "onCreate执行");
    }

    public static Context getContext() {
        return mContext;
    }
}
