package com.example.w2020skerdjan.spectrumtrack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.example.w2020skerdjan.spectrumtrack.Fragments.PersonalAreaFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripsFragment;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.TripsAdapter;
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

public class MainMenu extends AppCompatActivity {
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private  FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         fragmentManager = getSupportFragmentManager();



        //if you want to update the items at a later time it is recommended to keep it in a variable
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
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,item2,item3,item4,
                        new DividerDrawerItem(),
                        settings,logout

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                         fragmentTransaction = fragmentManager.beginTransaction();
                        Log.d("position", " "+position);
                        switch (position){
                            case 3:
                                initTripsFragment();
                                break;
                            case 4 :
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

}