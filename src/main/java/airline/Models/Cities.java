package airline.Models;

public class Cities {
    String cityName;
    String cityID;

    public Cities(String cityName, String cityID){
        this.cityName=cityName;
        this.cityID=cityID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
