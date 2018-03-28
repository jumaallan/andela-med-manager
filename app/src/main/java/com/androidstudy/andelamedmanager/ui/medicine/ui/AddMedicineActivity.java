package com.androidstudy.andelamedmanager.ui.medicine.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.androidstudy.andelamedmanager.R;
import com.androidstudy.andelamedmanager.ui.main.ui.MainActivity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMedicineActivity extends AppCompatActivity {

    @BindView(R.id.editTextMedicineName)
    EditText editTextMedicineName;
    @BindView(R.id.editTextMedicineDescription)
    EditText editTextMedicineDescription;
    @BindView(R.id.editTextMedicineInterval)
    EditText editTextMedicineInterval;
    @BindView(R.id.editTextMedicineStartDate)
    EditText editTextMedicineStartDate;
    @BindView(R.id.editTextMedicineEndDate)
    EditText editTextMedicineEndDate;
    @BindView(R.id.buttonContinue)
    Button buttonContinue;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    String name, description, interval;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        ButterKnife.bind(this);


        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationIcon(upArrow);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.activity_add_medicine));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        calendar = Calendar.getInstance();

        buttonContinue.setOnClickListener(view -> validateMedicalDetails());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        onBackPressed();
        return true;
    }

    private void validateMedicalDetails() {

        name = editTextMedicineName.getText().toString().trim();
        description = editTextMedicineDescription.getText().toString().trim();
        interval = editTextMedicineInterval.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            editTextMedicineName.setError("Please Enter Medicine Name");
            return;
        }

        if (TextUtils.isEmpty(description)) {
            editTextMedicineDescription.setError("Please Enter Medicine Description");
            return;
        }

        if (TextUtils.isEmpty(interval)) {
            editTextMedicineInterval.setError("Please Enter Medicine Interval");
            return;
        }

        saveMedicalData();
    }

    private void saveMedicalData() {
        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);

        Intent medicine = new Intent(this, ConfirmMedicineActivity.class);
        Bundle bundle = new Bundle();
        //TODO :: Change this :)
        /**
         * Pass data via Bundle
         */
        bundle.putString("name", name);
        bundle.putString("description", description);
        bundle.putString("interval", interval);
//        bundle.putString("startDate", startDate);
//        bundle.putString("endDate", endDate);
        medicine.putExtras(bundle);
        startActivity(medicine);
    }
}
