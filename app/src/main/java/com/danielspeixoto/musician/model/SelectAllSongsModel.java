package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.ISelectAllSongsModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IAllSongsPresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class SelectAllSongsModel implements ISelectAllSongsModel {

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
                Song._ID,
                Song.NAME,
                Song.ARTIST
        };
        Cursor cursor = db.query(Song.TABLE,
                projection,
                null,
                null,
                null,
                null,
                Song.NAME);
        if (cursor.moveToFirst()) {
            do {
                mSelectAllSongsPresenter.onReceivingSongs(new Song(cursor));
            } while (cursor.moveToNext());
            cursor.close();
        }
    }
}
