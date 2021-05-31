package com.example.activity30vov;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private final int  REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("Message","HEllo from the first activity");
                //this behaves just like hash map (i.e. it must contain key and value)
                i.putExtra("SecondMessage","Hello again");
                i.putExtra("IntegerValue",213);
                startActivityForResult(i,REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // this will helps to get data from second activity

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String resultFirst = data.getStringExtra("returnData");
                Toast.makeText(MainActivity.this, "result:"+resultFirst, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
