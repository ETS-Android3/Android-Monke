package com.example.nomonkeyingaround;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public interface FirebaseController {

    default void addUser(DatabaseReference db, UserAccount userAccount) {
        db.child("users").child(userAccount.getName()).setValue(userAccount);
    };
}


