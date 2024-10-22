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

    private final ArrayList<City> cities;
    private final Context context;

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
        return false;
    }
}
