package com.example.nomonkeyingaround;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    // Control declaration
    EditText userName, enterPasswd;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Control initialization
        userName = findViewById(R.id.InputUsername);
        enterPasswd = findViewById(R.id.InputPassword);
        login = findViewById(R.id.Login);


    }
}