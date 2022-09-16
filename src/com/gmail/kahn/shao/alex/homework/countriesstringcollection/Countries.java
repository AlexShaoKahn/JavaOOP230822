package com.gmail.kahn.shao.alex.homework.countriesstringcollection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Countries {

    private Set<String> countries;

    public Countries() {
        countries = new HashSet<>();
    }

    public Set<String> abbreviation(Set<String> myCountries) {
        return myCountries
                .stream()
                .filter(countries::contains)
                .limit(10)
                .map(e -> e.substring(0, 2).toUpperCase())
                .collect(Collectors.toSet());
    }

    private String getJsonStringCountries() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://countriesnow.space/api/v0.1/countries"))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private JSONObject jsonStringToJsonObject(String jsonString) {
        return new JSONObject(jsonString);
    }

    private Set<String> jsonObjectToMap(JSONObject jsonObject) {
        JSONArray countries = jsonObject.getJSONArray("data");
        Set<String> result = new HashSet<>();
        for (int i = 0; i < countries.length(); i++) {
            JSONObject o = countries.getJSONObject(i);
            result.add(o.getString("country"));
        }
        return result;
    }

    public void fillCountriesSet() throws IOException, InterruptedException {
        String jsonString = getJsonStringCountries();
        JSONObject jsonObject = jsonStringToJsonObject(jsonString);
        countries = jsonObjectToMap(jsonObject);
    }
}
