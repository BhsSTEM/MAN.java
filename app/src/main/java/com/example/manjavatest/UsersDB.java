package com.example.manjavatest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UsersDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "UsersDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Users";

    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE_NO = "phone_no";


    public UsersDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE Users ( id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, first_name TEXT, last_name TEXT, email TEXT, phone_no TEXT
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_USERNAME + " TEXT, " + KEY_PASSWORD + " TEXT, "
                + KEY_FIRST_NAME + " TEXT, " + KEY_LAST_NAME
                + " TEXT, " + KEY_EMAIL + " TEXT, " + KEY_PHONE_NO + " TEXT)");

//        SQLiteDatabase dB = this.getWritableDatabase();
//
//        // query to insert
//
//        dB.close();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void addUser(String username, String pass, String firstN, String lastN, String email, String phoneNum) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_PASSWORD, pass);
        values.put(KEY_FIRST_NAME, firstN);
        values.put(KEY_LAST_NAME, lastN);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PHONE_NO, phoneNum);

        db.insert(TABLE_NAME, null, values);


//        db.close();

    }

    public ArrayList<ModelUser> fetchUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ModelUser> list = new ArrayList<>();

        while (c.moveToNext()) {
            ModelUser mu = new ModelUser();
            mu.id = c.getInt(0);
            mu.username = c.getString(1);
            mu.pass = c.getString(2);
            mu.firstN = c.getString(3);
            mu.lastN = c.getString(4);
            mu.email = c.getString(5);
            mu.phoneNum = c.getString(6);

            list.add(mu);
        }

        return list;
    }
}
