package airline.Models;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by sailaja on 01/9/17.
 * This class maintains search fields from view
 * */
public class SearchCriteria {
    private String source;
    private String destination;
    private int passengers;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate travelDate;
    private String classType;

    public SearchCriteria(){ }
    public SearchCriteria(String source,String destination,int passengers){
        this.passengers=passengers;
        this.source=source;
        this.destination=destination;

    }
    public SearchCriteria(String source,String destination,int passengers,LocalDate travelDate){
        this.passengers=passengers;
        this.source=source;
        this.destination=destination;
        this.travelDate=travelDate;
    }
    public SearchCriteria(String source,String destination,int passengers,String classType){
        this.passengers=passengers;
        this.source=source;
        this.destination=destination;
        this.classType=classType;
    }

    public SearchCriteria(String source,String destination,int passengers,LocalDate travelDate,String classType){
        this.passengers=passengers;
        this.source=source;
        this.destination=destination;
        this.travelDate=travelDate;
        this.classType=classType;
    }

    public String getSource() {
        return source;
    }

    public LocalDate getTravelDate() {  return travelDate;   }

    public String getDestination() {
        return destination;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setSource(String source) { this.source = source;   }

    public void setDestination(String destination) {  this.destination = destination;    }

    public void setTravelDate(LocalDate travelDate) {  this.travelDate = travelDate;    }

    public void setClassType(String classType) { this.classType = classType;   }

    public String getClassType() {
        return classType;
    }


}
