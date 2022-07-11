package com.example.schoolmanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class LecturesAdapter extends RecyclerView.Adapter<LecturesAdapter.ViewHolder> {
    ArrayList<LecturesData> lecturesData ;

    public LecturesAdapter(ArrayList<LecturesData> lecturesData) {
        this.lecturesData=lecturesData;
    }

    @NonNull
    @Override
    public LecturesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lecturescard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String time = lecturesData.get(position).getTime();
        String sub = lecturesData.get(position).getSubject();
        String room = lecturesData.get(position).getRoom();
        holder.setData(time, sub, room);

    }

    @Override
    public int getItemCount() {
        return lecturesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Time, Subject, Room;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Time = itemView.findViewById(R.id.time);
            Subject = itemView.findViewById(R.id.sub);
            Room = itemView.findViewById(R.id.room);

        }

        public void setData(String time, String sub, String room) {

            Time.setText(time);
            Subject.setText(sub);
            Room.setText(room);
            
        }

    }
}