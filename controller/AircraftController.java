package controller;
import java.util.ArrayList;
import java.util.List;

import model.Aircraft;

public class AircraftController {
    private List<Aircraft> aircraftList;
    private int nextId;

    public AircraftController() {
        aircraftList = new ArrayList<>();
        nextId = 1;
    }

    public void addAircraft(Aircraft aircraft) {
        aircraft.setId(nextId++);
        aircraftList.add(aircraft);
    }

    public List<Aircraft> getAllAircraft() {
        return aircraftList;
    }

    public Aircraft getAircraftById(int id) {
        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getId() == id) {
                return aircraft;
            }
        }
        return null;
    }

    public void updateAircraft(Aircraft updatedAircraft) {
        for (int i = 0; i < aircraftList.size(); i++) {
            Aircraft aircraft = aircraftList.get(i);
            if (aircraft.getId() == updatedAircraft.getId()) {
                aircraftList.set(i, updatedAircraft);
                return;
            }
        }
    }

    public void deleteAircraft(Aircraft aircraftToDelete) {
        aircraftList.removeIf(aircraft -> aircraft.getId() == aircraftToDelete.getId());
    }
}
