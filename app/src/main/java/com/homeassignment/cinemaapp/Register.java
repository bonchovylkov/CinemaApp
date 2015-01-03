package com.homeassignment.cinemaapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import utils.Constants;
import utils.User;
import utils.UserManager;


public class Register extends Activity implements View.OnClickListener  {

    private UserManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = (Button) findViewById(R.id.btnDoRegister);
        btnRegister.setOnClickListener(this);
        manager = UserManager.getInstance();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
        switch(v.getId()) {
            case R.id.btnDoRegister:

                TextView tbxUserName = (TextView) findViewById(R.id.tbxUserName);
                String username = tbxUserName.getText().toString();

                TextView tbxPassword = (TextView) findViewById(R.id.tbxPassword);
                String pass = tbxPassword.getText().toString();



                if (username.length() == 0 || pass.length() == 0) {
                    Toast.makeText(this, "Username and password are mandatory", Toast.LENGTH_LONG).show();

                } else {


                    int id = manager.getUserId();
                    String role = Constants.UserRole;

                    //if it's the first user ever created, it's with admin role
                    if (id == 1) {
                        role = Constants.AdminRole;
                    }

                    User newUser = new User(id, username, pass, role);


                    manager.addUser(newUser);


                    Intent cinemaMain= new Intent(this, CinemaMain.class);
                    cinemaMain.putExtra(Constants.UserId, newUser.getId());
                    startActivity(cinemaMain);

                    manager.setCurrentUser(newUser);
                    break;
                }
        }

    }
}
