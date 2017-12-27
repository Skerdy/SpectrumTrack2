package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.w2020skerdjan.spectrumtrack.Fragments.PersonalAreaFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripCheckListFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripDetailFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripsFragment;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;
import java.util.ArrayList;
import java.util.List;

public class TripDetails extends BaseActivity {
    private ActionBar actionBar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> fragments = new ArrayList<>();
    private Trip trip;
    private Bundle bundle;
    private boolean checkListFlag = false;
  //  private FragmentPagerAdapter fragmentPagerAdapter;
    private BoomMenuButton bmb;
    private BoomMenuButton bmb1;
    private Button confirmButton;
    private MaterialDialog.Builder builder;
    private MaterialDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);
        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        //bmb1 = (BoomMenuButton) findViewById(R.id.bmb1);
        confirmButton = (Button) findViewById(R.id.confirmButton);
        Intent intent = getIntent();

        bundle = intent.getBundleExtra("Bundle");
        trip= (Trip) bundle.getSerializable("TripPosition");
        fragmentManager = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

      //  ((ViewGroup)scrollChildLayout.getParent()).removeView(scrollChildLayout);
        initTripDetailsFragment();
        configureBoomMenuFinal(false);
       // configureBoomMenuHam();


        bmb.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {
                if(index==0){
                    if(!checkListFlag){
                        checkListFlag=true;
                        initCheckListFragment();
                        configureBoomMenuFinal(true);
                    }
                    else {
                        checkListFlag=false;
                        initTripDetailsFragment();
                        configureBoomMenuFinal(false);
                    }
                }
                else if(index==1){
                   checkAllEquipments();
                }
                else if(index==2){
                    initNewMenu();
                }
            }

            @Override
            public void onBackgroundClick() {

            }

            @Override
            public void onBoomWillHide() {

            }

            @Override
            public void onBoomDidHide() {

            }

            @Override
            public void onBoomWillShow() {

            }

            @Override
            public void onBoomDidShow() {

            }
        });



    }

    private void checkAllEquipments() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return true;
    }
    private void initTripDetailsFragment(){
        confirmButton.setVisibility(View.GONE);
        setTitle("Trip Details");
        fragmentTransaction = fragmentManager.beginTransaction();
        TripDetailFragment fragment1 = TripDetailFragment.newInstance(trip);
        fragmentTransaction.replace(R.id.tripDetailsFragment, fragment1);
        fragmentTransaction.commit();
    }

    private void initCheckListFragment(){
        confirmButton.setVisibility(View.VISIBLE);

        setTitle("Trip Check List");
        fragmentTransaction = fragmentManager.beginTransaction();
        final TripCheckListFragment fragment2 = TripCheckListFragment.newInstance(trip);
        fragmentTransaction.replace(R.id.tripDetailsFragment, fragment2);
        fragmentTransaction.commit();

        //Dialogu
        builder = new MaterialDialog.Builder(this)
                .title("Alert")
                .content("We must be assured that all equipments are checked in order to proceed further!")
                .positiveText("OK");
        dialog = builder.build();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(fragment2.initConfirmationButton()){
                  Log.d("Confirm", "Konfirmimi true");
              }
              else {
                  Log.d("Confirm", "Konfirmimi false");
                  dialog.show();
              }

            }
        });
    }

    private void initNewMenu(){
        Intent intent = new Intent(TripDetails.this, TripCommands.class);
        startActivity(intent);
    }

    private void configureBoomMenu(boolean isEquipmentFragment){

        if(isEquipmentFragment){
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.check_list_icon).normalText("Trip Check-List");
            bmb.addBuilder(builder);
            TextOutsideCircleButton.Builder builder1 = new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.confirmation_trip).normalText("Proceed");
            bmb.addBuilder(builder1);
        }
        else {
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.trip_details_boom).normalText("Trip Details");
            bmb.addBuilder(builder);
            TextOutsideCircleButton.Builder builder1 = new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.confirmation_trip)
                    .normalText("Proceed");
            bmb.addBuilder(builder1);
        }
        bmb.refreshDrawableState();
    }

    private void configureBoomMenuFinal(boolean isEquipment){
        int size = bmb.getBoomButtons().size();
        for(int i = 0; i<size; i++ ){
            bmb.removeBuilder(0);
            Log.d("BMB", "Boom Button :" + i + " u fshi me sukses");
        }
        bmb.clearBuilders();
            TextOutsideCircleButton.Builder tripDetailsBuilder = new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.trip_details_boom).normalText("Trip Details");
            TextOutsideCircleButton.Builder tripCheckListBuilder = new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.check_list_icon).normalText("Trip Check-List");
            TextOutsideCircleButton.Builder checkAllBuilder = new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.checkall).normalText("Check-All Equipments");
            TextOutsideCircleButton.Builder proceedBuilder = new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.confirmation_trip).normalText("Proceed");
            if(isEquipment){
                bmb.addBuilder(tripDetailsBuilder);
                Log.d("BMB", "U shtua TripDetails");
            }
            else {
                bmb.addBuilder(tripCheckListBuilder);
                Log.d("BMB", "U Shtua Trip CheckList");
            }
            bmb.addBuilder(checkAllBuilder);
            bmb.addBuilder(proceedBuilder);
            bmb.refreshDrawableState();
        Log.d("BMB", "U ShtuaProceed");
    }

    private void configureBoomMenuHam(){
        for (int i = 0; i < bmb1.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder()
                    .normalImageRes(R.drawable.check_list_icon)
                    .normalTextRes(R.string.prove)
                    .subNormalTextRes(R.string.title_activity_calendar)
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            bmb1.addBuilder(new HamButton.Builder()
                                    .normalImageRes(R.drawable.check_list_icon)
                                    .normalTextRes(R.string.prove)
                                    .subNormalTextRes(R.string.title_activity_calendar));
                        }
                    });
            bmb1.addBuilder(builder);
        }
    }
}
