package com.androidstudy.andelamedmanager.ui.main.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.androidstudy.andelamedmanager.data.AppDatabase;
import com.androidstudy.andelamedmanager.data.model.User;

public class MainViewModel extends AndroidViewModel {

    private User userLiveData;
    private AppDatabase appDatabase;

    public MainViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
        userLiveData = appDatabase.userDao().getUserById("1");
    }

    public User getUserLiveData() {
        return userLiveData;
    }
}
