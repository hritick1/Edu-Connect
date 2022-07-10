package com.example.schoolmanagementsystem.Results;

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

import com.example.schoolmanagementsystem.R;
import com.example.schoolmanagementsystem.Results.Adapter_Results;
import com.example.schoolmanagementsystem.Results.Data_Results;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
RecyclerView recyclerView;
TextView heading;
    ArrayList<String> grade=new ArrayList<>();
    ArrayList<String> subject=new ArrayList<>();
    ArrayList<String> date=new ArrayList<>();
    ArrayList<String> marks =new ArrayList<>();
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
        setContentView(R.layout.activity_results);
        toolbarFxn();
      dataGet();

    }


    private void dataGet() {
        FirebaseFirestore.getInstance().collection(FirebaseAuth.getInstance().getCurrentUser().getUid()).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                grade.clear();
                date.clear();
                subject.clear();
                marks.clear();
                for(DocumentSnapshot s: value){
                    grade.add(s.getString("grade"));
                    date.add(s.getString("date"));
                    subject.add(s.getString("subject1"));
                    marks.add(s.getString("marks"));
                }
                setRecyclerView();

            }
        });
    }

    private void setRecyclerView() {
        recyclerView=findViewById(R.id.resultsRec);
        ArrayList<Data_Results> list=new ArrayList<>();
        for(int i=0;i<grade.size();i++){
            if(subject.get(i)!=null && grade.get(i)!=null && date.get(i)!=null && marks.get(i)!=null)
            list.add(new Data_Results(subject.get(i),"Grade: "+grade.get(i),date.get(i),"Marks Scored: "+marks.get(i)));
        }
       Adapter_Results adapter_results=new Adapter_Results(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter_results);
    }


    private void toolbarFxn() {

        heading=findViewById(R.id.toolbarText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        heading.setText("Results");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getOverflowIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#f5f5f5"), PorterDuff.Mode.SRC_ATOP);

    }
}