package com.example.alarmmanagerjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Toast.makeText(this,"Reminder set!",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this,RemiderBroadcast.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            long timeAtButtonClicked = System.currentTimeMillis();

            long oneMinute = 60000;

            alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonClicked + oneMinute,
                    pendingIntent);

        });
    }


    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "ReminderChannel";
            String description = "Chanel for reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyMe",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}