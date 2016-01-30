package com.example.khannedy.belajar;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.UUID;

/**
 * @author Eko Kurniawan Khannedy
 */
public class CreateContactView {

    @NotEmpty(message = "Nama tidak boleh kosong")
    public EditText editTextName;

    @NotEmpty(message = "Email tidak boleh kosong")
    @Email(message = "Format email tidak valid")
    public EditText editTextEmail;

    @NotEmpty(message = "Nomor telpon tidak boleh kosong")
    public EditText editTextPhone;

    public Button buttonSave;

    public CreateContactView(Activity a) {
        editTextName = (EditText) a.findViewById(R.id.createContact_editTextName);
        editTextEmail = (EditText) a.findViewById(R.id.createContact_editTextEmail);
        editTextPhone = (EditText) a.findViewById(R.id.createContact_editTextPhone);
        buttonSave = (Button) a.findViewById(R.id.createContact_buttonSave);
    }

    public Contact create(){
        Contact a = new Contact();

        a.id = UUID.randomUUID().toString();
        a.name = editTextName.getText().toString();
        a.email = editTextEmail.getText().toString();
        a.phone = editTextPhone.getText().toString();

        return a;
    }
}
