package project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking extends ABook {

    int numberOfMonths;
    int numberOfYears;
    int numberOfWeeks;
    int numberOfDays;
    int option;
    LocalDate deadline;
    LocalDate newDateLine;
    private Individual individual;
    private Company company;
    private Driver driver;
    ArrayList<Sedan> sedanC;
    ArrayList<Suv> suvC;
    ArrayList<Sport> sportC;
    ArrayList<Hatchback> hatchbackC;
    ArrayList<Jeep> jeepC;
    ArrayList<Micro> microC;
    ArrayList<Truck> truckC;
    ArrayList<Minibus> minibusC;

    public Booking(Individual i, Company c, Driver d, ArrayList<Sedan> sedan, ArrayList<Suv> suv, ArrayList<Sport> sport,
                   ArrayList<Hatchback> hatchback, ArrayList<Jeep> jeep, ArrayList<Micro> micro, ArrayList<Truck> truck, ArrayList<Minibus> minibus) {
        individual = i;
        company = c;
        driver = d;
        sedanC = sedan;
        suvC = suv;
        sportC = sport;
        hatchbackC = hatchback;
        jeepC = jeep;
        microC = micro;
        truckC = truck;
        minibusC = minibus;
    } // We create objects of the arrays from car types classes

    public Booking() {
        numberOfDays = 0;
        numberOfWeeks = 0;
        numberOfMonths = 0;
        numberOfYears = 0;
    }

    public Booking(int numberOfMonths, int numberOfYears, int numberOfWeeks, int numberOfDays) {
        this.numberOfMonths = numberOfMonths;
        this.numberOfYears = numberOfYears;
        this.numberOfWeeks = numberOfWeeks;
        this.numberOfDays = numberOfDays;
    }

    @Override
    public LocalDate addBookingDate() {
        Scanner scanAddBook = new Scanner(System.in);

        boolean variable = true;
        while (variable) {
            try {
                DateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY");
                Date date = new Date();
                System.out.println("Today's Date: " + formatDate.format(date)); // Today's date
                System.out.println("Choose an option:\n(1)Daily\n(2)Weekly\n(3)Monthly\n(4)Annually");
                System.out.println("(You can add more days, weeks, months or years later(with editing the date)");
                option = scanAddBook.nextInt(); // Customer will decide to rent the car Daily, Weekly, Monthly or Annually
                if (option == 1) {
                    System.out.print("How many days will you hire?: ");
                    numberOfDays = scanAddBook.nextInt(); // Customer will decide the number of days for renting
                    if (numberOfDays > 7 || numberOfDays < 0) {
                        System.out.println("This number is too much or not acceptable for \"daily hire\". Try other options...");
                    } else {
                        System.out.println(numberOfDays + " Day(s) Rented");
                        System.out.println("Deadline: ");
                        LocalDate nowOn = LocalDate.now();
                        deadline = nowOn.plusDays(numberOfDays); // The chosen days are being added into booking date
                        System.out.println(deadline);
                        variable = false;
                    }
                } else if (option == 2) {
                    System.out.print("How many weeks will you hire?: ");
                    numberOfWeeks = scanAddBook.nextInt(); // Customer will decide the number of weeks for renting
                    if (numberOfWeeks > 4 || numberOfWeeks < 0) {
                        System.out.println("This number is too much or not acceptable for \"weekly hire\". Try other options...");
                    } else {
                        System.out.println(numberOfWeeks + " Week(s) Rented");
                        System.out.println("Deadline: ");
                        LocalDate nowOn = LocalDate.now();
                        deadline = nowOn.plusWeeks(numberOfWeeks); // The chosen weeks are being added into booking date
                        System.out.println(deadline);
                        variable = false;
                    }
                } else if (option == 3) {
                    System.out.print("How many months will you hire?: ");
                    numberOfMonths = scanAddBook.nextInt(); // Customer will decide the number of months for renting
                    if (numberOfMonths > 12 || numberOfMonths < 0) {
                        System.out.println("This number is too much or not acceptable for \"monthly hire\". Try other options...");
                    } else {
                        System.out.println(numberOfMonths + " Month(s) Rented");
                        System.out.println("Deadline: ");
                        LocalDate nowOn = LocalDate.now();
                        deadline = nowOn.plusMonths(numberOfMonths); // The chosen months are being added into booking date
                        System.out.println(deadline);
                        variable = false;
                    }
                } else if (option == 4) {
                    System.out.print("How many years will you hire?: ");
                    numberOfYears = scanAddBook.nextInt(); // Customer will decide the number of years for renting
                    if (numberOfYears < 0) {
                        System.out.println("This number is not acceptable for \"annually hire\". Try again...");
                    } else {
                        System.out.println(numberOfYears + " Year(s) Rented");
                        System.out.println("Deadline: ");
                        LocalDate nowOn = LocalDate.now();
                        deadline = nowOn.plusYears(numberOfYears); // The chosen years are being added into booking date
                        System.out.println(deadline);
                        variable = false;
                    }
                } else {
                    System.out.println("The input you have entered is wrong! Try again!");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.err.println("You have entered an input except integer. Try again!!!");
            }
        }
        return deadline;
    }

    @Override
    public void deleteBookingDate(int index, int customerIndex) {
        if (customerIndex == 1) {
            individual.individualCustomer.get(index).setCustomerDate(null); // This will set the booking date of individual customer 'null'
        } else if (customerIndex == 2) {
            company.companyCustomer.get(index).setCustomerDate(null); // This will set the booking date of company 'null'
        }
        System.out.println("Your date has been deleted...");
    }


    @Override
    public void editEndDate(int typeCustomer, int index) {
        Scanner scanEdit = new Scanner(System.in);

        switch (typeCustomer) {
            case 1: // Editing for individual customer booking date
                System.out.println("-Individual-");
                boolean variable = true;
                while (variable) {
                    try {
                        System.out.println("Do you want to INCREASE or DECREASE the renting time?:  ");
                        System.out.println("Press 1 to INCREASE\nPress 2 to DECREASE\nPress 3 to QUIT");
                        int request = scanEdit.nextInt(); // Customer will decide to increase or decrease the renting time/period
                        switch (request) {
                            case 1:
                                System.out.println("Which one do you want to increase?\n(1)Day\n(2)Week\n(3)Month\n(4)Year");
                                int changeNumberI = scanEdit.nextInt(); // Customer will decide to increase renting time Daily, Weekly, Monthly or Annually
                                if (changeNumberI == 1) {
                                    System.out.print("Enter number of DAYS you want to add: ");
                                    int tempDay = scanEdit.nextInt(); // Customer will enter the number of days to increase deadline

                                    LocalDate nowOn = LocalDate.of(individual.individualCustomer.get(index).getCustomerDate().getYear(),
                                            individual.individualCustomer.get(index).getCustomerDate().getMonth(), individual.individualCustomer.get(index).getCustomerDate().getDayOfMonth());
                                    // Previous deadline of individual customer

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.plusDays(tempDay)); // Entered number of days by customer are added into the previous deadline, this will print out the new deadline

                                } else if (changeNumberI == 2) {
                                    System.out.print("Enter number of WEEKS you want to add: ");
                                    int tempWeek = scanEdit.nextInt(); // Customer will enter the number of weeks to increase deadline
                                    LocalDate nowOn = LocalDate.of(individual.individualCustomer.get(index).getCustomerDate().getYear(),
                                            individual.individualCustomer.get(index).getCustomerDate().getMonth(), individual.individualCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.plusWeeks(tempWeek)); // Entered number of weeks by customer are added into the previous deadline, this will print out the new deadline

                                } else if (changeNumberI == 3) {
                                    System.out.print("Enter number of MONTHS you want to add: ");
                                    int tempMonth = scanEdit.nextInt(); // Customer will enter the number of months to increase deadline
                                    LocalDate nowOn = LocalDate.of(individual.individualCustomer.get(index).getCustomerDate().getYear(),
                                            individual.individualCustomer.get(index).getCustomerDate().getMonth(), individual.individualCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.plusMonths(tempMonth)); // Entered number of months by customer are added into the previous deadline, this will print out the new deadline

                                } else if (changeNumberI == 4) {
                                    System.out.print("Enter number of YEARS you want to add: ");
                                    int tempYear = scanEdit.nextInt(); // Customer will enter the number of years to increase deadline
                                    LocalDate nowOn = LocalDate.of(individual.individualCustomer.get(index).getCustomerDate().getYear(),
                                            individual.individualCustomer.get(index).getCustomerDate().getMonth(), individual.individualCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.plusYears(tempYear)); // Entered number of years by customer are added into the previous deadline, this will print out the new deadline

                                } else {
                                    System.err.println("The variable you have entered is wrong...");
                                }
                                break;

                            case 2:
                                System.out.println("Which one do you want to subtract?\n(1)Day\n(2)Week\n(3)Month\n(4)Year");
                                int changeNumberD = scanEdit.nextInt(); // Customer will decide to subtract renting time Daily, Weekly, Monthly or Annually
                                if (changeNumberD == 1) {
                                    System.out.print("Enter number of DAYS you want to subtract: ");
                                    int tempDay = scanEdit.nextInt(); // Customer will enter the number of days to subtract deadline
                                    LocalDate nowOn = LocalDate.of(individual.individualCustomer.get(index).getCustomerDate().getYear(),
                                            individual.individualCustomer.get(index).getCustomerDate().getMonth(), individual.individualCustomer.get(index).getCustomerDate().getDayOfMonth());
                                    // Previous deadline of individual customer

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.minusDays(tempDay)); // Entered number of days by customer are subtracted from the previous deadline, this will print out the new deadline

                                } else if (changeNumberD == 2) {
                                    System.out.print("Enter number of WEEKS you want to subtract: ");
                                    int tempWeek = scanEdit.nextInt(); // Customer will enter the number of days to subtract deadline
                                    LocalDate nowOn = LocalDate.of(individual.individualCustomer.get(index).getCustomerDate().getYear(),
                                            individual.individualCustomer.get(index).getCustomerDate().getMonth(), individual.individualCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.minusWeeks(tempWeek)); // Entered number of weeks by customer are subtracted from the previous deadline, this will print out the new deadline

                                } else if (changeNumberD == 3) {
                                    System.out.print("Enter number of MONTHS you want to subtract: ");
                                    int tempMonth = scanEdit.nextInt(); // Customer will enter the number of days to subtract deadline
                                    LocalDate nowOn = LocalDate.of(individual.individualCustomer.get(index).getCustomerDate().getYear(),
                                            individual.individualCustomer.get(index).getCustomerDate().getMonth(), individual.individualCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.minusMonths(tempMonth)); // Entered number of months by customer are subtracted from the previous deadline, this will print out the new deadline

                                } else if (changeNumberD == 4) {
                                    System.out.print("Enter number of YEARS you want to subtract: ");
                                    int tempYear = scanEdit.nextInt(); // Customer will enter the number of days to subtract deadline
                                    LocalDate nowOn = LocalDate.of(individual.individualCustomer.get(index).getCustomerDate().getYear(),
                                            individual.individualCustomer.get(index).getCustomerDate().getMonth(), individual.individualCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.minusYears(tempYear)); // Entered number of years by customer are subtracted from the previous deadline, this will print out the new deadline

                                } else {
                                    System.err.println("The variable you have entered is wrong...");
                                }
                                break;

                            case 3:
                                System.out.println("Terminating...");
                                variable = false;
                                break;

                            default:
                                System.out.println("You have entered a wrong integer. Try again...");
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("You have entered an input except integer. Try again!!!");
                    }
                }
                break;
            case 2: // Editing for company booking date
                System.out.println("-Company-");
                boolean variable1 = true;
                while (variable1) {
                    try {
                        System.out.println("Do you want to INCREASE or DECREASE the renting time?:  ");
                        System.out.println("Press 1 to INCREASE\nPress 2 to DECREASE\nPress 3 to QUIT");
                        int request = Integer.parseInt(scanEdit.nextLine());
                        switch (request) {
                            case 1:
                                System.out.println("Which one do you want to increase?\n(1)Day\n(2)Week\n(3)Month\n(4)Year");
                                int changeNumberI = scanEdit.nextInt(); // Customer will decide to increase renting time Daily, Weekly, Monthly or Annually
                                if (changeNumberI == 1) {
                                    System.out.print("Enter number of DAYS you want to add: ");
                                    int tempDay = scanEdit.nextInt(); // Customer will enter the number of days to increase deadline

                                    LocalDate nowOn = LocalDate.of(company.companyCustomer.get(index).getCustomerDate().getYear(),
                                            company.companyCustomer.get(index).getCustomerDate().getMonth(), company.companyCustomer.get(index).getCustomerDate().getDayOfMonth());
                                    // Previous deadline of individual customer

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.plusDays(tempDay)); // Entered number of days by customer are added into the previous deadline, this will print out the new deadline

                                } else if (changeNumberI == 2) {
                                    System.out.print("Enter number of WEEKS you want to add: ");
                                    int tempWeek = scanEdit.nextInt(); // Customer will enter the number of weeks to increase deadline
                                    LocalDate nowOn = LocalDate.of(company.companyCustomer.get(index).getCustomerDate().getYear(),
                                            company.companyCustomer.get(index).getCustomerDate().getMonth(), company.companyCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.plusWeeks(tempWeek)); // Entered number of weeks by customer are added into the previous deadline, this will print out the new deadline

                                } else if (changeNumberI == 3) {
                                    System.out.print("Enter number of MONTHS you want to add: ");
                                    int tempMonth = scanEdit.nextInt(); // Customer will enter the number of months to increase deadline
                                    LocalDate nowOn = LocalDate.of(company.companyCustomer.get(index).getCustomerDate().getYear(),
                                            company.companyCustomer.get(index).getCustomerDate().getMonth(), company.companyCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.plusMonths(tempMonth)); // Entered number of months by customer are added into the previous deadline, this will print out the new deadline

                                } else if (changeNumberI == 4) {
                                    System.out.print("Enter number of YEARS you want to add: ");
                                    int tempYear = scanEdit.nextInt(); // Customer will enter the number of years to increase deadline
                                    LocalDate nowOn = LocalDate.of(company.companyCustomer.get(index).getCustomerDate().getYear(),
                                            company.companyCustomer.get(index).getCustomerDate().getMonth(), company.companyCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.plusYears(tempYear)); // Entered number of years by customer are added into the previous deadline, this will print out the new deadline

                                } else {
                                    System.err.println("The variable you have entered is wrong...");
                                }
                                break;

                            case 2:
                                System.out.println("Which one do you want to subtract?\n(1)Day\n(2)Week\n(3)Month\n(4)Year");
                                int changeNumberD = scanEdit.nextInt(); // Customer will decide to subtract renting time Daily, Weekly, Monthly or Annually
                                if (changeNumberD == 1) {
                                    System.out.print("Enter number of DAYS you want to subtract: ");
                                    int tempDay = scanEdit.nextInt(); // Customer will enter the number of days to subtract deadline
                                    LocalDate nowOn = LocalDate.of(company.companyCustomer.get(index).getCustomerDate().getYear(),
                                            company.companyCustomer.get(index).getCustomerDate().getMonth(), company.companyCustomer.get(index).getCustomerDate().getDayOfMonth());
                                    // Previous deadline of individual customer

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.minusDays(tempDay)); // Entered number of days by customer are subtracted from the previous deadline, this will print out the new deadline

                                } else if (changeNumberD == 2) {
                                    System.out.print("Enter number of WEEKS you want to subtract: ");
                                    int tempWeek = scanEdit.nextInt(); // Customer will enter the number of days to subtract deadline
                                    LocalDate nowOn = LocalDate.of(company.companyCustomer.get(index).getCustomerDate().getYear(),
                                            company.companyCustomer.get(index).getCustomerDate().getMonth(), company.companyCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.minusWeeks(tempWeek)); // Entered number of weeks by customer are subtracted from the previous deadline, this will print out the new deadline

                                } else if (changeNumberD == 3) {
                                    System.out.print("Enter number of MONTHS you want to subtract: ");
                                    int tempMonth = scanEdit.nextInt(); // Customer will enter the number of days to subtract deadline
                                    LocalDate nowOn = LocalDate.of(company.companyCustomer.get(index).getCustomerDate().getYear(),
                                            company.companyCustomer.get(index).getCustomerDate().getMonth(), company.companyCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.minusMonths(tempMonth)); // Entered number of months by customer are subtracted from the previous deadline, this will print out the new deadline

                                } else if (changeNumberD == 4) {
                                    System.out.print("Enter number of YEARS you want to subtract: ");
                                    int tempYear = scanEdit.nextInt(); // Customer will enter the number of days to subtract deadline
                                    LocalDate nowOn = LocalDate.of(company.companyCustomer.get(index).getCustomerDate().getYear(),
                                            company.companyCustomer.get(index).getCustomerDate().getMonth(), company.companyCustomer.get(index).getCustomerDate().getDayOfMonth());

                                    System.out.println("New Deadline:");
                                    System.out.println(newDateLine = nowOn.minusYears(tempYear)); // Entered number of years by customer are subtracted from the previous deadline, this will print out the new deadline

                                } else {
                                    System.err.println("The variable you have entered is wrong...");
                                }
                                break;

                            case 3:
                                System.out.println("Terminating...");
                                variable1 = false;
                                break;

                            default:
                                System.out.println("You have entered a wrong integer. Try again...");
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("You have entered an input except integer. Try again!!!");
                    }
                }
                break;
        }
    }

}

