package com.danielspeixoto.musician.view.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.view.activity.SongInfoActivity;
import com.danielspeixoto.musician.view.dialog.EditDeleteDialog;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class SongHolder extends BaseHolder implements IDeleteItemView {

    @BindView(R.id.songName)
    TextView songName;
    @BindView(R.id.songArtist)
    TextView songArtist;

    public SongHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @OnClick(R.id.optionsButton)
    public void onOptionsButtonPressed() {
        EditDeleteDialog dialog = new EditDeleteDialog(this, mAdapter.getActivity());
        Bundle bundle = new Bundle();
        bundle.putInt(Song._ID, id);
        dialog.setArguments(bundle);
        dialog.show(mAdapter.getActivity().getSupportFragmentManager(), dialog.TAG);
    }

    @OnClick(R.id.itemLayout)
    public void onItemClicked() {
        Intent intent = new Intent(mAdapter.getActivity(), SongInfoActivity.class);
        intent.putExtra(Song._ID, id);
        mAdapter.getActivity().startActivity(intent);
    }

    @Override
    public void refreshData() {
        mAdapter.refreshData();
    }
}
