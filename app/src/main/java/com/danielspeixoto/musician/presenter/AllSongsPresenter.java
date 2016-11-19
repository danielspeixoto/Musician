package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.SelectAllSongsModel;
import com.danielspeixoto.musician.model.module.ISelectAllSongsModel;
import com.danielspeixoto.musician.presenter.module.ISelectAllPresenter;
import com.danielspeixoto.musician.view.module.IListView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class AllSongsPresenter implements ISelectAllPresenter {

    private IListView mListSongView;
    private ISelectAllSongsModel mSelectAllSongsModel;

    public AllSongsPresenter(IListView mListSongView, Context mContext) {
        this.mListSongView = mListSongView;
        this.mSelectAllSongsModel = new SelectAllSongsModel(this, mContext);
    }

    @Override
    public void selectAll() {
        mSelectAllSongsModel.selectAllSongs();
    }

    @Override
    public void onReceiving(Object object) {
        mListSongView.addItem(object);
    }
}
