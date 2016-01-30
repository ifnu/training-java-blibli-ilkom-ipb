package com.example.khannedy.androidsmsgateway;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.java_websocket.WebSocket;

import java.util.ArrayList;

/**
 * @author Eko Kurniawan Khannedy
 */
public class ClientService {

    private static ArrayList<WebSocket> clients = new ArrayList<WebSocket>();

    public static void add(WebSocket a) {
        clients.add(a);
    }

    public static void remove(WebSocket a) {
        clients.remove(a);
    }

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void send(SmsRequest request){
        for(WebSocket w : clients){
            w.send(gson.toJson(request));
        }
    }

}
