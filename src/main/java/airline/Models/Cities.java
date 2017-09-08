package airline.Models;


/**
 * Created by sailaja on 31/8/17.
 * This class maintians cities
 * */

public class Cities {
    private String cityName;
    private String cityID;

    public Cities(String cityName, String cityID){
        this.cityName=cityName;
        this.cityID=cityID;
    }

    public String getCityID() {
        return cityID;
    }

    public String getCityName() {
        return cityName;
    }

}
