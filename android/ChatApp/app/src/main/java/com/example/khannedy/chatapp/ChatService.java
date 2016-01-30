package com.example.khannedy.chatapp;

import android.app.Activity;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * @author Eko Kurniawan Khannedy
 */
public class ChatService {

    public static ArrayAdapter<String> data;

    public static ChatClient client;

    public static Gson gson = new Gson();

    public static void init(Activity a) {
        data = new ArrayAdapter<String>(a, android.R.layout.simple_list_item_1, 0, new ArrayList<String>());

        if (client == null) {
            client = new ChatClient();
            client.connect();
        }
    }

    public static void login(Chat chat) {
        String json = gson.toJson(chat);
        client.send(json);
    }

    public static void message(Chat chat) {
        String json = gson.toJson(chat);
        client.send(json);
    }
}
