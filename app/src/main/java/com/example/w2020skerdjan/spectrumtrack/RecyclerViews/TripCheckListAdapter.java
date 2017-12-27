package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.CheckedTextViewModel;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.VehicleEquipment;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W2020 Android on 12/11/2017.
 */

public class TripCheckListAdapter extends RecyclerView.Adapter<TripCheckListAdapter.ViewHolder> {

private List<VehicleEquipment> vehicleEquipments =  new ArrayList<>();
//private ArrayList<TripCheckListFragment> = new ArrayList<>();

private Context ctx;



    private int checkedEquipments=0;

public TripCheckListAdapter(Context ctx, List<VehicleEquipment> vE) {
        this.vehicleEquipments = vE;
        this.ctx = ctx;
        checkedEquipments=0;
        }


    @Override
    public TripCheckListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv=  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.equipment_item, parent, false);
        return  new TripCheckListAdapter.ViewHolder(cv);
     }

    @Override
    public void onBindViewHolder(final TripCheckListAdapter.ViewHolder holder, int position) {
        VehicleEquipment vehicleEquipment = vehicleEquipments.get(position);
        final CheckedTextViewModel checkedTextViewModel = new CheckedTextViewModel(vehicleEquipment.getEquipment());
        checkedTextViewModel.setChecked(false);
        holder.equipmentName.setText(vehicleEquipment.getEquipment());
        holder.equipmentQuantity.setText(" of "+vehicleEquipment.getQuantity());
        holder.quantityEditor.setText(""+vehicleEquipment.getMinimalAmount());
        holder.checkBox.setChecked(false);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkedEquipments++;
                }
                else{
                    checkedEquipments--;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return vehicleEquipments.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView equipmentName;
        private TextView equipmentQuantity;
        private EditText quantityEditor;
        private CheckBox checkBox;
        public ViewHolder(View v) {
            super(v);
            equipmentName = (TextView) v.findViewById(R.id.equipmentName);
            equipmentQuantity = (TextView) v.findViewById(R.id.maxQuantity);
            quantityEditor = (EditText) v.findViewById(R.id.quantityEditor);
            checkBox = (CheckBox) v.findViewById(R.id.checkBox);
        }

    }

    public int getCheckedEquipments() {
        return checkedEquipments;
    }

    public void setCheckedEquipments(int checkedEquipments) {
        this.checkedEquipments = checkedEquipments;
    }
}
