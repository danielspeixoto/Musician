package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IDeleteModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IDeletePresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public class DeleteSongModel implements IDeleteModel<Song> {

    private final DatabaseHandler mDBHandler;
    private IDeletePresenter mDeleteSongPresenter;

    public DeleteSongModel(IDeletePresenter mDeleteSongPresenter, Context mContext) {
        this.mDeleteSongPresenter = mDeleteSongPresenter;
        this.mDBHandler = new DatabaseHandler(mContext);

    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.delete(Song.TABLE,
                Song._ID + " = ?",
                new String[]{Integer.toString(id)}
        );
        mDeleteSongPresenter.onDeleted();
    }
}
