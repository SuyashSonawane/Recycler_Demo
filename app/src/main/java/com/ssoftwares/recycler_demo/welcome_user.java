package com.ssoftwares.recycler_demo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class welcome_user extends AppCompatActivity {
    ProgressBar progressBar;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);
        TextView text = (TextView)findViewById(R.id.welcome_user_textView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        text.setText(str);
        progressBar =(ProgressBar)findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.VISIBLE);
        webView=(WebView)findViewById(R.id.web_view);

        String uri ="https://firebasestorage.googleapis.com/v0/b/fir-try-8cdc9.appspot.com/o/anonymous-wallpapers-30620-7440314.jpg?alt=media&token=aa0c9b95-cfce-418d-9088-f26c97781183";
        String final_uri="https://docs.google.com/viewer?url="+uri;

//        Setting webView options

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted (WebView view,String url, Bitmap favicon){
                super.onPageStarted(view,url,favicon);
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("Loading");
            }
            @Override
            public void onPageFinished (WebView view,String url){
                super.onPageFinished(view,url);
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("Loaded");
                progressBar.setVisibility(View.GONE);
            }
        });
        webView.loadUrl("https://picsum.photos/300/600");


    }
}
