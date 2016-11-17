package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.ISelectSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.ISelectSongPresenter;
import com.danielspeixoto.musician.util.Contract;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class SelectSongModel implements ISelectSongModel, Contract {

    private final DatabaseHandler mDBHandler;
    private final ISelectSongPresenter mSelectSongPresenter;

    public SelectSongModel(ISelectSongPresenter mSelectSongPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mSelectSongPresenter = mSelectSongPresenter;
    }

    @Override
    public void selectSong(int index) {
        Song song;
        SQLiteDatabase db = mDBHandler.getReadableDatabase();
        String[] projection = {
                SongColumns._ID,
                SongColumns.NAME,
                SongColumns.ARTIST,
                SongColumns.COMMENTS,
                SongColumns.LEVEL,
                SongColumns.BPM,
                SongColumns.BEATS_PER_BAR
        };
        Cursor c = db.query(SongColumns.TABLE,
                projection,
                SongColumns._ID + " = ?", // Where clause
                new String[]{Integer.toString(index)}, // Passing the index as an array
                null,
                null,
                null);
        if (c.moveToFirst()) {
            song = new Song(c.getInt(c.getColumnIndex(SongColumns._ID)),
                    c.getString(c.getColumnIndex(SongColumns.NAME)),
                    c.getString(c.getColumnIndex(SongColumns.ARTIST)),
                    c.getString(c.getColumnIndex(SongColumns.COMMENTS)),
                    c.getInt(c.getColumnIndex(SongColumns.LEVEL)),
                    c.getInt(c.getColumnIndex(SongColumns.BPM)),
                    c.getString(c.getColumnIndex(SongColumns.BEATS_PER_BAR))
            );
            c.close();
            mSelectSongPresenter.onSongReceived(song);
        }
    }

}
