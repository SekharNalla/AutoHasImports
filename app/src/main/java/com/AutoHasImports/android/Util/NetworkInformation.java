package com.AutoHasImports.android.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.AutoHasImports.android.AutoHasApplication;


/**
 * Created by Sekhar on 8/11/14.
 */

public class NetworkInformation {

    private static NetworkInformation _instance;

    private Context _context;

    private NetworkInformation() {
        _context = AutoHasApplication.getApplication().get_context();
    }

    public static synchronized NetworkInformation getInstance() {
        if( _instance == null ) {
            _instance = new NetworkInformation();
        }
        return _instance;
    }

    /**
     * Check for Network Availability.
     *  @return true if Network is Available and usable by us
     */
    public boolean isNetworkAvailable() {
        try {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return (activeNetwork != null && activeNetwork.isAvailable());
        } catch( Exception e) {
            return false;
        }
    }

    /**
     * Check for the Wifi connectivity.
     * @return true if wifi is connected otherwise returns false.
     */
    public boolean isWifiConnected() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return connectivityManager.getNetworkInfo( ConnectivityManager.TYPE_WIFI ).isConnected();
        } catch ( Exception e) {
            return false;
        }
    }

    /**
     * Check for type of internet connection
     * @return connection type
     */
    public String getRadioType() {
        String connection;
        try {
            ConnectivityManager mConnectivity = ( ConnectivityManager ) _context.getSystemService( Context.CONNECTIVITY_SERVICE );
            NetworkInfo info = mConnectivity.getActiveNetworkInfo();
            int type = info.getType();
            if ( type == ConnectivityManager.TYPE_MOBILE ) {
                connection = info.getSubtypeName();
            } else {
                connection = info.getTypeName();
            }
        } catch ( Exception e ) {
            connection = "Unknown";
        }

        return connection;
    }

}
