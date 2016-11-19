package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IUpdateSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IUpdateSongPresenter;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class UpdateSongModel implements IUpdateSongModel {

    private final DatabaseHandler mDBHandler;
    private final IUpdateSongPresenter mUpdadeSongPresenter;

    public UpdateSongModel(IUpdateSongPresenter mUpdadeSongPresenter, Context mContext) {
        this.mUpdadeSongPresenter = mUpdadeSongPresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void updateSong(Song song) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.update(Song.TABLE,
                Convert.toContentValues(song),
                Song._ID + " = ?",
                new String[]{Integer.toString(song.getId())});
        mUpdadeSongPresenter.onSongUpdated();
    }

}
