package com.corona.coronazp202;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JSON {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static JSONArray getJSONArray(JSONObject json) throws JSONException {
        // removing from JSON all unnecessary information and leaving only covid19Stats array
        int jsonLength = json.toString().length();
        String covid19Stats = "{" + json.toString().substring(96, jsonLength) + "}";

        // String to JSONObject
        JSONObject jsonObject = new JSONObject(covid19Stats);
        //JSONObject to JSONArray
        JSONArray jsonArray = jsonObject.getJSONArray("covid19Stats");

        return jsonArray;
    }

    public static ArrayList<Corona> getList(JSONArray jsonArray) throws JSONException {
        ArrayList<Corona> covidList = new ArrayList<Corona>();
        // Extract data from json and store into ArrayList as class objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Corona corona = new Corona(
                    json_data.getString("country"),
                    json_data.getString("lastUpdate"),
                    json_data.getString("keyId"),
                    json_data.getInt("confirmed"),
                    json_data.getInt("deaths")
            );
            covidList.add(corona);
        }
        return covidList;
    }

    public static ArrayList<Corona> getCoronaListByCountry(ArrayList<Corona> coronaList, String country) {
        ArrayList<Corona> coronaListByCountry = new ArrayList<Corona>();
        for (Corona corona : coronaList) {
            if (corona.getKeyId().contains(country)) {
                coronaListByCountry.add(corona);
            }
        }
        return coronaListByCountry;
    }

}
