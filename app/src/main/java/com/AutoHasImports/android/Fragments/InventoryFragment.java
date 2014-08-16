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
public class InventoryFragment extends RoboFragment {

    private Activity _activity;

    public InventoryFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.inventory_fragment, container, false);
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
            _activity.getActionBar().setTitle(ActivityTitles.INVENTORY.toString());
        }
    }

}
