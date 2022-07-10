package com.example.schoolmanagementsystem.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schoolmanagementsystem.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;

public class Register2Activity extends AppCompatActivity {
    private EditText name;
    private EditText mobile;
    private EditText age;
    private EditText RegistrationNo;
    private EditText Address;
    String user ="yes";
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    Button submit;
TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);


        name=findViewById(R.id.name);
        mobile=findViewById(R.id.mobile);
        age=findViewById(R.id.age);
        RegistrationNo=findViewById(R.id.regNo);
        Address=findViewById(R.id.Address);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserId=RegistrationNo.getText().toString();
                HashMap<String,Object> map=new HashMap<>();
                map.put("Name",name.getText().toString());
                map.put("Mobile No",mobile.getText().toString());
                map.put("Age",age.getText().toString());
                map.put("Address",Address.getText().toString());
                map.put("User",user);

                DocumentReference documentReference=db.collection("Student Entry").document(UserId);
                documentReference.set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Register2Activity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register2Activity.this,LoginActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register2Activity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        toolbarFxn();

    }

    private void toolbarFxn() {
        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Registration Form");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }
}