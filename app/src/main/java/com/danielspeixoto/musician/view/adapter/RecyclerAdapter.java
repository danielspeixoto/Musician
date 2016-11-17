package com.danielspeixoto.musician.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 14/11/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    ArrayList<Song> mSongs = new ArrayList<>();
    private Activity mActivity;

    public RecyclerAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_song_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Song song = mSongs.get(position);
        holder.songName.setText(song.getName());
        holder.songArtist.setText(song.getArtist());
    }

    public void addSong(Song song) {
        mSongs.add(song);
        updateList();
    }

    public void removeAll() {
        mSongs.clear();
        updateList();
    }

    private void updateList() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.songName) TextView songName;
        @BindView(R.id.songArtist) TextView songArtist;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
