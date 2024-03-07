package view;

import java.util.List;

import model.Aircraft;

public class AircraftView {
    // Método para exibir uma lista de aeronaves
    public void displayAircraftList(List<Aircraft> aircraftList) {
        System.out.println("List of Aircraft:");
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraftDetailsToString(aircraft));
        }
    }

    // Método para exibir os detalhes de uma aeronave específica
    public void displayAircraftDetails(Aircraft aircraft) {
        System.out.println("Aircraft Details:");
        System.out.println(aircraftDetailsToString(aircraft));
    }

    // Método utilitário para converter os detalhes de uma aeronave em uma string
    // formatada
    private String aircraftDetailsToString(Aircraft aircraft) {
        return "Model: " + aircraft.getModel() +
                ", Manufacturer: " + aircraft.getManufacturer() +
                ", Year: " + aircraft.getYear() +
                ", Capacity: " + aircraft.getCapacity() +
                ", Autonomy: " + aircraft.getAutonomy() +
                ", Price per Hour: $" + aircraft.getPricePerHour();
    }
}
