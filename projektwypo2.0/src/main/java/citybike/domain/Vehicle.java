package citybike.domain;

/**
 * Abstrakcyjna klasa bazowa dla wszystkich pojazdów.
 */
public abstract class Vehicle {
    // Klasa abstrakcyjna – nie można tworzyć jej obiektów bezpośrednio.
    // Służy jako wspólna baza dla wszystkich pojazdów (Bike, EBike).
    protected final String id; // Unikalny identyfikator pojazdu
    protected boolean locked; // Czy pojazd jest zablokowany (nieużywany / używany)

    public Vehicle(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.id = id;
        this.locked = true;
    }

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getId() {
        return id;
    }

    // Każda klasa potomna MUSI opisać się własnym tekstem
    public abstract String getDescription();
}