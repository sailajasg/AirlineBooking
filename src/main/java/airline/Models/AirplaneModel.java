package airline.Models;


import java.util.HashMap;

/**
 * Created by sailaja on 31/8/17.
 * This class maintains the plane details
 * modified on 6/9/17 to add Business,Economy and FirstClass category
 * */

public class AirplaneModel {
    private String planeID;
    private String planeName;

    private HashMap<TravelClassType.TravelClass,TravelClassModel> travelClass;



    public AirplaneModel(String planeID, String planeName, HashMap<TravelClassType.TravelClass,TravelClassModel> travelClass){
        this.planeID=planeID;
        this.planeName=planeName;
        this.travelClass=travelClass;
    }

    public String getPlaneID() {
        return planeID;
    }


    public String getPlaneName() {
        return planeName;
    }

    public HashMap<TravelClassType.TravelClass, TravelClassModel> getTravelClass() {
        return travelClass;
    }
}
