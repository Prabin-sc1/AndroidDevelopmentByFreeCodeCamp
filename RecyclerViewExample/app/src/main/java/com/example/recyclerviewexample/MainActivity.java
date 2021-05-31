package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView contactsRecView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Prabin","PrabinShah2019@gmail.com","hah.jpg"));
        contacts.add(new Contact("Prabina","PrabinaShah2019@gmail.com","acd.jpg"));
        contacts.add(new Contact("Rabin","RabinShah2019@gmail.com","acr.jpg"));
        contacts.add(new Contact("Rabina","RabinaShah2019@gmail.com","acddd.jpg"));
        contacts.add(new Contact("Sabin","SabinShah2019@gmail.com","acdf.jpg"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);


        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new GridLayoutManager(this,2));



    }
}