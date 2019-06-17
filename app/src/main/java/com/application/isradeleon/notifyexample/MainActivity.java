package com.application.isradeleon.notifyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.application.isradeleon.notify.Notify;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example
        Notify.create(getApplicationContext())
                /*
                 * Set notification title and content
                 * */
                .setTitle("Jill")
                .setContent("Hi! So today at 7 o'clock?")
                /*
                 * Set notification small icon from drawable resource
                 * */
                .setSmallIcon(R.drawable.ic_notifications_none_white_24dp)
                .setColor(R.color.colorPrimary)
                /*
                 * Set notification large icon from URL (INTERNET permission is needed)
                 * */
                .setLargeIcon("https://images.pexels.com/photos/139829/pexels-photo-139829.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=150&w=440")
                /*
                 * Circle shaped large icon
                 * */
                .circleLargeIcon()
                .show(); // Finally showing notification
    }
}
