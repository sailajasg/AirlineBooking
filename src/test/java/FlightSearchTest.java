//package airline;

import airline.Models.SearchCriteria;
import airline.Services.CityService;
import airline.Services.FlightServices;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightSearchTest {
    @Test
    public void shouldReturnCities(){
        CityService cities=new CityService();
        assertEquals(cities.getCities().size(),4);
    }

    @Test
    public void shouldReturnFlightsfromCHNtoHYD(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",5);
        //System.out.println(flights.searchFlight(searchCriteria).size());
        assertEquals((flights.searchFlight(searchCriteria).size()),4);
    }

    @Test
    public void shouldReturnFlightsfromCHNtoHYDWhenPassengerCountIs0(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",5);
        assertEquals((flights.searchFlight(searchCriteria).size()),4);
    }

    @Test
    public void shouldReturnNoFlightsfromCHNtoHYDWherePassengerCountIsGreaterThanAvailableSeats(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",150);
        assertEquals((flights.searchFlight(searchCriteria).size()),0);
    }

}
