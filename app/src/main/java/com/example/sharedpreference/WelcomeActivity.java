package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Retrieving the value using its keys the file name must be same in both saving and retrieving the data
        SharedPreferences sp = getSharedPreferences("REGISTER", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        findViewById(R.id.txt_logout).setOnClickListener(view -> {
            edit.putBoolean("isLoggedIn",false);
            edit.apply();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}