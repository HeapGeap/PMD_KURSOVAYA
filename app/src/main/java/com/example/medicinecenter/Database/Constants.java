package com.example.medicinecenter.Database;

public class Constants {
    public static final String TABLE_NAME = "WorkTime";
    public static final String TIME_ID = "time_id";
    public static final String DOCTOR_NAME = "doc_name";
    public static final String DOCTOR_SURNAME = "doc_surname";
    public static final String WEEK_INTERVAL = "w_i";
    public static final String ENTRY_TIME = "time";
    ////////////////////////////////////////////////////////////////////////////

    public static final String TABLE2_NAME = "registr";

    public static final String TABLE2_ID = "reg_id";

    public static final String NAME = "name";

    public static final String DATE = "date";

    public static final String DATE_TIME = "date_time";
    /////////////////////////////////////////////////////////////////////////////
    public static final String DB_NAME = "SanctumDB.db";
    public static final int DB_VERSION = 3;

    public static final String TIME_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + TIME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + DOCTOR_NAME + " VARCHAR," +
            DOCTOR_SURNAME + " VARCHAR," + WEEK_INTERVAL + " VARCHAR," + ENTRY_TIME + " VARCHAR)";

    public static final String DATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE2_NAME + " (" + TABLE2_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR," +
            DATE + " VARCHAR," + DATE_TIME + " VARCHAR)";

    public static final String TIME_DROP = " DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final String TABLE2_DROP = " DROP TABLE IF EXISTS " + TABLE2_NAME;
}
