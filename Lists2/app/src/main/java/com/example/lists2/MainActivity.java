package com.example.lists2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView citiesList;
    private Spinner studentSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citiesList = findViewById(R.id.citiesList);
        studentSpinner = findViewById(R.id.studentSpinner);


//
//        ArrayList<String> student = new ArrayList<>();
//        student.add("Ram");
//        student.add("Shayam");
//        student.add("Mahesh");
//        student.add("Prabin");
//        student.add("Pankaj");
//
//        ArrayAdapter<String> studentsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,student);
//
//        studentSpinner.setAdapter(studentsAdapter);

        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,studentSpinner.getSelectedItem().toString()+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        ArrayList<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("QueenLand");
        cities.add("California");
        cities.add("Janakpur");
        cities.add("Kathmandu");

        //Adapter = the purpose of adapter to fetch the data to your list view
        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cities
        );

        citiesList.setAdapter(citiesAdapter);

        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,cities.get(position)+" selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

}