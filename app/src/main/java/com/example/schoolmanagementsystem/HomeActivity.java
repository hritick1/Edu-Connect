package com.example.schoolmanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagementsystem.Attendance.AttendanceActivity;
import com.example.schoolmanagementsystem.Assignment.AssignmentActivity;
import com.example.schoolmanagementsystem.Examination.ExaminationActivity;
import com.example.schoolmanagementsystem.Lectures.LecturesActivity;
import com.example.schoolmanagementsystem.Results.ResultsActivity;
import com.example.schoolmanagementsystem.announcement.AnnouncementActivity;
import com.example.schoolmanagementsystem.signin.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class HomeActivity extends AppCompatActivity {
    TextView heading;
    Button announcements,lectures,attendance,assignments,exams,results;
    TextView name;

    @Override
    protected void onStart() {
        super.onStart();
        setName();
    }

    //    menu button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.logout){
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbarFxn();
        ids();  //setting up ids for buttons

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void setName() {
        name=findViewById(R.id.name);
        FirebaseFirestore.getInstance().collection(FirebaseAuth.getInstance().getCurrentUser().getUid()).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
for(DocumentSnapshot s:value){
    if(s.getString("Name")!=null)
    name.setText(s.getString("Name"));
}
            }
        });

    }


    private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);   //textview for toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(false);//setting up toolbar

        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);

    }

    private void ids() {
        announcements=findViewById(R.id.announcement);
        lectures=findViewById(R.id.lectures);
        attendance=findViewById(R.id.attendance);
        assignments=findViewById(R.id.assignment);
        exams=findViewById(R.id.exam);
        results=findViewById(R.id.result);
    }

    public void clicked(View view) {
        switch(view.getId()){
            case R.id.announcement:
                startActivity(new Intent(HomeActivity.this, AnnouncementActivity.class));
                break;
            case R.id.lectures:
                startActivity(new Intent(HomeActivity.this, LecturesActivity.class));
                break;
            case R.id.attendance:
                startActivity(new Intent(HomeActivity.this, AttendanceActivity.class));
                break;
            case R.id.assignment:
                startActivity(new Intent(HomeActivity.this, AssignmentActivity.class));
                break;
            case R.id.exam:
                startActivity(new Intent(HomeActivity.this, ExaminationActivity.class));
                break;
            case R.id.result:
                startActivity(new Intent(HomeActivity.this, ResultsActivity.class));
                break;
            default:
                Toast.makeText(this, "Wrong click!!!", Toast.LENGTH_SHORT).show();
        }



        }



}