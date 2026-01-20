package citybike.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stacja dokująca przechowująca pojazdy.
 */
public class DockingStation {

    public static final int DEFAULT_CAPACITY = 10;

    private final String name;
    private final int capacity;
    private final List<Vehicle> slots; // Lista pojazdów w stacji

    public DockingStation(String name, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.name = name;
        this.capacity = capacity;
        this.slots = new ArrayList<>();
    }

    // Dodaje pojazd do stacji
    public void dock(Vehicle vehicle) {
        if (slots.size() >= capacity) {
            throw new IllegalStateException("Station is full");
        }
        slots.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return Collections.unmodifiableList(slots);
    }

    public List<Vehicle> availableVehicles() {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : slots) {
            if (v instanceof Rentable r && r.isAvailable()) {
                result.add(v);
            }
        }
        return result;
    }
}