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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register1Activity extends AppCompatActivity {
    private EditText email;
    private EditText conf_pass;
    private EditText pass;
    String userId;
    private EditText name;
    private EditText mobile;
    private EditText age;

    TextView heading;

    private EditText Address;
    Button submit;
    FirebaseFirestore db ;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register1);
    toolbarFxn();

    email = findViewById(R.id.email);
    name = findViewById(R.id.name);
    auth = FirebaseAuth.getInstance();
    db = FirebaseFirestore.getInstance();
    mobile = findViewById(R.id.mobile);
    age = findViewById(R.id.age);
    Address = findViewById(R.id.Address);
    submit = findViewById(R.id.register);
    auth = FirebaseAuth.getInstance();
    pass = findViewById(R.id.password);
    conf_pass = findViewById(R.id.conf_password);

        submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String Email=email.getText().toString();
            String Pass=pass.getText().toString();
            String Conf_pass=conf_pass.getText().toString();

            if (TextUtils.isEmpty(Pass)||TextUtils.isEmpty(Email)||TextUtils.isEmpty(Conf_pass)){
                Toast.makeText(Register1Activity.this, "The Fields Should not be Empty", Toast.LENGTH_SHORT).show();
            }else if(!Pass.equals(Conf_pass)){
                Toast.makeText(Register1Activity.this, "The Passwords Differ!!", Toast.LENGTH_SHORT).show();
            }else{
                auth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register1Activity.this, "User Created!", Toast.LENGTH_SHORT).show();
                            userId=auth.getCurrentUser().getUid();
                            DocumentReference documentReference=db.collection("Student Entry").document(userId);

                            HashMap<String,Object> map=new HashMap<>();
                            map.put("Name",name.getText().toString());
                            map.put("Mobile no.",mobile.getText().toString());
                            map.put("Age",age.getText().toString());
                            map.put("Address",Address.getText().toString());
                            map.put("Id",userId);
                            map.put("user",1);

                            documentReference.set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                    Toast.makeText(Register1Activity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(Register1Activity.this,LoginActivity.class));
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Register1Activity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }
                });

            }


        }
    });
}

    private void toolbarFxn() {

        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Registration Form");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}