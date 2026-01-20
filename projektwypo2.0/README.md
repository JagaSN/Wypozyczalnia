# CityBike – System Wypożyczalni Rowerów

## Funkcjonalności
- Obsługa różnych typów pojazdów (Bike, EBike)
- Dziedziczenie i polimorfizm
- Interfejsy (Rentable, Exportable)
- Enum (AssistLevel)
- Wypożyczanie i zwroty
- Sprawdzanie dostępności
- Eksport danych do CSV
- Walidacja danych w konstruktorach
- Hermetyzacja danych

## Struktura pakietów
- citybike.app – klasa startowa (App)
- citybike.domain – logika domenowa (Vehicle, Bike, EBike, interfejsy, enumy)
- citybike.service – serwisy (RentalService, ReportingService)

## Wymagania
- Java 
- IntelliJ IDEA 

## Jak uruchomić
1. Otwórz IntelliJ IDEA
2. File → Open → wybierz folder projektu
3. Otwórz klasę citybike.app.App
4. Kliknij Run

## Przykładowe wyjście
id,type,info
B1,Bike,6
E1,EBike,400,LOW

## Zastosowane zagadnienia OOP
- Abstrakcja
- Dziedziczenie
- Polimorfizm
- Enkapsulacja
- Interfejsy
- Walidacja danych
- Stałe public static final

## Autor
Hubert Wittbrodt, Jan Wirkus