package com.homeassignment.cinemaapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import utils.Constants;


public class CinemaMain extends Activity {

    ActionBar.Tab tabOne;
    ActionBar.Tab tabTwo;

    CinemaFragment cinemaFragment = new CinemaFragment();
    MovieFragment movieFragment = new MovieFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_cinema_main);

        setTabs();

    }

    private void setTabs() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabOne = actionBar.newTab();
        tabOne.setText("Cinemas");
        tabOne.setTabListener(new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

                fragmentTransaction.replace(R.id.tapsLayout, cinemaFragment);



              //  FrameLayout layout =(FrameLayout) findViewById( R.id.mainLayout);
              //  FrameLayout listCinemas = (FrameLayout)  layout.findViewById(R.id.cinemasLayout);

              //  listCinemas.setVisibility(View.VISIBLE);

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }
        });

        actionBar.addTab(tabOne);

        tabTwo = actionBar.newTab();
        tabTwo.setText("Movies");
        tabTwo.setTabListener(new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

                //setting the selected cinema
                movieFragment.setSelectedCinemaIndex(cinemaFragment.getmCurCheckPosition());
                fragmentTransaction.replace(R.id.tapsLayout, movieFragment);


               Log.d(Constants.TAG, String.valueOf(cinemaFragment.getmCurCheckPosition()));

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }
        });
        actionBar.addTab(tabTwo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cinema_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
