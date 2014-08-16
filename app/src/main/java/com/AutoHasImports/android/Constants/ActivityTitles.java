package com.AutoHasImports.android.Constants;

/**
 * Created by Sekhar on 8/10/14.
 */

public enum ActivityTitles {

    HOME("Home"),
    INVENTORY("Inventory"),
    CAR_FINDER("Car Finder"),
    SPECIALS("Specials"),
    DIRECTIONS("Directions"),
    CONTACT_US("Contact Us");

    private String _name;

    private ActivityTitles(String name) { this._name = name; }

    @Override
    public String toString() {
        return _name;
    }
}
