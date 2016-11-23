package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IUpdateModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class UpdateSongModel implements IUpdateModel<Song> {

    private final DatabaseHandler mDBHandler;
    private final IUpdatePresenter mUpdatePresenter;

    public UpdateSongModel(IUpdatePresenter mUpdatePresenter, Context mContext) {
        this.mUpdatePresenter = mUpdatePresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void update(Song song) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.update(Song.TABLE,
                Convert.toContentValues(song),
                Song._ID + " = ?",
                new String[]{Long.toString(song.getId())});
        mUpdatePresenter.onUpdated();
    }

}
