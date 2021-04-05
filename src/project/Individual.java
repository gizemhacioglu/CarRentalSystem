package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Individual implements ICustomer {
    private int customerID;
    private String customerName;
    private String customerMobile;
    private String customerAddress;
    private LocalDate customerDate;
    ArrayList<Car> customerCarI;
    private Driver driverI;
  ArrayList<Individual> individualCustomer = new ArrayList<>();

    public Individual(ArrayList<Car> c){
        customerCarI =c;}

    public Individual(){
        customerID=0;
        customerName="Unknown";
        customerMobile="Unknown";
        customerAddress="Unknown";
        customerDate=null;
        customerCarI = new ArrayList<>();
        driverI = null;
    }

    public Individual(int customerID, String customerName, String customerMobile, String customerAddress, LocalDate customerDate, ArrayList<Car> cars, Driver driver) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerAddress = customerAddress;
        this.customerDate = customerDate;
        customerCarI =cars;
        driverI = driver;
    }

    public Individual(int customerID, String customerName, String customerMobile, String customerAddress) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerAddress = customerAddress;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public LocalDate getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(LocalDate customerDate) {
        this.customerDate = customerDate;
    }

    public Driver getDriverI() {
        return driverI;
    }

    public void setDriverI(Driver driverI) {
        this.driverI = driverI;
    }

    public void addIndividualCustomer(){
        individualCustomer.add(new Individual(1122,"Gizem Hacıoğlu","05342352667","üçyol/İzmir",getCustomerDate(), customerCarI, driverI));
        individualCustomer.add(new Individual(1123,"Ece Işık","05432678904","Narlıdere/İzmir",getCustomerDate(), customerCarI, driverI));
        individualCustomer.add(new Individual(1124,"Çağla Bulut","05378906534","Buca/İzmir",getCustomerDate(), customerCarI, driverI));
        individualCustomer.add(new Individual(1125,"Deniz Erkanat","05367893456","Narlıdere/İzmir",getCustomerDate(), customerCarI, driverI));
        individualCustomer.add(new Individual(1126,"Tuna Kozak","05346790657","Gaziemir/İzmir",getCustomerDate(), customerCarI, driverI));
        individualCustomer.add(new Individual(1127,"Süleyman Gökçe","05356348976","Bornova/İzmir",getCustomerDate(), customerCarI, driverI));
        individualCustomer.add(new Individual(1128,"Aleyna Zeybek","05378953478","Menemen/İzmir",getCustomerDate(), customerCarI, driverI));
        individualCustomer.add(new Individual(1129,"Eda Beder","05357908670","Poligon/İzmir",getCustomerDate(), customerCarI, driverI));
    }

    @Override
    public void createCustomer() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String tempName = null;
        String tempMobile;
        String tempAddress;
        int tempID;

        while (true) {
            System.out.println("MENU");
            System.out.println("1.Create a new individual customer.");
            System.out.println("2.EXIT");
            System.out.println("Please enter the option you want to do:");
            int choice= scan.nextInt();

              if(choice==1) {
                  FileOutputStream fos = null;
                  File file = new File("customer.txt"); //  created a file named "customer"
                  try {
                      fos=new FileOutputStream("customer.txt",true);
                      //We have specified that the information will be written to the file named "customer" and the writing process will continue as long as the creation process continues.
                      String s ="NEW INDIVIDUAL CUSTOMER : ";
                      byte[] sArray=s.getBytes(); //converted the string type variable to byte type
                      fos.write(sArray); //information printed on file
                      fos.write('\n');
                      System.out.print("1.Enter your name to create a new individual customer (Format: Name Surname):");
                      tempName = scan2.nextLine();
                      String n ="Customer Name : ";
                      byte[] nameArray=n.getBytes(); //converted the string type variable to byte type
                      fos.write(nameArray); //information printed on file
                      byte[] nArray=tempName.getBytes(); //converted the string type variable to byte type
                      fos.write(nArray); //information printed on file
                      fos.write('\n');
                      System.out.print("Enter your telephone number: ");
                      tempMobile = scan2.nextLine();
                      String m ="Customer Mobile : ";
                      byte[] mobileArray=m.getBytes(); //converted the string type variable to byte type
                      fos.write(mobileArray);
                      byte[] mArray=tempMobile.getBytes(); //converted the string type variable to byte type
                      fos.write(mArray); //information printed on file
                      fos.write('\n');
                      System.out.print("Enter your address: ");
                      tempAddress = scan2.nextLine();
                      String a ="Customer Address : ";
                      byte[] addressArray=a.getBytes(); //converted the string type variable to byte type
                      fos.write(addressArray); //information printed on file
                      byte[] aArray=tempAddress.getBytes(); //converted the string type variable to byte type
                      fos.write(aArray); //information printed on file
                      fos.write('\n');

                      SecureRandom pickID = new SecureRandom();
                      setCustomerID(tempID = pickID.nextInt(10000));
                      System.out.println("Your customer ID: " + tempID);
                      String i ="Customer ID : ";
                      byte[] IDArray=i.getBytes(); //converted the string type variable to byte type
                      fos.write(IDArray);
                      String ID = String.valueOf(tempID); //converted integer variable to string variable
                      byte[] iArray=ID.getBytes(); //converted the string type variable to byte type
                      fos.write(iArray); //information printed on file
                      fos.write('\n');

                      individualCustomer.add(new Individual(tempID, tempName, tempMobile, tempAddress, getCustomerDate(), customerCarI, driverI));


                  } catch (IOException e) {
                      System.out.println("There was an error writing the file!");
                  } finally{
                      try {
                          assert fos != null;
                          fos.close();
                      } catch (IOException e) {
                          System.out.println("File can not close!");
                      }
                  }
              }

           else if (choice==2) {
                System.out.println("Terminating...");
                break;
            }
            else{
                System.out.println("You have entered a wrong input. Try again...");
            }
        }
    }

    @Override
    public void deleteCustomer() {
        addIndividualCustomer();
        String tempName = null;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner (System.in);

        while (true) {
            System.out.println("MENU");
            System.out.println("1.Delete a individual customer.");
            System.out.println("2.EXIT");
            System.out.println("Please enter the option you want to do:");
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("What is your customer name you want to delete (Name and Surname): ");
                tempName = scan2.nextLine();

                for (int i = 0; i < individualCustomer.size(); i++) {
                    if (tempName.equals(individualCustomer.get(i).getCustomerName())) {
                        individualCustomer.remove(individualCustomer.get(i).getCustomerName());
                        System.out.println("Customer Name " + tempName + " has been deleted.");
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                if (!flag) {
                    System.out.println("No customer with this name was found. Please check the name again.");
                }
            }else if (choice == 2) {
                    System.out.println("Terminating...");
                break;
                }
            else{
                System.out.println("You have entered a wrong input. Try again...");
            }
        }
    }

    @Override
    public void searchCustomer() {
        addIndividualCustomer();
        int tempID;
        String tempName;
        boolean flag = true;
        boolean variable = true;
        Scanner scan = new Scanner(System.in);

        while (variable) {
            try {
                System.out.println("Do you want to search a customer with NAME or ID?");
                System.out.println("Press 1 to search with NAME\nPress 2 to search with ID\nPress 3 to QUIT:");
                int option = Integer.parseInt(scan.nextLine());
                switch (option) {
                    case 1:
                        System.out.print("The FULL NAME you want to search: ");
                        tempName = scan.nextLine();
                        for (int i = 0; i < individualCustomer.size(); i++) {
                            if (tempName.equals(individualCustomer.get(i).getCustomerName())) {
                                individualCustomer.get(i).displayCustomerInfo();
                                flag = true;
                            } else {
                                flag = false;
                            }
                        }
                        if (!flag) {
                            System.out.println("The FULL NAME you have entered is not found. Try again...");
                            flag = true;
                        }
                        break;
                    case 2:
                        System.out.print("The ID you want to search: ");
                        tempID = Integer.parseInt(scan.nextLine());
                        for (int i = 0; i < individualCustomer.size(); i++) {
                            if (tempID == individualCustomer.get(i).getCustomerID()) {
                                individualCustomer.get(i).displayCustomerInfo();
                                flag = true;
                            } else {
                                flag = false;
                            }
                        }
                        if (!flag) {
                            System.out.println("The ID you have entered is not found. Try again...");
                            flag = true;
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
                System.out.println("You have entered a wrong input. Try again...");
            }
        }
    }
    @Override
    public void editCustomer() {
        int choice;
        String tempName;
        String tempMobile;
        String tempAddress;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        boolean variable = true;
        while (variable) {
            System.out.println("Which information do you want to edit?");
            System.out.println("1.Name");
            System.out.println("2.Telephone Number");
            System.out.println("3.Address");
            System.out.println("4.EXIT");
            choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("What is your new customer name (Name and Surname): ");
                tempName = scan2.nextLine();
                setCustomerName(tempName);
                System.out.println("Your customer name has been updated " + tempName);


            } else if (choice == 2) {
                System.out.println("What is your new telephone number? ");
                tempMobile = scan2.nextLine();
                setCustomerMobile(tempMobile);
                System.out.println("Your customer mobile has been updated " + tempMobile);

            } else if (choice == 3) {
                System.out.println("What is your new address: ");
                tempAddress = scan2.nextLine();
                setCustomerMobile(tempAddress);
                System.out.println("Your customer address has been updated " + tempAddress);

            } else if (choice == 4) {
                System.out.println("Terminating...");
                variable = false;
            } else {
                System.out.println("Please select a valid transaction!");
            }
        }
    }

    @Override
    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + getCustomerID());
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Customer Mobile: " + getCustomerMobile());
        System.out.println("Customer Address: " + getCustomerAddress());
        System.out.println("Customer Renting Deadline: " + getCustomerDate());
        if(customerCarI != null) {
            int i = 0;
            System.out.println("Customer Rented Car Information:");
            for (Car itemReference : customerCarI) {
                i++;
                System.out.println(i + ". CAR: ");
                itemReference.displayInfo();
            }
        }else{
            System.out.println("No Car");
        }
        if(driverI != null){
            System.out.println("Customer Driver Information:");
            driverI.displayDriverInfo();
        }else{
            System.out.println("No Driver");
        }
    }
}

