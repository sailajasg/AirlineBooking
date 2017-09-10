package airline.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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


    TravelClassType.TravelClass business = TravelClassType.TravelClass.Business;
    TravelClassType.TravelClass economy = TravelClassType.TravelClass.Economy;
    TravelClassType.TravelClass firstClass= TravelClassType.TravelClass.FirstClass;

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



    public AirplaneModel getAirplaneModel() {
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
    public boolean isAvailableFromSourceAndDestination(String source, String destination){

        if((source.equalsIgnoreCase(getSource())) && (destination.equalsIgnoreCase(getDestination())))
            return  true;
        else
            return false;
    }


    /* This method verifies the availability of flights for the given departure date*/
    public boolean isFlightAvailableforDepartureDate(LocalDate departureDate){
        if(departureDate!=null) {
            if (departureDate.equals(getDepartureDate()))
                return true;
            else
                return false;
        }
        else
            return true;
    }

    public TravelClassModel getFlightClassTypeModel(TravelClassType.TravelClass travelClass){

            return getAirplaneModel().getTravelClass().get(travelClass);
    }


    /* This method verifies the availability of seats for the given class type and the passengers*/

    public boolean isSeatsAvailableForSelectedClassType(String classType, int numberOfPassengers){

        int availableSeats=0;

        //TravelClassType.TravelClass travelType = Business;
        if(classType!=null) {
            switch (classType) {
                case "Business":
                    availableSeats = getFlightClassTypeModel(business).getAvailableSeats();
                    break;
                case "Economy":
                    availableSeats = getFlightClassTypeModel(economy).getAvailableSeats();
                    break;
                case "FirstClass":
                    availableSeats = getFlightClassTypeModel(firstClass).getAvailableSeats();
                    break;
                default:
                    availableSeats=0;
                    break;
            }

        }

        if(availableSeats>=numberOfPassengers){
            return true;
        }
        else{
            return false;
        }
    }

    public double getBaseFare(String travelClass){
        double baseFare=0;
        switch (travelClass){
            case "Business":
                baseFare=getFlightClassTypeModel(business).getBaseFare();
            //System.out.println("business:"+availableSeats);
                break;
            case "Economy":
                int availableSeats=getFlightClassTypeModel(economy).getAvailableSeats();
                int totalSeats=getFlightClassTypeModel(economy).getTotalSeats();
                double basicFare = getFlightClassTypeModel(economy).getBaseFare();

                if(availableSeats<=totalSeats*0.4) {
                    //System.out.println("Inside 40%");
                    baseFare = basicFare;
                }
                else if(availableSeats>totalSeats*0.40 && availableSeats<=totalSeats *0.90) {
                   // System.out.println("inside 90%");
                    baseFare = basicFare + (basicFare *0.30);
                }
                else
                    baseFare=basicFare+(basicFare*0.60);
                break;
            case "FirstClass":
                baseFare=getFlightClassTypeModel(firstClass).getBaseFare();
                break;
        }
        return baseFare;
    }

}
