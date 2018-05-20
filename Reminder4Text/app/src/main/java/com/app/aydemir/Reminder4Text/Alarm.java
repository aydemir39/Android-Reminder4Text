package com.app.aydemir.Reminder4Text;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;

public class Alarm {
    private Context mContext;
    void setAlarm(int times)
    {
        Intent alarmIntent = new Intent(mContext, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0, alarmIntent,0);
        AlarmManager manager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        manager.setExact(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+60*60*1000,pendingIntent);
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("TIMER", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("alarmCount",times);
        editor.apply();
    }
    Alarm(Context mContext) {
        this.mContext = mContext;
    }
    void cancelAlarm(){
        Intent alarmIntent = new Intent(mContext, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0, alarmIntent,0);
        AlarmManager manager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
    }

}
