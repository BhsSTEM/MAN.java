package com.example.manjavatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecoverPassActivity extends AppCompatActivity {

    Button gotItButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_email_sent);

        gotItButton = findViewById(R.id.gotItButton);

        gotItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecoverPassActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}