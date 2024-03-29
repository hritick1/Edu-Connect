package com.example.schoolmanagementsystem.Examination;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagementsystem.R;
import com.example.schoolmanagementsystem.signin.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class ExaminationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<ExamData> examDataArrayList=new ArrayList<>();
    ArrayList<String>  examName=new ArrayList<>();
    ArrayList<String>  platform=new ArrayList<>();
    ArrayList<String>  type=new ArrayList<>();
    ArrayList<String>  dateTime=new ArrayList<>();

    TextView heading;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.logout){
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();        }
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

        toolbarFxn();
        getData();

    }
    private void setRecyclerView(){
        recyclerView=findViewById(R.id.Rview);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        for(int i=0;i<examName.size();i++){
            if(examName.get(i)!=null && platform.get(i)!=null && type.get(i)!=null && dateTime.get(i)!=null)
            examDataArrayList.add(new ExamData(examName.get(i),platform.get(i),
                    type.get(i),dateTime.get(i)));
        }
        ExamAdapter adapter=new ExamAdapter(examDataArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        FirebaseFirestore.getInstance().collection(FirebaseAuth.getInstance().getCurrentUser().getUid()).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                examName.clear();
                type.clear();
                platform.clear();
                dateTime.clear();

                for (DocumentSnapshot s:value){
                    examName.add(s.getString("Exam Name"));
                    type.add(s.getString("Type"));
                    platform.add(s.getString("Platform"));
                    dateTime.add(s.getString("Date_Time"));
                }
                setRecyclerView();
            }
        });
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

    }
}