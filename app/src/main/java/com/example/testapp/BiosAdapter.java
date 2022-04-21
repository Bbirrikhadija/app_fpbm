package com.example.testapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BiosAdapter extends ArrayAdapter<String> {

    DatabaseReference database;
    String message;

    //This is the constructor for MyAdapter: You can edit its second parameter a/c to your requirements
//I used Array List of strings
    public BiosAdapter(Context context, ArrayList<String> records){
        super(context, 0, records);

    }

    @Override
//Important method: You can write your own code in this function
//You can set your textview/ button methods
    public View getView(int position, View convertView, ViewGroup parent){
        //Get the data item for this position
        String item = getItem(position);
        //Check if an existing view is being reused, otherwise inflate the view
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout, parent, false);
        }


        Button list_but=(Button)convertView.findViewById(R.id.btn_1);
        TextView textView = convertView.findViewById(R.id.textView);


        textView.setText(item);

        list_but.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                database= FirebaseDatabase.getInstance().getReference().child("emploi").child("bios").child(item);
                database.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // getting a DataSnapshot for the location at the specified
                        // relative path and getting in the link variable
                        message = dataSnapshot.getValue(String.class);
                        if (message.equals("----")){
                            Toast.makeText(getContext(), "Vide", Toast.LENGTH_SHORT).show();
                        }else {
                            CharSequence options[] = new CharSequence[]{
                                    "Download",
                                    "View",
                                    "Cancel"
                            };
                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                            builder.setTitle("Choose One");
                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // we will be downloading the pdf
                                    if (which == 0) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message));
                                        getContext().startActivity(intent);
                                    }
                                    // We will view the pdf
                                    if (which == 1) {
                                        Intent intent = new Intent(v.getContext(), ViewpdfActivity.class);
                                        intent.putExtra("url", message);
                                        getContext().startActivity(intent);
                                    }
                                }
                            });
                            builder.show();
                        }
                    }

                    // this will called when any problem
// occurs in getting data
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // we are showing that error message in toast
                        Toast.makeText(getContext(), "Error Loading Pdf", Toast.LENGTH_SHORT).show();
                    }
                });


            }

        });
        return convertView;
    }
}