package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.SelectSongPresenter;
import com.danielspeixoto.musician.presenter.UpdateSongPresenter;
import com.danielspeixoto.musician.view.module.ISelectSongView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class UpdateSongActivity extends SongDataActivity implements ISelectSongView {

    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getIntent().getIntExtra(Song._ID, 1);
        new SelectSongPresenter(this, this).selectSong(id);
    }

    @Override
    public void saveSong(View view) {
        super.saveSong(view);
        song.setId(id);
        new UpdateSongPresenter(this, this).updateSong(song);
        finish();
    }

    @Override
    public void fillData(Song song) {
        nameEdit.setText(song.getName());
        artistEdit.setText(song.getArtist());
        beatsPerBarEdit.setText(song.getBeatsPerBar());
        commentsEdit.setText(song.getComments());
        levelSeek.setProgress(song.getLevel());
        if (song.getBpm() != 0) {
            bpmEdit.setText(Integer.toString(song.getBpm()));
        }
        if (song.getVideoPath() != null) {
            setVideoView(song.getVideoPath());
        }
    }

}
