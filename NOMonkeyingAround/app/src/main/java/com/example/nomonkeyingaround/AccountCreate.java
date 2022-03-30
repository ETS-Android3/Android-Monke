package com.example.nomonkeyingaround;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountCreate extends AppCompatActivity {

    //Reference to buttons and other controls
    Button createAccount;
    EditText name, userName, age, password, passwordReenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create);


        //Control assignment
        createAccount = findViewById(R.id.CreateAccount);
        name = findViewById(R.id.InputName);
        userName = findViewById(R.id.InputUsername);
        age = findViewById(R.id.InputAge);
        password = findViewById(R.id.InputPassword);
        passwordReenter = findViewById(R.id.reenterPassword);

        // New bundle definition for main activity being referenced after account creation
        Intent homePage = new Intent(this, MainActivity.class);
        Bundle homeBundle = new Bundle();
        homeBundle.putString("key1", "CFG:-Main Activity");
        homePage.putExtras(homeBundle);

        //button click listeners
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserAccount userAccount;
                try {
                    //isTeacher and isStudent set to false for dev purposes
                    userAccount = new UserAccount(-1, name.getText().toString(), userName.getText().toString(),
                            Integer.parseInt(age.getText().toString()), password.getText().toString(), false, false);
                    Toast.makeText(AccountCreate.this, userAccount.toString(), Toast.LENGTH_SHORT).show();
                    startActivity(homePage);
                    setContentView(R.layout.main_activity);
                }

                catch (Exception e) {
                    Toast.makeText(AccountCreate.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                    userAccount = new UserAccount(-1, "error", "error", 0, "error", false, false);
                }

                //new database reference created
                AccountDB accountDB = new AccountDB(AccountCreate.this);
                // addOne call adds account object to db
                boolean success = accountDB.addOne(userAccount);
                Toast.makeText(AccountCreate.this, "Success= "+ success, Toast.LENGTH_SHORT).show();

            }
        });
    }
}