package com.example.schoolmanagementsystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.schoolmanagementsystem.Admin.AdminExamsActivity;
import com.example.schoolmanagementsystem.Admin.AdminMainActivity;
import com.example.schoolmanagementsystem.signin.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;


public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
         Thread td = new Thread(){

             public void run(){
                 try{
                     sleep(4000);  //Waiting Time

                 }catch (Exception ex){
                     ex.printStackTrace();

                 }
                 finally {
                     if(FirebaseAuth.getInstance().getCurrentUser()!=null)
                         checkUser(FirebaseAuth.getInstance().getCurrentUser().getUid());
                     else
                         startActivity(new Intent(getApplicationContext(), LoginActivity.class));


                 }
             }
         }; td.start();


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
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        finish();
                    }}
            }
        });

        
    }

}