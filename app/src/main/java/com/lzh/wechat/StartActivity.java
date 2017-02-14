package com.lzh.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.lzh.wechat.util.ShareUtils;

/**
 *
 * Created by laizuhong on 2017/2/10.
 */

public class StartActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String username= ShareUtils.getStringXml("username");
                if (TextUtils.isEmpty(username)){
                    startActivity(new Intent(StartActivity.this,LoginActivity.class));
                }else {
                    startActivity(new Intent(StartActivity.this,MainActivity.class));
                }
                finish();
            }
        },200);
    }
}
