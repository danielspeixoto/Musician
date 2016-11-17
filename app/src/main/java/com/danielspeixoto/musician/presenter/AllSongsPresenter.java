package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.SelectAllSongsModel;
import com.danielspeixoto.musician.model.module.ISelectAllSongsModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IAllSongsPresenter;
import com.danielspeixoto.musician.view.module.IListSongView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class AllSongsPresenter implements IAllSongsPresenter {

    private IListSongView mListSongView;
    private ISelectAllSongsModel mSelectAllSongsModel;

    public AllSongsPresenter(IListSongView mListSongView, Context mContext) {
        this.mListSongView = mListSongView;
        this.mSelectAllSongsModel = new SelectAllSongsModel(this, mContext);
    }

    @Override
    public void selectAllSongs() {
        mSelectAllSongsModel.selectAllSongs();
    }

    @Override
    public void onReceivingSongs(Song song) {
        mListSongView.addSongToList(song);
    }
}
