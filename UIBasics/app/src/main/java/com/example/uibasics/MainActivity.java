package com.example.uibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//we are doing whatever we like in Parent Class(i.e. AppCompatActivity)
        setContentView(R.layout.activity_main);

    }
    public void onHelloBtnClicked(View view){
        TextView textView = findViewById(R.id.txtWelcome);
        textView.setText("Hello Again");
        

    }
}