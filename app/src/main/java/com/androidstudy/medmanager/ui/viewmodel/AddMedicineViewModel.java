package com.androidstudy.medmanager.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import com.androidstudy.medmanager.data.AppDatabase;
import com.androidstudy.medmanager.data.model.Medicine;


public class AddMedicineViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddMedicineViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    public void addMedicine(final Medicine medicine) {
        new addAsyncTask(appDatabase).execute(medicine);
    }

    private static class addAsyncTask extends AsyncTask<Medicine, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Medicine... params) {
            db.medicineDao().addMedicine(params[0]);
            return null;
        }

    }
}
