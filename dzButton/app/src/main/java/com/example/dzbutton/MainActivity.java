package com.example.dzbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Locale device = Locale.getDefault();

        Locale uk = new Locale.Builder().setLanguage("uk").setRegion("UA").build();
        Locale ru = new Locale.Builder().setLanguage("ru").setRegion("RU").build();
        Locale usa = new Locale.Builder().setLanguage("en").setRegion("US").build();
        ImageView img = findViewById(R.id.imageView);
        Button b = findViewById(R.id.button);




        if(device.getLanguage() == ru.getLanguage() )
        {
            b.setBackgroundResource(R.drawable.ru);
            img.setImageResource(R.drawable.ru);
        }
        else if(device.getLanguage() == uk.getLanguage())
        {
            b.setBackgroundResource(R.drawable.uk);
            img.setImageResource(R.drawable.uk);
        }
        else if(device.getLanguage() == usa.getLanguage())
        {

            b.setBackgroundResource(R.drawable.usa);
            img.setImageResource(R.drawable.usa);
        }
    }



    int count=0;

    public void buttonUp(View view) {

        Button b = (Button) view;
        int width = b.getWidth();
        int height = b.getHeight();

        TextView t = findViewById(R.id.textView);
        t.setText("heigt: " + height + ", " + "width: " + width + " | count: " + count);


        if(count==20)
        {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Button GAPLIK!!!", Toast.LENGTH_SHORT);
            toast.show();

            b.setText("Button GAPLIK!!!");
            b.setEnabled(false);
            return;
        }

        if(count % 2 == 0 )
        {
            width+=5;
            count++;
            b.setWidth(width);
        }
        else
        {
            height+=5;
            count++;
            b.setHeight(height);
        }

        b.setText(count+"");






    }
}