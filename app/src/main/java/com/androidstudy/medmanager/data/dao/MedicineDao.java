package com.androidstudy.medmanager.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.androidstudy.medmanager.data.model.Medicine;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MedicineDao {

    //Get all Medicine
    @Query("SELECT * FROM Medicine")
    LiveData<List<Medicine>> getAllMedicine();

    @Insert(onConflict = REPLACE)
    void addMedicine(Medicine medicine);
}
