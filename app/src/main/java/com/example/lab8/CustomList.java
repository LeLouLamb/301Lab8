package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }
    /**
     * Checks if the list contains the specified City.
     *
     * This method determines whether the internal list of cities contains the given {@code city}.
     * The check is performed using the {@link java.util.List#contains(Object)} method, which
     * relies on the {@link City#equals(Object)} method to compare the specified {@code city}
     * with the cities already present in the list.
     *
     * <p> The method returns {@code true} if the city is found in the list and {@code false} otherwise.
     * This method can be used to verify if a specific City object is present in the list before performing
     * operations such as deleting or modifying a city.
     *
     * <p> Example Usage:
     * <pre>
     *     CityManager cityManager = new CityManager();
     *     City toronto = new City("Toronto", "Ontario");
     *     cityManager.addCity(toronto);
     *
     *     // Check if Toronto is in the list
     *     boolean containsToronto = cityManager.hasCity(toronto);  // Returns true
     *
     *     // Check for a city not in the list
     *     City montreal = new City("Montreal", "Quebec");
     *     boolean containsMontreal = cityManager.hasCity(montreal);  // Returns false
     * </pre>
     *
     * <p> Use Case Scenarios:
     * <ul>
     *   <li>Checking for the existence of a city in the list before deleting or modifying it.</li>
     *   <li>Ensuring no duplicate cities are added to the list by checking if the city already exists.</li>
     *   <li>Validating user input by verifying if a particular city has been previously added.</li>
     * </ul>
     *
     * @param city The {@code City} object to check for in the list. It must match an existing city
     *             in the list based on the {@code equals} method of the City class.
     * @return {@code true} if the specified city is found in the list, {@code false} otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }
    /**
     * Deletes the specified City from the list if it exists, otherwise throws an exception.
     *
     * This method attempts to remove the given {@code city} from the internal list of cities.
     * If the city is successfully removed, the method completes normally. However, if the
     * specified city is not found in the list, an {@code IllegalArgumentException} is thrown
     * to indicate that the deletion was not successful.
     *
     * <p> The method relies on the {@link java.util.List#remove(Object)} method, which checks
     * if the list contains the specified city based on the {@link #equals(Object)} method
     * implementation of the {@code City} class. If the city is found, it is removed from
     * the list, and the list is updated accordingly.
     *
     * <p> Example Usage:
     * <pre>
     *     CityManager cityManager = new CityManager();
     *     City toronto = new City("Toronto", "Ontario");
     *     cityManager.addCity(toronto);
     *
     *     // Attempt to delete Toronto from the list
     *     cityManager.delete(toronto);  // Successfully removes the city
     *
     *     // Attempt to delete a city that is not in the list
     *     City montreal = new City("Montreal", "Quebec");
     *     cityManager.delete(montreal);  // Throws IllegalArgumentException
     * </pre>
     *
     * <p> Use Case Scenarios:
     * <ul>
     *   <li>Removing cities that are no longer needed from the list.</li>
     *   <li>Ensuring that a specific city is deleted only if it exists in the list.</li>
     *   <li>Handling errors by throwing an exception when an invalid deletion is attempted.</li>
     * </ul>
     *
     * @param city The {@code City} object to be removed from the list.
     *             It must match an existing city in the list based on the {@code equals} method.
     * @throws IllegalArgumentException If the city could not be found and removed from the list.
     */
    public void deleteCity(City city) {
        if (!cities.remove(city))
            throw new IllegalArgumentException("City could not be removed: " + city.getCityName());
    }
    /**
     * Returns the number of cities in the current list.
     *
     * This method provides the total count of City objects contained in the list of cities
     * managed by this class. It can be used to determine how many City objects have been
     * added to the list at any point.
     *
     * Example:
     * <pre><code>
     *     List&lt;City&gt; cities = new ArrayList&lt;&gt;();
     *     cities.add(new City("Toronto", "Ontario"));
     *     cities.add(new City("Vancouver", "British Columbia"));
     *     int count = countCities();  // Returns the number of cities in the list
     * </code></pre>
     *
     * @return The number of cities currently stored in the list.
     */
    public int countCities() {
        return cities.size();
    }
}
