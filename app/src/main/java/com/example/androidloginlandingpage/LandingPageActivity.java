package com.example.androidloginlandingpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LandingPageActivity extends AppCompatActivity {

    private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_LONG).show();
        tvUsername = findViewById(R.id.tvLandingPageUsername);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        tvUsername.setText("Welcome back " + username);
    }

    public static Intent getIntent(Context context, String username, String password) {
        Intent intent = new Intent(context, LandingPageActivity.class);
        intent.putExtra("testIntentUsername", username);
        intent.putExtra("testIntentPassword", password);
        return intent;
    }
}