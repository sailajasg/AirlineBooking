package airline.Repository;

import airline.Models.Cities;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by sailaja on 31/8/17.
 * This class creates list of cities
 * */

public class CityRepository {
    private static CityRepository single_instance=null;

    // static method to create instance of Singleton class
    public static CityRepository Singleton()
    {
        // To ensure only one instance is created
        if (single_instance == null)
        {
            single_instance = new CityRepository();
        }
        return single_instance;
    }

    public List<Cities> getCities() {
         List<Cities> cities = new ArrayList<Cities>();

        cities.add(new Cities("Hyderabad","HYD"));
        cities.add(new Cities("Bangalore","BLR"));
        cities.add(new Cities("Chennai","CHN"));
        cities.add(new Cities("Delhi","DEL"));
        return cities;
    }
}
