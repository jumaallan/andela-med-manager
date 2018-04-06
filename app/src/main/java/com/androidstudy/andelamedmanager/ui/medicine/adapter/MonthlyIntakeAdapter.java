package com.androidstudy.andelamedmanager.ui.medicine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.androidstudy.andelamedmanager.R;
import com.androidstudy.andelamedmanager.data.model.Medicine;
import com.androidstudy.andelamedmanager.ui.main.adapter.CustomItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MonthlyIntakeAdapter extends RecyclerView.Adapter<MonthlyIntakeAdapter.MedicineViewHolder> implements Filterable {
    CustomItemClickListener listener;
    private List<Medicine> medicineList;
    private List<Medicine> medicineListFiltered;

    public MonthlyIntakeAdapter(Context context, List<Medicine> medicineList, CustomItemClickListener listener) {
        Context context1 = context;
        this.medicineList = medicineList;
        this.medicineListFiltered = medicineList;
        this.listener = listener;
    }

    @Override
    public MedicineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_monthly_intake, parent, false);
        final MedicineViewHolder mViewHolder = new MedicineViewHolder(itemView);
        itemView.setOnClickListener(v -> listener.onItemClick(v, mViewHolder.getPosition()));
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final MedicineViewHolder holder, final int position) {
        final Medicine medicine = medicineListFiltered.get(position);

        holder.textViewMedicineName.setText(medicine.getName());
        holder.textViewMedicineInterval.setText(medicine.getInterval());

    }

    @Override
    public int getItemCount() {
        return medicineListFiltered.size();
    }

    /**
     * Remove all elements from the list.
     */
    public void clear() {
        final int size = getItemCount();
        medicineList.clear();
        medicineListFiltered.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void setItems(List<Medicine> items) {
        this.clear();
        this.medicineList = items;
        this.medicineListFiltered = items;
        this.notifyDataSetChanged();
    }

    //method filter
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    medicineListFiltered = medicineList;
                } else {
                    List<Medicine> filteredList = new ArrayList<>();
                    for (Medicine row : medicineList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    medicineListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = medicineListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                medicineListFiltered = (ArrayList<Medicine>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class MedicineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewMedicineName)
        TextView textViewMedicineName;
        @BindView(R.id.textViewMedicineInterval)
        TextView textViewMedicineInterval;
        @BindView(R.id.textViewMedicinePercentage)
        TextView textViewMedicinePercentage;

        MedicineViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
