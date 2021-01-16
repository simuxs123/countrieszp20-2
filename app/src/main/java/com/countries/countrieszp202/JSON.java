package com.countries.countrieszp202;

import android.util.Log;

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
            Log.d("very bad","something wrong");
            is.close();
        }
    }

    public static JSONArray getJSONArray(JSONObject json) throws JSONException {
        // removing from JSON all unnecessary information and leaving only covid19Stats array
        //int jsonLength = json.toString().length();
        //String covid19Stats = "{" + json.toString().substring(0, jsonLength) + "}";

        // String to JSONObject
        //JSONObject jsonObject = new JSONObject(covid19Stats);
        //JSONObject to JSONArray
        JSONArray jsonArray = json.getJSONArray("");

        return jsonArray;
    }

    public static ArrayList<Countries> getList(JSONArray jsonArray) throws JSONException {
        ArrayList<Countries> countrieList = new ArrayList<Countries>();
        // Extract data from json and store into ArrayList as class objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Countries countries = new Countries(
                    json_data.getString("name"),
                    json_data.getString("alpha2Code"),
                    json_data.getInt("population"),
                    json_data.getInt("area")
            );
            countrieList.add(countries);
        }
        System.err.println(countrieList);
        return countrieList;
    }

    public static ArrayList<Countries> getCountryListByCountry(ArrayList<Countries> countriesList, String country) {
        ArrayList<Countries> countriesListByCountry = new ArrayList<Countries>();
        for (Countries countries : countriesList) {
            if (countries.getCountry().contains(country)) {
                countriesListByCountry.add(countries);
            }
        }
        return countriesListByCountry;
    }

}
