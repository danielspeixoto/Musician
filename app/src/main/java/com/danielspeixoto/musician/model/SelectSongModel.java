package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.ISelectSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.ISelectSongPresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class SelectSongModel implements ISelectSongModel {

    private final DatabaseHandler mDBHandler;
    private final ISelectSongPresenter mSelectSongPresenter;

    public SelectSongModel(ISelectSongPresenter mSelectSongPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mSelectSongPresenter = mSelectSongPresenter;
    }

    @Override
    public void selectSong(int index) {
        SQLiteDatabase db = mDBHandler.getReadableDatabase();
        String[] projection = {
                Song._ID,
                Song.NAME,
                Song.ARTIST,
                Song.COMMENTS,
                Song.LEVEL,
                Song.BPM,
                Song.BEATS_PER_BAR
        };
        Cursor cursor = db.query(Song.TABLE,
                projection,
                Song._ID + " = ?", // Where clause
                new String[]{Integer.toString(index)}, // Passing the index as an array
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            mSelectSongPresenter.onSongReceived(new Song(cursor));
            cursor.close();
        }
    }

}
