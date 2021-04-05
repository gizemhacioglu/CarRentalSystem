package project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Car {

    private String brand;
    private int model;
    private double engine;
    private boolean gear;
    private String fuel;
    private String type;
    private String colour;
    private double kilometer;
    private double dailyHireRate;
    private String ID;
    private LocalDate carBooking;
    ArrayList<Car> cars = new ArrayList<>();

    public Car(){
        brand="No brand";
        model=0;
        engine=0.0;
        gear=false;
        fuel="/No fuel type/";
        type="No type";
        colour="No colour";
        kilometer=0.0;
        dailyHireRate=0.0;
        ID="No ID";
    }

    public Car(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID, LocalDate carBooking) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.gear = gear;
        this.fuel = fuel;
        this.type = type;
        this.colour = colour;
        this.kilometer = kilometer;
        this.dailyHireRate = dailyHireRate;
        this.ID = ID;
        this.carBooking = carBooking;
    }

    public Car(String brand, int model, double engine, boolean gear, String fuel, String type, String colour, double kilometer, double dailyHireRate, String ID) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.gear = gear;
        this.fuel = fuel;
        this.type = type;
        this.colour = colour;
        this.kilometer = kilometer;
        this.dailyHireRate = dailyHireRate;
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public boolean getGear() {
        return gear;
    }

    public void setGear(boolean gear) {
        this.gear = gear;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }

    public double getDailyHireRate() {
        return dailyHireRate;
    }

    public void setDailyHireRate(double dailyHireRate) {
        this.dailyHireRate = dailyHireRate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDate getCarBooking() {
        return carBooking;
    }

    public void setCarBooking(LocalDate carBooking) {
        this.carBooking = carBooking;
    }

    public void displayInfo(){
        System.out.println("Car Brand: "+getBrand());
        System.out.println("Car Model Year: "+getModel());
        String gearModel;
        if(getGear()==true){
            gearModel="Automatic";
            setGear(false);
        }
        else{
            gearModel="Manuel";
        }
        System.out.println("Car Engine: "+getEngine()+" "+getFuel()+" "+gearModel);
        System.out.println("Car Type: "+getType());
        System.out.println("Car Colour: "+getColour());
        System.out.println("Car Kilometers: "+getKilometer());
        System.out.println("Car Daily Hire Rate: "+getDailyHireRate() +" ₺");
        System.out.println("Car ID: "+getID());
        if(getCarBooking() != null){
            System.out.println("Car Booking Date: "+getCarBooking());
        }
        System.out.println();
    }
}
