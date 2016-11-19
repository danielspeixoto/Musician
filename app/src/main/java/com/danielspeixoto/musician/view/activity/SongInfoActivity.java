package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.SelectSongPresenter;
import com.danielspeixoto.musician.view.module.ISelectSongView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 19/11/16.
 */
public class SongInfoActivity extends BaseActivity implements ISelectSongView {

    @BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.artistText)
    TextView artistText;
    @BindView(R.id.bpmText)
    TextView bpmText;
    @BindView(R.id.bpmLabel)
    TextView bpmLabel;
    @BindView(R.id.beatsPerBarLabel)
    TextView beatsPerBarLabel;
    @BindView(R.id.beatsPerBarText)
    TextView beatsPerBarText;
    @BindView(R.id.commentsText)
    TextView commentsText;
    @BindView(R.id.levelSeek)
    ProgressBar levelSeek;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);
        ButterKnife.bind(this);
        new SelectSongPresenter(this, this).selectSong(getIntent().getIntExtra(Song._ID, -1));
    }

    @Override
    public void fillData(Song song) {
        hasInfo(nameText, song.getName());
        hasInfo(artistText, song.getArtist());
        hasInfo(commentsText, song.getComments());
        levelSeek.setProgress(song.getLevel());
        if (!song.getBeatsPerBar().equals(EMPTY_STRING)) {
            beatsPerBarLabel.setVisibility(View.VISIBLE);
            beatsPerBarText.setVisibility(View.VISIBLE);
            beatsPerBarText.setText(song.getBeatsPerBar());
        }
        if (song.getBpm() != 0) {
            bpmLabel.setVisibility(View.VISIBLE);
            bpmText.setVisibility(View.VISIBLE);
            bpmText.setText(Integer.toString(song.getBpm()));
        }
    }

    private void hasInfo(View view, String string) {
        ((TextView) view).setText(string);
        if (string == null) {
            view.setVisibility(View.GONE);
        }
    }
}
