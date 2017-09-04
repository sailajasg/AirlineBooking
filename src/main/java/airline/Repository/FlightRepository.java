package airline.Repository;

import airline.Models.AirplaneModel;
import airline.Models.FlightModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightRepository {

    private static FlightRepository single_instance=null;

    // static method to create instance of Singleton class
    public static FlightRepository Singleton()
    {
        // To ensure only one instance is created
        if (single_instance == null)
        {
            single_instance = new FlightRepository();
        }
        return single_instance;
    }

    public List<FlightModel> getFlights(){

        List<FlightModel> planesList = new ArrayList<FlightModel>();

        AirplaneModel JetAirModel=new AirplaneModel("Jet001","Jet AirWays",100);
        AirplaneModel SpiceJetModel = new AirplaneModel("SJ001","SpiceJet",10);
        AirplaneModel AirAsiaModel = new AirplaneModel("AA001","Air Asia",2);
        AirplaneModel AirBusModel = new AirplaneModel("AB001","AirBus",10);
        AirplaneModel LufthansaModel = new AirplaneModel("L001","Lufthnsa",6);
        AirplaneModel BoeingModel = new AirplaneModel("B001","Boeing",6);



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
