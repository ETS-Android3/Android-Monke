package com.example.nomonkeyingaround;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginOrAccountCreate extends AppCompatActivity {

    Button accountCreate;
    Intent accountCreation;
    Bundle accountCreationBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_account_create);

        //control assignment
        accountCreate = findViewById(R.id.CreateAccount);

        accountCreation = new Intent(this, CreateAccount.class);
        accountCreationBundle = new Bundle();
        accountCreationBundle.putString("key2", "CFG:-Create Account");
        accountCreation.putExtras(accountCreationBundle);

        accountCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(accountCreation);
                setContentView(R.layout.activity_account_create);
            }
        });
    }
}