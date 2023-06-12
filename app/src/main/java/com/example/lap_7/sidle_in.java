package com.example.lap_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class sidle_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidle_in);
        Intent intent=new Intent(sidle_in.this,sidle_out.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
    }
}