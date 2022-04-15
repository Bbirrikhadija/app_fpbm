package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AvisAdapter extends RecyclerView.Adapter<AvisAdapter.MyViewHolder> {

    Context context;

    ArrayList<News> list;



    public AvisAdapter(Context context, ArrayList<News> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.per_row,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        News news = list.get(position);
        holder.date_pub.setText(news.getDate_pub());
        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());
        boolean isExpanded =list.get(position).isExpanded();
        holder.expandebleLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        LinearLayout expandebleLayout;
        TextView title, description, date_pub;
        CardView card;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date_pub = itemView.findViewById(R.id.row_date);
            title = itemView.findViewById(R.id.row_name);
            description = itemView.findViewById(R.id.row_desc);
            card=itemView.findViewById(R.id.cardid);
            expandebleLayout=itemView.findViewById(R.id.expandebleLayout);
            card.setOnClickListener (new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    News news = list.get(getAdapterPosition());
                    news.setExpanded(!news.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

    }

}
