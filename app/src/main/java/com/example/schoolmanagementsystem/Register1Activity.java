package com.example.schoolmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register1Activity extends AppCompatActivity {
    private TextView heading;
    private EditText email;
    private EditText conf_pass;
    private EditText pass;
    private Button reg;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        toolbarFxn();
        email=findViewById(R.id.email);

        auth=FirebaseAuth.getInstance();
        pass=findViewById(R.id.password);
        conf_pass=findViewById(R.id.conf_password);
        reg=findViewById(R.id.register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String e1=email.getText().toString();
                String p1=pass.getText().toString();
                String conf_p=conf_pass.getText().toString();

                if (!p1.equals(conf_p))
                    Toast.makeText(Register1Activity.this, "Your Passwords Differ!!", Toast.LENGTH_SHORT).show();

                if (TextUtils.isEmpty(e1)||TextUtils.isEmpty(p1))
                    Toast.makeText(Register1Activity.this, "Enter the Values!!", Toast.LENGTH_SHORT).show();
                else
                    RegisterFunction(e1,p1);
            }
        });
    }

    private void RegisterFunction(String email,String Password){
        auth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(Register1Activity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Register1Activity.this, "Successful", Toast.LENGTH_SHORT).show();
                    Intent i2=new Intent(Register1Activity.this,Register2Activity.class);
                    startActivity(i2);
                }
                else
                    Toast.makeText(Register1Activity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void toolbarFxn() {

        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}