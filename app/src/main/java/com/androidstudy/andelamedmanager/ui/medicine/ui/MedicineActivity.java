package com.androidstudy.andelamedmanager.ui.medicine.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.androidstudy.andelamedmanager.R;
import com.androidstudy.andelamedmanager.base.ThemableActivity;
import com.androidstudy.andelamedmanager.data.model.MedData;
import com.androidstudy.andelamedmanager.ui.medicine.adapter.MedicineSparkAdapter;
import com.robinhood.spark.SparkView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MedicineActivity extends ThemableActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.textViewMedicineName)
    TextView textViewMedicineName;
    @BindView(R.id.sparkView)
    SparkView sparkView;

    private List<MedData> medDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.activity_add_medicine));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        medDataList = getDummyMedData();

        setupSparkView();

        Intent in = getIntent();
        Bundle b = in.getExtras();

        assert b != null;
        textViewMedicineName.setText(b.getString("name"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        onBackPressed();
        return true;
    }

    private void setupSparkView() {
        MedicineSparkAdapter adapter = new MedicineSparkAdapter(medDataList);
        sparkView.setAdapter(adapter);
    }

    private List<MedData> getDummyMedData() {
        List<MedData> listViewItems = new ArrayList<>();
        listViewItems.add(new MedData(2L, 5L));
        listViewItems.add(new MedData(3L, 4L));
        listViewItems.add(new MedData(1L, 8L));
        return listViewItems;
    }
}
