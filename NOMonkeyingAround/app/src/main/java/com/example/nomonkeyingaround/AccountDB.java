package com.example.nomonkeyingaround;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AccountDB extends SQLiteOpenHelper {

    //Constants defined for the user account db table and db columns for easier code references
    public static final String USER_ACCOUNT_TABLE = "USER_ACCOUNT_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_AGE = "AGE";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_ISTEACHER = "ISTEACHER";
    public static final String COLUMN_ISSTUDENT = "ISSTUDENT";

    public AccountDB(@Nullable Context context) {
        super(context, "AccountDB", null, 1);
    }

    //called when new db is created
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + USER_ACCOUNT_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, " + COLUMN_USERNAME + " TEXT, " + COLUMN_AGE + " INT, " + COLUMN_PASSWORD + " TEXT, "
                + COLUMN_ISTEACHER + " BOOL, " + COLUMN_ISSTUDENT + " BOOL)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    //called whenever version number of db is changed. prevents app crashing if db is updated
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //need method to add data to db. refer to video you were watching starting from 48mins
}
