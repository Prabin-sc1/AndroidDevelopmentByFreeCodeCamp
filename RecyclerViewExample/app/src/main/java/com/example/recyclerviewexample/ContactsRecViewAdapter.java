package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsRecViewAdapter extends RecyclerView.Adapter<ContactsRecViewAdapter.ViewHolder> {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Context context;

    public ContactsRecViewAdapter(Context context){
        this.context = context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //ViewGroup is parent of all the layout files
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.txtEmail.setText(contacts.get(position).getEmail());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,contacts.get(position).getName()+" selected",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
        /*Why this notifyDataSetChanged() here : because whenever your data coming from web server through internet,
         there obviously change in data in certain time, so this method helps Adapter to notify about that changes(i.e.refresh)*/

    }

    /* why setter here?
           = Because we make ArrayList as private, so if we want set data from main activity like initial data for contacts
       */


    public class ViewHolder extends RecyclerView.ViewHolder{ //Why ViewHolder? : Because It is a convention  and it works just like StringAdapter in Adapter class as we learn before
        private TextView txtName,txtEmail;
        private CardView parent;
        private ImageView image;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
