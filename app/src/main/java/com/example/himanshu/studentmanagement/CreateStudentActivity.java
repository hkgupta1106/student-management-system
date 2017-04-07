package com.example.himanshu.studentmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import model.StudentDetails;

public class CreateStudentActivity extends AppCompatActivity {

    private EditText etName, etSchoolName, etEmail;
    private TextView tvRollNo;
    private RadioGroup rgGender;
    private String name, schoolName, email, gender, rollno, value = "view",key;
    private int selectedGender, resultCode = 3;
    private static int id = 0;
    private boolean isEmailValidation;
    private RadioButton rbGender,rbMale,rbFemale;
    private StudentDetails studentDetails;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);
        final Button btnSave = (Button) findViewById(R.id.btn_Save);

        studentDetails = getIntent().getParcelableExtra("object");
        if (studentDetails != null) {
            initialization();
            key=getIntent().getStringExtra("key");
            if(key.equals(value))
            {
                setdata();
                etName.setEnabled(false);
                etSchoolName.setEnabled(false);
                etEmail.setEnabled(false);
                rbMale.setEnabled(false);
                rbFemale.setEnabled(false);
                btnSave.setVisibility(View.GONE);
            }
            else if(key.equals("edit"))
            {
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent paser=new Intent();
                        setdata();
                        intent.putExtra("pos", paser.getIntExtra("pos", 0));
                        setResult(2,intent);
                        finish();
                    }
                });

            }
        }

        else {
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initialization();

                    name = etName.getText().toString();
                    schoolName = etSchoolName.getText().toString();
                    email = etEmail.getText().toString();
                    isEmailValidation = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
                    rgGender = (RadioGroup) findViewById(R.id.rg_Gender);
                    selectedGender = rgGender.getCheckedRadioButtonId();
                    if (isValidation()) {
                        id = id + 1;
                        rollno = String.valueOf(id);
                        rbGender = (RadioButton) findViewById(selectedGender);
                        gender = rbGender.getText().toString();

                        studentDetails = new StudentDetails(name, email, schoolName, gender, rollno);
                        intent.putExtra("stuinfo", studentDetails);
                        setResult(resultCode, intent);
                        finish();
                    }
                }

            });
        }
    }

    public void initialization() {
        etName = (EditText) findViewById(R.id.et_Name);
        etSchoolName = (EditText) findViewById(R.id.et_School_Name);
        etEmail = (EditText) findViewById(R.id.et_Email);
        rbMale=(RadioButton)findViewById(R.id.rb_Male);
        rbFemale=(RadioButton)findViewById(R.id.rb_Female);
        tvRollNo = (TextView) findViewById(R.id.tv_Roll_No);


    }

    public boolean isValidation() {
        if (name.isEmpty() || schoolName.isEmpty() || email.isEmpty() || selectedGender == -1) {
            Toast.makeText(getApplicationContext(), "all fields are mandatory", Toast.LENGTH_SHORT).show();
            return false;
        } else if (name.matches("[0-9]*")) {
            Toast.makeText(getApplicationContext(), "Name should not be numeric", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!isEmailValidation) {
            Toast.makeText(getApplicationContext(), "Invalid email format", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void setdata() {
        etName.setText(studentDetails.getName());
        etEmail.setText(studentDetails.getEmail());
        etSchoolName.setText(studentDetails.getSchoolName());
        if(studentDetails.getGender().equals("Male"))
        {
            rbMale.setChecked(true);
        }
        else
        {
            rbFemale.setChecked(true);
        }

        tvRollNo.setText("Roll No :   "+studentDetails.getRollNo());
    }
}