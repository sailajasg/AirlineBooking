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

        HashMap<TravelClassType.TravelClass,TravelClassModel> travelClassJet =new HashMap<>();

        travelClassJet.put(TravelClassType.TravelClass.Economy, new TravelClassModel(195, 95,6000));
        travelClassJet.put(TravelClassType.TravelClass.Business, new TravelClassModel(30, 20,8000));
        travelClassJet.put(TravelClassType.TravelClass.FirstClass, new TravelClassModel(10, 10,10000));

        HashMap<TravelClassType.TravelClass,TravelClassModel> travelClassSpice =new HashMap<>();

        travelClassSpice.put(TravelClassType.TravelClass.Economy, new TravelClassModel(100, 50,5700));
        travelClassSpice.put(TravelClassType.TravelClass.Business, new TravelClassModel(30, 20,7600));
        travelClassSpice.put(TravelClassType.TravelClass.FirstClass, new TravelClassModel(10, 10,9800));

        HashMap<TravelClassType.TravelClass,TravelClassModel> travelClassAA =new HashMap<>();

        travelClassAA.put(TravelClassType.TravelClass.Economy, new TravelClassModel(100, 20,6670));
        travelClassAA.put(TravelClassType.TravelClass.Business, new TravelClassModel(30, 20,8550));
        travelClassAA.put(TravelClassType.TravelClass.FirstClass, new TravelClassModel(10, 10,10050));

        HashMap<TravelClassType.TravelClass,TravelClassModel> travelClassAB =new HashMap<>();

        travelClassAB.put(TravelClassType.TravelClass.Economy, new TravelClassModel(100, 50,6070));
        travelClassAB.put(TravelClassType.TravelClass.Business, new TravelClassModel(30, 20,8050));
        travelClassAB.put(TravelClassType.TravelClass.FirstClass, new TravelClassModel(10, 10,10500));

        HashMap<TravelClassType.TravelClass,TravelClassModel> travelClassLF =new HashMap<>();

        travelClassLF.put(TravelClassType.TravelClass.Economy, new TravelClassModel(100, 50,65500));
        travelClassLF.put(TravelClassType.TravelClass.Business, new TravelClassModel(30, 20,8550));
        travelClassLF.put(TravelClassType.TravelClass.FirstClass, new TravelClassModel(10, 10,92000));

        HashMap<TravelClassType.TravelClass,TravelClassModel> travelClassB =new HashMap<>();

        travelClassB.put(TravelClassType.TravelClass.Economy, new TravelClassModel(195, 50,6500));
        travelClassB.put(TravelClassType.TravelClass.Business, new TravelClassModel(30, 20,8500));
        travelClassB.put(TravelClassType.TravelClass.FirstClass, new TravelClassModel(10, 10,9000));


        AirplaneModel JetAirModel=new AirplaneModel("Jet001","Jet AirWays", travelClassJet);
        AirplaneModel SpiceJetModel = new AirplaneModel("SJ001","SpiceJet", travelClassSpice);
        AirplaneModel AirAsiaModel = new AirplaneModel("AA001","Air Asia",travelClassAA);
        AirplaneModel AirBusModel = new AirplaneModel("AB001","AirBus",travelClassAB);
        AirplaneModel LufthansaModel = new AirplaneModel("L001","Lufthansa",travelClassLF);
        AirplaneModel BoeingModel = new AirplaneModel("B001","Boeing",travelClassB);


        planesList.add(new FlightModel(JetAirModel,"JA1","CHN","HYD", LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(SpiceJetModel,"SJ1", "BLR","CHN",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(AirAsiaModel,"AA1", "CHN", "HYD",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(BoeingModel,"B001","CHN","HYD",LocalDate.of(2017,9,11)));
        planesList.add(new FlightModel(AirBusModel,"AB 123A", "BLR","CHN",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(LufthansaModel,"L001", "BLR", "CHN",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(JetAirModel,"JA2","CHN","DEL",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(SpiceJetModel,"SJ2", "BLR","HYD",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(AirAsiaModel,"AA2", "BLR", "CHN",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(BoeingModel,"B002","CHN","HYD",LocalDate.of(2017,9,27)));
        planesList.add(new FlightModel(AirBusModel,"AB123B", "BLR","DEL",LocalDate.of(2017,9,17)));
        planesList.add(new FlightModel(LufthansaModel,"L002", "DEL", "HYD",LocalDate.of(2017,9,17)));

        planesList.add(new FlightModel(JetAirModel,"JA3","HYD","BLR", LocalDate.of(2017,9,14)));
        planesList.add(new FlightModel(SpiceJetModel,"SJ3", "BLR","HYD",LocalDate.of(2017,9,13)));
        planesList.add(new FlightModel(AirAsiaModel,"AA3", "DEL", "HYD",LocalDate.of(2017,9,12)));
        planesList.add(new FlightModel(BoeingModel,"B004","HYD","DEL",LocalDate.of(2017,9,30)));
        planesList.add(new FlightModel(AirBusModel,"AB 123C", "BLR","DEL",LocalDate.of(2017,9,29)));
        planesList.add(new FlightModel(LufthansaModel,"L003", "BLR", "CHN",LocalDate.of(2017,9,28)));
        planesList.add(new FlightModel(JetAirModel,"JA4","CHN","DEL",LocalDate.of(2017,9,16)));
        planesList.add(new FlightModel(SpiceJetModel,"SJ4", "BLR","HYD",LocalDate.of(2017,9,18)));
        planesList.add(new FlightModel(AirAsiaModel,"AA4", "BLR", "DEL",LocalDate.of(2017,9,19)));
        planesList.add(new FlightModel(BoeingModel,"B004","CHN","HYD",LocalDate.of(2017,9,2)));
        planesList.add(new FlightModel(AirBusModel,"AB123D", "BLR","DEL",LocalDate.of(2017,9,15)));
        planesList.add(new FlightModel(LufthansaModel,"L004", "DEL", "BLR",LocalDate.of(2017,9,17)));

        return planesList;
    }
}
