package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    private City city;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * create a mockcityt for my city tests
     * @return
     */
    public City MockCity(){
        city = new City("Estevan", "SK");
        return city;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        city = MockCity();
        list.addCity(city);
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * add city to empty list
     * check if list has city
     * check if list has city that isn't added
     */
    @Test
    void hasCityTest() {
        list = MockCityList();
        list.addCity(MockCity());
        assertTrue(list.hasCity(MockCity()));
        city = new City("Yellowknife", "Northwest Territories");
        assertFalse(list.hasCity(city));
    }

    /**
     * add two city to empty list
     * check if list has cities
     * delete them and check if it still returns has
     */
    @Test
    void testDeleteCity() {
        list = MockCityList();
        list.addCity(MockCity());
        city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        assertTrue(list.hasCity(MockCity()));
        assertTrue(list.hasCity(city));
        list.deleteCity(MockCity());
        assertFalse(list.hasCity(MockCity()));
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
    }
}
