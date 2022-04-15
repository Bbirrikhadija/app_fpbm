package com.example.testapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class stri extends Fragment implements EmploiAdapter.ItemClickListener{
    EmploiAdapter adapter;
    DatabaseReference database;
    RecyclerView recyclerView;
    ArrayList<String> emploiSemestre = new ArrayList<String>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
            view = inflater.inflate(R.layout.fragment_stri, container, false);
        // Inflate the layout for this fragment

        recyclerView = view.findViewById(R.id.emploi);

        emploiSemestre.add("semestre 1");
        emploiSemestre.add("semestre 2");
        emploiSemestre.add("semestre 3");
        emploiSemestre.add("semestre 4");

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //remplir();
        adapter = new EmploiAdapter(getContext(), emploiSemestre);
        recyclerView.setAdapter(adapter);




        return view;
    }
   /* private void remplir(){
        emploiSemestre.add(new Emploi("semestre 1"));
        emploiSemestre.add(new Emploi("semestre 2"));
        emploiSemestre.add(new Emploi("semestre 3"));
        emploiSemestre.add(new Emploi("semestre 4"));
    }

    */

    @Override
    public void onItemClick(View view, int position) {
    }
}



