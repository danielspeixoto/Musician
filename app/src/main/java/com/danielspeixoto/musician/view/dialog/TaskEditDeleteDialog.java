package com.danielspeixoto.musician.view.dialog;

import android.content.Context;
import android.content.Intent;

import com.danielspeixoto.musician.presenter.DeleteTaskPresenter;
import com.danielspeixoto.musician.view.activity.UpdateSongActivity;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class TaskEditDeleteDialog extends BaseEditDeleteDialog {

    public TaskEditDeleteDialog(IDeleteItemView deleteItemView, Context context) {
        mDeletePresenter = new DeleteTaskPresenter(deleteItemView, context);
    }

    @Override
    public void onEditClicked() {
        // TODO Create UpdateTaskActivity
        Intent intent = new Intent(getActivity(), UpdateSongActivity.class);
        intent.putExtra(ID, id);
        startActivity(intent);
    }
}
