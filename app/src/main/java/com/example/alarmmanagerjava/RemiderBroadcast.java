package com.example.alarmmanagerjava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class RemiderBroadcast  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notifyMe")
                .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
                .setContentTitle("This is Your reminder")
                .setContentText("this is to notify you to read a quote today")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(200,builder.build());
    }
}
