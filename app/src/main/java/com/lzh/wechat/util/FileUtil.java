package com.lzh.wechat.util;

import android.content.Context;

import java.io.File;

public class FileUtil {

    public static String LOCATION;
    public static String apkdownload;
    public static String imagefile;

//    public static String picture;
//    public static String bugpath;

    public static void create(Context context) {
        if (LOCATION==null){
            LOCATION=context.getObbDir().getPath();
        }
        MyLog.e(LOCATION);
//        File file = new File(LOCATION);
//        if (!file.exists()) {
//            file.mkdirs();
//        }

        apkdownload=LOCATION+"/download/";
        File apk = new File(apkdownload);
        MyLog.e(apk.getAbsolutePath());
        if (!apk.exists()) {
            if (apk.mkdirs()){
                MyLog.e("创建了");
            }
        }else {
            MyLog.e("已存在");
        }

        imagefile = LOCATION + "/imagecache/";
        File image = new File(imagefile);
        if (!image.exists()) {
            image.mkdirs();
        }



//        picture = LOCATION + "/picture/";
//        File pic = new File(picture);
//        if (!pic.exists()) {
//            pic.mkdirs();
//        }
//
//        bugpath = LOCATION + "/bug/";
//        File bug = new File(bugpath);
//        if (!bug.exists()) {
//            bug.mkdirs();
//        }
    }
}
