package com.example.khannedy.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        view = new LoginView(this);
        view.buttonLogin.setOnClickListener(this);

        ChatService.init(this);
    }

    @Override
    public void onClick(View v) {
        if (v == view.buttonLogin) {
            Chat chat = view.create();
            ChatService.login(chat);

            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        }
    }
}
