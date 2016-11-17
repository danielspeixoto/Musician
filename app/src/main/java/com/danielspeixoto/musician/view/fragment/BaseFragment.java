package com.danielspeixoto.musician.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class BaseFragment extends Fragment {

    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG);
    }
}