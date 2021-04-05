package project;

import java.util.ArrayList;
import java.util.Scanner;

public class CarArrangement extends Car {
    ArrayList<Car> chosenCarI;
    ArrayList<Car> chosenCarC;
    ArrayList<Car> carC; // It will be added chosen cars to search by customer
    ArrayList<Sedan> sedanC;
    ArrayList<Suv> suvC;
    ArrayList<Sport> sportC;
    ArrayList<Hatchback> hatchbackC;
    ArrayList<Jeep> jeepC;
    ArrayList<Micro> microC;
    ArrayList<Truck> truckC;
    ArrayList<Minibus> minibusC;

    public CarArrangement(ArrayList<Car> car, ArrayList<Car> i, ArrayList<Car> c, ArrayList<Sedan> sedan, ArrayList<Suv> suv, ArrayList<Sport> sport,
                          ArrayList<Hatchback> hatchback,  ArrayList<Jeep> jeep, ArrayList<Micro> micro, ArrayList<Truck> truck, ArrayList<Minibus> minibus) {
        carC = car;
        chosenCarI = i;
        chosenCarC = c;
        sedanC = sedan;
        suvC = suv;
        sportC = sport;
        hatchbackC = hatchback;
        jeepC = jeep;
        microC = micro;
        truckC = truck;
        minibusC = minibus;
    } // We create objects of the arrays from car types classes

    public CarArrangement() {

    }


    public void addCar(int index) { // This index provides to know the customer is a company or individual
        Scanner addCar = new Scanner(System.in);
        System.out.println("-CAR ARRANGEMENT-");
        ArrayList<Integer> tempCarType = new ArrayList<>(); // This will hold the integers which represent the car types
        int option;
        for (int i = 0; ; i++) {
            try { // This will check whether entered input is true
                System.out.println("\nWhat type of car do you want? Choose the type(s) below." +
                        "\nPress 1 to see SEDAN \nPress 2 to see SUV\nPress 3 to see SPORT\nPress 4 to see HATCHBACK\n" +
                        "Press 5 to see JEEP\nPress 6 to see MICRO\nPress 7 to see TRUCK\n Press 8 to see MINIBUS\n"+
                        "(enter -1 to quit): ");
                tempCarType.add(option = Integer.parseInt(addCar.nextLine()));

                if (option == -1) {  //end of the choosing type(s)
                    break;
                }
                if (option == 1) { // If customer choose the sedan type, it will be added into carC arrayList to print out
                    carC.addAll(sedanC);
                } else if (option == 2) { // If customer choose the suv type, it will be added into carC arrayList to print out
                    carC.addAll(suvC);
                } else if (option == 3) { // If customer choose the sport type, it will be added into carC arrayList to print out
                    carC.addAll(sportC);
                } else if (option == 4) { // If customer choose the hatchback type, it will be added into carC arrayList to print out
                carC.addAll(hatchbackC);
                }  else if (option == 5) { // If customer choose the jeep type, it will be added into carC arrayList to print out
                carC.addAll(jeepC);
                } else if (option == 6) { // If customer choose the micro type, it will be added into carC arrayList to print out
                    carC.addAll(microC);
                }else if (option == 7) { // If customer choose the truck type, it will be added into carC arrayList to print out
                    carC.addAll(truckC);
                } else if (option == 8) { // If customer choose the minibus type, it will be added into carC arrayList to print out
                    carC.addAll(minibusC);
                }else {
                    System.err.println("You have entered a wrong integer. Try again!!! ");
                }
            } catch (NumberFormatException m) {
                System.err.println("You have entered an input except integer. Try again!!! ");
            }
        }
        System.out.println("Your wishes have added!\n");
        for (; ; ) {
            try { // This will check whether entered input is true
                System.out.println("\nWhat type of gear do you prefer?\nPress 1 to see MANUAL cars\nPress 2 to see AUTOMATIC cars");
                int option2 = Integer.parseInt(addCar.nextLine());
                if (option2 == 1) { // If customer choose MANUAL option, this will print out the manual cars
                    for (int i = 0; i < carC.size(); i++) {
                        if (!carC.get(i).getGear()) {
                            carC.get(i).displayInfo();
                        }
                    }
                    break;
                } else if (option2 == 2) { // If customer choose AUTOMATIC option, this will print out the automatic cars
                    for (int i = 0; i < carC.size(); i++) {
                        if (carC.get(i).getGear()) {
                            carC.get(i).displayInfo();
                        }
                    }
                    break;
                } else {
                    System.err.println("You have entered a wrong integer. Try again!!! ");
                }
            } catch (NumberFormatException i) {
                System.err.println("You have entered an input except integer. Try again!!! ");
            }
        }

        ArrayList<String> chosenCarID = new ArrayList<>(); // It will be added the chosen car(s)' ID

        for (int i = 0; ; i++) {
            System.out.println("Enter the car(s) ID you have chosen (enter -1 to quit):");
            chosenCarID.add(addCar.nextLine());
            if (chosenCarID.get(i).equals("-1")) {  //end of the choosing car(s)
                break;
            }
        }
        System.out.println("Your wishes have added!\n");

        for (int j = 0; j < carC.size(); j++) {
            for (int i = 0; i < chosenCarID.size(); i++) {
                if (chosenCarID.get(i).contains(carC.get(j).getID())) { //This will check whether the entered ID equals carC arrayList IDs
                    if (index == 1) {
                        chosenCarI.add(carC.get(j)); // Chosen cars by customer are added into another array which associated with 'individual'
                    } else if (index == 2) {
                        chosenCarC.add(carC.get(j));  // Chosen cars by customer are added into another array which associated with 'company'
                    }
                }
            }
        }
        // The chosen BOOKING DATE by customer will be added to chosen car(s) in main
    }

    public void deleteCar(int index, ArrayList<Car> i, ArrayList<Car> c) {
        System.out.println("-CAR DELETING-");
        Scanner delete = new Scanner(System.in);

        System.out.print("Please enter the sequence of the car you want to delete from list: ");
        int chosenCarIndex = Integer.parseInt(delete.nextLine()); //Deleted car index will be chosen by customer

        if (index == 1) {
            i.remove(chosenCarIndex - 1); // Car is deleting from the array which associated with 'individual'
        } else if (index == 2) {
            c.remove(chosenCarIndex - 1);  // Car is deleting from the array which associated with 'company'
        }
        System.out.println("The car you wanted to delete has been deleted!");
    }
}
