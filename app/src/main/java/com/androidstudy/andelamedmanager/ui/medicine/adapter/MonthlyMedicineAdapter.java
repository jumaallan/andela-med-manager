package com.androidstudy.andelamedmanager.ui.medicine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidstudy.andelamedmanager.R;
import com.androidstudy.andelamedmanager.data.model.Medicine;
import com.androidstudy.andelamedmanager.ui.main.adapter.CustomItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MonthlyMedicineAdapter extends RecyclerView.Adapter<MonthlyMedicineAdapter.MedicineViewHolder> {
    CustomItemClickListener listener;
    Context context;
    private List<Medicine> medicineList;

    public MonthlyMedicineAdapter(Context context, List<Medicine> medicineList, CustomItemClickListener listener) {
        this.context = context;
        this.medicineList = medicineList;
        this.listener = listener;
    }

    @Override
    public MonthlyMedicineAdapter.MedicineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_monthly_medicine, parent, false);
        final MonthlyMedicineAdapter.MedicineViewHolder mViewHolder = new MonthlyMedicineAdapter.MedicineViewHolder(itemView);
        itemView.setOnClickListener(v -> listener.onItemClick(v, mViewHolder.getPosition()));
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final MonthlyMedicineAdapter.MedicineViewHolder holder, final int position) {
        final Medicine medicine = medicineList.get(position);

        holder.textViewMedicineName.setText(medicine.getName());
        holder.textViewMedicineDescription.setText(medicine.getDescription());
        holder.textViewMedicineInterval.setText(medicine.getInterval() + " Times");
    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    class MedicineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewMedicineName)
        TextView textViewMedicineName;
        @BindView(R.id.textViewMedicineDescription)
        TextView textViewMedicineDescription;
        @BindView(R.id.textViewMedicineInterval)
        TextView textViewMedicineInterval;

        MedicineViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}

