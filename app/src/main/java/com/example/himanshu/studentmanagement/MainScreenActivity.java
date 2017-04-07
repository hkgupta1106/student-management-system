package com.example.himanshu.studentmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

import adapter.DisplayAdapter;
import model.StudentDetails;

public class MainScreenActivity extends AppCompatActivity {
    ArrayList<StudentDetails> studentDetailslist=new ArrayList<StudentDetails>();
    StudentDetails studentdetails = new StudentDetails();
    private  int requestCode=2,result_Code=3;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button btnAdd=(Button)findViewById(R.id.btnAddStudent);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainScreenActivity.this,CreateStudentActivity.class);
                startActivityForResult(intent,requestCode);
            }


        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent intent)
        {
            if(result_Code==resultCode)
            {
                studentdetails = intent.getParcelableExtra("stuinfo");
                studentDetailslist.add(studentdetails);
            }
            else if(resultCode==2)
            {
                int pos;
                pos=intent.getIntExtra("pos",0);
                studentDetailslist.set(pos,studentdetails);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();
            }

            DisplayAdapter displayadapter = new DisplayAdapter(this, studentDetailslist);

            recyclerView = (RecyclerView) findViewById(R.id.rvLayout);
            recyclerView.setAdapter(displayadapter);
            final ToggleButton toggle = (ToggleButton) findViewById(R.id.tbbuton);

            recyclerView.setLayoutManager(new GridLayoutManager(MainScreenActivity.this,2));

            toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainScreenActivity.this));
                    } else {
                        recyclerView.setLayoutManager(new GridLayoutManager(MainScreenActivity.this,2));
                    }
                }

            });
            recyclerView.setHasFixedSize(true);
        }

}
