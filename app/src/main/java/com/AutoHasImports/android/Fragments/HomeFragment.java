package com.AutoHasImports.android.Fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;


import com.AutoHasImports.android.Constants.ActivityTitles;
import com.AutoHasImports.android.R;

import java.util.ArrayList;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

/**
 * Created by Sekhar on 8/10/14.
 */

public class HomeFragment extends RoboFragment {

    Activity _activity;

    public HomeFragment() {}

    @InjectView(R.id.home_title) TextView _homeTitleTextView;

    @InjectView(R.id.homepage_image_switcher) ImageSwitcher _imageSwitcher;

    private ArrayList<String> _pricesArray = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populatePricesArray();

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(_activity.getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.
                        MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
                return myView;
            }
        });

    }

    private void populatePricesArray() {
        _pricesArray.add("$7000");
        _pricesArray.add("$14,000");
        _pricesArray.add("21,000");
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
            _activity.getActionBar().setTitle(ActivityTitles.HOME.toString());

            Typeface typeface;
            typeface = Typeface.createFromAsset(_activity.getBaseContext().getAssets(), "RobotoCondensed-Light.ttf");
            _homeTitleTextView.setTypeface(typeface);
            _homeTitleTextView.setText("Auto Has Imports");
            _homeTitleTextView.setTextSize(45);
            _homeTitleTextView.setTextColor(Color.GRAY);

            Animation in = AnimationUtils.loadAnimation(_activity, android.R.anim.slide_in_left);
            Animation out = AnimationUtils.loadAnimation(_activity, android.R.anim.slide_out_right);
            _imageSwitcher.setInAnimation(in);
            _imageSwitcher.setOutAnimation(out);
            _imageSwitcher.setImageResource(R.drawable.ic_drawer);

        }
    }
}
