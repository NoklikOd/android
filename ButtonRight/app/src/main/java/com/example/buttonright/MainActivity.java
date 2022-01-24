package com.example.buttonright;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }


    String message = "Очень многие программисты, которые начинают писать программы для Android, уже имеют за плечами опыт работы с другими языками программирования. И, они на ходу уже разбираются с особенностями Java. Тем более, что язык Java в своем синтаксисе очень похож на C++, C#, PHP и т.д.\t";
    Button bString;
    int stepStringMessage = 5;
    int firstIndexString = 0;
    int lastIndexString = 0;
    Timer timerMessage;
    TimerTask messageTimerTask;

    boolean step=false;
    int buttonPadding = 0;
    Button b;

    Timer timer;
    TimerTask mTimerTask;
    int millisseconds = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= findViewById(R.id.button);
        bString = findViewById(R.id.buttonString);
     {
                if(timer != null){
                    timer.cancel();
                }

                // Задаем поведение таймера при включенном и выключенном переключателе,
                // выполняем задачу MyTimerTask, описание которой будет ниже:
                timer = new Timer();
                mTimerTask = new MyTimerTask();

                // После задержки одна секунда, повторяем действие таймера каждую секунду:
                timer.schedule(mTimerTask, 1, 1);

         if(timerMessage != null){
             timerMessage.cancel();
         }

         // Задаем поведение таймера при включенном и выключенном переключателе,
         // выполняем задачу MyTimerTask, описание которой будет ниже:
         timerMessage = new Timer();
         messageTimerTask = new MyTimerTaskMessage();

         // После задержки одна секунда, повторяем действие таймера каждую секунду:
         timerMessage.schedule(messageTimerTask, 100, 100);
            }
    }







    class MyTimerTaskMessage extends TimerTask {

        public void stepString(){
            if(lastIndexString < 40)
            {
                lastIndexString++;
            }
            if(lastIndexString >= 40)
            {
                firstIndexString++;
                lastIndexString++;
            }
            if(lastIndexString >= message.length())
            {
                firstIndexString--;
            }
            if(firstIndexString<0)
            {
                firstIndexString=0;
                lastIndexString=0;
                stepStringMessage --;
            }
            String newMessage = message.substring(firstIndexString, lastIndexString) ;
            bString.setText(newMessage);

        }

        @Override
        public void run() {
            if(stepStringMessage == 0){
                timer.cancel();
            }
            runOnUiThread(new Runnable(){
                @RequiresApi(api = Build.VERSION_CODES.Q)
                @Override
                public void run() {
                    stepString();
                }});
        }
    }

    class MyTimerTask extends TimerTask {


        public void move(){
            if(step == false)
            {
                buttonPadding++;
            }
            if(step == true)
            {
                buttonPadding--;
            }
            if((buttonPadding + b.getWidth()) == getScreenWidth())
            {
                step = true;
            }
            if(buttonPadding == 0)
            {
                step = false;
            }
        }



        @Override
        public void run() {

            millisseconds++;
            move();

            if(millisseconds == 5000){
                timer.cancel();
            }
            runOnUiThread(new Runnable(){
                @RequiresApi(api = Build.VERSION_CODES.Q)
                @Override
                public void run() {
                    b.setTranslationX((float)buttonPadding);
                    getSupportActionBar().setTitle(millisseconds + "");
                }});
        }
    }
}