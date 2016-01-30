package com.example.khannedy.chatapp;

import android.app.Activity;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @author Eko Kurniawan Khannedy
 */
public class ChatClient extends WebSocketClient {

    public ChatClient() {
        super(URI.create("ws://192.168.1.224:9999"));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {

    }

    @Override
    public void onMessage(final String message) {
        Activity activity = (Activity) ChatService.data.getContext();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ChatService.data.add(message);
                ChatService.data.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }

    @Override
    public void onError(Exception ex) {

    }
}
