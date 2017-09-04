package airline.Services;

import airline.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import airline.Models.Cities;
import airline.Repository.CityRepository;

@Service

public class CityService {
    public List<Cities> getCities(){

    CityRepository cityRepository = new CityRepository();
    List<Cities> cities = cityRepository.getCities();
        return cities;
    }

}
