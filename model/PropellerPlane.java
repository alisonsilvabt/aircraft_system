package model;

public class PropellerPlane extends Aircraft {
    private int maxAltitude;

    public PropellerPlane(String model, String manufacturer, int year, int capacity, int autonomy, double pricePerHour,
            int maxAltitude) {
        super(model, manufacturer, year, capacity, autonomy, pricePerHour);
        this.maxAltitude = maxAltitude;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }
}
