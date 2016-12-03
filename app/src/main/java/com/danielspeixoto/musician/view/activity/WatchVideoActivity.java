package com.danielspeixoto.musician.view.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.MediaController;
import android.widget.VideoView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 19/11/16.
 */
public class WatchVideoActivity extends BaseActivity implements MediaPlayer.OnCompletionListener {

    public static final String VIDEO_POSITION = "videoPosition";

    @BindView(R.id.videoView)
    VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_video);
        ButterKnife.bind(this);
        videoView.setOnCompletionListener(this);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath(getIntent().getStringExtra(Song.VIDEO_PATH));
        videoView.start();
        if (savedInstanceState != null) {
            videoView.seekTo(savedInstanceState.getInt(VIDEO_POSITION));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.resume();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(VIDEO_POSITION, videoView.getCurrentPosition());
    }
}
