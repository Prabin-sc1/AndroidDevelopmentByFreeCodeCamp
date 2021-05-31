package com.example.uibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBoxChappie, checkBoxGravity, checkBoxPirates;

    private RadioGroup rgMaritalStatus;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progessBar);
        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);
        checkBoxChappie = findViewById(R.id.checkboxChappie);
        checkBoxGravity = findViewById(R.id.checkboxGravity);
        checkBoxPirates = findViewById(R.id.checkboxPirates);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(1000);
                }
            }
        });


        int checkedButton = rgMaritalStatus.getCheckedRadioButtonId();
        switch(checkedButton){
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this,"Married",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this,"Single",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbInRel:
                Toast.makeText(MainActivity.this,"In a relationship",Toast.LENGTH_SHORT).show();
                break;
            default:


        }
        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this,"Married",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                            Toast.makeText(MainActivity.this,"Single",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbInRel:
                            Toast.makeText(MainActivity.this,"In a relationship",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }
            }
        });
        thread.start();

        if(checkBoxPirates.isChecked()){
            Toast.makeText(MainActivity.this,"You have watched Pirates",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"You haven't watched Pirates till now",Toast.LENGTH_SHORT).show();
        }

        checkBoxPirates.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"You have watched Pirates",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"You haven't watched Pirates till now",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}