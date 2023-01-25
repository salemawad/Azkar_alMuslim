package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class page4 extends AppCompatActivity {
 private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        web=findViewById(R.id.web);
        Intent data= getIntent();
       int pagee= data.getExtras().getInt("page");

          if (pagee==0) {
              web.loadUrl("file:///android_asset/html/cont.html");
          }else if (pagee==1){
              web.loadUrl("file:///android_asset/html/lght.html");
          }else {
              web.loadUrl("file:///android_asset/html/nwm.html");
          }

    }
}