package com.danielspeixoto.musician.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;

import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class MainViewPager extends Fragment {

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_viewpager, container);
        final SongListFragment songListFragment = new SongListFragment();
        final TaskListFragment taskListFragment = new TaskListFragment();
        ViewPager viewPager = ButterKnife.findById(view, R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? songListFragment : taskListFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Songs" : "Tasks";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        return view;
    }
}
