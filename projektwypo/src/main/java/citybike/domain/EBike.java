package citybike.domain;

/**
 * Klasa reprezentująca rower elektryczny.
 */
public class EBike extends Vehicle implements Rentable, Exportable {
    // Dziedziczenie + interfejsy

    private final int batteryWh; // Pojemność baterii w Wh
    private AssistLevel assistLevel; // Enum – poziom wspomagania
    private boolean rented;

    public EBike(String id, int batteryWh) {
        super(id);
        if (batteryWh < 0) {
            throw new IllegalArgumentException("Battery must be >= 0");
        }
        this.batteryWh = batteryWh;
        this.assistLevel = AssistLevel.LOW;
        this.rented = false;
    }

    public void increaseAssist() {
        switch (assistLevel) {
            case LOW -> assistLevel = AssistLevel.MEDIUM;
            case MEDIUM -> assistLevel = AssistLevel.HIGH;
            case HIGH -> {}
        }
    }

    @Override
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
        return "EBike " + batteryWh + "Wh, assist=" + assistLevel;
    }

    @Override
    public String toCsv() {
        return id + ",EBike," + batteryWh + "," + assistLevel + "," + (isAvailable() ? "dostępny" : "wypożyczony");
    }
}