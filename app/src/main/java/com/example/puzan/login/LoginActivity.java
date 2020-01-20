package com.example.puzan.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puzan.MainActivity;
import com.example.puzan.R;
import com.example.puzan.models.User;
import com.example.puzan.network.GetDataService;
import com.example.puzan.network.RetrofitClientInstance;
import com.example.puzan.signup.SignUpActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etUsername,etPassword;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.login_email);
        etPassword = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.btn_login);

        etUsername.setText("admin");
        etPassword.setText("admin");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                User loginUser = new User();
                loginUser.setUsername(etUsername.getText().toString());
                loginUser.setPassword(etPassword.getText().toString());

                Log.d(TAG, etUsername.getText().toString());
                Log.d(TAG, etPassword.getText().toString());

                Call<Void> call = service.login(loginUser);
                call.enqueue(new Callback<Void>() {

                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.code() == 200){
                            Log.d(TAG, "success login");
                            Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                        Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                        Toast.makeText(LoginActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });

//
//                if(etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(LoginActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
//                    etUsername.setError("username or password is incorrect");
//                    etUsername.requestFocus();
//                }
            }
        });


    }
}
