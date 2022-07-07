package com.example.schoolmanagementsystem;

import static android.icu.lang.UCharacter.DecompositionType.VERTICAL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.schoolmanagementsystem.admin.ExamAdapter;
import com.example.schoolmanagementsystem.admin.ExamData;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class ExaminationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    FirebaseFirestore fireStore;
    ArrayList<ExamData> examDataArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);

        examDataArrayList.add(new ExamData("CSE123","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE456","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE789","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE101","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE112","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE131","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE415","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE161","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE718","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE192","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE021","LPU OAS","MCQ BASED","02-08-2022"));
        examDataArrayList.add(new ExamData("CSE222","LPU OAS","MCQ BASED","02-08-2022"));

        recyclerView=findViewById(R.id.Rview);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        ExamAdapter adapter=new ExamAdapter(examDataArrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}

