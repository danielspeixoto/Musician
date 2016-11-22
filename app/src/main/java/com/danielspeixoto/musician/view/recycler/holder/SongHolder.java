package com.danielspeixoto.musician.view.recycler.holder;

import android.content.Intent;
import android.os.Bundle;
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
    }

    @OnClick(R.id.itemLayout)
    public void onItemClicked() {
        Intent intent = new Intent(mAdapter.getActivity(), SongInfoActivity.class);
        intent.putExtra(ID, id);
        mAdapter.getActivity().startActivity(intent);
    }

    @OnClick(R.id.optionsButton)
    public void optionsButtonAction() {
        SongEditDeleteDialog dialog = new SongEditDeleteDialog(this, mAdapter.getActivity());
        Bundle bundle = new Bundle();
        bundle.putInt(ID, id);
        dialog.setArguments(bundle);
        dialog.show(mAdapter.getActivity().getSupportFragmentManager(), dialog.TAG);
    }

}
