package com.androidstudy.medmanager.ui.ui.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.androidstudy.medmanager.R;
import com.androidstudy.medmanager.ui.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MedicineSuccessActivity extends AppCompatActivity {

    @BindView(R.id.textViewMedicineName)
    TextView textViewMedicineName;
    @BindView(R.id.textViewMedicineDescription)
    TextView textViewMedicineDescription;
    @BindView(R.id.textViewMedicineInterval)
    TextView textViewMedicineInterval;
    @BindView(R.id.textViewMedicineStartDate)
    TextView textViewMedicineStartDate;
    @BindView(R.id.textViewMedicineEndDate)
    TextView textViewMedicineEndDate;
    @BindView(R.id.buttonAddMedicine)
    Button buttonAddMedicine;
    @BindView(R.id.buttonHomePage)
    Button buttonHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_success);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        assert bundle != null;
        textViewMedicineName.setText(bundle.getString("name"));
        textViewMedicineDescription.setText(bundle.getString("description"));
        textViewMedicineInterval.setText(bundle.getString("interval"));
//        textViewMedicineStartDate.setText(bundle.getString("startDate"));
//        textViewMedicineEndDate.setText(bundle.getString("endDate"));

        /**
         * Redirect to add another medicine!
         */
        buttonAddMedicine.setOnClickListener(view -> {
            Intent addMedicine = new Intent(getApplicationContext(), AddMedicineActivity.class);
            startActivity(addMedicine);
            finish();
        });

        /**
         * Redirect back to home page, User is satisfied/done!
         */
        buttonHomePage.setOnClickListener(view -> {
            Intent home = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(home);
            finish();
        });
    }
}
