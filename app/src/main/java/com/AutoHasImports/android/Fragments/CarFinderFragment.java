package com.AutoHasImports.android.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.AutoHasImports.android.Constants.ActivityTitles;
import com.AutoHasImports.android.R;

import roboguice.fragment.RoboFragment;

/**
 * Created by Sekhar on 8/10/14.
 */

public class CarFinderFragment extends RoboFragment {

    public CarFinderFragment() {}
    private Activity _activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.car_finder_fragment, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _activity = activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (_activity != null) {
            _activity.setTitle(ActivityTitles.CAR_FINDER.toString());
        }
    }


}
