package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.ISelectModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.ISelectPresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class SelectSongModel implements ISelectModel<Song> {

    private final DatabaseHandler mDBHandler;
    private final ISelectPresenter mSelectPresenter;

    public SelectSongModel(ISelectPresenter mSelectPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mSelectPresenter = mSelectPresenter;
    }

    @Override
    public void select(long id) {
        SQLiteDatabase db = mDBHandler.getReadableDatabase();
        String[] projection = {
                Song._ID,
                Song.NAME,
                Song.ARTIST,
                Song.COMMENTS,
                Song.LEVEL,
                Song.BPM,
                Song.BEATS_PER_BAR,
                Song.VIDEO_PATH
        };
        Cursor cursor = db.query(Song.TABLE,
                projection,
                Song._ID + " = ?", // Where clause
                new String[]{Long.toString(id)}, // Passing the index as an array
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            mSelectPresenter.onReceived(new Song(cursor));
            cursor.close();
        }
    }

}
