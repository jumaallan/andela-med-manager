package com.androidstudy.medmanager.ui.base.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.androidstudy.medmanager.data.AppDatabase;

public class MainViewModel extends AndroidViewModel {
    private AppDatabase appDatabase;

    public MainViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());
    }


}
