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

import com.example.schoolmanagementsystem.R;
import com.example.schoolmanagementsystem.Results.ResultsActivity;
import com.example.schoolmanagementsystem.signin.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Admin_Result_Activity extends AppCompatActivity {
    TextView heading;
    Button upload;
    EditText subject,date,grade,marks;
    Map<String,Object> map=new HashMap<String,Object>();
    String id;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.logout){
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
        setContentView(R.layout.activity_admin_result);
        toolbarFxn();
        ids();
        id=getIntent().getStringExtra("id");
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBase();
            }
        });

    }
    private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);   //textview for toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Upload Result");
        getSupportActionBar().setDisplayShowTitleEnabled(false);//setting up toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
    }
    private void dataBase() {
        map.put("date",date.getText().toString());
        map.put("grade",grade.getText().toString());
        map.put("subject1",subject.getText().toString());
        map.put("marks",marks.getText().toString());
        FirebaseFirestore.getInstance().collection(id).add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(getApplicationContext(), "Upload Successfull", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ids() {
        grade=findViewById(R.id.grade);
        date=findViewById(R.id.date);
        subject=findViewById(R.id.subject);
        marks=findViewById(R.id.marks);
        upload=findViewById(R.id.upload);

    }
    }
