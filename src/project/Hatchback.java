package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hatchback extends Car {
    ArrayList<Hatchback> hatchback = new ArrayList<>();

    public Hatchback(){
        super();
    }

    public Hatchback(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking) {
        super(brand, model, engine, gear, fuel, type, colour, kilometer, dailyHireRate, ID, carBooking);
    }

    public Hatchback(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID){
        super(brand,model,engine,gear,fuel,type,colour,kilometer,dailyHireRate,ID);
    }
    public void createHatchback(){

        hatchback.add(new Hatchback("Mercedes-Benz",2020,4.0,true,"Gasoline","Hatchback","Blue",0,200,"HATCHBACK1"));
        hatchback.add(new Hatchback("Porsche-Panamera",2018,4.0,true,"Gasoline","Hatchback","White",15000,160,"HATCHBACK2"));
        hatchback.add(new Hatchback("Aston Martin-Rapide",2016,6.0,true,"Gasoline","Hatchback","Grey",7943,150,"HATCHBACK3"));
        hatchback.add(new Hatchback("Audi-A7",2020,2.0,true,"Hybrid","Hatchback","Black",3000,220,"HATCHBACK4"));
        hatchback.add(new Hatchback("Tesla-ModelX",2018,4.0,true,"electricity","Hatchback","Red",10000,190,"HATCHBACK5"));
       cars.addAll(hatchback);
    }
    public void displayHatchbackInfo(){
        for(Car itemReference: hatchback){
            itemReference.displayInfo();
        }
    }
    @Override
    public String toString() {
        return "object of the hatchback";
    }
}
