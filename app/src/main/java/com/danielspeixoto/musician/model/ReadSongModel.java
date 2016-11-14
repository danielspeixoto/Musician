package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.IReadSongPresenter;
import com.danielspeixoto.musician.util.Contract;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class ReadSongModel implements IReadSongModel, Contract {

    private final DatabaseHandler mDBHandler;
    private final IReadSongPresenter mReadSongPresenter;

    public ReadSongModel(IReadSongPresenter mReadSongPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mReadSongPresenter = mReadSongPresenter;
    }

    @Override
    public void getRow(int index) {
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
            mReadSongPresenter.onSongReceived(song);
        }
    }

    @Override
    public void getAll() {
        SQLiteDatabase db = mDBHandler.getReadableDatabase();
        String[] projection = {
                SongColumns._ID,
                SongColumns.NAME,
                SongColumns.ARTIST
        };
        Cursor c = db.query(SongColumns.TABLE,
                projection,
                null,
                null,
                null,
                null,
                SongColumns.NAME);
        if (c.moveToFirst()) {
            do {
                Song song = new Song(c.getInt(c.getColumnIndex(SongColumns._ID)),
                        c.getString(c.getColumnIndex(SongColumns.NAME)),
                        c.getString(c.getColumnIndex(SongColumns.ARTIST)));
                mReadSongPresenter.onSongReceived(song);
            } while (c.moveToNext());
            c.close();
        }
    }
}
