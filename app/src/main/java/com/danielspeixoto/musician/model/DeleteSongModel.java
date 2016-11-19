package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IDeleteSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IDeleteSongPresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public class DeleteSongModel implements IDeleteSongModel {

    private final DatabaseHandler mDBHandler;
    private IDeleteSongPresenter mDeleteSongPresenter;

    public DeleteSongModel(IDeleteSongPresenter mDeleteSongPresenter, Context mContext) {
        this.mDeleteSongPresenter = mDeleteSongPresenter;
        this.mDBHandler = new DatabaseHandler(mContext);

    }

    @Override
    public void deleteSong(int id) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.delete(Song.TABLE,
                Song._ID + " = ?",
                new String[]{Integer.toString(id)}
        );
        mDeleteSongPresenter.onSongDeleted();
    }
}
