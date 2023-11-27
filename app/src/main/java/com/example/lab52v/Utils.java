package com.example.lab52v;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {
    public static JSONObject getDataFromUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder result = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            return new JSONObject(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}