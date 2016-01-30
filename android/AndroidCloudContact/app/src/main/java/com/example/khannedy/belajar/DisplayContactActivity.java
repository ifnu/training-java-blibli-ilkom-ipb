package com.example.khannedy.belajar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * @author Eko Kurniawan Khannedy
 */
public class DisplayContactActivity extends Activity {

    private DisplayContactView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_contact);

        view = new DisplayContactView(this);

        // set data
        ArrayList<Contact> data = ContactService.getAll();
        if (data == null) {
            // gagal
            Toast.makeText(this, "Terjadi error, mungkin koneksi error", Toast.LENGTH_SHORT).show();
        } else {
            view.setData(data);
        }
    }
}
