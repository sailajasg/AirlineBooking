package airline.Services;

import airline.Models.FlightModel;
import airline.Models.SearchCriteria;
import airline.Repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlightServices {

    FlightRepository flightRepository = new FlightRepository();

    public List<FlightModel> searchFlight(SearchCriteria searchCriteria) {

        List<FlightModel> flights = flightRepository.getFlights();

        List<FlightModel> resultFlights = new ArrayList<FlightModel>();

        //System.out.println(resultFlights.get(1).getDepartureDate());



       /*return flights.stream().filter(x -> x.getSource().equalsIgnoreCase(searchCriteria.getSource()))
                .filter(x -> x.getDestination().equalsIgnoreCase(searchCriteria.getDestination()))
                .filter(x -> x.getAvailableSeats()>=searchCriteria.getPassengers())
               .filter(x -> x.getDepartureDate().equals(searchCriteria.getDepartureDate()))

                .collect(Collectors.toList());*/

        for (FlightModel planes : flights) {
           // System.out.println(searchCriteria.getSource()+"---"+searchCriteria.getDestination());
            if ((planes.getSource().equalsIgnoreCase(searchCriteria.getSource())) &&
                    (planes.getDestination().equalsIgnoreCase(searchCriteria.getDestination())) &&
                    (planes.getAvailableSeats()>=searchCriteria.getPassengers()) &&
                    (planes.getDepartureDate().equals(searchCriteria.getDepartureDate()) || !(searchCriteria.getDepartureDate()!=null)) ) {
                resultFlights.add(planes);
            }
        }
        return resultFlights;
    }
}
