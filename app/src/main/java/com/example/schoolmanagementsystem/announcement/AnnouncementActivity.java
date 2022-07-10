package com.example.schoolmanagementsystem.announcement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagementsystem.R;
import com.example.schoolmanagementsystem.signin.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity {
    TextView heading;
    RecyclerView recyclerView;
    ArrayList<String> topic=new ArrayList<>();
    ArrayList<String> subject=new ArrayList<>();
    ArrayList<String> date=new ArrayList<>();
    ArrayList<String> full =new ArrayList<>();
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.logout){
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
        setContentView(R.layout.activity_announcement);
        toolbarFxn();
        dataGet();



         }

    private void dataGet() {
        FirebaseFirestore.getInstance().collection("Announcement").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                topic.clear();
                date.clear();
                subject.clear();
full.clear();
                for(DocumentSnapshot s: value){
                    topic.add(s.getString("topic"));
                    date.add(s.getString("date"));
                    subject.add(s.getString("subject"));
                    full.add(s.getString("full"));
                }
                setRecyclerView();

            }
        });
    }

    private void setRecyclerView() {
        recyclerView=findViewById(R.id.announcementRec);
        ArrayList<Data_Announcement> list=new ArrayList<>();
        for(int i=0;i<topic.size();i++){
            list.add(new Data_Announcement(topic.get(i),subject.get(i),date.get(i),full.get(i)));
        }
        Adapter_Announcement adapter_announcement=new Adapter_Announcement(list,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter_announcement);
    }


    private void toolbarFxn() {

        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Announcement");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);

    }
}