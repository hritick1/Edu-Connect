package com.example.schoolmanagementsystem.Assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystem.R;

import java.util.ArrayList;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder>{
    ArrayList<AssignmentData> assignmentData= new ArrayList<>();

    public AssignmentAdapter(ArrayList<AssignmentData> assignmentData){
        this.assignmentData=assignmentData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.assignmentcard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String assignment=assignmentData.get(position).getAssignment();
        String subject=assignmentData.get(position).getSubject();
        holder.setData(assignment,subject);
    }

    @Override
    public int getItemCount() {
        return assignmentData.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView Assignment,Subject;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Assignment=itemView.findViewById(R.id.assignment);
            Subject=itemView.findViewById(R.id.subject);

        }

        public void setData(String assignment, String subject) {

            Assignment.setText(assignment);
            Subject.setText(subject);
        }
    }
}