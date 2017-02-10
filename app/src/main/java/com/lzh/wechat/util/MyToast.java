package com.lzh.wechat.util;

import android.widget.Toast;

import com.lzh.wechat.MyApp;


public class MyToast {
    private static boolean canShow = true;

//    public static void makeText(Context context, String text, int showTime) {
//        if (canShow) {
//            Toast.makeText(MyApp.getInstance(),text,Toast.LENGTH_SHORT);
//            canShow = false;
//            new Timer().schedule(new TimerTask() {   //3�벻�ظ���
//                public void run() {
//                    canShow = true;
//                }
//            }, 2000);
//        }
//    }
//
//    public static void makeText(Context context, String text) {
//        if (canShow) {
//            Toast.makeText(MyApp.getInstance(),text,Toast.LENGTH_SHORT);
//            canShow = false;
//            new Timer().schedule(new TimerTask() {   //3�벻�ظ���
//                public void run() {
//                    canShow = true;
//                }
//            }, 2000);
//        }
//    }

    public static Toast toast=Toast.makeText(MyApp.getInstance(),"",Toast.LENGTH_SHORT);


    public static void makeText(String text) {
//        if (canShow) {
            toast.setText(text);
        toast.show();
//            Toast.makeText(MyApp.getInstance(),text+"",Toast.LENGTH_SHORT).show();

//            canShow = false;
//            new Timer().schedule(new TimerTask() {   //3�벻�ظ���
//                public void run() {
//                    canShow = true;
//                }
//            }, 2000);
//        }
    }
    public static void makeText(int res) {
        toast.setText(res);
        toast.show();
//        if (canShow) {
//            Toast.makeText(MyApp.getInstance(),MyApp.getInstance().getString(res),Toast.LENGTH_SHORT).show();
//            canShow = false;
//            new Timer().schedule(new TimerTask() {   //3�벻�ظ���
//                public void run() {
//                    canShow = true;
//                }
//            }, 2000);
//        }
    }


}
