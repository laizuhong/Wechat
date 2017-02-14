package com.lzh.wechat.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.lzh.wechat.R;

/**
 *
 * Created by laizuhong on 2017/2/13.
 */

public class CustomDialog extends Dialog{

    public CustomDialog(Context context, int resId,String tip) {
        super(context);
        setContentView(resId);
        TextView tvTip= (TextView) findViewById(R.id.tips);
        tvTip.setText(tip);
        Window window=getWindow();
        WindowManager.LayoutParams params=window.getAttributes();
        params.gravity= Gravity.CENTER;
        window.setAttributes(params);
        window.setBackgroundDrawableResource(android.R.color.transparent);//去掉四角的白色部分
    }


    public CustomDialog(Context context, View layout) {
        super(context);
        setContentView(layout);
        Window window=getWindow();
        WindowManager.LayoutParams params=window.getAttributes();
        params.gravity= Gravity.CENTER;
        window.setAttributes(params);
        window.setBackgroundDrawableResource(android.R.color.transparent);//去掉四角的白色部分
    }
}
