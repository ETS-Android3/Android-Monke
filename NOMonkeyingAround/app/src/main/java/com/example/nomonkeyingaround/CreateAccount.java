package com.example.nomonkeyingaround;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity implements FirebaseController{

    //Reference to buttons and other controls
    Button createAccount;
    EditText name, userName, age, password, passwordReenter, email;
    Chip isStudent, isTeacher, isPhysician;

    //constant firebase db reference initialized
    private final DatabaseReference USERDB = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create);

        //Initialization of firebase reference


        //Control assignment
        createAccount = findViewById(R.id.CreateAccount);
        name = findViewById(R.id.InputName);
        userName = findViewById(R.id.InputUsername);
        age = findViewById(R.id.InputAge);
        email = findViewById(R.id.InputEmail);
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
                            userAccount = new StudentAccount(name.getText().toString(), userName.getText().toString(),
                                    Integer.parseInt(age.getText().toString()),email.getText().toString(), password.getText().toString(),
                                    false, true, false);
                        }
                        else if (isTeacher.isChecked()) {
                            userAccount = new TeacherAccount(name.getText().toString(), userName.getText().toString(),
                                    Integer.parseInt(age.getText().toString()),email.getText().toString(), password.getText().toString(),
                                    true, false, false);
                        }
                        else if (isPhysician.isChecked()) {
                            userAccount = new PhysicianAccount(name.getText().toString(), userName.getText().toString(),
                                    Integer.parseInt(age.getText().toString()), email.getText().toString(), password.getText().toString(),
                                    false, false, true);
                        }
                        else {
                            userAccount = new UserAccount(name.getText().toString(), userName.getText().toString(),
                                    Integer.parseInt(age.getText().toString()), email.getText().toString(), password.getText().toString(), false,
                                    false, false);
                        }
                        Toast.makeText(CreateAccount.this, userAccount.toString(), Toast.LENGTH_SHORT).show();
                        startActivity(homePage);
                        setContentView(R.layout.main_activity);
                    }

                    catch (Exception e) {
                        Toast.makeText(CreateAccount.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                        // initializes userAccount with an error object if exception is hit
                        userAccount = new UserAccount("error", "error", 0, "error", "error", false, false,
                                false);

                    }
                }
                else {
                    Toast.makeText(CreateAccount.this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                    userAccount = new UserAccount("error", "error", 0, "error", "error", false, false,
                            false);

                }
                // only adds account to db if its a valid user
                if (!userAccount.getName().equals("error")) {
                    addUser(USERDB, userAccount);
                }
            }
        });


    }
}