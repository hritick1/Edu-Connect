package com.example.schoolmanagementsystem;

import androidx.annotation.NonNull;
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

import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity {
    TextView heading;
    RecyclerView recyclerView;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.logout){
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
        setContentView(R.layout.activity_announcement);
        toolbarFxn();
        recyclerView=findViewById(R.id.announcementRec);
        ArrayList<Data_Announcement> list=new ArrayList<>();
        list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));
        list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));
        list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));
        list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));    list.add(new Data_Announcement("Holiday","We will be getting holiday as its birthday" +
                " of me that is hritick enjoy","25-July-2022"));

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