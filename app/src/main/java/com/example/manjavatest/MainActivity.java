package com.example.manjavatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_login);

        UsersDB usersdb = new UsersDB(this);
//        usersdb.addUser("JohnDoe123", "Farmer4Life", "John", "Doe", "doejohn@johndeere.com", "1234567890");

//        ArrayList<ModelUser> data = usersdb.fetchUsers();
//        for (ModelUser mu : data) {
//        Log.d("User info", "Username " + mu.username + " Password " + mu.pass +
//                    " First Name " + mu.firstN + " Last Name " + mu.lastN +
//                    " Email " + mu.email + " Phone Number " + mu.phoneNum);
//        }

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().equals("JohnDoe") && pass.getText().toString().equals("Farmer4Life")) {
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}