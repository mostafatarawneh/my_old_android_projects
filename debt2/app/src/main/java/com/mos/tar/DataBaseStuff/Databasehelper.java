package com.mos.tar.DataBaseStuff;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "DEBT";

    // Table Names
    public static final String TABLE_LOGIN = "LOGIN";
    public static final String TABLE_INFO = "INFO";


    // SQL Statements to create a new databases.
    static final String CREATE_TABLE_LOGIN = "create table " + "LOGIN" + "( " + "ID" + " integer primary key ," + "USERNAME text,PASSWORD text); ";
    static final String CREATE_TABLE_INFO = "create table " + TABLE_INFO + "( " + "ID" + " integer primary key ," + "NAME text, AMOUNT real, NOTES text); ";


    public Databasehelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_LOGIN);
        db.execSQL(CREATE_TABLE_INFO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFO);

        // create new tables
        onCreate(db);
    }


}
