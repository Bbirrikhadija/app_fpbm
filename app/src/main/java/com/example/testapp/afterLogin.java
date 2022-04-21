package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class afterLogin extends AppCompatActivity {
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        btn1=findViewById(R.id.button);
       // btn2=findViewById(R.id.button2);
        //page demande de piece
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(afterLogin.this, demandePiece.class);
                startActivity(intent);


            }
        });
        //page RDV
       // btn2.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
              //  Intent intent = new Intent(afterLogin.this, rdvPage.class);
            //    startActivity(intent);

          //  }
        //});

    }
}