package com.example.lab52v;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;

public class DataLoader extends AsyncTask<String, Void, JSONObject> {

    private Parser parser;

    public DataLoader(Parser parser) {
        this.parser = parser;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        return Utils.getDataFromUrl(strings[0]);
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        if (jsonObject != null) {
            parser.parseData(jsonObject);
        } else {
            Log.e("DataLoader", "Failed to fetch data from the URL");
        }
    }
}
