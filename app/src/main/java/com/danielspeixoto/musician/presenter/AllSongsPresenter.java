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

    private IListView<Song> mListView;
    private ISelectAllModel<Song> mSelectAllModel;

    public AllSongsPresenter(IListView mListView, Context mContext) {
        this.mListView = mListView;
        this.mSelectAllModel = new SelectAllSongsModel(this, mContext);
    }

    @Override
    public void selectAll() {
        mSelectAllModel.selectAll();
    }

    @Override
    public void onReceiving(Song song) {
        mListView.addItem(song);
    }
}
