package com.example.schoolmanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolmanagementsystem.Admin.admin_data;
import com.example.schoolmanagementsystem.announcement.Adapter_Announcement;
import com.example.schoolmanagementsystem.announcement.Data_Announcement;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AdminMainActivity extends AppCompatActivity {
    TextView heading;
    RecyclerView recyclerView;
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> age=new ArrayList<>();
    ArrayList<String> mob=new ArrayList<>();
    ArrayList<String> id =new ArrayList<>();
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.logout){
            Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
        }
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
        setContentView(R.layout.activity_admin_main);
        toolbarFxn();
        dataGet();
    }
    private void dataGet() {
        FirebaseFirestore.getInstance().collection("Students").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                name.clear();
                age.clear();
                mob.clear();
                id.clear();
                for(DocumentSnapshot s: value){
                    name.add(s.getString("Name"));
                    age.add(s.getString("Age"));
                    mob.add(s.getString("Mobile No"));
                    id.add(s.getString("Id"));
                }
                setRecyclerView();

            }
        });
    }

    private void setRecyclerView() {
        recyclerView=findViewById(R.id.AdminRec);
        ArrayList<admin_data> list=new ArrayList<>();
        for(int i=0;i<name.size();i++){
            list.add(new admin_data(name.get(i),"Age: "+age.get(i),"Mobile No: "+mob.get(i),id.get(i)));
        }
     Admin_Adapter admin_adapter=new Admin_Adapter(list,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(admin_adapter);
    }


    private void toolbarFxn() {

        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("View Students");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);

    }
}