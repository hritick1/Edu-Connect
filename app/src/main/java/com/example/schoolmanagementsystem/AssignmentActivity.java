package com.example.schoolmanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagementsystem.Admin.AssignmentAdapter;
import com.example.schoolmanagementsystem.Admin.AssignmentData;

import com.example.schoolmanagementsystem.Admin.ExamAdapter;
import com.example.schoolmanagementsystem.Admin.ExamData;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AssignmentActivity extends AppCompatActivity {
    TextView heading;
    RecyclerView recyclerView;

    LinearLayoutManager layoutManager;
    ArrayList<AssignmentData> assignmentDataArrayList=new ArrayList<>();
    ArrayList<String> assignment=new ArrayList<>();
    ArrayList<String> subject=new ArrayList<>();
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.logout){
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

        toolbarFxn();
        getData();

    }
    private void setRecyclerView(){
        recyclerView=(RecyclerView) findViewById(R.id.assignrecycler);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        for(int i=0;i<assignment.size();i++){
            assignmentDataArrayList.add(new AssignmentData(assignment.get(i),subject.get(i)));
        }
        AssignmentAdapter adapter=new AssignmentAdapter(assignmentDataArrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void getData() {
        FirebaseFirestore.getInstance().collection("Assignment").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                assignment.clear();
                subject.clear();


                for (DocumentSnapshot s:value){
                    assignment.add(s.getString("Assignment"));
                    subject.add(s.getString("subject"));

                }
                setRecyclerView();
            }
        });
    }
    private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Assignment");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);

    }
}