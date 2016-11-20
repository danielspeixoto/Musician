package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.ISelectAllModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.ISelectAllPresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class SelectAllSongsModel implements ISelectAllModel<Song> {

    private final DatabaseHandler mDBHandler;
    private final ISelectAllPresenter mSelectAllSongsPresenter;

    public SelectAllSongsModel(ISelectAllPresenter mSelectAllSongsPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mSelectAllSongsPresenter = mSelectAllSongsPresenter;
    }

    @Override
    public void selectAll() {
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
                mSelectAllSongsPresenter.onReceiving(new Song(cursor));
            } while (cursor.moveToNext());
            cursor.close();
        }
    }
}
