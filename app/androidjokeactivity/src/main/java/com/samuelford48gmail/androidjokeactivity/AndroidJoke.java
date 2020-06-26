package com.samuelford48gmail.androidjokeactivity;

import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AndroidJoke extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_joke);
        tv=findViewById(R.id.textView);
        Intent intent = getIntent();
System.out.println(intent.getStringExtra("JOKE"));
        tv.setText( intent.getStringExtra("JOKE"));
    }
}
