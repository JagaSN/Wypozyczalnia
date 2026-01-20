package citybike.domain;

/**
 * Interfejs definiujący kontrakt wypożyczania.
 */
public interface Rentable {
    void rent();
    void returnBack();
    boolean isAvailable();
}