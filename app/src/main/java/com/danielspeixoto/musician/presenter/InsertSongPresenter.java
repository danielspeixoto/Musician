package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.InsertSongModel;
import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.view.module.IToastView;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongPresenter implements IInsertPresenter<Song> {

    private final IToastView mToastView;
    private IInsertModel mInsertModel;

    public InsertSongPresenter(IToastView mToastView, Context mContext) {
        this.mToastView = mToastView;
        this.mInsertModel = new InsertSongModel(this, mContext);
    }

    @Override
    public void insert(Song song) {
        mInsertModel.insert(song);
    }

    @Override
    public void onInserted() {
        mToastView.showMessage("Song has been created");
    }
}
