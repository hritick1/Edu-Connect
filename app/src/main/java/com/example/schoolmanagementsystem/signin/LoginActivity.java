package com.example.schoolmanagementsystem.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.TextView;

import com.example.schoolmanagementsystem.Admin.AdminMainActivity;
import com.example.schoolmanagementsystem.HomeActivity;
import com.example.schoolmanagementsystem.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    private EditText Usermail;
    private EditText Password;
    private Button login;
    private Button signup;

    TextView heading;
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbarFxn();
        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);
        Password=findViewById(R.id.password);
        Usermail=findViewById(R.id.useremail);
        auth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=Usermail.getText().toString();
                String pass=Password.getText().toString();

                if (TextUtils.isEmpty(mail)||TextUtils.isEmpty(pass))
                    Toast.makeText(getApplicationContext(), "Enter the Values!!", Toast.LENGTH_SHORT).show();
                else
                    Login1(mail,pass);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(LoginActivity.this, Register1Activity.class);
                startActivity(i1);
            }
        });
    }
    private void Login1(String mail,String pass){
        auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    checkUser(auth.getCurrentUser().getUid());
                }
                else
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Login Or Sign-up");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);

    }
    private void checkUser(String uid) {

        FirebaseFirestore.getInstance().collection(uid).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for(DocumentSnapshot s:value){
                if(s.getString("isAdmin")!=null){
                    startActivity(new Intent(getApplicationContext(), AdminMainActivity.class));
                    finish();
                }
                else{
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
                }}
            }
        });

    }
}