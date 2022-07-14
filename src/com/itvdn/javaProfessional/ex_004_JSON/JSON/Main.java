package com.itvdn.javaProfessional.ex_004_JSON.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {
    
    public static void main(String[] args) throws Exception {
        String request = "https://catfact.ninja/fact";
        String result = performRequest(request);
        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(result, JSON.class);
        System.out.println(json.fact);
        System.out.println("JSON: \n\t" + gson.toJson(json.fact));
    }

    // Делаем запрос и получаем JSON
    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];
            int r = 0;
            while ((r = br.read(buf)) > 0) {
                sb.append(new String(buf, 0, r));
            }
        } finally {
            http.disconnect();
        }

        return sb.toString();
    }

}