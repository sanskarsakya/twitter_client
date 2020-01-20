package com.example.puzan.signup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.puzan.MainActivity;
import com.example.puzan.R;
import com.example.puzan.adapters.RecyclerViewAdapter;
import com.example.puzan.login.LoginActivity;
import com.example.puzan.models.User;
import com.example.puzan.network.GetDataService;
import com.example.puzan.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private Button btn_create;
    private EditText etUsername, etPassword;

    private static final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.txt_username);
        etPassword = findViewById(R.id.txt_password);
        btn_create = findViewById(R.id.btn_FS_signup);

        etUsername.setText("admin");
        etPassword.setText("admin");
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                User createUser = new User();
                createUser.setUsername(etUsername.getText().toString());
                createUser.setPassword(etPassword.getText().toString());

                Log.d(TAG, etUsername.getText().toString());
                Log.d(TAG, etPassword.getText().toString());


                Call<List<User>> call = service.createUser(createUser);
                call.enqueue(new Callback<List<User>>() {

                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        Log.d(TAG, "initRecyclerView: init recyclerview.");
                        Toast.makeText(SignUpActivity.this, "User created", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}
