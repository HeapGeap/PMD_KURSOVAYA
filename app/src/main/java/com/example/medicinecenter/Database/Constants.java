package com.example.medicinecenter.Database;

public class Constants {
    public static final String TABLE_NAME = "WorkTime";
    public static final String TIME_ID = "time_id";
    public static final String DOCTOR_NAME = "doc_name";
    public static final String DOCTOR_SURNAME = "doc_surname";
    public static final String WEEK_INTERVAL = "w_i";
    public static final String ENTRY_TIME = "time";
    public static final String DB_NAME = "SanctumDB.db";
    public static final int DB_VERSION = 1;

    public static final String TIME_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + TIME_ID + " NUMBER PRIMARY KEY AUTOINCREMENT," + DOCTOR_NAME + " VARCHAR," +
            DOCTOR_SURNAME + " TEXT," + WEEK_INTERVAL + " TEXT," + ENTRY_TIME + " TEXT)";

    public static final String TIME_DROP = " DROP TABLE IF EXISTS " + TABLE_NAME;
}
