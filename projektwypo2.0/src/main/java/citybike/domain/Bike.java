package citybike.domain;

/**
 * Klasa reprezentująca zwykły rower.
 */
public class Bike extends Vehicle implements Rentable, Exportable {
    // extends Vehicle -> dziedziczenie
    // implements Rentable, Exportable -> realizacja kontraktów

    private final int gearCount; // Liczba biegów – cecha specyficzna dla Bike
    private boolean rented; // Czy rower jest aktualnie wypożyczony

    public Bike(String id, int gearCount) {
        super(id);
        if (gearCount <= 0) {
            throw new IllegalArgumentException("Gear count must be > 0");
        }
        this.gearCount = gearCount;
        this.rented = false;
    }

    @Override
    // Metoda z interfejsu Rentable – zmienia stan obiektu na wypożyczony
    public void rent() {
        if (!rented) {
            rented = true;
            unlock();
        }
    }

    @Override
    public void returnBack() {
        rented = false;
        lock();
    }

    @Override
    public boolean isAvailable() {
        return !rented;
    }

    @Override
    public String getDescription() {
        return "Bike with " + gearCount + " gears";
    }

    @Override
    public String toCsv() {
        return id + ",Bike," + gearCount + "," + (isAvailable() ? "dostępny" : "wypożyczony");
    }
}