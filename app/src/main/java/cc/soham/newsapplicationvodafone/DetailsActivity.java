package cc.soham.newsapplicationvodafone;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import cc.soham.newsapplicationvodafone.objects.NewsObjects;

/**
 * Created by sohammondal on 04/08/16.
 */

public class DetailsActivity extends AppCompatActivity {
    private static final String KEY_POSITION = "position";
    private static final int DEFAULT_POSITION = -1;

    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        webView = (WebView) findViewById(R.id.activity_details_webview);
        progressBar = (ProgressBar) findViewById(R.id.activity_details_progress);

        int position = getIntent().getIntExtra(KEY_POSITION, DEFAULT_POSITION);
        NewsObjects newsObjects = NewsObjects.getNewsObjectsList().get(position);

        loadWebViewForNewsObject(newsObjects);
    }

    private void loadWebViewForNewsObject(NewsObjects newsObjects) {
        getSupportActionBar().setTitle(newsObjects.getTitle());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });
        webView.loadUrl(newsObjects.getDetailsUrl());
    }

    public static void start(Context context, int position) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_POSITION, position);
        context.startActivity(intent);
    }
}
