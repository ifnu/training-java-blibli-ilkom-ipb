package com.example.khannedy.belajar;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author Eko Kurniawan Khannedy
 */
public class TaskLogin extends AsyncTask<Void, Void, String> {

    private Login a;

    public TaskLogin(Login a) {
        this.a = a;
    }

    @Override
    protected String doInBackground(Void... params) {
        String json = ContactService.gson.toJson(a);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder().url(ContactService.urlLogin).post(body).build();

        try {
            String response = ContactService.httpClient.newCall(request).execute().body().string();
            if (response.equals("Unauthorized")) {
                // login gagal
                return null;
            } else {
                // login sukses
                return response;
            }
        } catch (IOException e) {
            return null;
        }
    }
}
