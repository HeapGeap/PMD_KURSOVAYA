package com.example.medicinecenter.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Context context;
    private DatabaseBack databaseBack;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        this.context = context;
        databaseBack = new DatabaseBack(context);
    }

    public void openDb(){
        database = databaseBack.getWritableDatabase();
    }

    public void DatabaseInsert(String doc_name,String doc_surname, String w_i, String time ){
        ContentValues cv = new ContentValues();

        cv.put(Constants.DOCTOR_NAME,doc_name);
        cv.put(Constants.DOCTOR_SURNAME,doc_surname);
        cv.put(Constants.WEEK_INTERVAL,w_i);
        cv.put(Constants.ENTRY_TIME,time);

        database.insert(Constants.TABLE_NAME,null, cv);
    }

    public void DatabaseInsert2(String name,String date, String date_time){
        ContentValues cv = new ContentValues();

        cv.put(Constants.NAME,name);
        cv.put(Constants.DATE,date);
        cv.put(Constants.DATE_TIME,date_time);

        database.insert(Constants.TABLE2_NAME,null, cv);
    }



    public List<String> getDataFromDb(){

        List<String> tempList = new ArrayList<>();

        Cursor cursor = database.query(Constants.TABLE_NAME,null,null,null,
                null,null,null);

        while(cursor.moveToNext()){
            @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(Constants.DOCTOR_NAME));
            @SuppressLint("Range") String data2 = cursor.getString(cursor.getColumnIndex(Constants.DOCTOR_SURNAME));
            @SuppressLint("Range") String data3 = cursor.getString(cursor.getColumnIndex(Constants.WEEK_INTERVAL));
            @SuppressLint("Range") String data4 = cursor.getString(cursor.getColumnIndex(Constants.ENTRY_TIME));
            tempList.add(data);
            tempList.add(data2);
            tempList.add(data3);
            tempList.add(data4);
        }
        cursor.close();
        return tempList;
    }

    public List<String> getDataFromDb2(){

        List<String> tempList = new ArrayList<>();

        Cursor cursor = database.query(Constants.TABLE2_NAME,null,null,null,
                null,null,null);

        while(cursor.moveToNext()){
            @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(Constants.NAME));
            @SuppressLint("Range") String data2 = cursor.getString(cursor.getColumnIndex(Constants.DATE));
            @SuppressLint("Range") String data3 = cursor.getString(cursor.getColumnIndex(Constants.DATE_TIME));
            tempList.add(data);
            tempList.add(data2);
            tempList.add(data3);

        }
        cursor.close();
        return tempList;
    }

    public void closeDatabase(){
        database.close();
    }
}
