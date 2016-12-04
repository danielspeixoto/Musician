package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.SelectSongPresenter;
import com.danielspeixoto.musician.presenter.UpdateSongPresenter;
import com.danielspeixoto.musician.view.module.ISelectView;
import com.danielspeixoto.musician.view.module.IUpdateView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class UpdateSongActivity extends SongDataActivity implements ISelectView<Song>,
        IUpdateView<Song> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new SelectSongPresenter(this, this).select(getIntent().getLongExtra(Song._ID, 1));
    }

    @Override
    public void saveSong(View view) {
        super.saveSong(view);
        new UpdateSongPresenter(this, this).update(song);
    }

    @Override
    public void fillData(Song song) {
        this.song = song;
        nameEdit.setText(song.getName());
        artistEdit.setText(song.getArtist());
        beatsPerBarEdit.setText(song.getBeatsPerBar());
        commentsEdit.setText(song.getComments());
        levelSeek.setProgress(song.getLevel());
        if (song.getBpm() == 0) {
            bpmEdit.setText(Integer.toString(song.getBpm()));
        }
        if (song.getVideoPath() != null) {
            setVideoView(song.getVideoPath());
        }
    }

    @Override
    public void onObjectUpdated() {
        showMessage("Song has been updated");
        finish();
    }

    @Override
    public void onErrorUpdating(String message) {
        showMessage(message);
    }
}
