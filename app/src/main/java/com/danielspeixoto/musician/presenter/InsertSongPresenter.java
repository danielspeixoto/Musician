package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.InsertSongModel;
import com.danielspeixoto.musician.model.module.IInsertSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IInsertSongPresenter;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongPresenter implements IInsertSongPresenter {

    private IInsertSongModel mInsertSongModel;

    public InsertSongPresenter(Context mContext) {
        this.mInsertSongModel = new InsertSongModel(this, mContext);

    }

    @Override
    public void insertSong(Song song) {
        mInsertSongModel.insertSong(song);
    }
}
