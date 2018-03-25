package com.androidstudy.medmanager.ui.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.androidstudy.medmanager.R;
import com.androidstudy.medmanager.data.model.MenuView;
import com.androidstudy.medmanager.ui.adapter.DailyMedicineStatisticsAdapter;
import com.androidstudy.medmanager.ui.adapter.MainDashboardAdapter;
import com.androidstudy.medmanager.ui.ui.medicine.AddMedicineActivity;
import com.androidstudy.medmanager.ui.viewmodel.MedicineViewModel;
import com.androidstudy.medmanager.util.CirclePagerIndicatorDecoration;
import com.androidstudy.medmanager.util.ItemOffsetDecoration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.recyclerViewDailyMedicineStatistics)
    RecyclerView recyclerViewDailyMedicineStatistics;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    List<MenuView> menuViewList;
    private DailyMedicineStatisticsAdapter dailyMedicineStatisticsAdapter;
    private MainDashboardAdapter mainDashboardAdapter;

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

        menuViewList = getMenuOptions();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);

        mainDashboardAdapter = new MainDashboardAdapter(this, menuViewList, (v, position) -> {
            MenuView role = menuViewList.get(position);
            String menuName = role.getName();
            switch (menuName) {
                case "Add Medicine":
                    Intent addMedicine = new Intent(getApplicationContext(), AddMedicineActivity.class);
                    startActivity(addMedicine);
                    break;
                case "Profile":
                    break;
                case "Reminders":
                    break;
                case "Monthly Intake":
                    break;
                default:
                    Toast.makeText(MainActivity.this, "Sorry, It's Under development", Toast.LENGTH_SHORT).show();
                    break;
            }

        });
        recyclerView.setAdapter(mainDashboardAdapter);

        dailyMedicineStatisticsAdapter = new DailyMedicineStatisticsAdapter(this, new ArrayList<>());
        recyclerViewDailyMedicineStatistics.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        // add pager behavior
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerViewDailyMedicineStatistics);
        // pager indicator
        recyclerViewDailyMedicineStatistics.addItemDecoration(new CirclePagerIndicatorDecoration());
        recyclerViewDailyMedicineStatistics.setAdapter(dailyMedicineStatisticsAdapter);

        MedicineViewModel medicineViewModel = ViewModelProviders.of(this).get(MedicineViewModel.class);
        medicineViewModel.getMedicineList().observe(MainActivity.this, medicineList -> dailyMedicineStatisticsAdapter.addItems(medicineList));
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

    //Mock Data
    private List<MenuView> getMenuOptions() {
        List<MenuView> listViewItems = new ArrayList<>();
        listViewItems.add(new MenuView(1, "Add Medicine", R.drawable.ic_sample));
        listViewItems.add(new MenuView(2, "Profile", R.drawable.ic_sample));
        listViewItems.add(new MenuView(3, "Reminders", R.drawable.ic_sample));
        listViewItems.add(new MenuView(4, "Monthly Intake", R.drawable.ic_sample));
        return listViewItems;
    }
}
