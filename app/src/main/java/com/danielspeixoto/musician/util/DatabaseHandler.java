package com.danielspeixoto.musician.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.model.pojo.ToDo;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Musician.db";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Song.TABLE + " ("
                + Song._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Song.NAME + " VARCHAR(45), "
                + Song.ARTIST + " VARCHAR(45), "
                + Song.COMMENTS + " TEXT, "
                + Song.LEVEL + " INTEGER, "
                + Song.BPM + " INTEGER, "
                + Song.VIDEO_PATH + " VARCHAR(455), "
                + Song.BEATS_PER_BAR + " VARCHAR(15))");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Task.TABLE + " ("
                + Task._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Task.NAME + " VARCHAR(45), "
                + Task.DESCRIPTION + " VARCHAR(255))");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + ToDo.TABLE + " ("
                + ToDo._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ToDo.TASK_ID + " INTEGER REFERENCES "
                + Task.TABLE + "(" + Task._ID + ") ON DELETE CASCADE, "
                + ToDo.DESCRIPTION + " VARCHAR(45), "
                + ToDo.IS_FINISHED + " INTEGER DEFAULT 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
