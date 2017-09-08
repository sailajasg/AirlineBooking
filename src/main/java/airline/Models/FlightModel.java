package airline.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static airline.Models.TravelClassType.TravelClass.Business;
import static airline.Models.TravelClassType.TravelClass.Economy;
import static airline.Models.TravelClassType.TravelClass.FirstClass;


/**
 * Created by sailaja on 31/8/17.
 * This class maintians the flight information
 * Modified on 6/9/17 to add Class type
 * */

public class FlightModel {
    private String flightID;
    private String flightName;
    private String source;
    private String destination;

    private AirplaneModel airplaneModel;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;



    public FlightModel(AirplaneModel airplaneModel,String flightName, String source, String destination){
        this.flightName=flightName;
        this.source=source;
        this.destination=destination;

    }


    public FlightModel(AirplaneModel airplaneModel,String flightName, String source, String destination,  LocalDate departureDate){
        this.flightName=flightName;
        this.source=source;
        this.destination=destination;
        this.departureDate=departureDate;
        this.airplaneModel=airplaneModel;
    }

    private String getFlightID() {
        return flightID;
    }



    private AirplaneModel getAirplaneModel() {
        return airplaneModel;
    }



    private LocalDate getDepartureDate() {
        return departureDate;
    }



    public String getSource() {
        return source;
    }



    public String getDestination() {
        return destination;
    }



    public String getFlightName() {
        return flightName;
    }


    /* This method verifies the availability of flights between given source and destination */
    public boolean isavailableFromSourceAndDestination(String source, String destination){

        if((source.equalsIgnoreCase(getSource())) && (destination.equalsIgnoreCase(getDestination())))
            return  true;
        else
            return false;
    }


    /* This method verifies the availability of flights for the given departure date*/
    public boolean isFlightAvailbleforDepartureDate(LocalDate departureDate){
        if(departureDate!=null) {
            if (departureDate.equals(getDepartureDate()))
                return true;
            else
                return false;
        }
        else
            return true;
    }

    /* This method verifies the availability of seats for the given class type and the passengers*/

    public boolean isSeatsAvailableForSelectedClassType(String classType, int numberOfPassengers){

        int availableSeats=0;

        //TravelClassType.TravelClass travelType = Business;

        switch (classType){
            case "Business":
                availableSeats=getAirplaneModel().getTravelClass().get(Business).getAvailableSeats();
                //System.out.println("business:"+availableSeats);
                break;
            case "Economy":
                availableSeats=getAirplaneModel().getTravelClass().get(Economy).getAvailableSeats();

                break;
            case "FirstClass":
                availableSeats=getAirplaneModel().getTravelClass().get(FirstClass).getAvailableSeats();

                break;
        }


        if(availableSeats>=numberOfPassengers){
            return true;
        }
        else{
            return false;
        }
    }


}
