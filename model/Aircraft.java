package model;

public class Aircraft {
    private String model;
    private String manufacturer;
    private int id;
    private int year;
    private int capacity;
    private int autonomy;
    private double pricePerHour; //encapsulamento

    public Aircraft(String model, String manufacturer, int year, int capacity, int autonomy, double pricePerHour) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.capacity = capacity;
        this.autonomy = autonomy;
        this.pricePerHour = pricePerHour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(int autonomy) {
        this.autonomy = autonomy;
    }

    public double getPricePerHour() {
        return pricePerHour * 1.1; //10% de imposto
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
