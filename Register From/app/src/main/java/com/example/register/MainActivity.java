package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText fName;
    EditText lName;
    EditText email;

    TextView showFname,showLname,showEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onBtnClick(View view){
        fName= findViewById(R.id.firstNameId);
        lName = findViewById(R.id.lastNameId);
        email = findViewById(R.id.emailId);
        showFname = findViewById(R.id.showFirstNameId);
        showLname = findViewById(R.id.showLastNameId);
        showEmail = findViewById(R.id.showEmailId);


       showFname.setText("First Name: "+fName.getText().toString());
       showLname.setText("Last Name: "+lName.getText().toString());
       showEmail.setText("Email: "+email.getText().toString());

    }
}