package com.example.manjavatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
    EditText emailInput;
    Button submitButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        emailInput = findViewById(R.id.recEmailTextBox);
        submitButon = findViewById(R.id.submitButton);

        submitButon.setOnClickListener(new View.OnClickListener() {
            String email = "";
            @Override
            public void onClick(View v) {
                email = emailInput.getText().toString();

                if (!email.equals("")) {
                    email = "";
                    Intent intent = new Intent(ForgotPasswordActivity.this, RecoverPassActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter an email", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}