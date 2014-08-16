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
 * Created by Sekhar on 8/13/14.
 */

public class PriceSortGridAdapter extends BaseAdapter {

    private Context _context;
    private ArrayList<String> _pricesArray;

    @Inject  LayoutInflater layoutInflater;

    public PriceSortGridAdapter (Context context, ArrayList<String> pricesArray) {
        _context = context;
        _pricesArray = pricesArray;

        /** This helps us using Roboguice injects where we cannot extend RoboClasses */
        RoboGuice.getInjector(_context).injectMembers(this);
    }

    @Override
    public int getCount() {
        return _pricesArray.size();
    }

    @Override
    public Object getItem(int position) {
        return _pricesArray.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.price_view_grid, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView_price_grid);
        textView.setText(_pricesArray.get(position));
        return null;
    }
}
