package com.example.P0321_SimpleBrowser;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;


public class BrowserActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.browser);

        WebView webView = (WebView) findViewById(R.id.webView);

        Uri data = getIntent().getData();
        webView.loadUrl(data.toString());
    }
}