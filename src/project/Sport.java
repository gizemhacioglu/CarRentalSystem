package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sport extends Car {
    ArrayList<Sport> sport = new ArrayList<>();
    public Sport() {
    }

    public Sport(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID, carBooking);
    }

    public Sport(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID);
    }

    public void createSport(){

        sport.add(new Sport("BMW - M Series",2018,1.6,true,"Gasoline","Coupe","Blue",50000,500,"SPORT1"));
        sport.add(new Sport("Mercedes - AMG",2017,1.6,false,"Gasoline","Cabrio","Black",45000,550,"SPORT2"));
        sport.add(new Sport("Audi - A3",2018,1.5,false,"Gasoline","Cabrio","White",25000,580,"SPORT3"));
        cars.addAll(sport);
    }
    public void displaySportInfo(){
        for(Car itemReference : sport){
            itemReference.displayInfo();
        }
    }
    @Override
    public String toString() {
        return "object of the sport";
    }

}
