package airline.Models;

import java.time.LocalDate;

public class ViewModel {
    private String source;
    private String destination;
    private String travelClassType;
    private double baseFare;
    private LocalDate travelDate;
    private double totalPrice;
    private String flightName;

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getBaseFare(){return baseFare;}

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }



    public ViewModel(){}

    public ViewModel(String source, String destination, String travelClassType, double baseFare, LocalDate travelDate,String flightName) {
        this.source = source;
        this.destination = destination;
        this.travelClassType = travelClassType;
        this.baseFare = baseFare;
        this.travelDate = travelDate;
        this.flightName=flightName;
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

    public String getTravelClassType() {
        return travelClassType;
    }

    public void setTravelClassType(String travelClassType) {
        this.travelClassType = travelClassType;
    }


    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }
}
