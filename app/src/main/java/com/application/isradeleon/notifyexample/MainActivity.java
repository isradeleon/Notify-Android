package com.application.isradeleon.notifyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.application.isradeleon.notify.Notify;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Notify.create(this).setColor(R.color.colorAccent).setSmallIcon(R.mipmap.ic_launcher).show();
    }
}
