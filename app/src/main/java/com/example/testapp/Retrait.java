package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Retrait extends AppCompatActivity {
    Button btnval_retrait,logout;
    RadioButton BAC2,BAC;
    String choix;
    DatabaseReference grp2= FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrait);
        btnval_retrait=findViewById(R.id.button7);
        BAC=findViewById(R.id.simpleRadioButton8);
        BAC2=findViewById(R.id.simpleRadioButton9);
        logout=findViewById(R.id.logout);
        btnval_retrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (BAC.isChecked()){
                    choix=BAC.getText().toString();
                }
               else if(BAC2.isChecked()){
                    choix=BAC2.getText().toString();
                }
                else{
                    Toast.makeText(getApplicationContext(), "choisir une des choix", Toast.LENGTH_LONG).show();
                }
                HashMap<String, String> user1 = new HashMap();
                user1.put("P4", choix);
                grp2.child("Piece1").setValue(user1);
                Toast.makeText(getApplicationContext(), "la demande était bien enregistrée", Toast.LENGTH_LONG).show();




            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Retrait.this,"Loged out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Retrait.this,Scholarite.class));


            }
        });

    }
}