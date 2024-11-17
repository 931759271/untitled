package com.example.demo1.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    public static final String ALARM_ACTION="com.example.demo1.alarm";
   // private AlarmManager alarmManager;
    private Context context;

    public AlarmReceiver(Context context){
        super();
        this.context=context;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent!=null&&intent.getAction().equals(ALARM_ACTION)){
            Log.d("ssssss", "onReceive: shoudao");
            sendAlarm();
        }
    }

    //发送闹钟广播
    public void sendAlarm(){
        Intent intent=new Intent(ALARM_ACTION);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager= (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, 1000, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, 1000, pendingIntent);
        }


    }
}
