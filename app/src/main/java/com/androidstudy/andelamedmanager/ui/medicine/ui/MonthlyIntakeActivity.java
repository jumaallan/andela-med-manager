package com.androidstudy.andelamedmanager.ui.medicine.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.androidstudy.andelamedmanager.R;
import com.androidstudy.andelamedmanager.data.model.Medicine;
import com.androidstudy.andelamedmanager.ui.main.adapter.CustomItemClickListener;
import com.androidstudy.andelamedmanager.ui.medicine.adapter.MonthlyIntakeAdapter;
import com.androidstudy.andelamedmanager.ui.medicine.viewmodel.MedicineViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MonthlyIntakeActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

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

        //TODO::USE GRIDS
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        onBackPressed();
        return true;
    }
}
