package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {

    static int TIMEOUT_MILLIS = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(splashscreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, TIMEOUT_MILLIS);
    }
}