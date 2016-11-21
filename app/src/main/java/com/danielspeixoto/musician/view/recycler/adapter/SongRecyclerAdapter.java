package com.danielspeixoto.musician.view.recycler.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.AllSongsPresenter;
import com.danielspeixoto.musician.view.recycler.holder.SongHolder;

/**
 * Created by danielspeixoto on 14/11/16.
 */
public class SongRecyclerAdapter extends AllRecyclerAdapter {

    public SongRecyclerAdapter(AppCompatActivity mActivity) {
        super(mActivity);
        mSelectAllPresenter = new AllSongsPresenter(this, getActivity());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Song song = (Song) data.get(position);
        SongHolder songHolder = (SongHolder) holder;
        songHolder.setId(song.getId());
        songHolder.getSongName().setText(song.getName());
        songHolder.getSongArtist().setText(song.getArtist());
    }

    @Override
    public SongHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SongHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_song_item, parent, false),
                this);
    }

}
