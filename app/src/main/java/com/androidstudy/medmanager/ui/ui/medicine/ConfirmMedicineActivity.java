package com.androidstudy.medmanager.ui.ui.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.androidstudy.medmanager.R;
import com.androidstudy.medmanager.ui.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmMedicineActivity extends AppCompatActivity {

    @BindView(R.id.buttonAddMedicine)
    Button buttonAddMedicine;
    @BindView(R.id.buttonHomePage)
    Button buttonHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_medicine);
        ButterKnife.bind(this);

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
