package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.InsertSongModel;
import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.view.module.IInsertView;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongPresenter implements IInsertPresenter<Song> {

    private final IInsertView mInsertView;
    private final IInsertModel mInsertModel;
    private Song mSong;

    public InsertSongPresenter(IInsertView mInsertView, Context mContext) {
        this.mInsertView = mInsertView;
        this.mInsertModel = new InsertSongModel(this, mContext);
    }

    @Override
    public void insert(Song song) {
        mSong = song;
        mInsertModel.insert(song);
    }

    @Override
    public void onInserted(long id) {
        mSong.setId(id);
        mInsertView.onObjectInserted(mSong);
    }
}
