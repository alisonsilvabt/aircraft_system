package model;

import java.util.Date;

public class RentalTransaction {
    private Aircraft aircraft;
    private Date rentalDate;
    private int rentalDurationHours;

    public RentalTransaction(Aircraft aircraft, Date rentalDate, int rentalDurationHours) {
        this.aircraft = aircraft;
        this.rentalDate = rentalDate;
        this.rentalDurationHours = rentalDurationHours;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getRentalDurationHours() {
        return rentalDurationHours;
    }

    public void setRentalDurationHours(int rentalDurationHours) {
        this.rentalDurationHours = rentalDurationHours;
    }
}
