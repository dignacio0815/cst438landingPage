package com.example.androidloginlandingpage;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidloginlandingpage.Model.User;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    static ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = setUpUsers();
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (verifyLoginCredentials(username, password)) {
                    // login successful
                    Intent intent = new Intent(MainActivity.this, LandingPageActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    // display error message if credential are wrong
                    etPassword.getBackground().setColorFilter(getResources().getColor(R.color.colorError),
                            PorterDuff.Mode.SRC_ATOP);
                    etUsername.getBackground().setColorFilter(getResources().getColor(R.color.colorError),
                            PorterDuff.Mode.SRC_ATOP);
                    Toast.makeText(getApplicationContext(), "Credentials incorrect. Please try again...", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean verifyLoginCredentials(String username, String password) {
        for(User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<User> setUpUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("din_djarin", "baby_yoda_ftw"));
        users.add(new User("denize", "123"));
        users.add(new User("patric", "456"));
        return users;
    }
}