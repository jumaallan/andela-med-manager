package com.androidstudy.andelamedmanager.ui.medicine.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;

import com.androidstudy.andelamedmanager.R;
import com.androidstudy.andelamedmanager.base.ThemableActivity;
import com.androidstudy.andelamedmanager.data.model.Medicine;
import com.androidstudy.andelamedmanager.ui.main.adapter.CustomItemClickListener;
import com.androidstudy.andelamedmanager.ui.medicine.adapter.MonthlyIntakeAdapter;
import com.androidstudy.andelamedmanager.ui.medicine.viewmodel.MedicineViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MonthlyIntakeActivity extends ThemableActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.layout_empty)
    FrameLayout layout_empty;
    @BindView(R.id.searchViewMedicine)
    SearchView searchViewMedicine;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    MonthlyIntakeAdapter monthlyIntakeAdapter;
    private List<Medicine> medicineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_intake);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.activity_monthly_intake));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        MedicineViewModel medicineViewModel = ViewModelProviders.of(this).get(MedicineViewModel.class);
        medicineViewModel.getMedicineList().observe(this, medicines -> {
            if (MonthlyIntakeActivity.this.medicineList == null) {
                setListData(medicines);
            }
        });

        loadSearch();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        onBackPressed();
        return true;
    }

    public void setListData(final List<Medicine> medicineList) {
        this.medicineList = medicineList;

        if (medicineList.isEmpty()) {
            layout_empty.setVisibility(View.VISIBLE);
        }

        monthlyIntakeAdapter = new MonthlyIntakeAdapter(this, medicineList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Medicine medicine = medicineList.get(position);
                Intent intent = new Intent(getApplicationContext(), MedicineActivity.class);
                Bundle b = new Bundle();

                b.putString("name", medicine.getName());
                b.putString("description", medicine.getDescription());
                b.putString("interval", medicine.getInterval());
                b.putString("pills", medicine.getPills());
                b.putString("pillsTaken", medicine.getPillsTaken());
                b.putBoolean("true", medicine.isHasNotification());
                b.putString("startDate", medicine.getStartDate());
                b.putString("endDate", medicine.getEndDate());
                b.putInt("days", medicine.getDays());
                intent.putExtras(b);
                startActivity(intent);

            }
        });
        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(monthlyIntakeAdapter);
    }

    /**
     * Setup search view.
     */
    private void loadSearch() {
        searchViewMedicine.setFocusable(false);
        //adding search listener
        searchViewMedicine.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                monthlyIntakeAdapter.getFilter().filter(query);
                return false;
            }
        });
    }
}
