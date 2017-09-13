package airline.Services;


import airline.Models.FlightModel;
import airline.Models.SearchCriteria;
import airline.Models.ViewModel;
import airline.Repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;



/**
 * Created by sailaja on 31/8/17.
 * This class returns list of flights to controller based on search criteria
 * */

@Service
public class FlightServices {

    FlightRepository flightRepository = new FlightRepository();

    /*method  to filter the available flights based on search criteria*/
//
    public List<FlightModel> searchFlight(SearchCriteria searchCriteria) {

        List<FlightModel> flights = flightRepository.getFlights();

        return flights.stream()
                .filter(searchBetweenSourceAndDestination(searchCriteria))
                .filter(searchForTravelClass(searchCriteria))
                .filter(searchForDepartureDate(searchCriteria))
                .collect(Collectors.toList());
    }

    private Predicate<FlightModel> searchBetweenSourceAndDestination(SearchCriteria searchCriteria) {
        return x -> x.isAvailableFromSourceAndDestination(searchCriteria.getSource(), searchCriteria.getDestination());
    }

    private Predicate<FlightModel> searchForDepartureDate(SearchCriteria searchCriteria) {
        return x -> null == (searchCriteria.getTravelDate()) || x.isFlightAvailableforDepartureDate(searchCriteria.getTravelDate());
    }

    private Predicate<FlightModel> searchForTravelClass(SearchCriteria searchCriteria) {
        return x -> (null == searchCriteria.getClassType() && (searchCriteria.getPassengers() == 0))
                || (x.isSeatsAvailableForSelectedClassType(searchCriteria.getClassType(), searchCriteria.getPassengers()));
    }

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


    public List<ViewModel> returnViewModelFlights(SearchCriteria searchCriteria) {

        List<ViewModel> viewModelList = new ArrayList<>();
        ViewModel viewModelFlights ;

        List<FlightModel> filteredFlightDetails = searchFlight(searchCriteria);
        System.out.println("View Size:"+filteredFlightDetails.size());

        for (FlightModel flight : filteredFlightDetails) {
            viewModelFlights= new ViewModel();
            viewModelFlights.setFlightName(flight.getFlightName());
            viewModelFlights.setSource(flight.getSource());
            viewModelFlights.setDestination(flight.getDestination());
            viewModelFlights.setTravelDate(searchCriteria.getTravelDate());
            viewModelFlights.setTravelClassType(searchCriteria.getClassType());
            viewModelFlights.setBaseFare(flight.getBaseFare(searchCriteria.getClassType()));
            viewModelFlights.setTotalPrice(flight.calculateBaseFare(searchCriteria.getClassType()));

            viewModelList.add(viewModelFlights);
        }
        return viewModelList;
    }
}
