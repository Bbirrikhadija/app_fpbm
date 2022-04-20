
package com.example.testapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class isi extends Fragment {
    DatabaseReference database;
    String message;
    ListView simpleList;
    Button callbtn;
    String List[] = {"semestre 1", "semestre 2", "semestre 3", "semestre 4"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_isi, container, false);
        // Inflate the layout for this fragment
        simpleList = (ListView) view.findViewById(R.id.simpleListView);
        //callbtn= (Button) view.findViewById(R.id.btn_1);


        ArrayList<String> myData = new ArrayList<String>();
        myData.add("semestre 1");
        myData.add("semestre 2");
        myData.add("semestre 3");
        myData.add("semestre 4");
        String test = "https://firebasestorage.googleapis.com/v0/b/miniprojet-66ea3.appspot.com/o/EDT_ISI-S1_17-01-2022%20vf.pdf?alt=media&token=9399a94a-1884-459a-b5d5-669e3f75dd7c";

        MyAdapter adapter = new MyAdapter(getContext(), myData);
        simpleList.setAdapter(adapter);

       // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.layout,R.id.textView ,List);
        //simpleList.setAdapter(arrayAdapter);

        database=FirebaseDatabase.getInstance().getReference().child("pdf");
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message = dataSnapshot.getValue(String.class);
                Log.d("ibt", message);
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // we are showing that error message in toast
                Toast.makeText(getContext(), "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });




        // After clicking here alert box will come




        return view;
    }
}