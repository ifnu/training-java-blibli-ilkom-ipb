package com.example.khannedy.belajar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ContactService {

    public static String urlContacts = "http://971d0f9a.ngrok.io/khannedy/contacts";
    public static String urlLogin = "http://971d0f9a.ngrok.io/login";

    public static Gson gson = new Gson();

    public static OkHttpClient httpClient = new OkHttpClient();

    public static String session;

    public static boolean login(Login a) {
        try {

            session = new TaskLogin(a).execute().get();
            if (session == null) {
                return false;
            } else {
                return true;
            }

        } catch (InterruptedException e) {
            return false;
        } catch (ExecutionException e) {
            return false;
        }
    }

    public static boolean add(Contact a) {
        try {
            return new TaskCreateContact(a).execute().get();
        } catch (InterruptedException e) {
            return false;
        } catch (ExecutionException e) {
            return false;
        }
    }

    public static ArrayList<Contact> getAll() {
        try {
            return new TaskGetAllContact().execute().get();
        } catch (InterruptedException e) {
            return null;
        } catch (ExecutionException e) {
            return null;
        }
    }

}
