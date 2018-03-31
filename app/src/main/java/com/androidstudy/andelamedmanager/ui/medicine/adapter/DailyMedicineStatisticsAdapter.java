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

public class DailyMedicineStatisticsAdapter extends RecyclerView.Adapter<DailyMedicineStatisticsAdapter.MedicineHolder> implements View.OnClickListener {
    CustomItemClickListener listener;
    private Context context;
    private List<Medicine> medicineList;

    public DailyMedicineStatisticsAdapter(Context context, List<Medicine> medicineList, CustomItemClickListener listener) {
        this.context = context;
        this.medicineList = medicineList;
        this.listener = listener;
    }

    @Override
    public MedicineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_daily_medicine_statistics, parent, false);
        final MedicineHolder mViewHolder = new MedicineHolder(view);
        view.setOnClickListener(v -> listener.onItemClick(v, mViewHolder.getPosition()));
        return new MedicineHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicineHolder holder, int position) {
        Medicine medicine = medicineList.get(position);

        holder.textViewMedicineName.setText(String.valueOf(medicine.getName()));
    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public void addItems(List<Medicine> medicineList) {
        this.medicineList = medicineList;
        notifyDataSetChanged();
    }

    class MedicineHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewMedicineName)
        TextView textViewMedicineName;

        public MedicineHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
