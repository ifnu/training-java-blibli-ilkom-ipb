package com.example.khannedy.belajar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ContactMenuView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_menu);

        view = new ContactMenuView(this);
        view.buttonDisplayContacts.setOnClickListener(this);
        view.buttonCreateNewContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == view.buttonCreateNewContact){
            Intent i = new Intent(this, CreateContactActivity.class);
            startActivity(i);
        }else if(v == view.buttonDisplayContacts){
            Intent i = new Intent(this, DisplayContactActivity.class);
            startActivity(i);
        }
    }
}
