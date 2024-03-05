package com.example.manjavatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersDB usersdb = new UsersDB(this);
        usersdb.addUser("JohnDoe123", "Farmer4Life", "John", "Doe", "doejohn@johndeere.com", "1234567890");



    }
}