package com.androidstudy.medmanager;

import android.app.Application;

import com.androidstudy.medmanager.data.AppDatabase;

import timber.log.Timber;


public class MedManager extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Plant a Debug Timber Tree to log :)
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
