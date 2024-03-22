package com.example.manjavatest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    Button loginButton;
    TextView forgotPassTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        forgotPassTxt = (TextView)findViewById(R.id.forgotPassText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            String userInput = "";
            String passInput = "";
            @Override
            public void onClick(View v) {
                boolean valid = false;
                userInput = user.getText().toString();
                passInput = pass.getText().toString();

                if (userInput.equals("") || passInput.equals("")) {
                    if (userInput.equals("") && !passInput.equals("")) {
                        Toast.makeText(LoginActivity.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                    }
                    else if (!userInput.equals("") && passInput.equals("")) {
                        Toast.makeText(LoginActivity.this, "Please enter a password", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Please enter a username and a password", Toast.LENGTH_SHORT).show();
                    }
                }

                if (!userInput.equals("") && !passInput.equals("")) {
                    for (ModelUser mu : MainActivity.data) {
                        if (userInput.equals(mu.username) && passInput.equals(mu.pass))
                            valid = true;
                    }

                    // Adding as toasts for now, I'll link it to the right screen later
                    if (valid) {
                        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        userInput = "";
                        passInput = "";
                        valid = false;
                    } else
                        Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }



            }
        });

        forgotPassTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });


    }
}
