package com.AutoHasImports.android;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Sekhar on 8/11/14.
 */
public class AutoHasApplication extends Application {

    private Context _context;

    private static AutoHasApplication _application;

    public static AutoHasApplication getApplication() {
        if (_application == null) {
            //this shouldn't be possible
            throw new NullPointerException("_application is null");
        }
        return _application;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        _application = this;

        AutoHasSharedPreferences.init(AutoHasApplication.this);

        _context = getApplicationContext();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
        ImageLoader.getInstance().init(config);

    }

    public Context get_context() {
        return _context;
    }

    }
