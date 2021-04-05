package project;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private String driverID;
    private String driverName;
    private String driverMobile;
    private String driverAddress;
    private LocalDate driverBooking;
    ArrayList<Driver> driverList = new ArrayList<>();
    ArrayList<Driver> driverChoice = new ArrayList<>();
    int numberOfDrivers = 0;

    public Driver() {
        driverID = "Unknown";
        driverName = "Unknown";
        driverMobile = "Unknown";
        driverAddress = "Unknown";
        driverBooking = null;
    }

    public Driver(String driverID, String driverName, String driverMobile, String driverAddress, LocalDate driverBooking) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.driverMobile = driverMobile;
        this.driverAddress = driverAddress;
        this.driverBooking = driverBooking;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public LocalDate getDriverBooking() {
        return driverBooking;
    }

    public void setDriverBooking(LocalDate driverBooking) {
        this.driverBooking = driverBooking;
    }

    public void addDriver() {
        driverList.add((new Driver("SRCN1", "Sercan Yıldırım", "05435678902", "Konak/İzmir", getDriverBooking())));
        driverList.add((new Driver("AYTG1", "Aytuğ Gencel", "05362566513", "Balçova/İzmir", getDriverBooking())));
        driverList.add((new Driver("AHMT1", "Ahmet Tekin", "05342679024", "Buca/İzmir", getDriverBooking())));
        driverList.add((new Driver("HSN1", "Hasan Savsın", "05357905769", "Bostanlı/İzmir", getDriverBooking())));
        driverList.add((new Driver("CN1", "Can Dereli", "05436580321", "Güzelbahçe/İzmir", getDriverBooking())));
    }
    public void createDriver() {
        Scanner scan = new Scanner(System.in); // for other inputs
        Scanner scan2 = new Scanner(System.in); // for String inputs
        String tempName = null;
        String tempMobile;
        String tempAddress;
        String tempID;

        boolean variable = true;
        while (variable) {
            System.out.println("MENU");
            System.out.println("1.Create a driver.");
            System.out.println("2.EXIT");
            System.out.println("Please enter the option you want to do:");
            int choice = scan.nextInt();

            if (choice == 1) {
                System.out.println("Enter your driver ID: ");
                tempID=scan2.nextLine();
                System.out.print("Enter your name to create a new driver (Format: Name Surname):");
                tempName = scan2.nextLine();
                System.out.print("Enter your telephone number: ");
                tempMobile = scan2.nextLine();
                System.out.print("Enter your address: ");
                tempAddress = scan2.nextLine();
                driverList.add(new Driver(tempID, tempName, tempMobile, tempAddress, getDriverBooking())); // created driver added to list
                System.out.println("Driver " + tempName + " has been created.");
            }
            else if(choice==2){
                System.out.println("Terminating...");
                variable = false;
            }
            else{
                System.out.println("Please, select a valid option!");
            }
        }
    }

    public void deleteDriver() {
        addDriver(); // driver information in the list called up
        String tempName;
        boolean flag1 = true;
        Scanner scan = new Scanner(System.in); // for other inputs
        Scanner scan2 = new Scanner(System.in); // for String inputs
        boolean variable = true;
        while(variable) {
            System.out.println("MENU");
            System.out.println("1.Delete driver");
            System.out.println("2.EXIT");
            int choice = scan.nextInt();
            if ( choice ==1 ) {
                System.out.println("What is the driver's Name: ( Name and Surname)");
                tempName = scan.nextLine();
                for (int i = 0; i < driverList.size(); i++) {
                    if (tempName.equals(driverList.get(i).getDriverName())) {
                        driverList.remove(driverList.get(i).getDriverName());
                        System.out.println("Driver " + tempName + " has been deleted.");
                        flag1 = true;
                        break;
                    } else {
                        flag1 = false;
                    }
                }
                if (!flag1) {
                    System.out.println("No driver with this name was found. Please check the name again.");
                }
            }
            else if (choice == 2 ){
                System.out.println("Terminating...");
                variable = false;
            }
            else{
                System.out.println("Please, enter a valid option!");
            }
        }
    }

    public void editDriver() {
        addDriver(); // driver information in the list called up

        int choice;
        String tempID;
        String tempName;
        String tempMobile;
        String tempAddress;
        String newID;
        String newName;
        String newMobile;
        String newAddress;
        boolean flag1 = true;
        Scanner scan = new Scanner(System.in); // for other inputs
        Scanner scan2 = new Scanner(System.in); //for String inputs

        boolean variable = true;
        while (variable) {
            System.out.println("Which information do you want to edit?");
            System.out.println("1.Driver ID");
            System.out.println("2.Driver Name");
            System.out.println("3.Driver Mobile");
            System.out.println("4.Driver Address");
            System.out.println("5.EXIT");

            choice = scan.nextInt();

            if (choice == 1) {
                System.out.println("Which driver do you want to change his ID.\n Please enter the old ID: ");
                tempID = scan2.nextLine();
                for (int i = 0; i < driverList.size(); i++) {
                    if (tempID.equals(driverList.get(i).getDriverID())) {
                        System.out.println("What is your driver's new ID: ");
                        newID = scan2.nextLine();
                        driverList.get(i).setDriverID(newID);
                        System.out.println("Driver ID has been updated " + newID);
                        flag1 = true;
                        break;

                    } else {
                        flag1 = false;
                    }
                }
                if (!flag1) {
                    System.out.println("The ID you have entered is not found. Try again...");
                }
            } else if (choice == 2) {
                System.out.println("Which driver do you want to rename: (Format: Name and Surname) ");
                tempName = scan2.nextLine();
                for (int i = 0; i < driverList.size(); i++) {
                    if (tempName.equals(driverList.get(i).getDriverID())) {
                        System.out.println("What is your driver's new name: ");
                        newName = scan2.nextLine();
                        driverList.get(i).setDriverID(newName);
                        System.out.println("Driver name has been updated " + newName);
                        flag1 = true;
                        break;
                    } else {
                        flag1 = false;
                    }
                }
                if (!flag1) {
                    System.out.println("The name you have entered is not found. try again...");
                }
            } else if (choice == 3) {
                System.out.println("Which driver do you want to change his mobile. please enter the driver name:  (Format: Name and Surname ) ");
                tempName = scan2.nextLine();
                for (int i = 0; i < driverList.size(); i++) {
                    if (tempName.equals(driverList.get(i).getDriverName())) {
                        System.out.println("What is your driver's new mobile: ");
                        newMobile = scan2.nextLine();
                        driverList.get(i).setDriverID(newMobile);
                        System.out.println("Driver mobile has been updated " + newMobile);
                        flag1 = true;
                        break;
                    } else {
                        flag1 = false;
                    }
                }
                if (!flag1) {
                    System.out.println("The name you have entered is not found. Try again...");
                }
            } else if (choice == 4) {
                System.out.println("Which driver do you want to change his address? \nPlease enter the driver name: (Format: Name and Surname) ");
                tempName = scan2.nextLine();
                for (int i = 0; i < driverList.size(); i++) {
                    if (tempName.equals(driverList.get(i).getDriverName())) {
                        System.out.println("What is your driver's new address: ");
                        newAddress = scan2.nextLine();
                        driverList.get(i).setDriverID(newAddress);
                        System.out.println("Driver mobile has been updated " + newAddress);
                        flag1 = true;
                        break;
                    } else {
                        flag1 = false;
                    }
                }
                if (!flag1) {
                    System.out.println("The address you have entered ");
                }
            } else if (choice == 5) {
                variable = false;
            } else {
                System.out.println("Please, select a valid option!");
            }
        }
    }

    public void searchDriver() {
        addDriver(); // driver information in the list called up
        String tempName;
        boolean flag1 = true;
        Scanner scan = new Scanner(System.in); // for other inputs
        Scanner scan2 = new Scanner(System.in); // for String inputs
        boolean variable =true;
        while(variable) {
            System.out.println("MENU");
            System.out.println("1.Search the driver");
            System.out.println("2.EXIT");
            int choice = scan.nextInt();
            if(choice == 1 ) {
                System.out.println("What is your driver ID: ");
                tempName = scan.nextLine();
                for (int i = 0; i < driverList.size(); i++) {
                    if (tempName.equals(driverList.get(i).getDriverName())) {
                        driverList.get(i).displayDriverInfo();
                        flag1 = true;
                        break;
                    } else {
                        flag1 = false;
                    }
                }
                if (!flag1) {
                    System.out.println("No driver with this ID was found. Please check the ID again.");
                    flag1 = true;
                }
            }
            else if ( choice == 2){
                System.out.println("Terminating...");
                variable = false;
            }
            else{
                System.out.println("Please, select a valid option!");
            }
        }
    }
    public void pickDriver() {

        addDriver(); // driver information in the list called up
        Scanner scan = new Scanner(System.in); // for other inputs
        Scanner scan2 = new Scanner(System.in); // for String inputs
        int driverIndex = 0;
        boolean isDriverAvailable = true;

        boolean variable = true;
        while (variable) {
            System.out.println("Do you want a driver?");
            System.out.println("1.YES");
            System.out.println("2.NO");
            System.out.println("3.EXIT");
            System.out.println("(driver fee is 100 TL per day)");
           int choice = scan.nextInt();
            if (choice == 1) {
                boolean variable1 = true;
                while (variable1) {
                    System.out.println("Please select an action:");
                    System.out.println("1. Driver can be chosen randomly by company");
                    System.out.println("2. I want to choose the driver myself");
                    System.out.println("3. EXIT");
                   int choice2 = scan.nextInt();
                    if (choice2 == 1) {
                        SecureRandom randomDriverIndex = new SecureRandom();
                        for (Driver driver : driverList) {
                            driverIndex = randomDriverIndex.nextInt(driverList.size()); // A random element is selected from the driver list
                            System.out.println("Your driver is " + driverList.get(driverIndex).getDriverName());
                            driverChoice.add(driverList.get(driverIndex));
                            numberOfDrivers++;
                            break;
                        }
                    } else if (choice2 == 2) {
                        String tempName;
                        for (Driver driver : driverList) {
                            driver.displayDriverInfo();
                        }

                        System.out.println("Please, select your driver.");
                        System.out.println("What is your driver's name: (Format: Name Surname) ");
                        tempName = scan2.nextLine();
                        isDriverAvailable = false;
                        for (int i = 0; i < driverList.size(); i++) {
                            if (driverList.get(i).getDriverName().equals(tempName)) {
                                System.out.println("The driver was successfully selected.");
                                driverChoice.add(driverList.get(i));
                                numberOfDrivers++;
                                isDriverAvailable = true;
                                System.out.println("Your driver is " + tempName);
                                break;
                            } else {
                                isDriverAvailable = false;
                            }
                        }
                        if (!isDriverAvailable) {
                            if (driverChoice.contains(tempName)) { // driver suitability checked
                                System.out.println("Sorry, this driver is not available.");
                                isDriverAvailable = true;
                            }
                        }

                    } else if (choice2 == 3) {
                        variable1 = false;
                    } else {
                        System.out.println("Please, select a valid option!");
                    }
                }
            } else if (choice == 2) {
                System.out.println("Processing continues without selecting a driver.");
            } else if (choice == 3) {
                System.out.println("Terminating...");
                variable = false;
            } else {
                System.out.println("Please, select a valid option!");
            }
        }
    }

    public void displayDriverInfo() {
        System.out.println("Driver ID: " + getDriverID());
        System.out.println("Driver Name: " + getDriverName());
        System.out.println("Driver Mobile: " + getDriverMobile());
        System.out.println("Driver Address: " + getDriverAddress());
        if (driverBooking != null) {
            System.out.println("Driver Booking Date: " + getDriverBooking());
        }else{
            System.out.println("No Booking Date");
        }
    }
}
