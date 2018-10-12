package com.edu.aj.oub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomNav extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    //private TextView mTextMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);


        BottomNavigationView navigation =   findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new ParkFragment());
    }

    private boolean loadFragment(Fragment fragment)
    {
        if (fragment!=null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
            return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment=null;
        switch (item.getItemId())
        {
            case R.id.nav_park:
                fragment= new ParkFragment();
                break;

            case R.id.nav_bike:
                fragment= new BikeFragment();
                break;

            case R.id.nav_cab:
                fragment= new CabFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
