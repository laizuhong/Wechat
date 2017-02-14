package com.lzh.wechat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import com.lzh.wechat.util.MyLog;
import com.lzh.wechat.util.ShareUtils;
import com.lzh.wechat.view.CustomDialog;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

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
    MaterialEditText username;
    @Bind(R.id.password)
    MaterialEditText password;
    @Bind(R.id.login)
    AppCompatButton login;

    CustomDialog dialog;

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

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(username.getText().toString())&&!TextUtils.isEmpty(password.getText().toString())){
                    login.setEnabled(true);
                }else {
                    login.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(username.getText().toString())&&!TextUtils.isEmpty(password.getText().toString())){
                    login.setEnabled(true);
                }else {
                    login.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        AndPermission.with(this).requestCode(100).permission(Manifest.permission.READ_EXTERNAL_STORAGE).send();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        AndPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults, new PermissionListener() {
            @Override
            public void onSucceed(int requestCode) {

            }

            @Override
            public void onFailed(int requestCode) {
                finish();
            }
        });
    }

    @OnClick(R.id.login)
    public void onClick() {


        MyLog.e("login");
        String name=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pass))
            return;

        dialog=new CustomDialog(this,R.layout.dialog_loading,"正在登录......");
        dialog.show();

        LoginInfo loginInfo=new LoginInfo(name,pass);

        MyLog.e(loginInfo.getAccount());
        RequestCallback<LoginInfo> callback=new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo param) {
                dialog.dismiss();
                MyLog.e("onsuccess"+param.getAccount());
                ShareUtils.editXml("username",param.getAccount());
                ShareUtils.editXml("usertoken",param.getToken());
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onFailed(int code) {
                dialog.dismiss();
                MyLog.e("onfailed"+code);
            }

            @Override
            public void onException(Throwable exception) {
                dialog.dismiss();
                MyLog.e("onexception"+exception.toString());
            }
        };

        AuthService authService= NIMClient.getService(AuthService.class);
        authService.login(loginInfo).setCallback(callback);

    }
}
