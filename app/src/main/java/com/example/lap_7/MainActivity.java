package com.example.lap_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn_fast, btn_medium, btn_slow, btn_Fan,btn_off;
    ImageView img_quat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fast = findViewById(R.id.btn_fast);
        btn_medium = findViewById(R.id.btn_medium);
        btn_slow = findViewById(R.id.btn_slow);
        btn_Fan = findViewById(R.id.btn_Fan);
        btn_off = findViewById(R.id.btn_off);
        img_quat = findViewById(R.id.img_quat);
        btn_Fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,sidle_in.class);
                startActivity(intent);
            }
        });
        btn_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starfan(1000);
            }
        });
        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starfan(5000);
            }
        });
        btn_slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                starfan(10000);
            }
        });

        btn_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_quat.animate().cancel();
            }
        });


    }
    private void starfan(long time){
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                img_quat.animate()
                        .rotationBy(360)
                        .withEndAction(this)
                        .setDuration(time)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        };
        img_quat.animate()
                .rotationBy(360)
                .withEndAction(runnable)
                .setDuration(100)
                .setInterpolator(new LinearInterpolator())
                .start();
    }



//    private void startFanAnimation() {
//        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.main_anim);
//        img_quat.startAnimation(rotateAnimation);
//    }





}