package com.AutoHasImports.android;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sekhar on 8/11/14.
 */

public class AutoHasSharedPreferences {

    public static final String FIRST_NAME = "FirstName";

    public static final String LAST_NAME = "LastName";

    public static final String CITY = "City";

    public static final String STATE = "State";

    public static final String PHONE_NUMBER = "Phone";

    public static final String EMAIL = "Email";
    
    private static final String EMPTY_STRING_DEFAULT_VALUE = "";

    /** SharedPreference Object */
    private static SharedPreferences _sharedPreferences;

    /** Name of SharedPreferences file */
    private static final String PREFERENCE_NAME = "AutoHasPreferences";


    public static void init(Context context) {
        if (_sharedPreferences == null) {
            /** Get the shared preferences object for AutoHasImports */
            _sharedPreferences = context.getSharedPreferences( PREFERENCE_NAME, Context.MODE_PRIVATE );
        }
    }
    
    public static String getFirstName() {
        return getSharedPreferences(FIRST_NAME);
    }

    public static String getLastName() {
        return getSharedPreferences(LAST_NAME);
    }

    public static String getCity() {
        return getSharedPreferences(CITY);
    }

    public static String getState() {
        return getSharedPreferences(STATE);
    }

    public static String getPhoneNumber() {
        return getSharedPreferences(PHONE_NUMBER);
    }

    public static String getEmail() {
        return getSharedPreferences(EMAIL);
    }

    public static void setFirstName(String value) {
        setSharedPreferences(FIRST_NAME, value);
    }

    public static void setLastName(String value) {
        setSharedPreferences(LAST_NAME, value);
    }

    public static void setCity(String value) {
        setSharedPreferences(CITY, value);
    }

    public static void setState(String value) {
        setSharedPreferences(STATE, value);
    }

    public static void setPhoneNumber(String value) {
        setSharedPreferences(PHONE_NUMBER, value);
    }

    public static void setEmail(String value) {
        setSharedPreferences(EMAIL, value);
    }

    private static String getSharedPreferences(String key) {
        return  _sharedPreferences.getString(key, EMPTY_STRING_DEFAULT_VALUE);
    }

    private static void setSharedPreferences(String key, String value) {
        SharedPreferences.Editor editor = _sharedPreferences.edit();
        editor.putString(key, value).commit();
    }
}
