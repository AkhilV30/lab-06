package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {

    /** The city name */
    private String city;

    /** The province name */
    private String province;

    /**
     * This is the constructor for the City class.
     * @param city the name of the city
     * @param province the name of the province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name.
     * @return the name of the city
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name.
     * @return the name of the province
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compare by city name lexicographically.
     * @param other the other City
     * @return negative/zero/positive based on ordering
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    @Override
    public int hashCode() {
        return (city + "|" + province).hashCode();
    }
}