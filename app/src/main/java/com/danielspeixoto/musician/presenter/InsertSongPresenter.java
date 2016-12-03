package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.InsertSongModel;
import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.util.Auth;
import com.danielspeixoto.musician.view.module.IInsertView;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongPresenter implements IInsertPresenter<Song> {

    private final IInsertView<Song> mInsertView;
    private final IInsertModel<Song> mInsertModel;
    private Song mSong;

    public InsertSongPresenter(IInsertView<Song> mInsertView, Context mContext) {
        this.mInsertView = mInsertView;
        this.mInsertModel = new InsertSongModel(this, mContext);
    }

    @Override
    public void insert(Song song) {
        mSong = song;
        if (Auth.verifyItem(song)) {
            mInsertModel.insert(song);
        } else {
            mInsertView.onError("Must have a name");
        }
    }

    @Override
    public void onInserted(long id) {
        mSong.setId(id);
        mInsertView.onObjectInserted(mSong);
    }
}
