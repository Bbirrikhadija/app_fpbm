package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class choisir_piece extends AppCompatActivity {
     RadioButton AtestScolar,carte,s1,s2,s3,s4,AtestDeug,AtestVal;
     Button val,out;
     String chois1,choix2,chois3;
     //FirebaseAuth mAuth;
     DatabaseReference grp1=FirebaseDatabase.getInstance().getReference();
     FirebaseAuth mAuth;
     FirebaseUser firebaseUser;
     String test;

     //DatabaseReference grp2;
     //DatabaseReference grp3;
     //PieceChoisit user=new PieceChoisit();

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_piece);
        val=findViewById(R.id.button5);
        out=findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();



        AtestScolar=findViewById(R.id.simpleRadioButton);
        carte=findViewById(R.id.simpleRadioButton1);
        //grp2
        s1=findViewById(R.id.simpleRadioButton2);
        s2=findViewById(R.id.simpleRadioButton3);
        s3=findViewById(R.id.simpleRadioButton4);
        s4=findViewById(R.id.simpleRadioButton5);
        //grp3
        AtestDeug=findViewById(R.id.simpleRadioButton6) ;
        AtestVal=findViewById(R.id.simpleRadioButton7);
        grp1= FirebaseDatabase.getInstance().getReference("Piece");
        //grp2= FirebaseDatabase.getInstance().getReference("Piece2");
        //grp3= FirebaseDatabase.getInstance().getReference("Piece3");



        val.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                if(AtestScolar.isChecked()){
                    chois1=AtestScolar.getText().toString();

                }
                else if (carte.isChecked()){
                    chois1=carte.getText().toString();


                }
                if(s1.isChecked()){
                    choix2=s1.getText().toString();

                }
                else if(s2.isChecked()){
                    choix2=s2.getText().toString();


                }
                else if(s3.isChecked()){
                    choix2=s3.getText().toString();


                }
                else if(s4.isChecked()){
                    choix2=s4.getText().toString();

                }
                if(AtestDeug.isChecked()){
                    chois3=AtestDeug.getText().toString();

                }
                else if(AtestVal.isChecked()){
                    chois3=AtestVal.getText().toString();


                }

                else{
                    Toast.makeText(getApplicationContext(), "choisir une des choix", Toast.LENGTH_LONG).show();
                }

                //PieceChoisit S1;
                //S1 = new PieceChoisit(chois1, choix2, chois3);
                //grp1.push().setValue(S1);


                //DatabaseReference usersRef = ref.child("users");

                HashMap<String, String> user1 = new HashMap();
                user1.put("P1", chois1);
                user1.put("P2", choix2);
                user1.put("P3", chois3);
                FirebaseDatabase.getInstance().getReference().child("users").child(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot1) {
                        String Nb = String.valueOf(snapshot1.child("nbDemande").getValue());
                        Toast.makeText(choisir_piece.this, Nb, Toast.LENGTH_SHORT).show();
                        int nber = Integer.parseInt(Nb);
                        nber=nber+1;
                        String pc = String.valueOf(nber);

                        FirebaseDatabase.getInstance().getReference().child("users").child(firebaseUser.getUid()).child("nbDemande").setValue(pc);

                        grp1.child(firebaseUser.getUid()).child(pc).setValue(user1);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });





                //usersRef.setValue(users);
                //mDatabaseReference = mDatabase.getReference().child("user");
                //mDatabaseReference.setValue(user);
                Toast.makeText(getApplicationContext(), "la demande était bien enregistrée", Toast.LENGTH_LONG).show();

                //mDatabaseReference = mDatabase.getReference().child("choix1");
                //mDatabaseReference.setValue(chois1);

                //PieceChoisit user = new PieceChoisit(chois1,choix2,chois3);
                //mDatabaseReference = mDatabase.getReference().child("user");
                //mDatabaseReference.push().setValue(user);

                //stocker les données dans firebase
                //
               //choix= FirebaseDatabase.getInstance().getReference().child("PieceChoisit");





                //grp2.child("Piece2").setValue(choix2).toString();

                //grp3.child("Piece3").setValue(chois3).toString();

            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(choisir_piece.this,"Loged out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(choisir_piece.this,Scholarite.class));
            }
        });
    }



}