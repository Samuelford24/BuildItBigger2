package com.udacity.gradle.builditbigger.paid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tellJoke(View view) {
        new com.udacity.gradle.builditbigger.EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));

        // Toast.makeText(this, , Toast.LENGTH_SHORT).show();
    }



}
