package airline.Services;

import airline.Models.AirplaneModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FlightServices {


    public List<AirplaneModel> getFlights(){

        List<AirplaneModel> planesList = new ArrayList<AirplaneModel>();

        planesList.add(new AirplaneModel("JetAirways","Chennai","Hyderabad"));
        planesList.add(new AirplaneModel("SpiceJet", "Bangalore","Chennai"));
        planesList.add(new AirplaneModel("Air Asia", "Chennai", "Hyderabad"));
        planesList.add(new AirplaneModel("Boeing","Chennai","Hyderabad"));
        planesList.add(new AirplaneModel("AirBus 123A", "Bangalore","Chennai"));
        planesList.add(new AirplaneModel("Lufthansa", "Bangalore", "Chennai"));

        return planesList;
    }
    public List<AirplaneModel> searchFlight(String source,String destination) {

        List<AirplaneModel> planesList = getFlights();


        List<AirplaneModel> resultFlights = new ArrayList<AirplaneModel>();
        for (AirplaneModel planes : planesList) {
            if ((planes.getSource().equalsIgnoreCase(source)) && (planes.getDestination().equalsIgnoreCase(destination))) {
                resultFlights.add(planes);
            }
        }
        return resultFlights;
    }
}
