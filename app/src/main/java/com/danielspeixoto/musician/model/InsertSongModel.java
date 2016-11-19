package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IInsertSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IInsertSongPresenter;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongModel implements IInsertSongModel {

    private final DatabaseHandler mDBHandler;
    private final IInsertSongPresenter mInsertSongPresenter;

    public InsertSongModel(IInsertSongPresenter mInsertSongPresenter, Context mContext) {
        this.mInsertSongPresenter = mInsertSongPresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void insertSong(Song song) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.insert(Song.TABLE, null, Convert.toContentValues(song));
        mInsertSongPresenter.onSongInserted();
    }

}