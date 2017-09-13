//package airline;

import airline.Models.FlightModel;
import airline.Models.SearchCriteria;
import airline.Services.CityService;
import airline.Services.FlightServices;
import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightSearchTest {
    @DateTimeFormat(pattern="yyyy-mm-dd")

    @Test
    public void shouldReturnCities(){
        CityService cities=new CityService();
        assertEquals(cities.getCities().size(),4);
    }

    @Test
    public void shouldReturnFlightsfromCHNtoHYDfor5Passengers(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",5,"Business");
        //System.out.println(flights.searchFlight(searchCriteria).size());
        assertEquals((flights.searchFlight(searchCriteria).size()),5);
    }

    @Test
    public void shouldReturnFlightsfromCHNtoHYDWhenPassengerCountIs0(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",0);
        assertEquals((flights.searchFlight(searchCriteria).size()),5);
    }

    @Test
    public void shouldReturnNoFlightsfromCHNtoHYDWherePassengerCountIsGreaterThanAvailableSeats(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",1200);
        assertEquals((flights.searchFlight(searchCriteria).size()),0);
    }


    @Test
    public void shouldReturnFlightsFromCHNtoHYDonDeparturedate17SepEconomyclass(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",5,LocalDate.of(2017,9,17),"Economy");
        assertEquals((flights.searchFlight(searchCriteria).size()),2);
    }

    @Test
    public void shouldReturnZeroFlightsFromCHNtoHYDonDeparturedate10SepEconomyclass(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",5,LocalDate.of(2017,9,10),"Economy");
        assertEquals((flights.searchFlight(searchCriteria).size()),0);
    }

    @Test
    public void shouldReturnFlightsFromCHNtoHYDonDeparturedateisNullForEconomyclass(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",5,"Economy");
        assertEquals((flights.searchFlight(searchCriteria).size()),5);
    }

    @Test
    public void shouldReturnZeroFlightsFromCHNtoHYDonDeparturedate17sepForEconomyclassFor200Passengers(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",200,LocalDate.of(2017,9,17),"Economy");
        assertEquals((flights.searchFlight(searchCriteria).size()),0);
    }

    @Test
    public void shouldReturnBaseFareForFlightsFromCHNtoHYDForEconomyclass(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",5,"Economy");
        List<FlightModel> availableFligts = flights.searchFlight(searchCriteria);
        assertEquals(availableFligts.get(0).getBaseFare("Economy"),6000.0,0);
    }

    @Test
    public void shouldReturnTotalFareForFlightsFromCHNtoHYDForEconomyclassBasedOnfillingRates(){
        FlightServices flights = new FlightServices();
        SearchCriteria searchCriteria = new SearchCriteria("CHN","HYD",5,"Economy");
        List<FlightModel> availableFligts = flights.searchFlight(searchCriteria);
        assertEquals(availableFligts.get(0).calculateBaseFare("Economy"),7800.0,0);
    }

}
