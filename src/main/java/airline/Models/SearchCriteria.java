package airline.Models;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class SearchCriteria {
    String source;
    String destination;
    int passengers;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate departureDate;

    public SearchCriteria(){

    }
    public SearchCriteria(String source,String destination,int passengers){
        this.passengers=passengers;
        this.source=source;
        this.destination=destination;

    }
    public SearchCriteria(String source,String destination,int passengers,LocalDate departureDate){
        this.passengers=passengers;
        this.source=source;
        this.destination=destination;
        this.departureDate=departureDate;
    }
    public String getSource() {
        return source;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
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

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
