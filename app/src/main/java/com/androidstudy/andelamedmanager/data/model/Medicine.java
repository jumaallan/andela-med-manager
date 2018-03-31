package com.androidstudy.andelamedmanager.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Medicine {
    @PrimaryKey(autoGenerate = true)
    private long medicineId;
    // private long userId;
    private String name;
    private String description;
    private String interval;
    private String pills;
    private boolean hasNotification;  //User can switch them on/off per Med
    private String startDate;
    private String endDate;

    public Medicine(String name, String description, String interval, String pills, boolean hasNotification, String startDate, String endDate) {
        this.name = name;
        this.description = description;
        this.interval = interval;
        this.pills = pills;
        this.hasNotification = hasNotification;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getPills() {
        return pills;
    }

    public void setPills(String pills) {
        this.pills = pills;
    }

    public boolean isHasNotification() {
        return hasNotification;
    }

    public void setHasNotification(boolean hasNotification) {
        this.hasNotification = hasNotification;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
