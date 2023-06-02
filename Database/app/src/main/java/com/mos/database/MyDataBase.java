package com.mos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDataBase extends SQLiteAssetHelper {
    public final static String DATABASE_NAME="cars.db";

    public final static String DATABASE_TABLE_NAME="car";
    public final static int DATABASE_VERSTION=1;
    public MyDataBase (Context context){
        super(context,DATABASE_TABLE_NAME,null,DATABASE_VERSTION);
    }

    //@Override
   // public void onCreate(SQLiteDatabase db) {
     //   db.execSQL("CREATE TABLE car (id INTEGER PRIMARY KEY AUTOINCREMENT,model TEXT,color TEXT,distanceperLiter REAL)");
    //}

    //@Override
    //public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     //db.execSQL("DROP TABLE IF EXISTS car");
     //onCreate(db);
    //}
    public boolean Insertcar(Car car){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("model",car.getModel());
        values.put("color",car.getColor());
        values.put("distanceperLiter",car.getDistanceperLiter());
        long reuslt = db.insert(DATABASE_TABLE_NAME,null,values);
        return reuslt != -1;
    }
    public boolean UpdateCar(Car car){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("model",car.getModel());
        values.put("color",car.getColor());
        values.put("distanceperLiter",car.getDistanceperLiter());
        String arg [] = {car.getId()+""};
        int reuslt = db.update(DATABASE_TABLE_NAME,values,"id=?",arg);
        return reuslt != 0;
    }
    public long getrowCountinDatabase(){
        SQLiteDatabase db = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db,DATABASE_TABLE_NAME);
    }
    public boolean Deletecar(Car car){
        SQLiteDatabase db = getWritableDatabase();

        String arg [] = {car.getId()+""};
        long reuslt = db.delete(DATABASE_TABLE_NAME,"id=?",arg);
        return reuslt != -1;
    }
    public ArrayList<Car> getallcar(){
        ArrayList<Car> cars =new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
       Cursor c = db.rawQuery("SELECT * FROM "+DATABASE_TABLE_NAME,null);
       if(c.moveToFirst()){
           do {
               int id = c.getInt(0);
               String model =c.getString(1);
               String color =c.getString(2);
               double dpl=c.getDouble(3);
               Car car = new Car(id,model,color,dpl);
               cars.add(car);
           }while (c.moveToNext());
             c.close();
       }
        return cars;
    }
    public ArrayList<Car> getcar(String modelserach){
        ArrayList<Car> cars =new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM car WHERE model =?",new String[]{modelserach});
        if(c.moveToFirst()){
            do {
                int id = c.getInt(0);
                String model =c.getString(1);
                String color =c.getString(2);
                double dpl=c.getDouble(3);
                Car car = new Car(id,model,color,dpl);
                cars.add(car);
            }while (c.moveToNext());
            c.close();
        }
        return cars;
    }

}
