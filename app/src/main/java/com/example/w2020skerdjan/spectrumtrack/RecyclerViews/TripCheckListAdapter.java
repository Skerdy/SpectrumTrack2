package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Fragments.TripCheckListFragment;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.TripDetailsItem;
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

public TripCheckListAdapter(Context ctx, List<VehicleEquipment> vE) {
        this.vehicleEquipments = vE;
        this.ctx = ctx;
        }


    @Override
    public TripCheckListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv=  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.equipment_item, parent, false);
        return  new TripCheckListAdapter.ViewHolder(cv);
     }

    @Override
    public void onBindViewHolder(TripCheckListAdapter.ViewHolder holder, int position) {
        VehicleEquipment vehicleEquipment = vehicleEquipments.get(position);
        holder.equipmentName.setText(vehicleEquipment.getEquipment());
        holder.equipmentQuantity.setText(" of "+vehicleEquipment.getQuantity());
        holder.equipmentQuantity.setChecked(false);
        holder.quantityEditor.setText(""+vehicleEquipment.getMinimalAmount());
    }

    @Override
    public int getItemCount() {
        return vehicleEquipments.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView equipmentName;
        private CheckedTextView equipmentQuantity;
        private EditText quantityEditor;
        public ViewHolder(View v) {
            super(v);
            equipmentName = (TextView) v.findViewById(R.id.equipmentName);
            equipmentQuantity = (CheckedTextView) v.findViewById(R.id.checkQuantity);
            quantityEditor = (EditText) v.findViewById(R.id.quantityEditor);
        }

    }
}
