package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.SelectAllSongsModel;
import com.danielspeixoto.musician.model.module.ISelectAllModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.ISelectAllPresenter;
import com.danielspeixoto.musician.view.module.IListView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class AllSongsPresenter implements ISelectAllPresenter<Song> {

    private IListView mListSongView;
    private ISelectAllModel mSelectAllSongsModel;

    public AllSongsPresenter(IListView mListSongView, Context mContext) {
        this.mListSongView = mListSongView;
        this.mSelectAllSongsModel = new SelectAllSongsModel(this, mContext);
    }

    @Override
    public void selectAll() {
        mSelectAllSongsModel.selectAll();
    }

    @Override
    public void onReceiving(Song song) {
        mListSongView.addItem(song);
    }
}
