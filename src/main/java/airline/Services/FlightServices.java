package airline.Services;


import airline.Models.FlightModel;
import airline.Models.SearchCriteria;
import airline.Repository.FlightRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;



/**
 * Created by sailaja on 31/8/17.
 * This class returns list of flights to controller based on search criteria
 * */

@Service
public class FlightServices {

    FlightRepository flightRepository = new FlightRepository();

    public List<FlightModel> searchFlight(SearchCriteria searchCriteria) {

        List<FlightModel> flights = flightRepository.getFlights();

       return flights.stream()
               .filter(x -> x.isavailableFromSourceAndDestination(searchCriteria.getSource(),searchCriteria.getDestination()))

                .filter(x -> x.isSeatsAvailableForSelectedClassType(searchCriteria.getClassType(),searchCriteria.getPassengers()))
               .filter(x -> x.isFlightAvailbleforDepartureDate(searchCriteria.getDepartureDate()))
                .collect(Collectors.toList());

        /*for (FlightModel planes : flights) {

          // System.out.println("AvailableSeats "+availableSeats);

            if ((planes.isavailableFromSourceAndDestination(searchCriteria.getSource(),searchCriteria.getDestination())) &&
                    (planes.isSeatsAvailableForSelectedClassType(searchCriteria.getClassType(),searchCriteria.getPassengers())) &&
                    ((planes.isFlightAvailbleforDepartureDate(searchCriteria.getDepartureDate())
                            || !(searchCriteria.getDepartureDate() != null))) ){
                                     resultFlights.add(planes);
                }

        }

        return resultFlights;*/
    }



}
