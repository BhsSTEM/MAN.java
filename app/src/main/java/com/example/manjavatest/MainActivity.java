package com.example.manjavatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersDB usersdb = new UsersDB(this);
//        usersdb.addUser("JohnDoe123", "Farmer4Life", "John", "Doe", "doejohn@johndeere.com", "1234567890");

        ArrayList<ModelUser> data = usersdb.fetchUsers();
        for (ModelUser mu : data) {
        Log.d("User info", "Username " + mu.username + " Password " + mu.pass +
                    " First Name " + mu.firstN + " Last Name " + mu.lastN +
                    " Email " + mu.email + " Phone Number " + mu.phoneNum);
        }
    }
}