package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Car car = new Car();
        Sedan sedan = new Sedan();
        Suv suv = new Suv();
        Sport sport = new Sport();
        Hatchback hatchback = new Hatchback();
        Jeep jeep = new Jeep();
        Micro micro = new Micro();
        Truck truck = new Truck();
        Minibus minibus = new Minibus();

        Individual individual = new Individual();
        Company company = new Company();
        Driver driver = new Driver();
        Booking booking = new Booking(individual,company,driver,sedan.sedan,suv.suv,sport.sport,hatchback.hatchback,
                jeep.jeep,micro.micro,truck.truck,minibus.minibus);

        company.addCompanyCustomer();
        individual.addIndividualCustomer();
        driver.addDriver();
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Car> individualCar = new ArrayList<>();
        ArrayList<Car> companyCar = new ArrayList<>();

        sedan.createSedan();
        suv.createSuv();
        sport.createSport();
        hatchback.createHatchback();
        jeep.createJeep();
        micro.createMicro();
        truck.createTruck();
        minibus.createMinibus();

        CarArrangement arrangement = new CarArrangement(cars,individualCar,companyCar,sedan.sedan,suv.suv,sport.sport,hatchback.hatchback,
                jeep.jeep,micro.micro,truck.truck,minibus.minibus);
        Individual individual1 = new Individual(individualCar);
        Company company1 = new Company(companyCar);

        int tempCustomerID=0;
        boolean variable = true;
        while(variable) {
            try { //This will check the input which is integer or not
                System.out.println("PRESS 1 to ADD NEW CUSTOMER\nDo you already sign up ? -->> \nPRESS 2 to LOG IN WITH CUSTOMER ID\n(You cannot see the MENU until logging in)\n");
                int option1 = Integer.parseInt(input.nextLine()); // To see the operations, customer will create new customer or log in
                switch (option1) {
                    case 1:
                        System.out.println("PRESS 1 to create INDIVIDUAL \nPRESS 2 to create COMPANY");
                        int option2 = Integer.parseInt(input.nextLine()); // Customer will remark she/he is individual or company
                        if (option2 == 1) {
                            individual.createCustomer(); // Creating individual customer
                        } else if (option2 == 2) {
                            company.createCustomer(); // Creating company customer
                        } else {
                            System.err.println("You have entered a wrong integer. Try again!!!");
                        }
                        break;
                    case 2:
                        System.out.println("PRESS 1 to log in with INDIVIDUAL ID \nPRESS 2 to log in with COMPANY ID");
                        int option3 = Integer.parseInt(input.nextLine());
                        if (option3 == 1) {
                            System.out.print("Your ID: ");
                            int tempID = Integer.parseInt(input.nextLine()); // Customer will enter the ID
                            tempCustomerID = tempID;
                            for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                if (tempID == individual.individualCustomer.get(i).getCustomerID()) {  // This will check the customer's ID whether equals to previous IDs
                                    System.out.println("You are in!");
                                    variable = false;
                                }
                            }
                        } else if (option3 == 2) {
                            System.out.print("Your ID: ");
                            int tempID = Integer.parseInt(input.nextLine()); // Customer will enter the ID
                            tempCustomerID = tempID;
                            for (int i = 0; i < company.companyCustomer.size(); i++) {
                                if (tempID == company.companyCustomer.get(i).getCompanyID()) {  // This will check the company's ID whether equals to previous IDs
                                    System.out.println("You are in!");
                                    variable = false;
                                }
                            }
                        } else {
                            System.err.println("You have entered a wrong integer. Try again!!!");
                        }break;

                    default:
                        System.err.println("You have entered a wrong integer. Try again!!!");
                }
                }catch(NumberFormatException e){
                    System.err.println("You have entered an input except integer. Try again!!!");
                }
            }

        boolean variable2 = true;
        while(variable2) {
            displayMenu();
            try {
            int option1 = Integer.parseInt(input.nextLine()); // Customer will choose  an option from menu
            switch (option1) {
                case 1:
                    boolean variable1 = true;
                    while (variable1) {
                        System.out.println("PRESS 1 to ADD CAR into your renting list\nPRESS 2 to DELETE CAR(S) from your renting list\nPRESS 3 to TERMINATE car-related operations");
                        int option = Integer.parseInt(input.nextLine());
                        switch (option) {
                            case 1:
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) { // This will indicate that customer is individual
                                        arrangement.addCar(1);
                                        individual.individualCustomer.get(i).customerCarI.addAll(individualCar); // Adding car(s) as an individual car
                                        individual.individualCustomer.get(i).displayCustomerInfo(); // This will print out the information of individual customer
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) { // This will indicate that customer is company
                                        arrangement.addCar(2);
                                        company.companyCustomer.get(i).customerCarC.addAll(companyCar); // Adding car(s) as company car
                                        company.companyCustomer.get(i).displayCustomerInfo(); // This will print out the information of company
                                    }
                                }
                                break;
                            case 2:
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    for (int j = 0; j < individual.customerCarI.size(); j++) {
                                        if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                            individual.individualCustomer.get(i).customerCarI.get(j).displayInfo(); // This will print out the information of individual car
                                        }
                                    }
                                }
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    for (int j = 0; j < individual.customerCarI.size(); j++) {
                                        if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                            arrangement.deleteCar(1, individual.individualCustomer.get(i).customerCarI, company.companyCustomer.get(0).customerCarC); // Deleting car from individual car(s) list
                                        } // We take '0' as company customer arrayList index to reduce an error (array index out of bounds)
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    for (int j = 0; j < company.customerCarC.size(); j++) {
                                        if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                            company.companyCustomer.get(i).customerCarC.get(j).displayInfo(); // This will print out the information of company car
                                        }
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    for (int j = 0; j < company.customerCarC.size(); j++) {
                                        if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                            arrangement.deleteCar(2, individual.individualCustomer.get(0).customerCarI, company.companyCustomer.get(i).customerCarC); // Deleting car from company car(s) list
                                        } // We take '0' as individual customer arrayList index to reduce error (array index out of bounds)
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Car-Related operations are terminating...");
                                variable1 = false;
                                break;
                            default:
                                System.err.println("You have entered a wrong integer. Try again!!!");
                        }
                    }
                    break;
                case 2:
                    boolean variable5=true;
                    while(variable5) {
                        System.out.println("PRESS 1 to ADD CUSTOMER\nPRESS 2 to DELETE CUSTOMER\nPRESS 3 to SEARCH CUSTOMER\nPRESS 4 to EDIT CUSTOMER\nPRESS 5 to TERMINATE customer-related operations");
                        int option2 = Integer.parseInt(input.nextLine());
                        switch (option2) {
                            case 1:
                                System.out.println("What type of customer are you?\n1.INDIVIDUAL\n2.COMPANY\nPlease enter your customer type: ");
                                int choiceCustomer = Integer.parseInt(input.nextLine());
                                if (choiceCustomer == 1) {
                                    individual.createCustomer();
                                } else if (choiceCustomer == 2) {
                                    company.createCustomer();
                                } else {
                                    System.out.println("You have entered a wrong integer. Try again!!!");
                                }
                                break;
                            case 2:
                                // first checked whether the customer is an individual or a company
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                        individual.deleteCustomer();
                                    }
                                }

                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                        company.deleteCustomer();
                                    }
                                }
                                break;
                            case 3:
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                        individual.searchCustomer();
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                        company.searchCustomer();
                                    }
                                }
                                break;
                            case 4:
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                        individual.editCustomer();
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                        company.editCustomer();
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("Booking-date operations are terminating...");
                                variable5 = false;
                                break;
                        }
                    }
                    break;

                case 3:
                    boolean variable3 = true;
                    while (variable3) {
                        System.out.println("PRESS 1 to ADD BOOKING DATE\nPRESS 2 to DELETE BOOKING DATE\nPRESS 3 to EDIT BOOKING DATE\nPRESS 4 to TERMINATE booking date-related operations");
                        int option3 = Integer.parseInt(input.nextLine());
                        switch (option3) {
                            case 1:
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                        individual.individualCustomer.get(i).setCustomerDate(booking.addBookingDate()); // This will add booking date into individual customer
                                    }
                                }
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    for (int j = 0; j < individual.customerCarI.size(); j++) {
                                        if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                            individual.individualCustomer.get(i).customerCarI.get(j).setCarBooking(individual.individualCustomer.get(i).getCustomerDate()); // This will set individual customer's booking date as individual customer's car booking date
                                            individual.individualCustomer.get(i).customerCarI.get(j).displayInfo(); // This will print out the information of individual car with its booking date
                                        }
                                    }
                                }
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    for (int t = 0; t < driver.driverChoice.size(); t++) {
                                        if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                            driver.driverChoice.get(t).setDriverBooking(individual.individualCustomer.get(i).getCustomerDate()); // This sets the individual customer booking date as driver's booking date
                                            individual.individualCustomer.get(i).displayCustomerInfo();
                                        }
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                        company.companyCustomer.get(i).setCustomerDate(booking.addBookingDate()); // This will add booking date into company
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    for (int j = 0; j < company.customerCarC.size(); j++) {
                                        if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                            company.companyCustomer.get(i).customerCarC.get(j).setCarBooking(company.companyCustomer.get(i).getCustomerDate()); // This will set company's booking date as company's car booking date
                                            company.companyCustomer.get(i).customerCarC.get(j).displayInfo(); // This will print out the information of company car with its booking date
                                        }
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    for (int t = 0; t < driver.driverChoice.size(); t++) {
                                        if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                            driver.driverChoice.get(t).setDriverBooking(company.companyCustomer.get(i).getCustomerDate()); // This sets the company booking date as driver's booking date
                                            company.companyCustomer.get(i).displayCustomerInfo();
                                        }
                                    }
                                }
                                break;
                            case 2:
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    for (int j = 0; j < individual.customerCarI.size(); j++) {
                                        if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                            booking.deleteBookingDate(i, 1); // This will delete individual customer booking date
                                            individual.individualCustomer.get(i).customerCarI.get(j).setCarBooking(null); // This will delete individual car booking date
                                            individual.individualCustomer.get(i).displayCustomerInfo(); // This will print out information of individual customer without booking date
                                        }
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    for (int j = 0; j < company.customerCarC.size(); j++) {
                                        if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                            booking.deleteBookingDate(i, 2); // This will delete company booking date
                                            company.companyCustomer.get(i).customerCarC.get(j).setCarBooking(null); // This will delete company car booking date
                                            company.companyCustomer.get(i).displayCustomerInfo(); // This will print out information of company without booking date
                                        }
                                    }
                                }
                                break;
                            case 3:
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    for (int j = 0; j < individual.customerCarI.size(); j++) {
                                        if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                            booking.editEndDate(1, i); // Individual customer can edit the booking date which is taken previously
                                            individual.individualCustomer.get(i).setCustomerDate(booking.newDateLine); // This will set the new booking date
                                            individual.individualCustomer.get(i).customerCarI.get(j).setCarBooking(individual.individualCustomer.get(i).getCustomerDate()); // This will set individual customer's booking date as individual customer's car booking date
                                            individual.individualCustomer.get(i).displayCustomerInfo(); // This will print out information of individual customer with new booking date
                                        }
                                    }
                                }

                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    for (int t = 0; t < driver.driverChoice.size(); t++) {
                                        if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                            driver.driverChoice.get(t).setDriverBooking(individual.individualCustomer.get(i).getCustomerDate()); // This sets the individual customer booking date as driver's booking date
                                            individual.individualCustomer.get(i).displayCustomerInfo();
                                        }
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    for (int j = 0; j < company.customerCarC.size(); j++) {
                                        if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                            booking.editEndDate(2, i); // Company can edit the booking date which is taken previously
                                            company.companyCustomer.get(i).setCustomerDate(booking.newDateLine); // This will set the new booking date
                                            company.companyCustomer.get(i).customerCarC.get(j).setCarBooking(company.companyCustomer.get(i).getCustomerDate()); // This will set company's booking date as company's car booking date
                                            company.companyCustomer.get(i).displayCustomerInfo(); // This will print out information of company with new booking date
                                        }
                                    }
                                }
                               
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    for (int t = 0; t < driver.driverChoice.size(); t++) {
                                        if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                            driver.driverChoice.get(t).setDriverBooking(company.companyCustomer.get(i).getCustomerDate()); // This sets the company booking date as driver's booking date
                                            company.companyCustomer.get(i).displayCustomerInfo();
                                        }
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Booking-date operations are terminating...");
                                variable3 = false;
                                break;
                            default:
                                System.err.println("You have entered a wrong integer. Try again!!!");
                        }
                    }
                    break;
                case 4:
                    boolean variable4 = true;
                    while (variable4) {
                        System.out.println("PRESS 1 to ADD DRIVER\nPRESS 2 to DELETE DRIVER\nPRESS 3 to EDIT DRIVER\nPRESS 4 to SEARCH DRIVER\n" +
                                "PRESS 5 to PICK DRIVER\nPRESS 6 to TERMINATE driver-related operations");
                        int option4 = Integer.parseInt(input.nextLine());
                        switch (option4){
                            case 1 :
                                        driver.createDriver();
                                break;

                            case 2 :
                                for(int i =0; i<driver.driverList.size();i++){
                                    driver.driverList.get(i).displayDriverInfo();
                                }
                                driver.deleteDriver(); //this method allows you to delete the driver
                                break;

                            case 3 :
                                for(int i =0; i<driver.driverList.size();i++){
                                    driver.driverList.get(i).displayDriverInfo();
                                }
                                driver.editDriver(); //this method allows you to edit the driver which information do you want to change
                                break;

                            case 4 :
                                driver.searchDriver(); // this method allows you to search the driver
                                break;

                            case 5 :
                                for (int i = 0; i < individual.individualCustomer.size(); i++) {
                                    if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {
                                    driver.pickDriver(); // This method allows customer to pick the driver
                                    for(int j=0; j< driver.driverChoice.size(); j++) {
                                            individual.individualCustomer.get(i).setDriverI(driver.driverChoice.get(j)); // This sets the driver as individual car driver
                                            driver.driverChoice.get(j).setDriverBooking(individual.individualCustomer.get(i).getCustomerDate()); // This sets the individual customer booking date as driver's date
                                        }
                                    }
                                }
                                for (int i = 0; i < company.companyCustomer.size(); i++) {
                                    if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {
                                        driver.pickDriver();
                                    for (int j = 0; j < driver.driverChoice.size(); j++) {
                                            company.companyCustomer.get(i).setDriverC(driver.driverChoice.get(j)); // This sets the driver as company car driver
                                            driver.driverChoice.get(j).setDriverBooking(company.companyCustomer.get(i).getCustomerDate()); // This sets the company booking date as driver's date
                                        }
                                    }
                                }

                                break;

                            case 6 :
                                System.out.println("Driver operations are terminating...");
                                variable4 = false;
                                break;

                            default:
                                System.err.println("You have entered a wrong integer. Try again!!!");
                        }
                    }break;

                case 5 : // payment operations
                    double actualPrice = 0 ;
                    for (int i = 0; i < individual.individualCustomer.size(); i++) {
                        for (int j = 0; j < individual.customerCarI.size(); j++) {
                            if (tempCustomerID == individual.individualCustomer.get(i).getCustomerID()) {

                                   actualPrice += individual.individualCustomer.get(i).customerCarI.get(j).getDailyHireRate() * // this takes the chosen car(s) daily price and multiplies with days/weeks/months/years
                                            ((booking.numberOfYears * 365 * 0.85) + (booking.numberOfMonths * 30 * 0.90) + (booking.numberOfWeeks * 7 * 0.95) + (booking.numberOfDays));
                                    if (individual.individualCustomer.get(i).getDriverI() != null) { // this checks whether the customer has a driver
                                        actualPrice += ((booking.numberOfYears * 365)+(booking.numberOfMonths * 30)+(booking.numberOfWeeks * 7)+(booking.numberOfDays))*100*driver.numberOfDrivers;
                                } // if customer has a driver, it will be added 100₺ for each driver
                            }
                        }
                    }
                    for (int i = 0; i < company.companyCustomer.size(); i++) {
                        for (int j = 0; j < company.customerCarC.size(); j++) {
                            if (tempCustomerID == company.companyCustomer.get(i).getCompanyID()) {

                                    actualPrice += company.companyCustomer.get(i).customerCarC.get(j).getDailyHireRate() *
                                            ((booking.numberOfYears * 365 * 0.85) + (booking.numberOfMonths * 30 * 0.90) + (booking.numberOfWeeks * 7 * 0.95) + (booking.numberOfDays));
                                    if (company.companyCustomer.get(i).getDriverC() != null) {
                                        actualPrice += ((booking.numberOfYears * 365)+(booking.numberOfMonths * 30)+(booking.numberOfWeeks * 7)+(booking.numberOfDays))*100*driver.numberOfDrivers;
                                }
                            }
                        }
                    }
                    System.out.println("Bill: "+actualPrice+" ₺");
                    System.out.println("\nWould you like to pay with credit car or in cash?\nIn cash --> same bill\nWith credit card --> %2 tax will be added" +
                            "\nPRESS 1 to pay in cash\nPRESS 2 to pay with credit card");
                    Scanner inputPayment = new Scanner(System.in);
                    int paymentOption = Integer.parseInt(inputPayment.nextLine());
                    if(paymentOption == 1){
                        System.out.println("Bill: "+actualPrice+" ₺");
                    }
                    if(paymentOption == 2){
                        actualPrice += actualPrice*0.02; // %2 = 0.02 , so it is added tax to actual price
                        System.out.println("%2 tax has been added\nNew Bill: "+actualPrice+" ₺");
                    }

                    break;

                case 6:
                    System.out.println("Terminating...");
                    System.out.println("THANK YOU FOR CHOOSING US!");
                    variable2 = false;
                    break;
            }
                } catch (NumberFormatException n) {
                    System.err.println("You have entered an input except integer. Try again!!!");
                }
            }
    }
    public static void displayMenu(){
        System.out.println();
        System.out.println("PRESS 1 to see << Car-Related Operations >>");
        System.out.println("PRESS 2 to see << Customer-Related Operations >>");
        System.out.println("PRESS 3 to see << Booking Date-Related Operations >>");
        System.out.println("PRESS 4 to see << Driver-Related Operations >>");
        System.out.println("PRESS 5 to see << Payment-Related Operations >>");
        System.out.println("PRESS 6 to TERMINATE program");
    }
}
