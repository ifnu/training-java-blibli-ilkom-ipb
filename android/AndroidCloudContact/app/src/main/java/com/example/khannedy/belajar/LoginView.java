package com.example.khannedy.belajar;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Eko Kurniawan Khannedy
 */
public class LoginView {

    public EditText editTextUsername;
    public EditText editTextPassword;
    public Button buttonLogin;

    public LoginView(Activity activity) {

        editTextUsername = (EditText) activity.findViewById(R.id.login_editTextUsername);
        editTextPassword = (EditText) activity.findViewById(R.id.login_editTextPassword);
        buttonLogin = (Button) activity.findViewById(R.id.login_buttonLogin);

    }

    public Login create(){

        Login a = new Login();
        a.username = editTextUsername.getText().toString();
        a.password = editTextPassword.getText().toString();

        return a;

    }

}
