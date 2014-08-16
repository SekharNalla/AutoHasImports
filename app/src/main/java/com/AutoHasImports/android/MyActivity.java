package com.AutoHasImports.android;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.AutoHasImports.android.Adapters.NavigationListAdapter;
import com.AutoHasImports.android.Constants.ActivityTitles;
import com.AutoHasImports.android.Constants.NavigationList;
import com.AutoHasImports.android.Fragments.CarFinderFragment;
import com.AutoHasImports.android.Fragments.ContactUsFragment;
import com.AutoHasImports.android.Fragments.DirectionsFragment;
import com.AutoHasImports.android.Fragments.HomeFragment;
import com.AutoHasImports.android.Fragments.InventoryFragment;
import com.AutoHasImports.android.Fragments.SpecialsFragment;

import java.util.ArrayList;

import roboguice.activity.RoboFragmentActivity;


public class MyActivity extends RoboFragmentActivity {

    private String[] _navigatonList;
    private DrawerLayout _drawerLayout;
    private ListView _navigationListView;
    private ActionBarDrawerToggle _drawerToggle;
    private NavigationListAdapter _navigationListAdapter;
    private ArrayList<String> _navigationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        _navigatonList = getResources().getStringArray(R.array.navigation_list);
        _drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        _navigationListView = (ListView) findViewById(R.id.left_drawer);
        // set a custom shadow that overlays the main content when the drawer opens
        _drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        _navigationArrayList = new ArrayList<String>();
        populateArrayList();

        _navigationListAdapter = new NavigationListAdapter(getApplicationContext(), _navigationArrayList);
        _navigationListView.setAdapter(_navigationListAdapter);

        _drawerToggle = new ActionBarDrawerToggle(this, _drawerLayout, R.drawable.ic_navigation_drawer, R.string.open, R.string.close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };

        _drawerLayout.setDrawerListener(_drawerToggle);
        _navigationListView.setOnItemClickListener(new NavigationClickListener());

        /* Open and close with App icon */
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            selectItem(NavigationList.HOME);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

         /** Open and close with App icon */
        if (_drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class NavigationClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {

        switch (position) {

            case NavigationList.HOME:

                HomeFragment homeFragment = new HomeFragment();
                Bundle args = new Bundle();
                homeFragment.setArguments(args);

                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().add(R.id.content_frame, homeFragment).addToBackStack("stack").commit();

                _navigationListView.setItemChecked(position, true);
                setTitle(ActivityTitles.HOME.toString());
                _drawerLayout.closeDrawer(_navigationListView);
                _navigationListView.setItemChecked(position, true);

                break;

            case NavigationList.INVENTORY:

                InventoryFragment inventoryFragment = new InventoryFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().add(R.id.content_frame, inventoryFragment).addToBackStack("stack").commit();

                _navigationListView.setItemChecked(position, true);
                setTitle(ActivityTitles.INVENTORY.toString());
                _drawerLayout.closeDrawer(_navigationListView);
                break;

            case NavigationList.SPECIALS:

                SpecialsFragment specialsFragment = new SpecialsFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().add(R.id.content_frame, specialsFragment).addToBackStack("stack").commit();

                _navigationListView.setItemChecked(position, true);
                setTitle(ActivityTitles.SPECIALS.toString());
                _drawerLayout.closeDrawer(_navigationListView);
                break;

            case NavigationList.CAR_FINDER:

                CarFinderFragment carFinderFragment = new CarFinderFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().add(R.id.content_frame, carFinderFragment).addToBackStack("stack").commit();

                _navigationListView.setItemChecked(position, true);
                setTitle(ActivityTitles.CAR_FINDER.toString());
                _drawerLayout.closeDrawer(_navigationListView);
                break;

            case NavigationList.DIRECTIONS:

                DirectionsFragment directionsFragment = new DirectionsFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().add(R.id.content_frame, directionsFragment).addToBackStack("stack").commit();

                _navigationListView.setItemChecked(position, true);
                setTitle(ActivityTitles.DIRECTIONS.toString());
                _drawerLayout.closeDrawer(_navigationListView);

                break;

            case NavigationList.CONTACT_US:

                ContactUsFragment contactUsFragment = new ContactUsFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().add(R.id.content_frame, contactUsFragment).addToBackStack("stack").commit();
                _navigationListView.setItemChecked(position, true);
                setTitle(ActivityTitles.CONTACT_US.toString());
                _drawerLayout.closeDrawer(_navigationListView);
                break;
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        getActionBar().setTitle(title);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = _drawerLayout.isDrawerOpen(_navigationListView);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        // makes those three lines shrink in when the drawer is opened
        _drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        _drawerToggle.onConfigurationChanged(newConfig);
    }

    private void populateArrayList() {
        _navigationArrayList.add(ActivityTitles.HOME.toString());
        _navigationArrayList.add(ActivityTitles.INVENTORY.toString());
        _navigationArrayList.add(ActivityTitles.CAR_FINDER.toString());
        _navigationArrayList.add(ActivityTitles.SPECIALS.toString());
        _navigationArrayList.add(ActivityTitles.DIRECTIONS.toString());
        _navigationArrayList.add(ActivityTitles.CONTACT_US.toString());
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        if(_drawerLayout.isDrawerOpen(Gravity.LEFT)){
            _drawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            super.onBackPressed();
        }
    }
}
