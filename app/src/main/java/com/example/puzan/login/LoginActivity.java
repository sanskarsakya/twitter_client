package com.example.puzan.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puzan.MainActivity;
import com.example.puzan.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.txt_name);
        etPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);

        etUsername.setText("admin");
        etPassword.setText("admin");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                    etUsername.setError("username or password is incorrect");
                    etUsername.requestFocus();
                }
            }
        });


    }
}
