package com.example.lab52v;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Parser {

    public void parseData(JSONObject jsonObject) {
        ArrayList<String> currencyList = new ArrayList<>();

        try {
            JSONObject rates = jsonObject.getJSONObject("rates");
            Iterator<String> keys = rates.keys();
            while (keys.hasNext()) {
                String currencyCode = keys.next();
                double rate = rates.getDouble(currencyCode);
                String displayText = currencyCode + " - " + rate;
                currencyList.add(displayText);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
