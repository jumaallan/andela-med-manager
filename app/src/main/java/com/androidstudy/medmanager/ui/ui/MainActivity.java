package com.androidstudy.medmanager.ui.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.androidstudy.medmanager.R;
import com.androidstudy.medmanager.data.model.Medicine;
import com.androidstudy.medmanager.ui.adapter.DailyMedicineStatisticsAdapter;
import com.androidstudy.medmanager.ui.ui.medicine.AddMedicineActivity;
import com.androidstudy.medmanager.ui.viewmodel.MedicineViewModel;
import com.androidstudy.medmanager.util.CirclePagerIndicatorDecoration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.recyclerViewDailyMedicineStatistics)
    RecyclerView recyclerViewDailyMedicineStatistics;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    private MedicineViewModel medicineViewModel;
    private DailyMedicineStatisticsAdapter dailyMedicineStatisticsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("EEEE, MMM d, yyyy");
        String currentDate = simpleDateFormat.format(calendar.getTime());
        date.setText(currentDate);

        dailyMedicineStatisticsAdapter = new DailyMedicineStatisticsAdapter(this, new ArrayList<Medicine>());

        recyclerViewDailyMedicineStatistics.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        // add pager behavior
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerViewDailyMedicineStatistics);
        // pager indicator
        recyclerViewDailyMedicineStatistics.addItemDecoration(new CirclePagerIndicatorDecoration());

        recyclerViewDailyMedicineStatistics.setAdapter(dailyMedicineStatisticsAdapter);

        medicineViewModel = ViewModelProviders.of(this).get(MedicineViewModel.class);
        medicineViewModel.getMedicineList().observe(MainActivity.this, medicineList -> dailyMedicineStatisticsAdapter.addItems(medicineList));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent medicine = new Intent(getApplicationContext(), AddMedicineActivity.class);
            startActivity(medicine);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //TODO :: Remove this later :)
    //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                       .setAction("Action", null).show();
}
