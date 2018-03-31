package com.androidstudy.andelamedmanager.ui.medicine.adapter;

import com.androidstudy.andelamedmanager.data.model.MedData;
import com.robinhood.spark.SparkAdapter;

import java.util.List;

public class MedicineSparkAdapter extends SparkAdapter {
    private List<MedData> yData;

    public MedicineSparkAdapter(List<MedData> yData) {
        this.yData = yData;
    }

    @Override
    public int getCount() {
        return yData == null ? 0 : yData.size();
    }

    @Override
    public MedData getItem(int index) {
        return yData.get(index);
    }

    @Override
    public float getY(int index) {
        return getItem(index).getPills();
    }
}