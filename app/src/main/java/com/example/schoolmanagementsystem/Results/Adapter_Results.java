package com.example.schoolmanagementsystem.Results;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystem.R;

import java.util.ArrayList;

public class Adapter_Results extends RecyclerView.Adapter<Adapter_Results.ViewHolder> {
    public Adapter_Results(ArrayList<Data_Results> lists) {
        this.lists = lists;
    }

    ArrayList <Data_Results> lists=new ArrayList<>();

    @NonNull
    @Override
    public Adapter_Results.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.items_result,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Results.ViewHolder holder, int position) {
        Data_Results data= lists.get(position);
holder.subject.setText(data.getSubject());
        holder.date.setText(data.getDate());
        holder.grade.setText(data.getGrade());
        holder.marks.setText(data.getMarks());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,date,grade,marks;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.subject);
            date=itemView.findViewById(R.id.date);
            grade=itemView.findViewById(R.id.grade);
            marks=itemView.findViewById(R.id.marks);
        }
    }
}
