package com.example.schoolmanagementsystem.Admin;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.schoolmanagementsystem.LecturesActivity;
import com.example.schoolmanagementsystem.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;

public class AdminLecturesActivity extends AppCompatActivity {
    TextView heading;
    EditText Time,Subject,Room;
    Button viewUser,Upload;
    Map<String,Object> map=new HashMap<>();
String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_lectures);
        toolbarFxn();
        ID();
        id=getIntent().getStringExtra("id");
        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBase();
                Time.setText("");
                Subject.setText("");
                Room.setText("");

            }
        });

        viewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminLecturesActivity.this, LecturesActivity.class));
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
        Time=findViewById(R.id.time);
        Room=findViewById(R.id.room);
        Subject = findViewById(R.id.sub);

        viewUser=findViewById(R.id.view);
        Upload=findViewById(R.id.upload);
    }

    private void dataBase() {
        map.put("Time", Time.getText().toString());
        map.put("subjectLec", Subject.getText().toString());
        map.put("Room", Room.getText().toString());

        FirebaseFirestore.getInstance().collection(id).add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(AdminLecturesActivity.this, "Upload Successful!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AdminLecturesActivity.this, "Upload Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Lectures");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);

    }
}



