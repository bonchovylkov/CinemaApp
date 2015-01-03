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


public class Login extends Activity implements View.OnClickListener {

    private UserManager manager;
    TextView tbxUserName,tbxPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        manager = UserManager.getInstance();
        tbxUserName = (TextView) findViewById(R.id.tbxUserName);
        tbxPassword = (TextView) findViewById(R.id.tbxPassword);
        Button btnDoLogin = (Button) findViewById(R.id.btnDoLogin);
        btnDoLogin.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
        switch (v.getId()) {
            case R.id.btnDoLogin:

                User user =  manager.getUserByNameAndPassword(tbxUserName.getText().toString(), tbxPassword.getText().toString());

                if(user!=null) {
                    Intent sentToEditView = new Intent(this, CinemaMain.class);

                    sentToEditView.putExtra(Constants.UserId, user.getId());
                    startActivity(sentToEditView);
                }else{
                    Toast.makeText(this, "Wrong username or password", Toast.LENGTH_LONG).show();
                }

                manager.setCurrentUser(user);

                break;
        }
    }
}
