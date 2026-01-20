package citybike.service;

import citybike.domain.*;

public class RentalService {
    // Logika biznesowa wypożyczeń – nie jest w mainie

    private final DockingStation station;

    public RentalService(DockingStation station) {
        this.station = station;
    }

    public void rentVehicle(String id) {
        for (Vehicle v : station.getAllVehicles()) {
            if (v.getId().equals(id) && v instanceof Rentable r) {
                if (r.isAvailable()) {
                    r.rent();
                }
            }
        }
    }

    public void returnVehicle(String id) {
        for (Vehicle v : station.getAllVehicles()) {
            if (v.getId().equals(id) && v instanceof Rentable r) {
                r.returnBack();
            }
        }
    }
}