package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.ISelectAllSongsModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IAllSongsPresenter;
import com.danielspeixoto.musician.util.Contract;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class SelectAllSongsModel implements ISelectAllSongsModel, Contract {

    private final DatabaseHandler mDBHandler;
    private final IAllSongsPresenter mSelectAllSongsPresenter;

    public SelectAllSongsModel(IAllSongsPresenter mSelectAllSongsPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mSelectAllSongsPresenter = mSelectAllSongsPresenter;
    }

    @Override
    public void selectAllSongs() {
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
                mSelectAllSongsPresenter.onReceivingSongs(song);
            } while (c.moveToNext());
            c.close();
        }
    }
}
