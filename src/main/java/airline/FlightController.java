package airline;

import airline.Models.FlightModel;
import airline.Models.Cities;
import airline.Models.FlightModel;
import airline.Models.SearchCriteria;

import airline.Services.CityService;
import airline.Services.FlightServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
@SpringBootApplication
public class FlightController {

    @Autowired
    private CityService cityService;

    @Autowired
    private FlightServices flightServices;

    @RequestMapping("/")

    public String welcomeMessage(Model model) {


        final List<Cities> cities = cityService.getCities();


        model.addAttribute("cities",cities);
        model.addAttribute("searchCriteria",new SearchCriteria());

      return "flightSearch";

    }

    @RequestMapping(value="/airlineSearch", method=RequestMethod.POST)
    public String airPlaneSearch(@ModelAttribute(value="SearchCriteria") SearchCriteria searchCriteria , Model model){

    //final List<AirplaneModel> planesList =flightServices.getFlights();
        if((searchCriteria.getPassengers()==0)){searchCriteria.setPassengers(1);}
        //System.out.println(searchCriteria.getDepartureDate());

        final List<FlightModel> availableFlights =  flightServices.searchFlight(searchCriteria);

        model.addAttribute("result",availableFlights);
        model.addAttribute("passengers",searchCriteria.getPassengers());
        return "flightSearchResult";

    }




}
