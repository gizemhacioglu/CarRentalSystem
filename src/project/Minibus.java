package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Minibus extends Car {
    ArrayList<Minibus> minibus = new ArrayList<>();
    private int passengerCapacity;

    public Minibus(){
        super();
    }

    public Minibus(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking, int passengerCapacity) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID, carBooking);
        this.passengerCapacity = passengerCapacity;
    }

    public Minibus(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, int passengerCapacity){
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID);
        this.passengerCapacity=passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void createMinibus(){
        minibus.add(new Minibus("Mercedes - Benz",2020,2.5,true,"Diesel","High Ceiling","Black",0,200,"MINIBUS1",9));
        minibus.add(new Minibus("Mercedes - Benz",2020,3.0,true,"Diesel","High ceiling","Brown",5000,230,"MINIBUS2",11));
        minibus.add(new Minibus("Isuzu",2019,4.5,false,"Diesel","High Ceiling","White",20000,270,"MINIBUS3",29));
        minibus.add(new Minibus("Mercedes - Benz",2019,2.5,false,"Diesel","High Ceiling","Gold",3000,250,"MINIBUS4",22));
        cars.addAll(minibus);
    }
    public void displayMinibusInfo(){
        for(Car itemReference: minibus){
            itemReference.displayInfo();
        }
    }
    @Override
    public String toString() {
        return "object of the minibus";
    }

}
