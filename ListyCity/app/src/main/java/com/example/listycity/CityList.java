package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects.
 */
public class CityList {
    /** Internal storage for cities */
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it does not already exist.
     * @param city candidate city to add
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Returns a sorted list of cities (by city name).
     * @return sorted list (ascending by name)
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list); // requires City to be Comparable
        return list;
    }

    /**
     * Returns true if the list contains the given city.
     * @param city city to check
     * @return whether the city is present
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes the given city if present; otherwise throws.
     * @param city city to remove
     * @throws IllegalArgumentException if the city is not present
     */
    public void delete(City city) {
        if (!cities.remove(city)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the number of cities currently in the list.
     * @return count of cities
     */
    public int countCities() {
        return cities.size();
    }
}