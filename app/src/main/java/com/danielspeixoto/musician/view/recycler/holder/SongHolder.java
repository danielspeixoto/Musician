package com.danielspeixoto.musician.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.view.activity.SongInfoActivity;
import com.danielspeixoto.musician.view.dialog.SongEditDeleteDialog;
import com.danielspeixoto.musician.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Getter;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class SongHolder extends AllHolder {

    @BindView(R.id.songName)
    @Getter
    TextView songName;
    @BindView(R.id.songArtist)
    @Getter
    TextView songArtist;

    public SongHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
        ButterKnife.bind(this, itemView);
        dialog = new SongEditDeleteDialog(this, mAdapter.getActivity());
    }

    @OnClick(R.id.itemLayout)
    public void onItemClicked() {
        getInfo(SongInfoActivity.class);
    }

}
