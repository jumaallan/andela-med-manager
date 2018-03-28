package com.androidstudy.medmanager.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.androidstudy.medmanager.data.model.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void addUser(User user);
}
