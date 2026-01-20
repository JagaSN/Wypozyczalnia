package citybike.domain;

/**
 * Interfejs do eksportu danych (np. CSV).
 */
public interface Exportable {
    String toCsv();
}