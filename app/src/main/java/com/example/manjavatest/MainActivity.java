package com.example.manjavatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // DB
    static UsersDB userDB;
    static ArrayList<ModelUser> data;

    // Login Screen
//    EditText user;
//    EditText pass;
//    Button loginButton;
//    TextView forgotPassTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.blank);

        // DB Stuff --------------------------------------------------------------------------------
        userDB = new UsersDB(this);
//        userDB.addUser("JohnDoe123", "Farmer4Life", "John", "Doe", "doejohn@johndeere.com", "1234567890");
//        userDB.addUser("AnnaPau", "h0L4", "Anna", "Pauline", "paulineanna@johndeere.com", "0987654321");
//        userDB.addUser("Trent_W", "1234abc", "Trent", "Williams", "williamstrent@johndeere.com", "9876543210");


        data = userDB.fetchUsers();
        for (ModelUser mu : data) {
        Log.d("User info", "Username " + mu.username + " Password " + mu.pass +
                    " First Name " + mu.firstN + " Last Name " + mu.lastN +
                    " Email " + mu.email + " Phone Number " + mu.phoneNum);
        }

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}