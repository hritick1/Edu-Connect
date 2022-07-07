package com.example.schoolmanagementsystem;

<<<<<<< HEAD
import static android.icu.lang.UCharacter.DecompositionType.VERTICAL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
=======
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
>>>>>>> 63564292da1ed18533170ebfa6faaa68de04b6df

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagementsystem.admin.ExamAdapter;
import com.example.schoolmanagementsystem.admin.ExamData;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class ExaminationActivity extends AppCompatActivity {
<<<<<<< HEAD
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    FirebaseFirestore fireStore;
    ArrayList<ExamData> examDataArrayList=new ArrayList<>();
=======
    TextView heading;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
>>>>>>> 63564292da1ed18533170ebfa6faaa68de04b6df

        if(item.getItemId()==R.id.logout){
            Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);
<<<<<<< HEAD

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
=======
        toolbarFxn();

    }





    private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Examination");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
>>>>>>> 63564292da1ed18533170ebfa6faaa68de04b6df

    }
}

