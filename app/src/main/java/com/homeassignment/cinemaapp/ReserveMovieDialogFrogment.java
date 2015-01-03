package com.homeassignment.cinemaapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;


public class ReserveMovieDialogFrogment extends DialogFragment {

    Spinner spinner;
    TextView movieName;

    static ReserveMovieDialogFrogment newInstance(String movieName,String playedInCinemas,String username) {
        ReserveMovieDialogFrogment f = new ReserveMovieDialogFrogment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString("movieName", movieName);
        args.putString("playedInCinemas", playedInCinemas);
        args.putString("username", username);
        f.setArguments(args);

        return f;
    }

   // @Override
  //  public View onCreateView(LayoutInflater inflater, ViewGroup container,
  //                           Bundle savedInstanceState) {
  //      View v = inflater.inflate(R.layout.fragment_reserve_movie_dialog_frogment, container, false);
  //      TextView lbMovieName = (TextView) v.findViewById(R.id.lbMovieNameReserve);
  //      lbMovieName.setText(getArguments().getString("movieName"));
//
//
  //      return v;
  //  }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
     //  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
     //
     //  builder.setMessage("Reserve seats")
     //          .setPositiveButton("Reserve", new DialogInterface.OnClickListener() {
     //              public void onClick(DialogInterface dialog, int id) {
     //                  // FIRE ZE MISSILES!
     //              }
     //          })
     //          .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
     //              public void onClick(DialogInterface dialog, int id) {

     //              }
     //          });
     //  // Create the AlertDialog object and return it
     //  return builder.create();


        // custom dialog
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_reserve_movie_dialog_frogment);
        dialog.setTitle("Reserve seats for");

        // set the custom dialog components - text, image and button
        movieName = (TextView) dialog.findViewById(R.id.lbMovieNameReserve);
        movieName.setText(getArguments().getString("movieName"));

        List<String> elephantList = Arrays.asList(getArguments().getString("playedInCinemas").split(","));


         spinner = (Spinner)dialog.findViewById(R.id.cinemasSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter =new  ArrayAdapter<String>(getActivity(),
                 android.R.layout.simple_spinner_item,elephantList);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);



        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        // if button is clicked, close the custom dialog
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button btnReserve = (Button) dialog.findViewById(R.id.btnReserve);
        // if button is clicked, close the custom dialog
        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText countSeats = (EditText) dialog.findViewById(R.id.tbxSeatsCount);

                Toast.makeText(getActivity(),
                        "User " + getArguments().getString("username")  +
                      "has reserved " +  countSeats.getText() +
                       " tickets for  " + movieName.getText() +
                       " movie at " + spinner.getSelectedItem().toString() + " cinema!",
                         Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        return dialog;
    }

}
