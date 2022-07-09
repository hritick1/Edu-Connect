package com.example.schoolmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystem.Admin.AdminActivity;
import com.example.schoolmanagementsystem.Admin.admin_data;
import com.example.schoolmanagementsystem.announcement.Data_Announcement;
import com.example.schoolmanagementsystem.announcement.ViewAnnounceActivity;

import java.util.ArrayList;

public class Admin_Adapter extends RecyclerView.Adapter<Admin_Adapter.ViewHolder> {
    public Admin_Adapter(ArrayList<admin_data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<admin_data> list=new ArrayList<>();
    Context context;
    @NonNull
    @Override
    public Admin_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_admin,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Admin_Adapter.ViewHolder holder, int position) {
    admin_data data=list.get(position);
   holder.age.setText(data.getAge());
        holder.name.setText(data.getName());
        holder.mob.setText(data.getMob());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name,mob,age;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name=itemView.findViewById(R.id.name);
           mob =itemView.findViewById(R.id.mob);
            age=itemView.findViewById(R.id.age);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent().setClass(context, AdminActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            int pos=this.getAdapterPosition();
            admin_data data=list.get(pos);
            i.putExtra("id",data.getId());
// Launch the new activity and add the additional flags to the intent
            context.startActivity(i);
        }
    }
}
