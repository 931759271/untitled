package com.example.demo1.entity;


import android.util.Log;

import com.example.demo1.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GoodsInfo
{
    private String name;
    private String pic;
    private String desc;



    private String url;
    public GoodsInfo(String name,String pic,String desc,String url){
        this.name=name;
        this.pic=pic;
        this.desc=desc;
        this.url=url;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }





    private static String[] mNameArray1={
            "新闻报刊","新闻报刊","新闻报刊","新闻报刊"
    };
    private static String[] mNameArray2={
            "地方媒体","地方媒体","地方媒体","地方媒体"
    };
    private static String[] mNameArray3={
            "广播电视", "广播电视", "广播电视", "广播电视"
    };

    private static  String[] mDescArray1={
            "今日头条",
            "人民日报",
            "南方周末",
            "新京报"
    };
    private static  String[] mDescArray2={
            "中安在线",
            "南方网",
            "上海热线",
            "齐鲁网"
    };
    private static  String[] mDescArray3={
            "央视网",
            "中国科学社会网",
            "央广网",
            "视界网"
    };


    private  static  String[] picArray1={
            "https://img2.baidu.com/it/u=3389121476,3137028105&fm=253&app=120&size=w931&n=0&f=PNG&fmt=auto?sec=1731517200&t=976c553a13c9492fb01ee6f2800a5527",
            "https://img0.baidu.com/it/u=2845787010,2956795367&fm=253&fmt=auto?w=1140&h=738",
            "https://img2.baidu.com/it/u=3146627964,1317925007&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1731517200&t=addac7d75279954b61639da1070ffb88",
            "https://img0.baidu.com/it/u=3326850293,1478205046&fm=253&app=138&size=w931&n=0&f=PNG&fmt=auto?sec=1731517200&t=0be37d40274ce22f0d42f55a9b7724f7"

    };
    private  static  String[] picArray2={
            "https://img0.baidu.com/it/u=2723134510,1220527994&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1731517200&t=95141a23690a9e754d862c063087e50e",
            "https://img2.baidu.com/it/u=3172086149,2122459018&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1731517200&t=ed9cb3c197f2417f250359046f6036df",
            "https://img0.baidu.com/it/u=3169901538,1639375282&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1731517200&t=b13b947bc6ab3e11ef7ae329074a7c16",
            "https://img2.baidu.com/it/u=2453004888,3203412509&fm=253&app=138&size=w931&n=0&f=PNG&fmt=auto?sec=1731517200&t=c9c2219173cc6f71e60ebe09d2329587"

    };
    private  static  String[] picArray3={
            "https://img2.baidu.com/it/u=1182779352,2922990244&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1731517200&t=8d1115adcaa8455a00726f92fb249f58",
            "https://img2.baidu.com/it/u=1621840287,120709743&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1731517200&t=47843106d37c3cc3de704ffc312dacee",
            "https://img0.baidu.com/it/u=3667468451,146693488&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1731517200&t=1ad31d1526e39d02229d496668da2371",
            "https://img0.baidu.com/it/u=697846904,850100808&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1731517200&t=7160260e9f4dcb616d2cfd02ae9d90b4"

    };
    private static String[] urlArray1={
            "https://www.toutiao.com/",
            "http://paper.people.com.cn/",
            "https://www.infzm.com/",
            "https://www.bjnews.com.cn/"
    };
    private static String[] urlArray2={
            "http://www.anhuinews.com/",
            "https://www.southcn.com/",
            "https://www.online.sh.cn/",
            "https://www.iqilu.com/"
    };
    private static String[] urlArray3={
            "https://tv.cctv.com/",
            "https://cssn.cn/",
            "https://www.cnr.cn/",
            "https://www.cbg.cn/"
    };

    public static ArrayList<ArrayList<GoodsInfo>>getDefaultList1(){

       ArrayList<GoodsInfo> goodList1=new ArrayList<>();
        for (int i=0;i< picArray1.length;i++){
            goodList1.add(new GoodsInfo(mNameArray1[i],picArray1[i],mDescArray1[i],urlArray1[i]));
        }
        ArrayList<GoodsInfo> goodList2=new ArrayList<>();
        for (int i=0;i< picArray1.length;i++){
            goodList2.add(new GoodsInfo(mNameArray2[i],picArray2[i],mDescArray2[i],urlArray2[i]));
        }
        ArrayList<GoodsInfo> goodList3=new ArrayList<>();
        for (int i=0;i< picArray1.length;i++){
            goodList3.add(new GoodsInfo(mNameArray3[i],picArray3[i],mDescArray3[i],urlArray3[i]));
        }
        ArrayList<ArrayList<GoodsInfo>>goodList=new ArrayList<>();
        goodList.add(goodList1);
        goodList.add(goodList2);
        goodList.add(goodList3);
        Log.d("ssss", goodList.get(1).get(1).getDesc());
        return goodList;
    }
    public static ArrayList<GoodsInfo>getDefaultList(){

       ArrayList<GoodsInfo> goodList=new ArrayList<>();
        for (int i=0;i< picArray1.length;i++){
            goodList.add(new GoodsInfo(mNameArray1[i],picArray1[i],mDescArray1[i],urlArray1[i]));
        }
        ArrayList<ArrayList<GoodsInfo>>mgoodList=new ArrayList<>();
        mgoodList.add(goodList);


        Log.d("ssss", mgoodList.get(0).get(1).getDesc());
        return goodList;
    }
}
