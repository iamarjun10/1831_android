package com.example.mywebview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SwipeRefreshLayout swipeRefreshLayout =(SwipeRefreshLayout)findViewById(R.id.swipeLayout);
        webView=(WebView) findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setSoundEffectsEnabled(true);

        webView.setWebViewClient(new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        if(isConnection()){
            webView.loadUrl("https://www.youtube.com");
        }else{
            webView.loadUrl("file:///android_asset/arjun.html");
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(isConnection()){
                    webView.loadUrl("https://www.youtube.com");
                }
                else{
                    webView.loadUrl("file:///android_asset/arjun.html");
                }

                swipeRefreshLayout.setRefreshing(false);
            }


        });

    }

    private boolean isConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork!= null && activeNetwork.isConnected();
    }
}