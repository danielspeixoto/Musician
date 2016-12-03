package com.danielspeixoto.musician.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.VideoView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class SongDataActivity extends BaseActivity {

    public static final int PICK_VIDEO = 1;
    protected Song song = new Song();
    protected int flags;
    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.artistEdit)
    EditText artistEdit;
    @BindView(R.id.bpmEdit)
    EditText bpmEdit;
    @BindView(R.id.beatsPerBarEdit)
    EditText beatsPerBarEdit;
    @BindView(R.id.commentsEdit)
    EditText commentsEdit;
    @BindView(R.id.levelSeek)
    SeekBar levelSeek;
    @BindView(R.id.videoView)
    VideoView videoView;
    @BindView(R.id.videoContainer)
    RelativeLayout videoContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_data);
        ButterKnife.bind(this);
        videoView.setOnPreparedListener((mp) -> mp.setVolume(0, 0));
        videoView.setOnCompletionListener((mp) -> mp.start());
    }

    @OnClick(R.id.pickVideoButton)
    public void pickVideo() {
        Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        i.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        flags = i.getFlags() & (Intent.FLAG_GRANT_READ_URI_PERMISSION
                | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        startActivityForResult(i, PICK_VIDEO);
    }

    @OnClick(R.id.deleteVideoButton)
    public void removeVideo() {
        song.setVideoPath(null);
        videoContainer.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PICK_VIDEO:
                    setVideoView(data.getData().toString());
                    getContentResolver().takePersistableUriPermission(data.getData(), flags);
                    break;
            }
        }
    }

    @OnClick(R.id.saveButton)
    public void saveSong(View view) {
        song.setName(nameEdit.getText().toString());
        song.setArtist(artistEdit.getText().toString());
        song.setComments(commentsEdit.getText().toString());
        song.setLevel(levelSeek.getProgress());
        song.setBeatsPerBar(beatsPerBarEdit.getText().toString());
        if (!bpmEdit.getText().toString().equals(EMPTY_STRING)) {
            song.setBpm(Integer.parseInt((bpmEdit.getText().toString())));
        }
    }

    protected void setVideoView(String videoPath) {
        song.setVideoPath(videoPath);
        videoView.setVideoPath(videoPath);
        videoView.start();
        videoContainer.setVisibility(View.VISIBLE);
    }
}
