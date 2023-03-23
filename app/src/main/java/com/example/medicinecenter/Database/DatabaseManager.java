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

        database.insert(Constants.TIME_TABLE,null, cv);
    }

    public List<String> getDataFromDb(){
        List<String> tempList = new ArrayList<>();

        Cursor cursor = database.query(Constants.TIME_TABLE,null,null,null,
                null,null,null);

        while(cursor.moveToNext()){
            @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(Constants.DOCTOR_NAME));
            tempList.add(data);
        }
        cursor.close();
        return tempList;
    }

    public void closeDatabase(){
        database.close();
    }
}
