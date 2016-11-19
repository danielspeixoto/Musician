package com.danielspeixoto.musician.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public class AreYouSureDialog extends DialogFragment {

    public static final String TAG = "areYouSure";
    private IOnYesClicked mOnYesClicked;

    public AreYouSureDialog(IOnYesClicked mOnYesClicked) {
        this.mOnYesClicked = mOnYesClicked;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Are you sure?")
                .setPositiveButton("Yes", (dialog, which) -> mOnYesClicked.onYesClicked())
                .setNegativeButton("Cancel", null)
                .create();
    }
}
