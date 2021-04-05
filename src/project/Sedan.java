package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sedan extends Car{
    ArrayList<Sedan> sedan = new ArrayList<>();

    public Sedan() {
        super();
    }

    public Sedan(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID, carBooking);
    }

    public Sedan(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID);
    }

    public void createSedan(){

        sedan.add(new Sedan("Ford - Focus",2018,1.6,true,"Diesel","Comfort","White",60000,250,"SEDAN1"));
        sedan.add(new Sedan("Fiat - Linea",2017,1.3,false,"Diesel","Multijet","White",95000,220,"SEDAN2"));
        sedan.add(new Sedan("Honda - Civic",2020,1.6,true,"LPG - Gasoline","Elegance","Grey",5000,250,"SEDAN3"));
        sedan.add(new Sedan("Toyota - Corolla",2019,1.8,true,"Hybrid","Dream","Blue",25000,190,"SEDAN4"));
        sedan.add(new Sedan("Renault - Megane",2018,1.5,true,"Diesel","Touch","Grey",50000,180,"SEDAN5"));
        sedan.add(new Sedan("Hyundai - Accent Blue",2017,1.6,false,"Diesel","Standard","White",60000,190,"SEDAN6"));
        sedan.add(new Sedan("Dacia - Logan",2010,1.4,false,"Diesel","Economy","Grey",110000,120,"SEDAN7"));
        sedan.add(new Sedan("Citroen - C Elysee",2017,1.6,false,"Diesel","Comfort","White",95000,150,"SEDAN8"));
        cars.addAll(sedan);

    }

    public void displaySedanInfo(){
        for(Car itemReference : sedan){
            itemReference.displayInfo();
        }
    }

    @Override
    public String toString() {
        return "object of the sedan";
    }

}
