package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.BaseChatActivity;
import com.example.w2020skerdjan.spectrumtrack.Fragments.HomeFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.PersonalAreaFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripsFragment;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

public class MainMenu extends BaseActivity implements WaveSwipeRefreshLayout.OnRefreshListener {
    private Toolbar toolbar;
    private  FragmentManager fragmentManager;
    private  FragmentTransaction fragmentTransaction;
    private  Drawer result;
    private WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem itemHome = new PrimaryDrawerItem().withIdentifier(0).withName("Home");
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Calendar");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Chat");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Trips");
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Personal Area");
        SecondaryDrawerItem settings = new SecondaryDrawerItem().withIdentifier(5).withName("Settings");
        SecondaryDrawerItem logout = new SecondaryDrawerItem().withIdentifier(6).withName("Logout");

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.nav_header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Skerdjan Gurabardhi").withEmail("skerdilol@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

//create the drawer and remember the `Drawer` result object
         result= new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        itemHome, item1,item2,item3,item4,
                        new DividerDrawerItem(),
                        settings,logout

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                         fragmentTransaction = fragmentManager.beginTransaction();
                        Log.d("position", " "+position);
                        switch (position){
                            case 1:
                                initHome();
                                break;
                            case 2:
                                initCalendar();
                                break;
                            case 3:
                                initChatActivity();
                                break;
                            case 4:
                                initTripsFragment();
                                break;
                            case 5 :
                                initPersonalAreaFragment();
                                break;
                        }

                        return false;
                    }
                })
                .withAccountHeader(headerResult)
                .build();


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);;

        initLoader();
        mWaveSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private void initPersonalAreaFragment(){
        PersonalAreaFragment fragment = new PersonalAreaFragment();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    private void initTripsFragment(){
        TripsFragment fragment1 = new TripsFragment();
        fragmentTransaction.replace(R.id.fragment, fragment1);
        fragmentTransaction.commit();
    }

    private void initChatActivity(){
        Intent intent = new Intent(MainMenu.this, ChatActivity.class);
        startActivity(intent);
    }

    private void initHome(){
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.fragment, homeFragment);
        fragmentTransaction.commit();
    }

    private void initCalendar(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainMenu.this, CalendarActivity.class);
                startActivity(intent);
            }
        }, 200);

    }

    @Override
    public void onBackPressed() {
        if(!result.isDrawerOpen()){
            result.closeDrawer();
        }
        else
            result.openDrawer();
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    private class Task extends AsyncTask<Void, Void, String[]> {
        @Override
        protected String[] doInBackground(Void... voids) {
            return new String[0];
        }

        @Override protected void onPostExecute(String[] result) {
            // Call setRefreshing(false) when the list has been refreshed.
            mWaveSwipeRefreshLayout.setRefreshing(false);
            super.onPostExecute(result);
        }
    }

    private void refresh(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mWaveSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1100);
    }


    public void initLoader (){

        mWaveSwipeRefreshLayout = (WaveSwipeRefreshLayout) findViewById(R.id.main_swipe);
        mWaveSwipeRefreshLayout.setColorSchemeColors(Color.WHITE, Color.WHITE);
        mWaveSwipeRefreshLayout.setOnRefreshListener(this);
        mWaveSwipeRefreshLayout.setWaveColor(Color.argb(100,255,0,0));
        //mWaveSwipeRefreshLayout.setRefreshing(true);

    }
}
