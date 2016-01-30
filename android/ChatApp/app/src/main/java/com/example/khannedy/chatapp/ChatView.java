package com.example.khannedy.chatapp;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * @author Eko Kurniawan Khannedy
 */
public class ChatView {

    public ListView listViewChat;
    public EditText editTextMessage;
    public Button buttonSend;

    public ChatView(Activity a) {
        listViewChat = (ListView) a.findViewById(R.id.chat_listViewChat);
        editTextMessage = (EditText) a.findViewById(R.id.chat_editTextMessage);
        buttonSend = (Button) a.findViewById(R.id.chat_buttonSend);
    }

    public Chat create() {
        Chat a = new Chat();
        a.type = "chat";
        a.message = editTextMessage.getText().toString();
        return a;
    }
}
