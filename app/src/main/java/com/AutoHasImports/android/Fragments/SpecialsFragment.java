package com.AutoHasImports.android.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.AutoHasImports.android.Constants.ActivityTitles;
import com.AutoHasImports.android.R;
import com.squareup.picasso.Picasso;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

/**
 * Created by Sekhar on 8/10/14.
 */
public class SpecialsFragment extends RoboFragment {

    Activity _activity;

    @InjectView (R.id.special_fragment_img) ImageView _imageView;

    public SpecialsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.specials_fragment, container, false);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _activity = activity;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Picasso.with(_activity.getBaseContext()).load("http://2.bp.blogspot.com/-LDaA7cP9MmA/Tddgg2e-HcI/AAAAAAAABoQ/xHH5Wau_V00/s1600/hello.png").resize(300,300).centerInside().into(_imageView);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (_activity != null) {
            _activity.getActionBar().setTitle(ActivityTitles.SPECIALS.toString());
        }
    }
}
