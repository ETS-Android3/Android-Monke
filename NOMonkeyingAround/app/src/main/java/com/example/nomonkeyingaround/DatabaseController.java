package com.example.nomonkeyingaround;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseController extends SQLiteOpenHelper {

    //Constants defined for the user account db table and db columns for easier code references
    public static final String USER_ACCOUNT_TABLE = "USER_ACCOUNT_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_AGE = "AGE";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_ISTEACHER = "ISTEACHER";
    public static final String COLUMN_ISSTUDENT = "ISSTUDENT";

    public DatabaseController(@Nullable Context context) {
        super(context, "AccountDB", null, 1);
    }

    //called when new db is created
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creates USER_ACCOUNT table in
        String createTableStatement = "CREATE TABLE " + USER_ACCOUNT_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, " + COLUMN_USERNAME + " TEXT, " + COLUMN_AGE + " INT, " + COLUMN_PASSWORD + " TEXT, "
                + COLUMN_ISTEACHER + " BOOL, " + COLUMN_ISSTUDENT + " BOOL)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    //called whenever version number of db is changed. prevents app crashing if db is updated
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //method adds UserAccount object instance data members to the USER_ACCOUNT table in db
    public boolean addOne(UserAccount userAccount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, userAccount.getName());
        contentValues.put(COLUMN_USERNAME, userAccount.getUserName());
        contentValues.put(COLUMN_AGE, userAccount.getAge());
        contentValues.put(COLUMN_PASSWORD, userAccount.getPasswd());
        contentValues.put(COLUMN_ISSTUDENT, userAccount.isStudent());
        contentValues.put(COLUMN_ISTEACHER, userAccount.isTeacher());

        long insert = db.insert(USER_ACCOUNT_TABLE, null, contentValues);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    //method queries USER_ACCOUNT_TABLE and returns list containing all UserAccount
    //objects in the db
    public List<UserAccount> getAll() {
        List<UserAccount> returnList = new ArrayList<>();

        //get data from database

        String queryString = " SELECT * FROM " + USER_ACCOUNT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int userID = cursor.getInt(0);
                String name = cursor.getString(1);
                String userName = cursor.getString(2);
                int userAge = cursor.getInt(3);
                String userPassword = cursor.getString(4);
                boolean isStudent = cursor.getInt(5) == 1? true: false;
                boolean isTeacher = cursor.getInt(6) == 1? true: false;

                UserAccount userAccount = new UserAccount(userID, name, userName,
                        userAge, userPassword, isStudent, isTeacher);
                returnList.add(userAccount);
            } while (cursor.moveToFirst());
        }
        else {
            //failure. do not add anything to list
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
