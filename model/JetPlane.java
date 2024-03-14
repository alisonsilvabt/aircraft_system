package model;

public class JetPlane extends Aircraft {
    private int maxSpeed;

    public JetPlane(String model, String manufacturer, int year, int capacity, int autonomy, double pricePerHour,
            int maxSpeed) {
        super(model, manufacturer, year, capacity, autonomy, pricePerHour);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPricePerHour() {
        double pricePerHour = super.getPricePerHour();
        return pricePerHour * 1.2; // 20% de imposto
    }
}
