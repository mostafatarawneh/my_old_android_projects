package com.example.matrialdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class ExternalDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DB_TABLE_NAME="users";
    private static final String DB_TABLE_ROW_ID="id";
    private static final String DB_TABLE_ROW_USERNAME="username";
    private static final String DB_TABLE_ROW_PASSWORD="password";

    public ExternalDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //@Override
    //public void onCreate(SQLiteDatabase db) {
      //  db.execSQL("CREATE TABLE info(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT)");
    //}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS car");
        onCreate(db);
    }


}




