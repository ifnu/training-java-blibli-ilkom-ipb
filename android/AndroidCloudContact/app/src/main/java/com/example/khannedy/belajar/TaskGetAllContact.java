package com.example.khannedy.belajar;

import android.os.AsyncTask;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Eko Kurniawan Khannedy
 */
public class TaskGetAllContact extends AsyncTask<Void, Void, ArrayList<Contact>> {

    @Override
    protected ArrayList<Contact> doInBackground(Void... params) {
        Request request = new Request.Builder().
                url(ContactService.urlContacts).
                header("session", ContactService.session).
                get().
                build();

        try {
            Response response = ContactService.httpClient.newCall(request).execute();
            String json = response.body().string();

            Type type = new TypeToken<ArrayList<Contact>>() {
            }.getType();

            return ContactService.gson.fromJson(json, type);
        } catch (IOException e) {
            return null;
        }
    }
}
