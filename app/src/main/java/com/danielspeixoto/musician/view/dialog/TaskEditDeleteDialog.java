package com.danielspeixoto.musician.view.dialog;

import android.content.Context;
import android.content.Intent;

import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.DeleteTaskPresenter;
import com.danielspeixoto.musician.view.activity.UpdateTaskActivity;
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
        Intent intent = new Intent(getActivity(), UpdateTaskActivity.class);
        intent.putExtra(Task.TABLE, (Task) getArguments().getParcelable(Task.TABLE));
        startActivity(intent);
    }
}
