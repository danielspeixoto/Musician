package com.danielspeixoto.musician.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.danielspeixoto.musician.presenter.DeleteSongPresenter;
import com.danielspeixoto.musician.view.activity.UpdateSongActivity;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class SongEditDeleteDialog extends BaseEditDeleteDialog {

    public SongEditDeleteDialog(IDeleteItemView deleteItemView, Context context) {
        mDeletePresenter = new DeleteSongPresenter(deleteItemView, context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getLong(ID);
    }

    @Override
    public void onEditClicked() {
        Intent intent = new Intent(getActivity(), UpdateSongActivity.class);
        intent.putExtra(ID, id);
        startActivity(intent);
    }
}
