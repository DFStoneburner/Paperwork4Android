package stone.paperwork.adapters;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

import stone.paperwork.models.NotebooksResponse;
import stone.paperwork.models.NotesResponse;

/**
 * Created by pirate_steve on 3/29/2015.
 */
public class NotebooksFetcher {
    private static OkHttpClient client = new OkHttpClient();

    public static NotebooksResponse queryNotebooks() throws IOException {
        Gson gson = new GsonBuilder().create();
        Request request = new Request.Builder()
                .url("http://192.168.1.50/api/v1/notebooks")
                .header("Authorization", Credentials.basic("dfstoneburner@gmail.com", "Camelot"))
                .build();
        String responseCall = client.newCall(request).execute().body().string();

        Log.d("Response Call", responseCall);

        return gson.fromJson(responseCall, NotebooksResponse.class);
    }

    public static NotesResponse queryNotes(String id) throws IOException {
        Gson gson = new GsonBuilder().create();
        Request request = new Request.Builder()
                .url("http://192.168.1.50/api/v1/notebooks/" + id + "/notes")
                .header("Authorization", Credentials.basic("dfstoneburner@gmail.com", "Camelot"))
                .build();
        String responseCall = client.newCall(request).execute().body().string();

        Log.d("Response Call", responseCall);

        return gson.fromJson(responseCall, NotesResponse.class);
    }
}
