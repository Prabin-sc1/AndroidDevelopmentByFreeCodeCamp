package com.example.activity30vov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button button;
    private TextView showTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.button2);
        showTxt = findViewById(R.id.showId);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            //String  msg = extras.getString("Message");
            int myInt = extras.getInt("IntegerValue");
            showTxt.setText(String.valueOf(myInt));
        }
        //extras.get("Message");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code goes here for return data to neighbour first activity
                Intent  returnIntent = getIntent();
                returnIntent.putExtra("returnData","From secondActivity");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }

}