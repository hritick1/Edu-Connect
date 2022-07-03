package com.example.schoolmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
TextView heading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}