package com.androidstudy.andelamedmanager.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.androidstudy.andelamedmanager.data.dao.MedicineDao;
import com.androidstudy.andelamedmanager.data.dao.UserDao;
import com.androidstudy.andelamedmanager.data.model.Medicine;
import com.androidstudy.andelamedmanager.data.model.User;

@Database(entities = {Medicine.class, User.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "medmanager_db")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public abstract MedicineDao medicineDao();

    public abstract UserDao userDao();
}