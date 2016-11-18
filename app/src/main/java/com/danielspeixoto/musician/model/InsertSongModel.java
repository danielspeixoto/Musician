package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IInsertSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongModel implements IInsertSongModel {

    private final DatabaseHandler mDBHandler;

    public InsertSongModel(Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void insertSong(Song song) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.insert(Song.TABLE, null, Convert.toContentValues(song));
    }

}