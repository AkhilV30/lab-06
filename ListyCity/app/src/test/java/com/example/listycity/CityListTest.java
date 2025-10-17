package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    // add(): success
    @Test
    void testAdd() {
        CityList list = mockCityList();
        assertEquals(1, list.getCities().size());
        City regina = new City("Regina", "Saskatchewan");
        list.add(regina);
        assertEquals(2, list.getCities().size());
        assertTrue(list.getCities().contains(regina));
    }

    // add(): duplicate throws
    @Test
    void testAddException() {
        CityList list = mockCityList();
        City yellowknife = new City("Yellowknife", "Northwest Territories");
        list.add(yellowknife);
        assertThrows(IllegalArgumentException.class, () -> list.add(yellowknife));
    }

    // getCities(): sorted behavior
    @Test
    void testGetCities() {
        CityList list = mockCityList();
        assertEquals(0, mockCity().compareTo(list.getCities().get(0)));
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        list.add(charlottetown);
        assertEquals(0, charlottetown.compareTo(list.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(list.getCities().get(1)));
    }

    // hasCity — participation
    @Test
    void testHasCity() {
        CityList list = mockCityList();
        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(list.hasCity(new City("Vancouver", "BC")));
    }

    // delete — removes when present (participation)
    @Test
    void testDeleteRemoves() {
        CityList list = mockCityList();
        City calgary = new City("Calgary", "Alberta");
        list.add(calgary);
        assertTrue(list.hasCity(calgary));
        list.delete(calgary);
        assertFalse(list.hasCity(calgary));
        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
    }

    // delete — throws when absent (participation)
    @Test
    void testDeleteThrowsWhenMissing() {
        CityList list = mockCityList();
        assertThrows(IllegalArgumentException.class,
                () -> list.delete(new City("Halifax", "Nova Scotia")));
    }

    // countCities — participation
    @Test
    void testCountCities() {
        CityList list = mockCityList();
        assertEquals(1, list.countCities());
        list.add(new City("Calgary", "Alberta"));
        assertEquals(2, list.countCities());
        list.delete(new City("Calgary", "Alberta"));
        assertEquals(1, list.countCities());
    }
}