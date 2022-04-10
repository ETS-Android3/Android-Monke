package com.example.nomonkeyingaround;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class UserAccountTableController extends AppCompatActivity {

    //Reference to buttons and other controls
    Button createAccount;
    EditText name, userName, age, password, passwordReenter;
    Chip isStudent, isTeacher, isPhysician;

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
        isStudent = findViewById(R.id.isStudent);
        isTeacher = findViewById(R.id.isTeacher);
        isPhysician = findViewById(R.id.isPhysician);

        // New bundle initialization for main activity being referenced after account creation
        Intent homePage = new Intent(this, MainActivity.class);
        Bundle homeBundle = new Bundle();
        homeBundle.putString("key1", "CFG:-Main Activity");
        homePage.putExtras(homeBundle);

        //OnClickListeners set checked value for other buttons, so only one choice can be selected
        isStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isTeacher.setChecked(false);
                isPhysician.setChecked(false);
            }
        });

        isTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStudent.setChecked(false);
                isPhysician.setChecked(false);
            }
        });

        isPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStudent.setChecked(false);
                isTeacher.setChecked(false);
            }
        });

        //button click listener
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserAccount userAccount;

                //if checks if entered passwords are the same
                if (password.getText().toString().equals(passwordReenter.getText().toString())) {
                    try {
                        // If else block initializes userAccount variable with either different account based on choice selected
                        if (isStudent.isChecked()) {
                            userAccount = new StudentAccount(-1, name.getText().toString(), userName.getText().toString(),
                                    Integer.parseInt(age.getText().toString()), password.getText().toString(), false, true,
                                    false);
                        }
                        else if (isTeacher.isChecked()) {
                            userAccount = new TeacherAccount(-1, name.getText().toString(), userName.getText().toString(),
                                    Integer.parseInt(age.getText().toString()), password.getText().toString(), true, false,
                                    false);
                        }
                        else if (isPhysician.isChecked()) {
                            userAccount = new PhysicianAccount(-1, name.getText().toString(), userName.getText().toString(),
                                    Integer.parseInt(age.getText().toString()), password.getText().toString(), false, false,
                                    true);
                        }
                        else {
                            userAccount = new UserAccount(-1, name.getText().toString(), userName.getText().toString(),
                                    Integer.parseInt(age.getText().toString()), password.getText().toString(), false, false,
                                    false);
                        }
                        Toast.makeText(UserAccountTableController.this, userAccount.toString(), Toast.LENGTH_SHORT).show();
                        startActivity(homePage);
                        setContentView(R.layout.main_activity);
                    }

                    catch (Exception e) {
                        Toast.makeText(UserAccountTableController.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                        // initializes userAccount with an error object if exception is hit
                    }
                }
                else {
                    Toast.makeText(UserAccountTableController.this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                }

                userAccount = new UserAccount(-1, "error", "error", 0, "error", false, false,
                        false);
                //new database reference created
                DatabaseController databaseController = new DatabaseController(UserAccountTableController.this);
                // addOne call adds account object to db
                // addOne only called if userAccount isn't error object
                if (!userAccount.getName().equals("error")) {
                    boolean success = databaseController.addOne(userAccount);
                    Toast.makeText(UserAccountTableController.this, "Success= " + success, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}