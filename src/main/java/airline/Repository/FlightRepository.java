package airline.Repository;

import airline.Models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Sailaja on 31/8/17.
 * This class creates a list of flights
 * */

public class FlightRepository {


    public List<FlightModel> getFlights(){

        List<FlightModel> planesList = new ArrayList<>();

        HashMap<TravelClassType.TravelClass,TravelClassModel> travelClass =new HashMap<>();
        //System.out.println("key::"+TravelClassType.TravelClass.Business);
        travelClass.put(TravelClassType.TravelClass.Economy, new TravelClassModel(100, 50,6000));
        travelClass.put(TravelClassType.TravelClass.Business, new TravelClassModel(30, 20,8000));
        travelClass.put(TravelClassType.TravelClass.FirstClass, new TravelClassModel(10, 10,10000));


        AirplaneModel JetAirModel=new AirplaneModel("Jet001","Jet AirWays", travelClass);
        AirplaneModel SpiceJetModel = new AirplaneModel("SJ001","SpiceJet", travelClass);
        AirplaneModel AirAsiaModel = new AirplaneModel("AA001","Air Asia",travelClass);
        AirplaneModel AirBusModel = new AirplaneModel("AB001","AirBus",travelClass);
        AirplaneModel LufthansaModel = new AirplaneModel("L001","Lufthansa",travelClass);
        AirplaneModel BoeingModel = new AirplaneModel("B001","Boeing",travelClass);


        planesList.add(new FlightModel(JetAirModel,"JA1","CHN","HYD", LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(SpiceJetModel,"SJ1", "BLR","CHN",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(AirAsiaModel,"AA1", "CHN", "HYD",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(BoeingModel,"B001","CHN","HYD",LocalDate.of(2017,9,11)));
        planesList.add(new FlightModel(AirBusModel,"AB 123A", "BLR","CHN",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(LufthansaModel,"L001", "BLR", "CHN",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(JetAirModel,"JA2","CHN","DEL",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(SpiceJetModel,"SJ2", "BLR","HYD",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(AirAsiaModel,"AA2", "BLR", "BLR",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(BoeingModel,"B002","CHN","HYD",LocalDate.of(2017,9,27)));
        planesList.add(new FlightModel(AirBusModel,"AB123B", "BLR","DEL",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(LufthansaModel,"L002", "DEL", "HYD",LocalDate.of(2017,9,17)));

        return planesList;
    }
}
