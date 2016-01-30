package com.example.khannedy.androidsmsgateway;

import android.app.Activity;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.google.gson.Gson;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author Eko Kurniawan Khannedy
 */
public class SmsServer extends WebSocketServer {

    private Activity activity;
    private Gson gson = new Gson();

    public SmsServer(Activity a) throws UnknownHostException {
        super(new InetSocketAddress(9999));
        activity = a;
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        try{

            SmsRequest request = gson.fromJson(message, SmsRequest.class);
            SmsManager.getDefault().sendTextMessage(
                    request.to,
                    null,
                    request.message,
                    null,
                    null
            );
            conn.send("sms telah dikirim");

        }catch (Throwable e){
            conn.send(e.getMessage());
        }
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        ClientService.add(conn);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        ClientService.remove(conn);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ClientService.remove(conn);
    }
}
