package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Suv extends Car {
    ArrayList<Suv> suv = new ArrayList<>();
    public Suv() {
        super();
    }

    public Suv(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID, carBooking);
    }

    public Suv(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID);
    }

    public void createSuv(){

        suv.add(new Suv("Volkswagen - Tiguan",2019,1.6,false,"Diesel","Standard","White",50000,320,"SUV1"));
        suv.add(new Suv("Hyundai - Cona",2016,1.6,false,"Diesel","Full Size","Red",70000,300,"SUV2"));
        suv.add(new Suv("Fiat - 500x",2020,1.2,true,"Gasoline","Sport","Red",10000,350,"SUV3"));
        suv.add(new Suv("Honda - CR-V",2018,1.5,true,"Hybrid","Executive","Black",40000,350,"SUV4"));
        suv.add(new Suv("Volvo - XC90",2016,2.0,true,"Diesel","Luxury","White",60000,380,"SUV5"));
        cars.addAll(suv);

    }
    public void displaySuvInfo(){
        for(Car itemReference : suv){
            itemReference.displayInfo();
        }
    }

    @Override
    public String toString() {
        return "object of the suv";
    }

}

