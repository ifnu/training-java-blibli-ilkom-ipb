package com.example.khannedy.chatapp;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Eko Kurniawan Khannedy
 */
public class LoginView {

    public EditText editTextUsername;
    public Button buttonLogin;

    public LoginView(Activity a) {
        editTextUsername = (EditText) a.findViewById(R.id.login_editTextUsername);
        buttonLogin = (Button) a.findViewById(R.id.login_buttonLogin);
    }

    public Chat create() {
        Chat a = new Chat();
        a.type = "login";
        a.username = editTextUsername.getText().toString();
        return a;
    }

}
