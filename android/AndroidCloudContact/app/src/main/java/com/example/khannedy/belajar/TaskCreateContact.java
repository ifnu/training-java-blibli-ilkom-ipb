package com.example.khannedy.belajar;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author Eko Kurniawan Khannedy
 */
public class TaskCreateContact extends AsyncTask<Void, Void, Boolean> {

    private Contact a;

    public TaskCreateContact(Contact a) {
        this.a = a;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        String json = ContactService.gson.toJson(a);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder().
                url(ContactService.urlContacts).
                header("session", ContactService.session).
                post(body).
                build();

        try {
            ContactService.httpClient.newCall(request).execute();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
