package com.androidstudy.medmanager.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidstudy.medmanager.R;
import com.androidstudy.medmanager.data.model.Medicine;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyMedicineStatisticsAdapter extends RecyclerView.Adapter<DailyMedicineStatisticsAdapter.MedicineHolder> implements View.OnClickListener {
    private Context context;
    private List<Medicine> medicineList;

    public DailyMedicineStatisticsAdapter(Context context, List<Medicine> medicineList) {
        this.context = context;
        this.medicineList = medicineList;
    }

    @Override
    public MedicineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_daily_medicine_statistics, parent, false);
        return new MedicineHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicineHolder holder, int position) {
        Medicine menuItem = medicineList.get(position);
//
//        holder.textViewTarget.setText(String.valueOf(menuItem.getTarget()));
//        holder.textViewActual.setText(String.valueOf(menuItem.getActual()));
//        holder.textViewRealization.setText(String.valueOf(menuItem.getRealization()) + "%");
    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    @Override
    public void onClick(View v) {

    }

    class MedicineHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewTarget)
        TextView textViewTarget;
        @BindView(R.id.textViewActual)
        TextView textViewActual;
        @BindView(R.id.textViewRealization)
        TextView textViewRealization;

        public MedicineHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
