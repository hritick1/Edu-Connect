package com.example.schoolmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Announcement extends RecyclerView.Adapter<Adapter_Announcement.ViewHolder> {
    public Adapter_Announcement(ArrayList<Data_Announcement> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<Data_Announcement> list=new ArrayList<>();
    Context context;
    @NonNull
    @Override
    public Adapter_Announcement.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_announcement,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Announcement.ViewHolder holder, int position) {
        Data_Announcement data= list.get(position);
holder.topic.setText(data.getTopic());
holder.subject.setText(data.getSubject());
holder.date.setText(data.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView topic,subject,date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        topic=itemView.findViewById(R.id.topic);
        subject=itemView.findViewById(R.id.subject);
        date=itemView.findViewById(R.id.date);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
