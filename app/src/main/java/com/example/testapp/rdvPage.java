package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class rdvPage extends AppCompatActivity {
   EditText t1,t2;
   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdv_page);
        t1=findViewById(R.id.ensembledepiece);
        t2=findViewById(R.id.t2);
        btn =findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(rdvPage.this,"Loged out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(rdvPage.this,Scholarite.class));

            }
        });


    }
}