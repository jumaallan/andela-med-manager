package com.androidstudy.medmanager.ui.medicine.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidstudy.medmanager.R;
import com.androidstudy.medmanager.data.model.Medicine;
import com.androidstudy.medmanager.ui.medicine.viewmodel.AddMedicineViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmMedicineActivity extends AppCompatActivity {

    @BindView(R.id.textViewMedName)
    TextView textViewMedName;
    @BindView(R.id.textViewMedDescription)
    TextView textViewMedDescription;
    @BindView(R.id.textViewMedInterval)
    TextView textViewMedInterval;
    @BindView(R.id.textViewMedStartDate)
    TextView textViewMedStartDate;
    @BindView(R.id.textViewMedEndDate)
    TextView textViewMedEndDate;
    @BindView(R.id.buttonEditMedicine)
    Button buttonEditMedicine;
    @BindView(R.id.buttonSaveMedicine)
    Button buttonSaveMedicine;
    String name, description, interval, startDate, endDate;
    Bundle bundle;
    private AddMedicineViewModel addMedicineViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_medicine);
        ButterKnife.bind(this);

        addMedicineViewModel = ViewModelProviders.of(this).get(AddMedicineViewModel.class);

        Intent intent = getIntent();
        bundle = intent.getExtras();

        assert bundle != null;
        name = bundle.getString("name");
        description = bundle.getString("description");
        interval = bundle.getString("interval");
//        startDate = bundle.getString("startDate");
//        endDate = bundle.getString("endDate");

        textViewMedName.setText(name);
        textViewMedDescription.setText(description);
        textViewMedInterval.setText(interval);
//        textViewMedicineStartDate.setText(startDate);
//        textViewMedicineEndDate.setText(endDate);

        /**
         * User needs to edit the details again :)
         */
        buttonEditMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent med = new Intent(ConfirmMedicineActivity.this.getApplicationContext(), AddMedicineActivity.class);
                med.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ConfirmMedicineActivity.this.startActivity(med);
            }
        });

        /**
         * User is happy with the data :) Save :)
         */
        buttonSaveMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmMedicineActivity.this.saveMedicine();
            }
        });
    }

    private void saveMedicine() {
        addMedicineViewModel.addMedicine(new Medicine(
                name,
                description,
                interval
        ));

        Intent success = new Intent(getApplicationContext(), MedicineSuccessActivity.class);
        success.putExtras(bundle);
        startActivity(success);
    }
}
