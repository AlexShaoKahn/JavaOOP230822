package com.gmail.kahn.shao.alex.homework.countriesstringcollection;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) throws IOException, InterruptedException {
        var countries = new Countries();
        countries.fillCountriesSet();
        Set<String> myCountries = Set.copyOf(
                List.of(
                        "Ukraine", "Cuba", "Morocco", "Neverland",
                        "Panama", "Serbia", "Tunisia", "Mordor",
                        "Slovakia", "Portugal", "Nepal", "Krakozhia",
                        "Moldova", "Maldives", "Laos", "Skyrim"
                )
        );
        System.out.println(myCountries);
        System.out.println(countries.abbreviation(myCountries));

    }


}
