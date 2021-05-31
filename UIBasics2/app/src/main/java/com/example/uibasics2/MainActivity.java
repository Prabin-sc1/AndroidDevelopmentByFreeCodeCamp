package com.example.uibasics2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtHello;
    private EditText edtTxtName;
    Button btnHello;

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnHello:
                //Toast.makeText(this,"Second Button Clicked",Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, "Hello "+edtTxtName.getText().toString(), Toast.LENGTH_SHORT).show();
                //every activity is a context
                txtHello.setText("Hello "+edtTxtName.getText().toString());
                //why toString because toString helps to change editable text to string
                break;
            case R.id.edtTxtName:
                Toast.makeText(this,"Attempting to type something",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHello = findViewById(R.id.btnHello);
        edtTxtName = findViewById(R.id.edtTxtName);
        txtHello = findViewById(R.id.txtHello);
        edtTxtName.setOnClickListener(this);

        btnHello.setOnClickListener(this);




    }
}