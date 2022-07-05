package com.example.schoolmanagementsystem;

import androidx.annotation.NonNull;
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

import com.example.schoolmanagementsystem.Admin.AdminActivity;
import com.example.schoolmanagementsystem.announcement.AnnouncementActivity;

public class HomeActivity extends AppCompatActivity {
    TextView heading;
    Button announcements,lectures,attendance,assignments,exams,results;

//    menu button
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
        setContentView(R.layout.activity_home);

        toolbarFxn();
        ids();  //setting up ids for buttons

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
                startActivity(new Intent(getApplicationContext(), AnnouncementActivity.class));
                break;
            case R.id.lectures:
                startActivity(new Intent(getApplicationContext(),LecturesActivity.class));
                break;
            case R.id.attendance:
                startActivity(new Intent(getApplicationContext(), AdminActivity.class));
                break;
            case R.id.assignment:
                startActivity(new Intent(getApplicationContext(),AssignmentActivity.class));
                break;
            case R.id.exam:
                startActivity(new Intent(getApplicationContext(),ExaminationActivity.class));
                break;
            case R.id.result:
                startActivity(new Intent(getApplicationContext(),AnnouncementActivity.class));
                break;
            default:
                Toast.makeText(this, "Wrong click!!!", Toast.LENGTH_SHORT).show();
        }



        }



}