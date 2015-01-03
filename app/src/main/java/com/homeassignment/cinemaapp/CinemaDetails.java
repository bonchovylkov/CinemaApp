package com.homeassignment.cinemaapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import utils.Constants;


public class CinemaDetails extends Activity implements View.OnClickListener{

    TextView lbCinemaTitle;
    TextView lbWorkingHours;
    TextView lbAddress;
    TextView hdnSelectedCinemaCode;
    ImageView pictureOne;
    ImageView pictureTwo;
    Button btnCheckMovies;
    int defaultCinemaPicture = R.drawable.cinema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_details);

        //get all fields that need to fill with the selected cinema data
        lbCinemaTitle = (TextView) findViewById(R.id.lbCinemaTitle);
        lbWorkingHours = (TextView) findViewById(R.id.lbWorkingHours);
        lbAddress = (TextView) findViewById(R.id.lbAddress);
        hdnSelectedCinemaCode = (TextView) findViewById(R.id.hdnSelectedCinemaCode);
        pictureOne = (ImageView) findViewById(R.id.cinemaPictureOne);
        pictureTwo = (ImageView) findViewById(R.id.cinemaPictureTwo);

        //set listener to button show all moview
        btnCheckMovies = (Button) findViewById(R.id.btnCheckMovies);
        btnCheckMovies.setOnClickListener(this);


        //get the intent with the data in it
        Intent intent = getIntent();
        lbCinemaTitle.setText(intent.getStringExtra("CinemaName")) ;
        lbWorkingHours.setText(intent.getStringExtra("WorkingHours")) ;
        lbAddress.setText(intent.getStringExtra("Address")) ;
        hdnSelectedCinemaCode.setText(String.valueOf(intent.getIntExtra("SelectedCinemaCode",0)) ) ;
        pictureOne.setBackgroundResource((intent.getIntExtra("PictureOne", defaultCinemaPicture)));
        pictureTwo.setBackgroundResource((intent.getIntExtra("PictureTwo", defaultCinemaPicture)) );


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cinema_details, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCheckMovies:
                //on click i show all movies for the selected cinema
                Log.d(Constants.TAG, String.valueOf(hdnSelectedCinemaCode.getText()));


                Intent intent = new Intent();
                intent.setClass(this, SelectedCinemaMovies.class);
                intent.putExtra("SelectedCinemaCode", hdnSelectedCinemaCode.getText());

                startActivity(intent);



                break;

        }
    }
}
