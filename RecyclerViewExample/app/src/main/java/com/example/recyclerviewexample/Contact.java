package com.example.recyclerviewexample;

import androidx.annotation.NonNull;

public class Contact {
    private String name;
    private String email;
    private String imageUrl;


    public Contact(String name, String email, String imageUrl) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Contact setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
