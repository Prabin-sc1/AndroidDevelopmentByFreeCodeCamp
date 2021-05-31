package com.example.fonts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button pickImgBtn, registerBtn;
    private EditText name, email, password, reenterPassword;
    private RadioGroup genderGrp;
    private RadioButton male, female, both;
    private CheckBox agree;
    private ConstraintLayout parent;
    private TextView txtWarnName, txtWarnEmail, txtWarnPassword, txtWarnPassRepeat;
    private Spinner countriesSpinner;

    private static final String TAG = "TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickImgBtn = findViewById(R.id.pickImageId);
        registerBtn = findViewById(R.id.registerBtnId);
        name = findViewById(R.id.nameId);
        email = findViewById(R.id.emailId);
        password = findViewById(R.id.passwordId);
        reenterPassword = findViewById(R.id.repasswordId);
        txtWarnName = findViewById(R.id.textView);
        txtWarnEmail = findViewById(R.id.textView2);
        txtWarnPassword = findViewById(R.id.textView3);
        txtWarnPassRepeat = findViewById(R.id.textView4);

        countriesSpinner = findViewById(R.id.spinnerId);
        agree = findViewById(R.id.agreeCheckBoxId);
        genderGrp = findViewById(R.id.radioGroup);
        male = findViewById(R.id.maleId);
        female = findViewById(R.id.femaleId);
        both = findViewById(R.id.bothId);

        agree = findViewById(R.id.agreeCheckBoxId);

        parent = findViewById(R.id.parent);

        pickImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Yet to talk about", Toast.LENGTH_SHORT).show();
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });

    }
    private void initRegister(){
        Log.d(TAG,"initRegister: Started");
        if(validateData()){
            if(agree.isChecked()){
                showSnackBar();
            }else{
                Toast.makeText(this, "You need to agree to the licence agreement", Toast.LENGTH_SHORT).show();
            }

        }

        }


    private boolean validateData() {
        Log.d(TAG, "validateData : started");
        if (name.getText().toString().equals("")) {

            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your name");
            return false;
        }
            if (email.getText().toString().equals("")) {
                txtWarnEmail.setVisibility(View.VISIBLE);
                txtWarnName.setText("Enter your email");
                return false;
            }
            if (password.getText().toString().equals("")) {

                txtWarnPassword.setVisibility(View.VISIBLE);
                txtWarnPassword.setText("Enter your password");
                return false;
            }

            if (reenterPassword.getText().toString().equals("")) {
                txtWarnPassRepeat.setVisibility(View.VISIBLE);
                txtWarnPassRepeat.setText("Please Re-Enter your password");
                return false;
            }
            if(!password.getText().toString().equals(reenterPassword.getText().toString())){
                txtWarnPassRepeat.setVisibility(View.VISIBLE);
                txtWarnPassRepeat.setText("Password doesn't match");

            }
            return true;

        }
        private void showSnackBar() {

        Log.d(TAG,"showSnackBar : Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();

        String userCountry = countriesSpinner.getSelectedItem().toString();

        String gender = "";
        switch (genderGrp.getCheckedRadioButtonId()){
            case R.id.maleId:
                gender = "Male";
                break;
            case R.id.femaleId:
                gender = "Female";
                break;
            case R.id.bothId:
                gender = "Both";
                break;
            default:
                gender = "Unknown";
                break;
        }
        String snackText = "Name: "+userName+"\n"+"Email: "+userEmail+"\n"+"Gender: "+gender+"\n"+"Country: "+userCountry;

        Log.d(TAG,snackText);


        Snackbar.make(parent,snackText,Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                password.setText("");
                reenterPassword.setText("");
            }
        }).show();
        }




}