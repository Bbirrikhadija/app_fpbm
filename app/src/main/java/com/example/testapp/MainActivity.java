package com.example.testapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {
    GridLayout mainGridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        mainGridLayout = (GridLayout) findViewById(R.id.mainGridLayout);
        setSingleEvent(mainGridLayout);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.news:
                        startActivity(new Intent(getApplicationContext(), Neews.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:

                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), About.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.school:
                        startActivity(new Intent(getApplicationContext(), Scholarite.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.emploi:
                        startActivity(new Intent(getApplicationContext(), EmploiActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void setSingleEvent(GridLayout mainGridLayout) {
        for (int i=0; i<mainGridLayout.getChildCount();i++){
            CardView cardview = (CardView)mainGridLayout.getChildAt(i);
            final int finali = i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finali==0){
                        Intent intent1 = new Intent( MainActivity.this ,Neews.class);
                        startActivity(intent1);
                    }
                    else if (finali==1){
                        Intent intent2 = new Intent( MainActivity.this ,About.class);
                        startActivity(intent2);
                    }
                    else if (finali==3){
                        Intent intent3 = new Intent( MainActivity.this ,Scholarite.class);
                        startActivity(intent3);
                    }
                    else if (finali==4){
                        Intent intent4 = new Intent( MainActivity.this ,EmploiActivity.class);
                        startActivity(intent4);
                    }
                }
            });
        }
    }
}

