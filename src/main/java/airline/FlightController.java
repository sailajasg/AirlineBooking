package airline;

import airline.Models.*;
import airline.Models.FlightModel;

import airline.Services.CityService;
import airline.Services.FlightServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sailaja on 31/8/17.
 */
@Controller
@SpringBootApplication
public class FlightController {

    @Autowired
    private CityService cityService;

    @Autowired
    private FlightServices flightServices;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @RequestMapping("/")

    public String welcomeMessage(Model model) {


        final List<Cities> cities = cityService.getCities();

//List the available cities
        model.addAttribute("cities",cities);

        model.addAttribute("searchCriteria",new SearchCriteria());

//restrict the date picker to take entries from todays date
        LocalDate today= LocalDate.now();
        model.addAttribute("today",today);

//list the travel class types to view
        List<TravelClassType.TravelClass> travelClassList = Arrays.asList(TravelClassType.TravelClass.values());
       // System.out.println("List:"+travelClassList.size());
        model.addAttribute("travelClassList",travelClassList);

      return "flightSearch";

    }

    @RequestMapping(value="/airlineSearch", method=RequestMethod.POST)
    public String airPlaneSearch(@ModelAttribute(value="SearchCriteria") SearchCriteria searchCriteria , Model model){

    //final List<AirplaneModel> planesList =flightServices.getFlights();
        if((searchCriteria.getPassengers()==0))
        {
            searchCriteria.setPassengers(1);
        }

        final List<FlightModel> availableFlights =  flightServices.searchFlight(searchCriteria);



        model.addAttribute("result",availableFlights);
        model.addAttribute("passengers",searchCriteria.getPassengers());

        model.addAttribute("classType",searchCriteria.getClassType());



        return "flightSearchResult";

    }




}
