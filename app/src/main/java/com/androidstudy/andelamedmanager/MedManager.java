package com.androidstudy.andelamedmanager;

import android.app.Application;

import com.androidstudy.andelamedmanager.settings.Settings;

import timber.log.Timber;

public class MedManager extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Plant a Debug Timber Tree to log :)
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        // init Settings
        Settings.init(this);
    }
}
