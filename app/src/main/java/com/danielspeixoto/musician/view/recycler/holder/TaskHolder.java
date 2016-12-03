package com.danielspeixoto.musician.view.recycler.holder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.view.activity.TaskInfoActivity;
import com.danielspeixoto.musician.view.dialog.TaskEditDeleteDialog;
import com.danielspeixoto.musician.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Getter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class TaskHolder extends AllHolder {

    @BindView(R.id.taskName)
    @Getter
    TextView taskName;
    @BindView(R.id.taskDescription)
    @Getter
    TextView taskDescription;

    public TaskHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
        ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.itemLayout)
    public void onItemClicked() {
        Intent intent = new Intent(mAdapter.getActivity(), TaskInfoActivity.class);
        // Task object being passed as Parcelable
        intent.putExtra(Task.TABLE, (Task) mAdapter.getData().get(index));
        mAdapter.getActivity().startActivity(intent);
    }

    @OnClick(R.id.optionsButton)
    public void optionsButtonAction() {
        TaskEditDeleteDialog dialog = new TaskEditDeleteDialog(this, mAdapter.getActivity());
        Bundle bundle = new Bundle();
        bundle.putParcelable(Task.TABLE, (Task) mAdapter.getData().get(index));
        dialog.setArguments(bundle);
        dialog.show(mAdapter.getActivity().getSupportFragmentManager(), dialog.TAG);
    }
}
