package com.example.khannedy.belajar;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * @author Eko Kurniawan Khannedy
 */
public class DisplayContactView {

    public ListView listContact;

    private Activity context;

    public DisplayContactView(Activity a) {
        listContact = (ListView) a.findViewById(R.id.displayContact_ListContact);
        context = a;
    }

    public void setData(ArrayList<Contact> data){
        ArrayAdapter<Contact> adapter =
                new ArrayAdapter<Contact>(
                        context,
                        android.R.layout.simple_list_item_1,
                        data
                );

        listContact.setAdapter(adapter);
    }

}
