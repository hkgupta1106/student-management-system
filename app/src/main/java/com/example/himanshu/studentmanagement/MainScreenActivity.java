package com.example.himanshu.studentmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

import adapter.DisplayAdapter;
import model.StudentDetails;

/**
 * main scrren activity which displays sudent details
 */
public class MainScreenActivity extends AppCompatActivity {
    private static int requestCodeOne = 2, resultCodeOne = 3;
    private ArrayList<StudentDetails> studentDetailslist = new ArrayList<StudentDetails>();
    private StudentDetails studentdetails = new StudentDetails();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button btnAdd = (Button) findViewById(R.id.btnAddStudent);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(MainScreenActivity.this, CreateStudentActivity.class);
                startActivityForResult(intent, requestCodeOne);
            }


        });
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent intent) {
        if (this.resultCodeOne == resultCode) {
            studentdetails = intent.getParcelableExtra("stuinfo");
            studentDetailslist.add(studentdetails);
        } else if (resultCode == 2) {
            int pos;
            pos = intent.getIntExtra("pos", 0);
            studentdetails = intent.getParcelableExtra("object");
            studentDetailslist.set(pos, studentdetails);
        } else {
            Toast.makeText(getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();
        }

        DisplayAdapter displayadapter = new DisplayAdapter(this, studentDetailslist);

        recyclerView = (RecyclerView) findViewById(R.id.rvLayout);
        recyclerView.setAdapter(displayadapter);
        final ToggleButton toggle = (ToggleButton) findViewById(R.id.tbbuton);

        recyclerView.setLayoutManager(new GridLayoutManager(MainScreenActivity.this, 2));

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                if (isChecked) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainScreenActivity.this));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(MainScreenActivity.this, 2));
                }
            }

        });
        recyclerView.setHasFixedSize(true);
    }

}
