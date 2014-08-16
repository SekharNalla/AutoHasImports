package com.AutoHasImports.android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.AutoHasImports.android.R;
import com.google.inject.Inject;

import java.util.ArrayList;

import roboguice.RoboGuice;

/**
 * Created by Sekhar on 8/11/14.
 */

public class NavigationListAdapter extends BaseAdapter {

    private Context _context;
    private ArrayList<String> _navigationList;

    @Inject
    LayoutInflater inflater;

    public NavigationListAdapter(Context context, ArrayList<String> navigationList) {

        _context = context;
        _navigationList = navigationList;

        /** This helps us using Roboguice injects where we cannot extend RoboClasses */
        RoboGuice.getInjector(_context).injectMembers(this);
    }

    @Override
    public int getCount() {
        return _navigationList.size();
    }

    @Override
    public Object getItem(int positon) {
        return _navigationList.get(positon);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.navigation_list_item, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(_navigationList.get(i));

        return convertView;
    }
}
