package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.IWriteSongPresenter;
import com.danielspeixoto.musician.util.Contract;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class WriteSongModel implements IWriteSongModel, Contract {

    private final DatabaseHandler mDBHandler;
    private final IWriteSongPresenter mWriteSongPresenter;

    public WriteSongModel(IWriteSongPresenter mWriteSongPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mWriteSongPresenter = mWriteSongPresenter;
    }

    @Override
    public void insert(Song song) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.insert(SongColumns.TABLE, null, Convert.toContentValues(song));
    }

    @Override
    public void update(Song song) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.update(SongColumns.TABLE,
                Convert.toContentValues(song),
                SongColumns._ID + " = ?",
                new String[]{Integer.toString(song.getId())});
    }

    @Override
    public void delete(Song song) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.delete(SongColumns.TABLE,
                SongColumns._ID + " = ?",
                new String[]{Integer.toString(song.getId())}
        );
    }

}
