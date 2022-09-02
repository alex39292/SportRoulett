package com.danilas.sportroulette.screens;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userstore.db";
    private static final int SCHEMA = 2;
    static final String TABLE = "Exercises";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "exercise";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
        System.out.println("Constractor launched");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate launched");
        db.execSQL("CREATE TABLE " + TABLE + "(" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT);" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgrade launched");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}
