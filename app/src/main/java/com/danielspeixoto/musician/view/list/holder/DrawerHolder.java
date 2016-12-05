package com.danielspeixoto.musician.view.list.holder;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.view.list.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.Getter;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerHolder extends BaseHolder {

    @BindView(R.id.drawer_text)
    @Getter
    TextView drawerText;

    public DrawerHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @OnClick(R.id.drawer_item)
    public void itemClicked() {
        switch (index) {
            case 0:
                Toast.makeText(mAdapter.getActivity(), "1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(mAdapter.getActivity(), "2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
