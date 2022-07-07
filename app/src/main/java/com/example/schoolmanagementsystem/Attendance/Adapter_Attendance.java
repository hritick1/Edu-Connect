package com.example.schoolmanagementsystem.Attendance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystem.R;

import java.util.ArrayList;

public class Adapter_Attendance  extends RecyclerView.Adapter<Adapter_Attendance.ViewHolder>{
    public Adapter_Attendance(ArrayList<Data_Attendance> list) {
        this.list = list;
    }

    ArrayList<Data_Attendance> list =new ArrayList<>();

    @NonNull
    @Override
    public Adapter_Attendance.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_attendance,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Attendance.ViewHolder holder, int position) {
        Data_Attendance data= list.get(position);
        holder.topic.setText(data.getTopic());
        holder.subject.setText(data.getSubject());
        holder.attendance.setText(data.getAttendance());
        holder.date.setText(data.getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topic,subject,attendance,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           topic= itemView.findViewById(R.id.topic);
           subject=itemView.findViewById(R.id.subject);
           attendance=itemView.findViewById(R.id.attendance);
           date=itemView.findViewById(R.id.date);
        }
    }
}


