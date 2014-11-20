package com.trinkmobiles.notificationexample;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    public static final int NOTIFICATION_ID = 123;

    private Button btnCreateNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateNotification = (Button) findViewById(R.id.create_notification);
        btnCreateNotification.setOnClickListener(new CreateOnClick());
    }

    private class CreateOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String msg = "Click me";

            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//            intent.putExtra("msg", "I got it!");

            PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
                    0,
                    intent,
                    PendingIntent.FLAG_CANCEL_CURRENT);

            Notification.Builder mBuilder = new Notification.Builder(MainActivity.this)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.im_photo_place_holder))
                    .setContentTitle(getString(R.string.app_name))
                    .setContentText(msg)
                    .setAutoCancel(true)
                    .setLights(Color.argb(255, 54, 211, 249), 300, 300)
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);

            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(NOTIFICATION_ID, mBuilder.getNotification());
        }
    }

}
