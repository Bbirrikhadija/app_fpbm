package com.example.testapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class EmploiAdapter extends RecyclerView.Adapter<EmploiAdapter.ViewHolder> {

    DatabaseReference database;
    String message;
    Context context;
    private ArrayList<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public EmploiAdapter(Context context, ArrayList<String> mData) {
        this.context = context;
        this.mData = mData;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.strilayout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String emploi = mData.get(position);
        holder.myTextView.setText(emploi);
    }
    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView myTextView;
        Button button;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textView);
            button=itemView.findViewById(R.id.btn_2);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
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
                            database= FirebaseDatabase.getInstance().getReference().child("emploi").child("stri").child("semestre 1");
                            database.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    // getting a DataSnapshot for the location at the specified
                                    // relative path and getting in the link variable
                                    message = dataSnapshot.getValue(String.class);
                                    Toast.makeText(itemView.getContext(), message, Toast.LENGTH_SHORT).show();
                                }

                                // this will called when any problem
                                // occurs in getting data
                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                    // we are showing that error message in toast
                                    Toast.makeText(itemView.getContext(), "Error Loading Pdf", Toast.LENGTH_SHORT).show();
                                }
                            });

                            if (which == 0) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message));
                                itemView.getContext().startActivity(intent);
                            }
                            // We will view the pdf
                            if (which == 1) {
                                Intent intent = new Intent(v.getContext(), ViewpdfActivity.class);
                                intent.putExtra("url", message);
                                itemView.getContext().startActivity(intent);
                            }
                        }
                    });
                    builder.show();
                }
            });

        }
        public void setDetail(Emploi e){
            myTextView.setText(e.getNom());
        }


    }

    // convenience method for getting data at click position
    /*Emploi getItem(int id) {
        return mData.get(id);
    }

     */
    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
