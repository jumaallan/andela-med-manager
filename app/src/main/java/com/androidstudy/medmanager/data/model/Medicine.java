package com.androidstudy.medmanager.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Medicine {
    @PrimaryKey(autoGenerate = true)u
    // private long userId;
    private String name;
    private String description;
    private String interval;
//    private String startDate;
//    private String endDate;


    public Medicine(String name, String description, String interval) {
        this.name = name;
        this.description = description;
        this.interval = interval;
    }

    public long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(long medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }
}
