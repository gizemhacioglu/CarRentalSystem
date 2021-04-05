package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Truck extends Car {
    ArrayList<Truck> truck = new ArrayList<>();
    private int capacity;
    public Truck(){
        super();
    }

    public Truck(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking, int capacity) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID, carBooking);
        this.capacity = capacity;
    }

    public Truck(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, int capacity){
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID);
        this.capacity=capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void createTruck(){

        truck.add(new Truck("Mercedes - Benz",2020,5.0,true,"Diesel","High Cabin","White",0,300,"TRUCK1",10000));
        truck.add(new Truck("Mercedes - Benz",2013,5.0,false,"Diesel","Standart","White",72118,450,"TRUCK2",40000));
        truck.add(new Truck("MAN",2015,5.0,false,"Diesel","Standart","Grey",50000,370,"TURCK3",20000));
        truck.add(new Truck("Ford Trucks",2019,5.0,false,"Diesel","High Cabin","White",1143,400,"TRUCK4",20000));
        cars.addAll(truck);
    }
    public void displayTruckInfo(){
        for(Car itemReference: truck){
            itemReference.displayInfo();
        }
    }
    @Override
    public String toString() {
        return "object of the truck";
    }

}
