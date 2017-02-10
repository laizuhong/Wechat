package com.lzh.wechat.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.lzh.wechat.MyApp;


public class ShareUtils {


    public static String getStringXml(String name) {
        SharedPreferences sp = MyApp.sp;
        return sp.getString(name, null);
    }

    public static boolean getBoolean(String name) {
        SharedPreferences sp = MyApp.sp;
        return sp.getBoolean(name, false);
    }

    public static int getInt(String name) {
        SharedPreferences sp = MyApp.sp;
        return sp.getInt(name, 0);
    }

    public static void editXml(String key, String content) {
        SharedPreferences sp = MyApp.sp;
        Editor editor = sp.edit();
        editor.putString(key, content);
        editor.apply();
    }

    public static void editInt(String key, int content) {
        SharedPreferences sp = MyApp.sp;
        Editor editor = sp.edit();
        editor.putInt(key, content);
        editor.apply();
    }

    public static void editBoolean(String key, Boolean content) {
        SharedPreferences sp = MyApp.sp;
        Editor editor = sp.edit();
        editor.putBoolean(key, content);
        editor.apply();
    }

    public static void removeXml(String key) {
        SharedPreferences sp = MyApp.sp;
        Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }
}
