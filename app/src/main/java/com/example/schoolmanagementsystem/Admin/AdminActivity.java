package com.example.schoolmanagementsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagementsystem.AssignmentActivity;
import com.example.schoolmanagementsystem.ExaminationActivity;
import com.example.schoolmanagementsystem.LecturesActivity;
import com.example.schoolmanagementsystem.R;
import com.example.schoolmanagementsystem.announcement.AnnouncementActivity;

public class AdminActivity extends AppCompatActivity {
TextView heading;
    Button announcements,lectures,attendance,assignments,exams,results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        toolbarFxn();
        ids();  //setting up ids for buttons
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
        switch (view.getId()) {
            case R.id.announcement:
                startActivity(new Intent(getApplicationContext(), AdminAnnounceActivity.class));
                break;
            case R.id.lectures:
                startActivity(new Intent(getApplicationContext(), LecturesActivity.class));
                break;
            case R.id.attendance:
                startActivity(new Intent(getApplicationContext(), AnnouncementActivity.class));
                break;
            case R.id.assignment:
                startActivity(new Intent(getApplicationContext(), AssignmentActivity.class));
                break;
            case R.id.exam:
                startActivity(new Intent(getApplicationContext(), ExaminationActivity.class));
                break;
            case R.id.result:
                startActivity(new Intent(getApplicationContext(), AnnouncementActivity.class));
                break;
            default:
                Toast.makeText(this, "Wrong click!!!", Toast.LENGTH_SHORT).show();
        }
    }


        private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);   //textview for toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(false);//setting up toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
    }
}