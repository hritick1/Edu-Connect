package com.example.schoolmanagementsystem.admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.schoolmanagementsystem.R;
import java.util.ArrayList;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewHolder>{
    ArrayList<ExamData> examData;

    public ExamAdapter(ArrayList<ExamData> examData){
        this.examData=examData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.examcard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String name=examData.get(position).getExamName();
        String type=examData.get(position).getType();
        String platform=examData.get(position).getPlatform();
        String date_time=examData.get(position).getDate_time();
        holder.setData(name,type,platform,date_time);
    }

    @Override
    public int getItemCount() {
        return examData.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView Name,Type,PlatForm,Date_Time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.name);
            Type=itemView.findViewById(R.id.type);
            PlatForm=itemView.findViewById(R.id.platform);
            Date_Time=itemView.findViewById(R.id.dateTime);
        }

        public void setData(String name, String type, String platform, String date_time) {

            Name.setText(name);
            Type.setText(type);
            PlatForm.setText(platform);
            Date_Time.setText(date_time);
        }
    }
}