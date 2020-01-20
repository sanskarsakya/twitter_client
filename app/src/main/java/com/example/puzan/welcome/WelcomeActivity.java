package com.example.puzan.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import com.example.puzan.MainActivity;
import com.example.puzan.R;
import com.example.puzan.login.LoginActivity;
import com.example.puzan.signup.SignUpActivity;

public class WelcomeActivity extends AppCompatActivity {

    private Button btn_create;
    private TextView txt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        setContentView(R.layout.activity_welcome);

        // start ui binding
        btn_create = findViewById(R.id.btn_create);
        txt_login = findViewById(R.id.txt_login);
        // end ui binding

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
