package com.example.khannedy.chatapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Eko Kurniawan Khannedy
 */
public class ChatActivity extends Activity implements View.OnClickListener {

    private ChatView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        ChatService.init(this);

        view = new ChatView(this);
        view.listViewChat.setAdapter(ChatService.data);
        view.buttonSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == view.buttonSend) {
            Chat chat = view.create();
            ChatService.message(chat);
            view.editTextMessage.setText("");
        }
    }
}
