package com.danielspeixoto.musician.view.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.danielspeixoto.musician.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class BaseFragment extends Fragment {

    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG);
    }

    public void showLog(String message) {
        Log.d(((BaseActivity) getActivity()).TAG, message);
    }
}