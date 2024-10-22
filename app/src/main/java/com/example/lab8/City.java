package com.example.lab8;

import java.util.Objects;

public class City {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }


    /**
     * Compares this City object to another object for equality.
     *
     * This method overrides the default {@code equals} implementation to provide a custom equality
     * check for {@code City} objects. Two City objects are considered equal if:
     * <ul>
     *   <li>They refer to the same object in memory (i.e., {@code this == o}).</li>
     *   <li>The provided object is not {@code null} and is of the same class as this City object.</li>
     *   <li>Both City objects have the same {@code city} name and {@code province} name.</li>
     * </ul>
     *
     * The method uses {@link java.util.Objects#equals} to compare both the city names and provinces
     * for equality, handling potential null values safely.
     *
     * <p> Example:
     * <pre>
     *     City city1 = new City("Toronto", "Ontario");
     *     City city2 = new City("Toronto", "Ontario");
     *     boolean isEqual = city1.equals(city2);  // isEqual will be true
     * </pre>
     *
     * @param o The object to be compared for equality with this City.
     * @return {@code true} if this City object is equal to the specified object based on
     *         the above criteria; {@code false} otherwise.
     * @throws ClassCastException if the specified object is not of type {@code City}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) && Objects.equals(province, city1.province);
    }

    /**
     * Generates a hash code for this City object.
     *
     * This method overrides the default {@code hashCode} implementation to provide a hash code
     * based on the city name and province. The generated hash code is consistent with the
     * {@link #equals(Object)} method, meaning that two City objects that are considered equal
     * (based on their city name and province) will have the same hash code.
     *
     * <p> The hash code is generated using {@link java.util.Objects#hash}, which combines the hash
     * codes of the city and province fields. This ensures that the hash code is computed efficiently
     * and handles potential {@code null} values in the fields.
     *
     * <p> Example:
     * <pre>
     *     City city1 = new City("Toronto", "Ontario");
     *     City city2 = new City("Toronto", "Ontario");
     *     boolean isEqual = city1.equals(city2);    // true
     *     int hash1 = city1.hashCode();
     *     int hash2 = city2.hashCode();
     *     boolean sameHash = hash1 == hash2;        // true, because city1 and city2 are equal
     * </pre>
     *
     * <p> This method is crucial when City objects are used in hash-based collections, such as
     * {@code HashMap} or {@code HashSet}, to ensure that objects that are equal have the same
     * hash code and can be retrieved or stored correctly.
     *
     * @return A hash code value for this City object, based on its city name and province.
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
