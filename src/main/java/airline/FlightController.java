package airline;

import airline.Models.AirplaneModel;
import airline.Models.Cities;
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

    public static void main(String []args) {
        SpringApplication.run(FlightController.class,args);
    }


    @Autowired
    private CityService cityService;

    @Autowired
    private FlightServices flightServices;

    @RequestMapping("/")

    public String welcomeMessage(Model model) {


        final List<Cities> cities = cityService.getCities();


        model.addAttribute("cities",cities);

      return "flightSearch";

    }

    @RequestMapping(value="/airlineSearch", method=RequestMethod.POST)
    public String airPlaneSearch(Model model, @RequestParam String source, @RequestParam String destination){

        //final List<AirplaneModel> planesList =flightServices.getFlights();

        final List<AirplaneModel> availableFlights =  flightServices.searchFlight(source,destination);

        model.addAttribute("result",availableFlights);
        return "flightSearchResult";

    }




}
