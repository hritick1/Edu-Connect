package com.example.schoolmanagementsystem.Admin;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagementsystem.Examination.ExaminationActivity;
import com.example.schoolmanagementsystem.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AdminExamsActivity extends AppCompatActivity {
    TextView heading;
    EditText ExamName,type,examPlatform,dateTime;
    Button viewUser,Upload;
    Map<String,Object> map=new HashMap<>();
String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_exams);
        toolbarFxn();
        ID();
        id=getIntent().getStringExtra("id");
        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBase();
                ExamName.setText("");
                type.setText("");
                examPlatform.setText("");
                dateTime.setText("");
            }
        });

        viewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminExamsActivity.this, ExaminationActivity.class));
            }
        });
    }

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

    private void ID(){
        ExamName=findViewById(R.id.examName);
        type=findViewById(R.id.examtype);
        examPlatform=findViewById(R.id.platform);
        dateTime=findViewById(R.id.datetime);
        viewUser=findViewById(R.id.view);
        Upload=findViewById(R.id.upload);
    }
    private void dataBase() {
        map.put("Exam Name",ExamName.getText().toString());
        map.put("Type",type.getText().toString());
        map.put("Platform",examPlatform.getText().toString());
        map.put("Date_Time",dateTime.getText().toString());
        FirebaseFirestore.getInstance().collection("Examination").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(AdminExamsActivity.this, "Upload Successful!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AdminExamsActivity.this, "Upload Failed!", Toast.LENGTH_SHORT).show();
                }
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