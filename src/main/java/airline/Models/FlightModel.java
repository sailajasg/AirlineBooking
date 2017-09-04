package airline.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class FlightModel {
    String flightID;
    String flightName;
    String source;
    String destination;

    AirplaneModel airplaneModel;

    int totalCapacity;
    int availableSeats;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate departureDate;

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public AirplaneModel getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(AirplaneModel airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public FlightModel(AirplaneModel airplaneModel,String flightName, String source, String destination){
        this.flightName=flightName;
        this.source=source;
        this.destination=destination;

        this.totalCapacity=airplaneModel.totalCapacity;
        this.availableSeats=totalCapacity;

    }


    public FlightModel(AirplaneModel airplaneModel,String flightName, String source, String destination,  LocalDate departureDate){
        this.flightName=flightName;
        this.source=source;
        this.destination=destination;
        this.totalCapacity=airplaneModel.totalCapacity;
        this.availableSeats=totalCapacity;
        this.departureDate=departureDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirPlaneName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = getAirplaneModel().totalCapacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
