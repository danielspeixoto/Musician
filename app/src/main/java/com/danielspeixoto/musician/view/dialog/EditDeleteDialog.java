package com.danielspeixoto.musician.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.DeleteSongPresenter;
import com.danielspeixoto.musician.presenter.module.IDeleteSongPresenter;
import com.danielspeixoto.musician.view.activity.UpdateSongActivity;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public class EditDeleteDialog extends DialogFragment {

    public static final String TAG = "editDelete";
    private IDeleteSongPresenter mDeleteSongPresenter;

    public EditDeleteDialog(IDeleteItemView deleteItemView, Context context) {
        mDeleteSongPresenter = new DeleteSongPresenter(deleteItemView, context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setItems(new CharSequence[]{getString(R.string.dialog_edit), getString(R.string.dialog_delete)},
                        (dialog, which) -> {
                            final int id = getArguments().getInt(Song._ID);
                            switch (which) {
                                case 0:
                                    Intent intent = new Intent(getActivity().getApplicationContext(), UpdateSongActivity.class);
                                    intent.putExtra(Song._ID, id);
                                    startActivity(intent);
                                    break;
                                case 1:
                                    new AreYouSureDialog(() -> mDeleteSongPresenter.deleteSong(id))
                                            .show(getFragmentManager(), AreYouSureDialog.TAG);
                                    break;
                            }
                        }).create();
    }
}
