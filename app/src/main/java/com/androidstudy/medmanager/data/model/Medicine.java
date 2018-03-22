package com.androidstudy.medmanager.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Medicine {
    @PrimaryKey(autoGenerate = true) private long medicineId;
    private String medicineName;
}
