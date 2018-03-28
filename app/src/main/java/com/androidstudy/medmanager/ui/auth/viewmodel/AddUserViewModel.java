package com.androidstudy.medmanager.ui.auth.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.androidstudy.medmanager.data.AppDatabase;
import com.androidstudy.medmanager.data.model.Medicine;
import com.androidstudy.medmanager.data.model.User;

import java.util.List;

public class AddUserViewModel extends AndroidViewModel {
    private AppDatabase appDatabase;

    public AddUserViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    public void addUser(final User user) {
        new AddUserViewModel.addAsyncTask(appDatabase).execute(user);
    }

    private static class addAsyncTask extends AsyncTask<User, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final User... params) {
            db.userDao().addUser(params[0]);
            return null;
        }

    }
}
