package com.homeassignment.cinemaapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import utils.Constants;
import utils.User;
import utils.UserManager;


public class MovieDetails extends Activity implements View.OnClickListener{

    TextView lbMovieName;
    TextView lbCast;
    TextView lbCinemas;
    TextView hdnSelectedMovieCode;
    ImageView imgMovie;
UserManager manager = UserManager.getInstance();
    Button btnReserve;
    int defaultCinemaPicture = R.drawable.cinema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);



        //get all fields that need to fill with the selected cinema data
        lbMovieName = (TextView) findViewById(R.id.lbMovieNameReserve);
        lbCast = (TextView) findViewById(R.id.lbCast);
        lbCinemas = (TextView) findViewById(R.id.lbCinemas);
        hdnSelectedMovieCode = (TextView) findViewById(R.id.hdnSelectedMovieCode);
        imgMovie = (ImageView) findViewById(R.id.imgMovie);

        //set listener to button to revere seats
        btnReserve = (Button) findViewById(R.id.btnReserve);
        btnReserve.setOnClickListener(this);


        //get the intent with the data in it
        Intent intent = getIntent();
        lbMovieName.setText(intent.getStringExtra("MovieName")) ;
        lbCast.setText(intent.getStringExtra("Cast")) ;
        lbCinemas.setText(intent.getStringExtra("CinemasPlayedIn")) ;
        hdnSelectedMovieCode.setText(String.valueOf(intent.getIntExtra("SelectedMovieCode", 0))) ;
        imgMovie.setBackgroundResource((intent.getIntExtra("MoviePicture", defaultCinemaPicture)));

        //check if there are available seats
        Boolean hasSeats = intent.getBooleanExtra("HasSeats",false);
        if(!hasSeats){
            this.imgMovie.setClickable(false);
            this.imgMovie.setEnabled(false);

            this.imgMovie.setBackgroundColor(Color.parseColor("#EEEEEE"));
        }

    }

    //TODO back button

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_details, menu);
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
            case R.id.btnReserve:
                //on click i show all movies for the selected cinema
                Log.d(Constants.TAG, String.valueOf(hdnSelectedMovieCode.getText()));

                //get current user
                User user =  UserManager.getCurrentUser();

                //create diaglog fragment and show it
                ReserveMovieDialogFrogment reserve =
                        new ReserveMovieDialogFrogment()
                         .newInstance(
                         this.lbMovieName.getText().toString(),this.lbCinemas.getText().toString(),user.getUsername());


                reserve.show(getFragmentManager(), "dialog");

                break;

        }
    }
}
