package com.example.schoolmanagementsystem.Attendance;

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

import com.example.schoolmanagementsystem.R;
import com.example.schoolmanagementsystem.announcement.Adapter_Announcement;
import com.example.schoolmanagementsystem.announcement.Data_Announcement;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
    TextView heading;
    RecyclerView recyclerView;
    ArrayList<String> topic=new ArrayList<>();
    ArrayList<String> subject=new ArrayList<>();
    ArrayList<String> date=new ArrayList<>();
    ArrayList<String> attendance =new ArrayList<>();

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

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
        setContentView(R.layout.activity_attendance);
        toolbarFxn();
        dataGet();

    }
    private void dataGet() {
        FirebaseFirestore.getInstance().collection("Attendance").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                topic.clear();
                date.clear();
                subject.clear();
                attendance.clear();
                for(DocumentSnapshot s: value){
                    topic.add(s.getString("topic"));
                    date.add(s.getString("date"));
                    subject.add(s.getString("subject"));
                    attendance.add(s.getString("attendance"));
                }
                setRecyclerView();

            }
        });
    }

    private void setRecyclerView() {
        recyclerView=findViewById(R.id.attendanceRec);
        ArrayList<Data_Attendance> list=new ArrayList<>();
        for(int i=0;i<topic.size();i++){
            list.add(new Data_Attendance("Topic: "+topic.get(i),subject.get(i),attendance.get(i),date.get(i)));
        }
        Adapter_Attendance adapter_attendance=new Adapter_Attendance(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter_attendance);
    }



    private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);   //textview for toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Attendance");
        getSupportActionBar().setDisplayShowTitleEnabled(false);//setting up toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
    }
}