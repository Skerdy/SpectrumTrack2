package com.example.w2020skerdjan.spectrumtrack.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.w2020skerdjan.spectrumtrack.Adapters.DashboardAdapter;
import com.example.w2020skerdjan.spectrumtrack.Adapters.DefaultListAdapter;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.Utils.DemoUtils;
import com.felipecsl.asymmetricgridview.library.Utils;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;

/**
 * Created by W2020 Android on 12/6/2017.
 */

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    AsymmetricGridView dashboardGrid;
    private DashboardAdapter adapter;
    private DemoUtils demoUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dashboardGrid = (AsymmetricGridView) view.findViewById(R.id.listView);
        dashboardGrid.setAllowReordering(false);
        demoUtils= new DemoUtils();
        adapter=new DefaultListAdapter(getActivity(), demoUtils.moarItems(5) );
        dashboardGrid.setRequestedColumnCount(1);
        dashboardGrid.setRequestedHorizontalSpacing(Utils.dpToPx(getActivity(), 0));
        dashboardGrid.setAdapter(getNewAdapter());
        dashboardGrid.setDebugging(true);
        dashboardGrid.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        adapter =null;
    }

    private void setNumColumns(int numColumns) {
        dashboardGrid.setRequestedColumnCount(numColumns);
        dashboardGrid.determineColumns();
        dashboardGrid.setAdapter(getNewAdapter());
    }

    private AsymmetricGridViewAdapter getNewAdapter() {
        return new AsymmetricGridViewAdapter(getActivity(), dashboardGrid, adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item " + position + " clicked", Toast.LENGTH_SHORT).show();
    }
}
