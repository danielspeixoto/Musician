package com.danielspeixoto.musician.view.activity;

import android.view.View;

import com.danielspeixoto.musician.presenter.InsertSongPresenter;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongActivity extends SongDataActivity {

    @Override
    public void saveSong(View view) {
        super.saveSong(view);
        new InsertSongPresenter(this).insertSong(song);
    }
}
