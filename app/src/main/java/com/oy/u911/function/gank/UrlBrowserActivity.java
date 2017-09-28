package com.oy.u911.function.gank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.oy.u911.R;
import com.oy.u911.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author   : xiaoyu
 * Date     : 2017/9/28 20:12
 * Describe :
 */

public class UrlBrowserActivity extends BaseActivity {

    private static final String KEY_URL = "key_url";

    public static void bowser(Context context, String url) {
        Intent intent = new Intent(context, UrlBrowserActivity.class);
        intent.putExtra(KEY_URL, url);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @InjectView(R.id.url_toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.url_progressbar)
    ProgressBar mProgressBar;

    @InjectView(R.id.url_webview)
    WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_url);

        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickFinishListener);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
        String url = getIntent().getStringExtra(KEY_URL);
        mWebView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return;
        }
        super.onBackPressed();
    }
}
