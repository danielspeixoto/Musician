package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongModel implements IInsertModel<Song> {

    private final DatabaseHandler mDBHandler;
    private final IInsertPresenter mInsertPresenter;

    public InsertSongModel(IInsertPresenter mInsertPresenter, Context mContext) {
        this.mInsertPresenter = mInsertPresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void insert(Song song) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.insert(Song.TABLE, null, Convert.toContentValues(song));
        mInsertPresenter.onInserted();
    }

}