package citybike.app;

import citybike.domain.*;
import citybike.service.*;

/**
 * Klasa demonstracyjna – warstwa uruchomieniowa.
 * Pokazuje działanie całego systemu krok po kroku.
 */
public class App {
    // Metoda startowa – pokazuje działanie systemu krok po kroku
    public static void main(String[] args) {

        System.out.println("=== START SYSTEMU WYPOŻYCZALNI ===");

        // Tworzymy stację
        DockingStation station = new DockingStation("Centrum", 5);

        // Tworzymy pojazdy
        Bike bike1 = new Bike("B1", 6);
        Bike bike2 = new Bike("B2", 3);
        EBike ebike1 = new EBike("E1", 450); // HIGH – dużo baterii
        EBike ebike2 = new EBike("E2", 150); // LOW – mało baterii

        // Dodajemy pojazdy do stacji
        station.dock(bike1);
        station.dock(bike2);
        station.dock(ebike1);
        station.dock(ebike2);

        System.out.println("Dodano pojazdy do stacji.");

        // Tworzymy serwisy
        RentalService rentalService = new RentalService(station);
        ReportingService reportingService = new ReportingService();

        // Raport początkowy
        System.out.println("\n--- RAPORT POCZĄTKOWY (DOSTĘPNOŚĆ) ---");
        System.out.println(reportingService.generateCsv(station));

        // Wypożyczenia
        System.out.println("Wypożyczam B1 i E2...");
        rentalService.rentVehicle("B1");
        rentalService.rentVehicle("E2");

        // Raport po wypożyczeniach
        System.out.println("\n--- RAPORT PO WYPOŻYCZENIACH (ZMIANA STANU) ---");
        System.out.println(reportingService.generateCsv(station));

        // Zwrot
        System.out.println("Zwracam B1...");
        rentalService.returnVehicle("B1");

        // Raport końcowy
        System.out.println("\n--- RAPORT KOŃCOWY (PO ZWROCIE) ---");
        System.out.println(reportingService.generateCsv(station));

        System.out.println("=== KONIEC DEMONSTRACJI ===");
    }
}