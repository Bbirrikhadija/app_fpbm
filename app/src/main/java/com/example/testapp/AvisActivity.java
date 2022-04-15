package com.example.testapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AvisActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("news");


    // FirebaseRecyclerAdapter<News,NewsViewHolder> firebaseRecyclerAdapter;
    AvisAdapter myAdapter;
    RecyclerView NewsRecycle;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<News> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Avisactivity_main);
        NewsRecycle = findViewById(R.id.avis_menu);
        NewsRecycle.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        NewsRecycle.setLayoutManager(layoutManager);
        list = new ArrayList<>();
        myAdapter = new AvisAdapter(this, list);
        NewsRecycle.setAdapter(myAdapter);

        myRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot Snapshot) {
                for (DataSnapshot dataSnapshot: Snapshot.getChildren()){
                    News news=dataSnapshot.getValue(News.class);
                    list.add(news);
                }
                myAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }

}


