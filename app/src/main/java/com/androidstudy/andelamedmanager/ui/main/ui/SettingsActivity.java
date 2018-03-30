package com.androidstudy.andelamedmanager.ui.main.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.androidstudy.andelamedmanager.R;
import com.androidstudy.andelamedmanager.base.ThemableActivity;
import com.androidstudy.andelamedmanager.view.SettingsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends ThemableActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.activity_add_medicine));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new SettingsFragment())
                    .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        onBackPressed();
        return true;
    }
}
