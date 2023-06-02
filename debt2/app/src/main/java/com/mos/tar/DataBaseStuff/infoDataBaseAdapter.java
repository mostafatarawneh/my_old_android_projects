package com.mos.tar.DataBaseStuff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.mos.tar.debt_data;

import java.util.ArrayList;

//import com.example.tar.infoDatabase.infoDataBaseHelper;


public class infoDataBaseAdapter {


    private static final String TABLE_INFO = "INFO";
    private static final String COLUMN_ID = "ID";


    // Variable to hold the database instance
    public SQLiteDatabase db;

    // Context of the application using the database.
    private final Context context;

    // Database open/upgrade helper
    private Databasehelper dbHelper;


    public infoDataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new Databasehelper(context, Databasehelper.DATABASE_NAME, null, Databasehelper.DATABASE_VERSION);
    }

    public infoDataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(debt_data database_debt_data) {
        ContentValues newValues = new ContentValues();

        // Assign values for each row.
        newValues.put("NAME", database_debt_data.getName());
        newValues.put("AMOUNT", database_debt_data.getAmount());
        newValues.put("NOTES", database_debt_data.getNote());


        // Insert the row into your table
        db.insert(Databasehelper.TABLE_INFO, null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }


    //    public String getSinlgeEntry(String userName) {
//        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
//        if(cursor.getCount()<1) // UserName Not Exist
//        {
//            cursor.close();
//            return "غير موجود";
//        }
//        cursor.moveToFirst();
//        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
//        cursor.close();
//        return password;
//    }
//    public void updateEntry(String userName,String password) {
//        // Define the updated row content.
//        ContentValues updatedValues = new ContentValues();
//        // Assign values for each row.
//        updatedValues.put("USERNAME", userName);
//        updatedValues.put("PASSWORD",password);
//
//        String where="USERNAME = ?";
//        db.update("LOGIN",updatedValues, where, new String[]{userName});
//    }
//
//    public  boolean isNotEmpty(){
//
//        Cursor mCursor = db.rawQuery("SELECT * FROM " + "LOGIN", null);
//        Boolean rowExists;
//        if (mCursor.moveToFirst())
//        {
//            // DO SOMETHING WITH CURSOR
//            return rowExists = true;
//
//        }
//        // I AM EMPTY
//        return   rowExists = false;
//    }
    public ArrayList<debt_data> listContacts() {
        String sql = "select * from " + TABLE_INFO;

        db = this.dbHelper.getReadableDatabase();
        ArrayList<debt_data> storeContacts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                Double amount = Double.parseDouble(cursor.getString(2));
                String note = cursor.getString(3);
                storeContacts.add(new debt_data(id, name, amount, note));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeContacts;
    }

    public boolean isNotEmpty() {

        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_INFO, null);

        if (mCursor.moveToFirst()) {
            // DO SOMETHING WITH CURSOR
            return true;

        }
        // I AM EMPTY
        return false;
    }

    public void deleteEntry(int id) {
        db = this.dbHelper.getWritableDatabase();
        db.delete(TABLE_INFO, COLUMN_ID + "	= ?", new String[]{String.valueOf(id)});
    }
}
