package com.androidstudy.andelamedmanager.data.model;

public class MedData {
    private float pillsTaken;
    private float pills;

    public MedData(float pillsTaken, float pills) {
        this.pillsTaken = pillsTaken;
        this.pills = pills;
    }

    public float getPillsTaken() {
        return pillsTaken;
    }

    public void setPillsTaken(float pillsTaken) {
        this.pillsTaken = pillsTaken;
    }

    public float getPills() {
        return pills;
    }

    public void setPills(float pills) {
        this.pills = pills;
    }
}
