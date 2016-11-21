package com.danielspeixoto.musician.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.view.activity.SongInfoActivity;
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
        dialog = new TaskEditDeleteDialog(this, mAdapter.getActivity());
    }

    @OnClick(R.id.itemLayout)
    public void onItemClicked() {
        // TODO Create TaskInfoActivity
        getInfo(SongInfoActivity.class);
    }
}
