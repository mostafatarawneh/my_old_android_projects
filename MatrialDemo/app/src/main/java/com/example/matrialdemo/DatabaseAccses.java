package com.example.matrialdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccses {
    private SQLiteDatabase database;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private static DatabaseAccses instance;
    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DB_TABLE_NAME="info";
    private static final String DB_TABLE_ROW_ID="id";
    private static final String DB_TABLE_ROW_USERNAME="username";
    private static final String DB_TABLE_ROW_PASSWORD="password";

    private DatabaseAccses(Context context) {
        this.sqLiteOpenHelper = new ExternalDatabase(context);
    }
    public static DatabaseAccses getInstance(Context context){
     if(instance==null){
         instance=new DatabaseAccses(context);
     }
     return instance;
    }
    public void open(){
     this.database=this.sqLiteOpenHelper.getWritableDatabase();
    }
    public void close(){
        if(this.database!=null){
            this.database.close();
        }
    }

    public boolean InsertUser(User user){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DB_TABLE_ROW_USERNAME,user.getName());
        contentValues.put(DB_TABLE_ROW_PASSWORD,user.getPass());
        long Reuslt = database.insert(DB_TABLE_NAME,null,contentValues);
        return Reuslt !=-1;
    }
    public boolean UpdateUserInfo(User user){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DB_TABLE_ROW_USERNAME,user.getName());
        contentValues.put(DB_TABLE_ROW_PASSWORD,user.getPass());
        String [] args ={user.getId()+""};
        int ruslt = database.update(DB_TABLE_NAME,contentValues,"id=?",args);
        return ruslt != 0;
    }
    public long GetRowCount(){
        long reu= DatabaseUtils.queryNumEntries(database,DB_TABLE_NAME);
        return reu;
    }
    public boolean DeleteUser(User user){
        String [] args = {user.getName()};
        long reuslt= database.delete(DB_TABLE_NAME,"username=?",args);
        return reuslt != -1;
    }
    public ArrayList<User> GetAllUsers(){
        ArrayList<User> arrayList =new ArrayList<>();
        Cursor c = database.rawQuery("SELECT * FROM "+DB_TABLE_NAME,null);
        if( c.moveToFirst()){
            do {
                int id =c.getInt(c.getColumnIndex(DB_TABLE_ROW_ID));
                String username =c.getString(c.getColumnIndex(DB_TABLE_ROW_USERNAME));
                String password =c.getString(c.getColumnIndex(DB_TABLE_ROW_PASSWORD));
                User user=new User(id,username,password);
                arrayList.add(user);
            }while (c.moveToNext());
            c.close();

        }



        return arrayList;
    }
    public boolean ReplaceUser(User user){
        ContentValues contentValues =new ContentValues();
        contentValues.put(DB_TABLE_ROW_USERNAME,user.getName());
        contentValues.put(DB_TABLE_ROW_PASSWORD,user.getPass());
        long res= database.replace(DB_TABLE_NAME,null,contentValues);
        return res !=-1;
    }
}
