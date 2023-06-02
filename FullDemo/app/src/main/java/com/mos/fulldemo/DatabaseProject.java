package com.mos.fulldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;


public class DatabaseProject extends SQLiteAssetHelper {
    private static String DATABASE_NAME="Users.db";
    private static int DATABASE_VERSION=1;
    private static final String DB_TABLE_NAME="user";
    private static final String DB_TABLE_ROW_ID="id";
    private static final String DB_TABLE_ROW_USERNAME="username";
    private static final String DB_TABLE_ROW_PASSWORD="password";
    private static final String DB_TABLE_ROW_AGE="Age";
    private static final String DB_TABLE_ROW_WORK="work";

    public DatabaseProject (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

       @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS car");
        onCreate(db);
    }
    public boolean InsertUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DB_TABLE_ROW_USERNAME,user.getUsername());
        contentValues.put(DB_TABLE_ROW_PASSWORD,user.getPassword());
        contentValues.put(DB_TABLE_ROW_AGE,user.getAge());
        contentValues.put(DB_TABLE_ROW_WORK,user.getWork());
        long Reuslt = db.insert(DB_TABLE_NAME,null,contentValues);
        return Reuslt !=-1;
    }
    public boolean UpdateUserInfo(User user){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DB_TABLE_ROW_USERNAME,user.getUsername());
        contentValues.put(DB_TABLE_ROW_PASSWORD,user.getPassword());
        contentValues.put(DB_TABLE_ROW_AGE,user.getAge());
        contentValues.put(DB_TABLE_ROW_WORK,user.getWork());
        String [] args ={user.getId()+""};
        int ruslt = db.update(DB_TABLE_NAME,contentValues,"id=?",args);
        return ruslt != 0;
    }
    public long GetRowCount(){
        SQLiteDatabase db = getReadableDatabase();
        long reu= DatabaseUtils.queryNumEntries(db,DB_TABLE_NAME);
        return reu;
    }
    public boolean DeleteUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        String [] args = {user.getUsername()};
        long reuslt= db.delete(DB_TABLE_NAME,"username=?",args);
        return reuslt != -1;
    }
    public ArrayList<User> GetAllUsers(){
        ArrayList<User> arrayList =new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+DB_TABLE_NAME,null);
        if( c.moveToFirst()){
            do {
                int id =c.getInt(c.getColumnIndex(DB_TABLE_ROW_ID));
                String username =c.getString(c.getColumnIndex(DB_TABLE_ROW_USERNAME));
                String password =c.getString(c.getColumnIndex(DB_TABLE_ROW_PASSWORD));
                String age = c.getString(c.getColumnIndex(DB_TABLE_ROW_AGE));
                String work = c.getString(c.getColumnIndex(DB_TABLE_ROW_WORK));
                User user=new User(id,username,password,age,work);
                arrayList.add(user);
            }while (c.moveToNext());
            c.close();

        }

        return arrayList;
    }

}
