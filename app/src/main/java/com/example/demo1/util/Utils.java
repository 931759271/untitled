package com.example.demo1.util;

import android.content.Context;

public class Utils {
    public static int dip2px(Context context,float dpValue){
        //获取手机当前像素密度，一个dp对应几个px
        float scale=context.getResources().getDisplayMetrics().density;
        //四舍五入取整
        return (int)(dpValue*scale+0.5f);



    }
}
