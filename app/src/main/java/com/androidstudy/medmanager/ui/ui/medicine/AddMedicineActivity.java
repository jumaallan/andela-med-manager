package com.androidstudy.medmanager.ui.ui.medicine;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.androidstudy.medmanager.R;
import com.androidstudy.medmanager.data.model.Medicine;
import com.androidstudy.medmanager.ui.ui.MainActivity;
import com.androidstudy.medmanager.ui.viewmodel.AddMedicineViewModel;

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

    String name, description, interval;
    private AddMedicineViewModel addMedicineViewModel;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        ButterKnife.bind(this);

        addMedicineViewModel = ViewModelProviders.of(this).get(AddMedicineViewModel.class);
        calendar = Calendar.getInstance();

        buttonContinue.setOnClickListener(view -> validateMedicalDetails());
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
        addMedicineViewModel.addMedicine(new Medicine(
                Long.parseLong("123"),
                Long.parseLong("123"),
                name,
                description,
                interval,
                "",
                ""
        ));

        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
    }
}
