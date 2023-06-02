package com.example.matrialdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MYDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data";
    private static final int DATABASE_VERSION = 1;
    private static final String DB_TABLE_NAME="info";
    private static final String DB_TABLE_ROW_ID="id";
    private static final String DB_TABLE_ROW_USERNAME="username";
    private static final String DB_TABLE_ROW_PASSWORD="password";

    public MYDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE info(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS car");
        onCreate(db);
    }
public boolean InsertUser(User user){
 SQLiteDatabase db = getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put(DB_TABLE_ROW_USERNAME,user.getName());
    contentValues.put(DB_TABLE_ROW_PASSWORD,user.getPass());
    long Reuslt = db.insert(DB_TABLE_NAME,null,contentValues);
    return Reuslt !=-1;
}
public boolean UpdateUserInfo(User user){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DB_TABLE_ROW_USERNAME,user.getName());
        contentValues.put(DB_TABLE_ROW_PASSWORD,user.getPass());
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
        String [] args = {user.getName()};
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
    User user=new User(id,username,password);
    arrayList.add(user);
}while (c.moveToNext());
       c.close();

   }



return arrayList;
}
public boolean ReplaceUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(DB_TABLE_ROW_USERNAME,user.getName());
        contentValues.put(DB_TABLE_ROW_PASSWORD,user.getPass());
       long res= db.replace(DB_TABLE_NAME,null,contentValues);
        return res !=-1;
}

}




