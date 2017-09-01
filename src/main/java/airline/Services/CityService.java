package airline.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import airline.Models.Cities;

@Service

public class CityService {


     public List<Cities> getCities() {
        List<Cities> cities = new ArrayList<Cities>();

        cities.add(new Cities("Hyderabad","HYD"));
        cities.add(new Cities("Bangalore","BLR"));
        cities.add(new Cities("Chennai","CHN"));
        cities.add(new Cities("Delhi","DEL"));
        return cities;
    }

}
