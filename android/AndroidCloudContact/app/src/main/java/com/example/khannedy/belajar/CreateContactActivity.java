package com.example.khannedy.belajar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import java.util.List;

/**
 * @author Eko Kurniawan Khannedy
 */
public class CreateContactActivity extends Activity implements View.OnClickListener, Validator.ValidationListener {

    private CreateContactView view;

    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_contact);

        view = new CreateContactView(this);
        view.buttonSave.setOnClickListener(this);

        validator = new Validator(view);
        validator.setValidationListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == view.buttonSave) {
            validator.validate();
        }
    }

    @Override
    public void onValidationSucceeded() {
        // save new contact
        Contact a = view.create();
        if(ContactService.add(a) == true){
            finish(); // close activity
        }else{
            // gagal
            Toast.makeText(this, "Terjadi error, mungkin koneksi error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            Toast.makeText(this, error.getCollatedErrorMessage(this), Toast.LENGTH_SHORT).show();
        }
    }
}
