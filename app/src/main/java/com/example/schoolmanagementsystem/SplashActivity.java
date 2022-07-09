package com.example.schoolmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.example.schoolmanagementsystem.Admin.AdminExamsActivity;
import com.example.schoolmanagementsystem.signin.LoginActivity;


public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));

    }


}