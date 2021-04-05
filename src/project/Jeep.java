package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Jeep extends Car {
    ArrayList<Jeep> jeep = new ArrayList<>();

    public Jeep() {
        super();
    }

    public Jeep(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID, carBooking);
    }

    public Jeep(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID);
    }

    public void createJeep() {

        jeep.add(new Jeep("Jeep-Grand Cherokee", 2017, 3.0, true, "Diesel", "Standard", "Black", 31000, 200, "JEEP1"));
        jeep.add(new Jeep("Jeep-CJ", 1980, 3.0, false, "Diesel", "Suv", "Red", 70000, 210, "JEEP2"));
        jeep.add(new Jeep("Jeep-Commander", 2007, 3.0, true, "Diesel", "Suv", "Black", 250000, 220, "JEEP3"));
        jeep.add(new Jeep("Jeep-Wrangler", 2015, 2.8, true, "Diesel", "Suv", "Black", 30000, 200, "JEEP4"));
        jeep.add(new Jeep("Rolls-Royce", 2020, 6.7, true, "Gasoline", "Suv", "Grey", 5000, 210, "JEEP5"));
        cars.addAll(jeep);
    }

    public void displayJeepInfo() {
        for (Car itemReference : jeep) {
            itemReference.displayInfo();
        }
    }
    @Override
    public String toString() {
        return "object of the jeep";
    }
}
