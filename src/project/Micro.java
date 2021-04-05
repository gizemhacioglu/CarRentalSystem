package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Micro extends Car {
    ArrayList<Micro> micro = new ArrayList<>();

    public Micro(){
        super();
    }

    public Micro(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID, carBooking);
    }

    public Micro(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID){
        super(brand,model,engine,gear,fuel,type,colour,kilometer,dailyHireRate,ID);
    }
    public void createMicro(){
        micro.add(new Micro("Nissan-Micra",2011,1.2,false,"Gasoline","Standart","White",100000,100,"MICRO1"));
        micro.add(new Micro("Fiat-500C",2016,1.2,false,"Gasoline","Cabrio","White",62000,110,"MICRO2"));
        micro.add(new Micro("Hyundai-i10",2014,1.0,true,"Gasoline","Standart","Red",89000,120,"MICRO3"));
        micro.add(new Micro("Fiat-500C",2020,1.2,true,"Gasoline","Standart","Black",10000,130,"MICRO4"));
        micro.add(new Micro("Toyota-Yaris",2017,1.5,true,"Gasoline","Standart","Blue",29000,100,"MICRO5"));
        cars.addAll(micro);
    }

    public void displayMicroInfo(){
        for(Car itemReference: micro){
            itemReference.displayInfo();
        }
    }
    @Override
    public String toString() {
        return "object of the micro";
    }

}
