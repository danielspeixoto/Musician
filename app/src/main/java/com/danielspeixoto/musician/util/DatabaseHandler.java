package com.danielspeixoto.musician.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper implements Contract {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Musician.db";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + SongColumns.TABLE + " ("
                + SongColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SongColumns.NAME + " VARCHAR(45), "
                + SongColumns.ARTIST + " VARCHAR(45), "
                + SongColumns.COMMENTS + " TEXT, "
                + SongColumns.LEVEL + " INTEGER, "
                + SongColumns.BPM + " INTEGER, "
                + SongColumns.BEATS_PER_BAR + " VARCHAR(15))");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TaskColumns.TABLE + " ("
                + TaskColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TaskColumns.NAME + " VARCHAR(45), "
                + TaskColumns.DESCRIPTION + " VARCHAR(255))");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TodoColumns.TABLE + " ("
                + TodoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TodoColumns.TASK_ID + " INTEGER REFERENCES "
                + TaskColumns.TABLE + "(" + TaskColumns._ID + ") ON DELETE CASCADE, "
                + TodoColumns.DESCRIPTION + " VARCHAR(45), "
                + TodoColumns.IS_FINISHED + " VARCHAR(45))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
