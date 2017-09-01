package airline.Models;

public class AirplaneModel {
    String airPlaneName;
    String source;
    String destination;

    public AirplaneModel(String airPlaneName, String source, String destination){
        this.airPlaneName=airPlaneName;
        this.source=source;
        this.destination=destination;
    }

    public String getAirPlaneName() {
        return airPlaneName;
    }

    public void setAirPlaneName(String airPlaneName) {
        this.airPlaneName = airPlaneName;
    }

    public String getSource() {
        return source;
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



}
