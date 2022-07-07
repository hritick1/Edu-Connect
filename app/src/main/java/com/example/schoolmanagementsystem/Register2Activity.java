package com.example.schoolmanagementsystem;

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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;

public class Register2Activity extends AppCompatActivity {
    private EditText name;
    private EditText mobile;
    private EditText age;
    private EditText Address;
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
        Address=findViewById(R.id.Address);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> map=new HashMap<>();
                map.put("Name",name.getText().toString());
                map.put("Mobile No.",mobile.getText().toString());
                map.put("Age",age.getText().toString());
                map.put("Address",Address.getText().toString());

                db.collection("Student Entry").add(map)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(Register2Activity.this, "Registration Successful!\n Log in To Continue", Toast.LENGTH_SHORT).show();
                                Intent I=new Intent(Register2Activity.this,LoginActivity.class);
                                startActivity(I);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Register2Activity.this, "Failed!", Toast.LENGTH_SHORT).show();
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
        heading.setText("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }
}