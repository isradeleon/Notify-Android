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
                .setTitle("Jill Zhao")
                .setContent("Hi! So I meet you today?")
                /*
                 * Set notification small icon from drawable resource
                 * */
                .setSmallIcon(R.drawable.ic_notifications_none_white_24dp)
                .setColor(R.color.colorPrimary)
                /*
                 * Set notification large icon from drawable resource or URL
                 * (INTERNET permission needs to be added in AndroidManifest.xml)
                 * */
                .setLargeIcon("https://images.pexels.com/photos/139829/pexels-photo-139829.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=150&w=440")
                /*
                 * Circle shaped large icon
                 * */
                .circleLargeIcon()
                /*
                 * Set a big picture from drawable resource or URL
                 * (INTERNET permission needs to be added to AndroidManifest.xml)
                 * */
                .setBigPicture("https://images.pexels.com/photos/1058683/pexels-photo-1058683.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
                .show(); // Finally showing the notification
    }
}
