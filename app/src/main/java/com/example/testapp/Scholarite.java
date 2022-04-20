package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.auth.FirebaseAuth;


public class Scholarite extends AppCompatActivity {
    EditText userName, password;
    Button btnSubmit;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //important
        mAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.text_userName);
        password = findViewById(R.id.text_pass);
        btnSubmit = findViewById(R.id.btnSubmit_login);

    }


    public void signin(View view){
        String userName2 = userName.getText().toString();
        String userName1 = userName2 + "@gmail.com";
        String pass = password.getText().toString();
        //long  passCheck = Long.parseLong(password.getText().toString());
        if (userName2.isEmpty()||pass.isEmpty()) {
            userName.setError("ce Champ est nécessaire");
            password.setError("ce Champ est nécessaire");
            return;
        }



        mAuth.signInWithEmailAndPassword(userName1, pass)
                .addOnCompleteListener(Scholarite.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //bar.setVisibility(View.INVISIBLE);
                            Intent intent = new Intent(Scholarite.this, afterLogin.class);
                            startActivity(intent);
                        } else {
                            //bar.setVisibility(View.INVISIBLE);
                            userName.setText("");
                            password.setText("");
                            Toast.makeText(getApplicationContext(), "les données entrées sont incorrectes", Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });
        Intent intent2 = new Intent(this, afterLogin.class);
        intent2.putExtra("edittext", userName1);
        intent2.putExtra("nbLettre", pass);


    }
}
