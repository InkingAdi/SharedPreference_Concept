package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "LOGGED";
    EditText edt_username, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_password = findViewById(R.id.edt_password);
        edt_username = findViewById(R.id.edt_username);

        // Retrieving the value using its keys the file name must be same in both saving and retrieving the data
        SharedPreferences sp = getSharedPreferences("REGISTER", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        Log.d(TAG, "onCreate: "+sp.getBoolean("isLoggedIn",false));
        if(sp.getBoolean("isLoggedIn",false)) {
            Log.d(TAG, "onCreate: Logged In !");
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }

        findViewById(R.id.btn_login).setOnClickListener(view -> {

            if(!(edt_username.getText().toString().trim().isEmpty() && edt_password.getText().toString().trim().isEmpty()))
            {
                if(edt_username.getText().toString().equals("aditya") && edt_password.getText().toString().equals("password")) {
                    edit.putBoolean("isLoggedIn", true);
                    edit.apply();

                    Intent intent = new Intent(this, WelcomeActivity.class);
                    startActivity(intent);
                }
            }

        });

    }
}