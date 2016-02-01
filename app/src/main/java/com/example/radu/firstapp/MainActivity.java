package com.example.radu.firstapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends Activity {

    public static String text;
    public static String linie;

    public static String getMinutes(Calendar rightNow) {

        if (rightNow.get(Calendar.MINUTE) + 45 > 59)
            return (String.valueOf(rightNow.get(Calendar.MINUTE) - 15));
        return String.valueOf(rightNow.get(Calendar.MINUTE) + 45);
    }

    public static String getHourAndMinutes(Calendar rightNow) {
        if (!String.valueOf(rightNow.get((Calendar.MINUTE)) + 45).equals(getMinutes(rightNow))) {
            if (rightNow.get(Calendar.HOUR_OF_DAY) + 1 < 10)
                return "0" + String.valueOf(rightNow.get(Calendar.HOUR_OF_DAY) + 1)
                        + ":"
                        + String.valueOf(getMinutes(rightNow));

            return String.valueOf(rightNow.get(Calendar.HOUR_OF_DAY) + 1)
                    + ":"
                    + String.valueOf(getMinutes(rightNow));
        }
        return getHour(rightNow) + ":" + getMinutes(rightNow);
    }

    public static String getHour(Calendar rightNow) {
        if (rightNow.get(Calendar.HOUR_OF_DAY) < 10)
            return "0" + String.valueOf(rightNow.get(Calendar.HOUR_OF_DAY));
        return String.valueOf(rightNow.get(Calendar.HOUR_OF_DAY));
    }

    public static String getMonth(Calendar rightNow) {
        if (rightNow.get(Calendar.MONTH) + 1 < 10)
            return "0" + String.valueOf(rightNow.get(Calendar.MONTH) + 1);
        return String.valueOf(rightNow.get(Calendar.MONTH) + 1);
    }

    public static String getDay(Calendar rightNow) {
        if (rightNow.get(Calendar.DAY_OF_MONTH) < 10)
            return "0" + String.valueOf(rightNow.get(Calendar.DAY_OF_MONTH));
        return String.valueOf(rightNow.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        final EditText ctpLine = (EditText) findViewById(R.id.ctpLine);
        final Intent intent = new Intent(MainActivity.this, ChatLayout.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = 132795;
                int max = 865742;
                Random randomNumber = new Random();
                linie = ctpLine.getText().toString();
                if (!linie.isEmpty()) {
                    Calendar rightNow = Calendar.getInstance();

                    text = "Biletul pentru linia " + linie + " a fost activat. Valabil pana la " +
                           getHourAndMinutes(rightNow)
                            + " in " + getDay(rightNow) + "/" + getMonth(rightNow) +
                            "/" + rightNow.get(Calendar.YEAR) +
                            ". Cost total:0.50EUR + Tva. Cod confirmare: " + (randomNumber.nextInt(max - min + 1) + min) + ".";
//                    ContentValues values = new ContentValues();
//                    values.put("address", "7479");
//                    values.put("body", linie);
//                    getContentResolver().insert(Uri.parse("content://sms/sent"), values);
//                    values.put("body", text);
//                    getContentResolver().insert(Uri.parse("content://sms/inbox"), values);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
