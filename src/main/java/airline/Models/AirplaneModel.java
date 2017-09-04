package airline.Models;

public class AirplaneModel {
    String planeID;
    String planeName;
    int totalCapacity;

    public AirplaneModel(String planeID, String planeName, int totalCapacity) {
        this.planeID = planeID;
        this.planeName = planeName;
        this.totalCapacity = totalCapacity;
    }

    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
}
