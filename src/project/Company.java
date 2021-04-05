package project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Company implements ICustomer {
    private int companyID;
    private String companyName;
    private String companyMobile;
    private String companyAddress;
    private LocalDate customerDate;
    ArrayList<Car> customerCarC;
    private Driver driverC;
    ArrayList<Company> companyCustomer= new ArrayList<>();

    public Company(ArrayList<Car> c){
        customerCarC =c;}

    public Company(){
        companyID=0;
        companyName="Unknown";
        companyMobile="Unknown";
        companyAddress="Unknown";
        customerDate=null;
        customerCarC = new ArrayList<>();
        driverC = null;
    }

    public Company(int companyID,String companyName,String companyMobile,String companyAddress){
        this.companyID=companyID;
        this.companyName=companyName;
        this.companyMobile=companyMobile;
        this.companyAddress=companyAddress;
    }
    public Company(int companyID, String companyName, String companyMobile, String companyAddress, LocalDate customerDate,ArrayList<Car> cars, Driver driver){
        this.companyID=companyID;
        this.companyName=companyName;
        this.companyMobile=companyMobile;
        this.companyAddress=companyAddress;
        this.customerDate = customerDate;
        customerCarC =cars;
        driverC = driver;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public LocalDate getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(LocalDate customerDate) {
        this.customerDate = customerDate;
    }

    public Driver getDriverC() {
        return driverC;
    }

    public void setDriverC(Driver driverC) {
        this.driverC = driverC;
    }

    public void addCompanyCustomer(){
        companyCustomer.add(new Company(1130,"İZMİR EKONOMİ ÜNİVERSİTESİ","02322567908","Balçova/İzmir",getCustomerDate(), customerCarC, driverC));
        companyCustomer.add(new Company(1131,"PETKİM PETROKİMYA HOLDING","02324440809","Aliağa/İzmir",getCustomerDate(), customerCarC, driverC));
        companyCustomer.add(new Company(1132,"PHIL SA PHILIP MORRIS SABANCI","02324445676","Torbalı/İzmir",getCustomerDate(), customerCarC, driverC));
        companyCustomer.add(new Company(1133,"STATİK YAZILIM","02325020827","Bayraklı/İzmir",getCustomerDate(), customerCarC, driverC));
        companyCustomer.add(new Company(1134,"BMC OTOMOTİV SANAYİ","0232477100","Bornova/İzmir",getCustomerDate(), customerCarC, driverC));
    }

    @Override
    public void createCustomer() {
        addCompanyCustomer();
        String tempName;
        String tempMobile;
        String tempAddress;
        int tempID;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        while (true) {
            System.out.println("MENU");
            System.out.println("1.Create a new company customer");
            System.out.println("2.EXIT");
            System.out.println("Please enter the option you want to do:");
            int choice=scan.nextInt();
            if(choice==1) {
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream("customer.txt",true);
                } catch (FileNotFoundException e) {
                    System.out.println("That file can not found!");
                }
                try {
                    fos = new FileOutputStream("customer.txt", true);
                    String s = "NEW COMPANY CUSTOMER :";
                    byte[] sArray = s.getBytes(); //converted the string type variable to byte type
                    fos.write(sArray); // information printed on file
                    fos.write('\n');
                    System.out.print("Enter your name to create a new company customer (Format: Name Surname): ");
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
                    fos.write(mobileArray); //information printed on file
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
                    setCompanyID(tempID = pickID.nextInt(10000));
                    System.out.println("This is yours customer ID: " + getCompanyID());
                    String i ="Customer ID : ";
                    byte[] IDArray=i.getBytes();
                    fos.write(IDArray); //information printed on file
                    String ID = String.valueOf(tempID); //converted integer variable to string variable
                    byte[] iArray=ID.getBytes(); //converted the string type variable to byte type
                    fos.write(iArray); //information printed on file
                    fos.write('\n');

                    companyCustomer.add(new Company(tempID, tempName, tempMobile, tempAddress, getCustomerDate(), customerCarC, driverC));

                } catch (IOException e) {
                    System.out.println("There was an error writing the file!");
                    } finally{
                        try {
                            fos.close();
                        } catch (IOException e) {
                            System.out.println("File can not close!");
                        }
                    }
                }
            else if (choice==2){
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
            addCompanyCustomer();
            String tempName;
            boolean flag = true;
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            while (true) {
                System.out.println("MENU");
                System.out.println("1.Delete a new company customer");
                System.out.println("2.EXIT");
                System.out.println("Please enter the option you want to do:");
                int choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println("What is your customer name (Name and Surname): ");
                    tempName = scan2.nextLine();
                    for (int i = 0; i < companyCustomer.size(); i++) {
                        if(tempName.equals(companyCustomer.get(i).getCompanyName())){
                            companyCustomer.remove(companyCustomer.get(i).getCompanyName());
                            System.out.println("Driver " + tempName + " has been deleted.");
                            flag=true;
                            break;
                        }
                        else{
                            flag= false;
                        }
                    }
                    if(!flag){
                        System.out.println("No driver with this name was found. Please check the name again.");
                    }
                }
                else if(choice==2){
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
        addCompanyCustomer();
        String tempName;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("MENU");
                System.out.println("1.Search a company customer");
                System.out.println("2.EXIT");
                System.out.println("Please enter the option you want to do:");
                int choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println("What is teh customer name you want to search: ");
                    tempName = scan2.nextLine();
                    for (int i = 0; i < companyCustomer.size(); i++) {
                        if (tempName.equals(companyCustomer.get(i).getCompanyName())) {
                            companyCustomer.get(i).displayCustomerInfo();
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                    if (!flag) {
                        System.out.println("No driver with this name was found. Please check the name again.");
                    }


                } else if (choice == 2) {
                    System.out.println("Terminating...");
                    break;
                } else {
                    System.out.println("You have entered a wrong input. Try again...");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered a wrong input. Try again...");
            }
        }
    }

    @Override
    public void editCustomer() {
        addCompanyCustomer();
        int choice;
        String tempName;
        String tempMobile;
        String tempAddress;
        String newName;
        String newMobile;
        String newAddress;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        boolean var = true;
        while (var) {
            System.out.println("Which information do you want to edit?");
            System.out.println("1.Name");
            System.out.println("2.Telephone Number");
            System.out.println("3.Address");
            System.out.println("4.EXIT");
            choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Which company do you want to change company name.\n Please enter the old name: ");
                tempName = scan2.nextLine();
                for (int i = 0; i < companyCustomer.size(); i++) {
                    if (tempName.equals(companyCustomer.get(i).getCompanyName())) {
                        System.out.println("What is the new company name: ");
                        newName = scan2.nextLine();
                        companyCustomer.get(i).setCompanyName(newName);
                        System.out.println("The company name has been updated " + tempName);
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                if (!flag) {
                    System.out.println("The company name you have entered is not found. Try again...");
                }

            } else if (choice == 2) {
                System.out.println("Which company do you want to change company mobile. Please enter the company name: ");
                tempName = scan2.nextLine();
                for (int i = 0; i < companyCustomer.size(); i++) {
                    if (tempName.equals(companyCustomer.get(i).getCompanyName())) {
                        System.out.println("What is the new company mobile: ");
                        newMobile = scan2.nextLine();
                        companyCustomer.get(i).setCompanyMobile(newMobile);
                        System.out.println("The company mobile has been updated " + newMobile);
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                if (!flag) {
                    System.out.println("The company name you have entered is not found. Try again...");
                }

            } else if (choice == 3) {
                System.out.println("Which company do you want to change company address. Please enter the company name: ");
                tempName = scan2.nextLine();
                for (int i = 0; i < companyCustomer.size(); i++) {
                    if (tempName.equals(companyCustomer.get(i).getCompanyName())) {
                        System.out.println("What is the company address: ");
                        newAddress = scan2.nextLine();
                        companyCustomer.get(i).setCompanyAddress(newAddress);
                        System.out.println("The company address has been updated " + newAddress);
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                if (!flag) {
                    System.out.println("The company name you have entered is not found. Try again...");
                }
            } else if (choice == 4) {
                System.out.println("Terminating...");
                var = false;

            } else {
                System.out.println("Please select a valid transaction!");
            }
        }
    }

    @Override
    public void displayCustomerInfo() {
        System.out.println("Company ID: " + getCompanyID());
        System.out.println("Company Name: " + getCompanyName());
        System.out.println("Company Mobile: " + getCompanyMobile());
        System.out.println("Company Address: " + getCompanyAddress());
        System.out.println("Customer Renting Deadline: " + getCustomerDate());
        if(customerCarC != null) {
            int i = 0;
            System.out.println("Customer Rented Car Information:");
            for (Car itemReference : customerCarC) {
                i++;
                System.out.println(i + ". CAR: ");
                itemReference.displayInfo();
            }
        }else{
            System.out.println("No Car");
        }
        if(driverC != null){
            System.out.println("Customer Driver Information:");
                driverC.displayDriverInfo();
        }else{
            System.out.println("No Driver");
        }
    }

}