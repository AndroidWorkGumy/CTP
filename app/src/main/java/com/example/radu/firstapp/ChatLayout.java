package com.example.radu.firstapp;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class ChatLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_layout);

        Calendar calendar = Calendar.getInstance();
        TextView dateAndHour = (TextView) findViewById(R.id.dateAndHourTextField);
        TextView image1 = (TextView) findViewById(R.id.imageView1);
        TextView image2 = (TextView) findViewById(R.id.imageView2);

        dateAndHour.setText(MainActivity.getDay(calendar) + "/" + MainActivity.getMonth(calendar)
         + "/" + calendar.get(Calendar.YEAR) + "  " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));

        image1.setGravity(Gravity.CENTER);
        image1.setBackgroundResource(R.drawable.sms_galben);
        image1.setText(MainActivity.linie);
        image1.setWidth(MainActivity.linie.length() * 5);

        image2.setGravity(Gravity.CENTER);
        image2.setBackgroundResource(R.drawable.sms_albastru);
        image2.setText(MainActivity.text);
    }
}
