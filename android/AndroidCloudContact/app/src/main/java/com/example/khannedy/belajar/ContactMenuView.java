package com.example.khannedy.belajar;

import android.app.Activity;
import android.widget.Button;

/**
 * @author Eko Kurniawan Khannedy
 */
public class ContactMenuView {

    public Button buttonCreateNewContact;

    public Button buttonDisplayContacts;

    public ContactMenuView(Activity a) {

        buttonCreateNewContact = (Button) a.findViewById(R.id.contactMenu_ButtonCreateNewContact);

        buttonDisplayContacts = (Button) a.findViewById(R.id.contactMenu_ButtonDisplayContacts);
    }
}
