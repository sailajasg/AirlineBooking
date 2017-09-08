package airline.Models;

public class TravelClassModel{
    private int totalSeats;
    private int availableSeats;
    private double baseFare;

    public TravelClassModel(){    }

    public TravelClassModel(int totalSeats, int availableSeats, double baseFare) {

        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.baseFare = baseFare;
    }



    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getBaseFare() {
        return baseFare;
    }
}
