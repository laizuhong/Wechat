package com.lzh.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;

import com.lzh.wechat.util.MyLog;
import com.lzh.wechat.util.ShareUtils;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * Created by laizuhong on 2017/2/10.
 */

public class LoginActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.username)
    TextInputEditText username;
    @Bind(R.id.password)
    TextInputEditText password;
    @Bind(R.id.login)
    AppCompatButton login;

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        toolbar.setTitle("登录");
        setSupportActionBar(toolbar);

    }

    @OnClick(R.id.login)
    public void onClick() {
        MyLog.e("login");
        String name=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        LoginInfo loginInfo=new LoginInfo(name,pass);

        MyLog.e(loginInfo.getAccount());
        RequestCallback<LoginInfo> callback=new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo param) {
                MyLog.e("onsuccess"+param.getAccount());
                ShareUtils.editXml("username",param.getAccount());
                ShareUtils.editXml("usertoken",param.getToken());
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }

            @Override
            public void onFailed(int code) {
                MyLog.e("onfailed"+code);
            }

            @Override
            public void onException(Throwable exception) {
                MyLog.e("onexception"+exception.toString());
            }
        };

        AuthService authService=NIMClient.getService(AuthService.class);
        authService.login(loginInfo).setCallback(callback);

    }
}
