package com.example.khannedy.belajar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * @author Eko Kurniawan Khannedy
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private LoginView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        view = new LoginView(this);
        view.buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == view.buttonLogin){

            Login a = view.create();

            if(ContactService.login(a) == true){
                // login sukses
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }else{
                // login gagal
                Toast.makeText(this, "Ups, login gagal", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
