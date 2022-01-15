package com.example.dztimer;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.time.Month;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

String []mycoloros = {"#8A2BE2","#0000FF","#7FFFD4","#FFFF00","#FF0000","#FA8072","#9ACD32"};

Random r=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View layout = findViewById(R.id.mainLayout);
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {0xFFEE82EE,0xFFFF00FF});
        gd.setCornerRadius(0f);
        layout.setBackground(gd);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#000000")));
    }


    public void enterTimer(View view) {

        View layout = findViewById(R.id.mainLayout);
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {0xFFFF00FF,0xFFEE82EE});
        gd.setCornerRadius(0f);
        layout.setBackground(gd);


        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor(mycoloros[r.nextInt(mycoloros.length)])));

        Toast toast = Toast.makeText(getApplicationContext(),
                "Show", Toast.LENGTH_SHORT);
        toast.show();

        EditText _day = findViewById(R.id.numDay);
        EditText _month = findViewById(R.id.numMonth);
        EditText _year = findViewById(R.id.numYears);
        EditText _hours = findViewById(R.id.numHours);
        EditText _minuts = findViewById(R.id.numMinuts);

        int _y = Integer.parseInt(_year.getText().toString());
        int _m = Integer.parseInt(_month.getText().toString());
        int _d = Integer.parseInt(_day.getText().toString());
        int _h = Integer.parseInt(_hours.getText().toString());
        int _min = Integer.parseInt(_minuts.getText().toString());




        Calendar timerEnd = new GregorianCalendar(_y, _m-1, _d);
        //Calendar timerEnd = new GregorianCalendar(2022, Calendar.JANUARY, 20);

        timerEnd.set(Calendar.HOUR, _h);
        timerEnd.set(Calendar.MINUTE, _min);
        //timerEnd.set(Calendar.HOUR, 18);
        //timerEnd.set(Calendar.MINUTE, 0);
        Calendar now = GregorianCalendar.getInstance();
        long timerMilliseconds = timerEnd.getTimeInMillis() - now.getTimeInMillis();

        long day = timerMilliseconds / (24 * 60 * 60 * 1000);
        timerMilliseconds -= day * 24 * 60 * 60 * 1000;

        long hours = timerMilliseconds / (60 * 60 * 1000);
        timerMilliseconds -= (hours * 60 * 60 * 1000);

        long minutes = timerMilliseconds / (60 * 1000);
        timerMilliseconds -= minutes * 60 * 1000;

        long seconds = timerMilliseconds / 1000;

        String str_days="";
        if(day == 1 || day == 21 || day ==31 )
        {
            str_days="день";
        }
        else if(day == 2 || day == 3 || day == 4 ||
                day == 22 || day == 23 || day == 24)
        {
            str_days="дня";
        }
        else
        {
            str_days = "дней";
        }
                    TextView tv = findViewById(R.id.textView2);
        tv.setText(day + " "+ str_days + "\n"
                + hours + ":" + minutes + ":" + seconds);
    }


}