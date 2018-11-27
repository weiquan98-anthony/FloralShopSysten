/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentd;

import static assignmentd.FloralShopSystem.displayDeliveryList;
import static assignmentd.FloralShopSystem.listOrder;
import static assignmentd.FloralShopSystem.paymentList;
import static assignmentd.FloralShopSystem.tempList;
import static assignmentd.FloralShopSystem.updatePaymentStaus;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class AssignmentD {

    /**
     * @param args the command line arguments
     */
    Calendar calendar = Calendar.getInstance();
    public java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
    public static LinkedList<CatalogOrder> orderList = new LinkedList<>();

    public static LinkedList<Item> orderedItems = new LinkedList<>();
    public static LinkedList<Payment> payment = new LinkedList<>();

    public static LinkedList<Integer> itemQuantity = new LinkedList<>();

    public static LinkedList<CatalogOrder> iCustomerOrder = new LinkedList<>();

    public static LinkedList<CatalogOrder> cherasDeliveryList = new LinkedList<>();
    public static LinkedList<CatalogOrder> setapakDeliveryList = new LinkedList<>();
    public static LinkedList<IndividualCustomer> iCustomer = new LinkedList<>();
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic  

        LinkedList<Payment> paymentList = new LinkedList<>();
        LinkedList<Payment> tempList = new LinkedList<>();

        orderedItems.add(new Item(001, "Sunflower", 23.88, 20));
        orderedItems.add(new Item(002, "Roses", 23.88, 20));
        itemQuantity.add(2);
        itemQuantity.add(3);
        orderList.add(new CatalogOrder(001, 001, LocalTime.now(), LocalDate.now(), "Pick Up", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 27), "1", 30.00, orderedItems, itemQuantity));
        orderList.add(new CatalogOrder(002, 002, LocalTime.now(), LocalDate.now(), "Pick Up", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 27), "2", 40.00, orderedItems, itemQuantity));
        //hardcode
        iCustomer.add(new IndividualCustomer(001, "Jason", "99, Lorong abc", "012345678", "abc@gmail.com", "Individual", 43300, "Cheras"));
        iCustomerOrder.add(new CatalogOrder(001, 002, LocalTime.now(), LocalDate.now(), "Pick Up", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 25), "1", 30.00, orderedItems, itemQuantity));
        iCustomerOrder.add(new CatalogOrder(002, 001, LocalTime.now(), LocalDate.now(), "Cash on Delivery", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 25), "2", 30.00, orderedItems, itemQuantity));

        menu();

    }

    public static void menu() {
        int choice = 0;
        boolean valid = false;
        do {
            System.out.println("*****Please select your choice: *****" + "\n" + "1. Order Pick Up List" + "\n2. Update Payment Status" + "\n3. Delivery List");

            choice = scan.nextInt();

            if (choice == 1) {
                listOrder();
                valid = true;
            } else if (choice == 2) {
                tempList = updatePaymentStaus();

                for (int i = 0; i < tempList.size(); i++) {
                    paymentList.add(tempList.get(i));
                }
                valid = true;
            } else if (choice == 3) {
                displayDeliveryList();
                valid = true;
            } else {
                System.out.println("You have entered wrong choice");
            }
        } while (valid != true);
    }

    public static void listOrder() {
        boolean valid = false;
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

        int choice = 0;

        System.out.println("*****Order Pick Up List for Today: *****" + "\n");
        System.out.println();
        int check =0;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getDeliveryMethod().equals("Pick Up") && orderList.get(i).getOrderStatus() != "Paid") {
               
                if (orderList.get(i).getDeliveryTime().equals("1")) {
                    orderList.get(i).setDeliveryTime("9am-11am");
                } else if (orderList.get(i).getDeliveryTime().equals("2")) {
                    orderList.get(i).setDeliveryTime("11am-1pm");
                } else if (orderList.get(i).getDeliveryTime().equals("3")) {
                    orderList.get(i).setDeliveryTime("1am-3pm");
                } else if (orderList.get(i).getDeliveryTime().equals("4")) {
                    orderList.get(i).setDeliveryTime("3pm-5pm");
                }
                //if order is pick up type, but already paid, then dont display
                System.out.println(i + 1 + ". " + "Order ID: " + orderList.get(i).getOrderID() + "\n"
                        + "Customer ID: " + orderList.get(i).getCustID() + "\n"
                        + "Pick Up Time: " + orderList.get(i).getDeliveryTime() + "\n" + "Item: " + orderedItems.get(i).getName()
                        + "\nOrder Time: " + orderList.get(i).getOrderTime().toString()
                        + "\nOrder Date: " + orderList.get(i).getOrderDate() + "\n*****************************");
                 check++;
            }
        }
        if(check==0){          
                System.out.print("There is no pick up list for today!\n");
        }
        do {
            System.out.println("Do you want to continue?(Enter 0 to go to menu, 1 for exit)");
            choice = scan.nextInt();
            if (choice == 0) {
                menu();
                valid = true;
            } else if (choice == 1) {
                System.exit(0);
            }
        } while (valid != true);
    }

    public static LinkedList<Payment> updatePaymentStaus() {
        LinkedList<Payment> paymentList = new LinkedList<>();
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        boolean valid = false;
        int choice = 0;

        System.out.println("*****Below are the list of order that u may update: " + "\n");
        System.out.println();

        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(i + 1 + "."
                    + " " + "Order ID: " + orderList.get(i).getOrderID() + "\n"
                    + "Customer ID: " + orderList.get(i).getCustID() + "\n"
                    + "Order Time: " + currentTimestamp + "\n" + "Item: " + orderedItems.get(i).getName() + "\n"
                    + "Payment Status: " + orderList.get(i).getOrderStatus() + "\n" + "*****************************");

        }
        int userInput = 0;

        do {
            System.out.println("Please enter the order ID that you wish to update\n Enter 0 to back to menu.");

            Scanner scan = new Scanner(System.in);

            userInput = scan.nextInt();
            for (int i = 0; i < orderList.size(); i++) {
                if (userInput == orderList.get(i).getOrderID()) {
                    orderList.get(i).setOrderStatus("Paid");
                    System.out.print("Order has been paid!\n");
                    Payment payment = new Payment("P0001", orderList.get(i).getOrderID(), orderList.get(i).getCustID(), 22.0, "Paid");
                    paymentList.add(payment);
                    do {
                        System.out.println("Do you want to continue?(Enter 0 to go to menu, 1 for exit)");
                        choice = scan.nextInt();
                        if (choice == 0) {
                            menu();
                            valid = true;
                        } else if (choice == 1) {
                            System.exit(0);
                        }

                    } while (valid != true);

                }
            }

        } while (userInput != 0);

        if (paymentList.size() == 0) {
            menu();
        }

        return paymentList;

    }

    public static void displayDeliveryList() {

        int choice = 0;
        boolean valid = false;

        System.out.println("\nDelivery List: ");

        for (int i = 0; i < iCustomerOrder.size(); i++) {

            Integer custId = iCustomerOrder.get(i).getCustID();
            if (iCustomerOrder.get(i).getDeliveryMethod() == "Cash on Delivery") {
                for (int j = 0; j < iCustomer.size(); j++) {
                    if (custId == iCustomer.get(j).getCustID()) {
                        if (iCustomer.get(j).getPostcode() == 43200 || iCustomer.get(j).getPostcode() == 43300 || iCustomer.get(j).getPostcode() == 56100) {
                            cherasDeliveryList.add(iCustomerOrder.get(i));
                        } else {
                            setapakDeliveryList.add(iCustomerOrder.get(i));
                        }
                    }
                }
            }
        }
        System.out.println("Cheras Area Delivery List:\n");
        for (int i = 0; i < cherasDeliveryList.size(); i++) {
            //if the date now same as delivery date of the COD
            Integer custId = cherasDeliveryList.get(i).getCustID();
            if (LocalDate.now().equals(LocalDate.of(2018, Month.NOVEMBER, 27))) {
                for (int j = 0; j < iCustomer.size(); j++) {
                    if (custId == iCustomer.get(j).getCustID()) {
                        String custAdd = iCustomer.get(j).getCustAdd();
                        System.out.println("Order ID: " + cherasDeliveryList.get(i).getOrderID() + "\n Order Items" + cherasDeliveryList.get(i).getOrderedItems()
                                + "\n Address: " + custAdd + "\n************************************************************************************************");

                    }
                }
            } else {
                System.out.println("Sorry, there is no delivery to be made today." + "\n************************************************************************************************");
            }
        }

        System.out.println("\nSetapak Area Delivery List:\n");
        if (setapakDeliveryList.size() != 0) {
            for (int i = 0; i < setapakDeliveryList.size(); i++) {
                Integer custId = setapakDeliveryList.get(i).getCustID();
                if (LocalDate.now().equals(LocalDate.of(2018, Month.NOVEMBER, 25))) {
                    for (int j = 0; j < iCustomer.size(); j++) {
                        if (custId == iCustomer.get(j).getCustID()) {
                            String custAdd = iCustomer.get(j).getCustAdd();
                            System.out.println("Order ID: " + setapakDeliveryList.get(i).getOrderID() + "\n Order Items" + setapakDeliveryList.get(i).getOrderedItems()
                                    + "\n*********");

                        }
                    }
                } else {
                    System.out.println("Sorry, there is no delivery to be made today."
                            + "\n************************************************************************************************");
                }
            }
        } else {
            System.out.println("Sorry, there is no delivery to be made today."
                    + "\n************************************************************************************************");
        }
        do {
            System.out.println("Do you want to continue?(Enter 0 to go to menu, 1 for exit)");
            choice = scan.nextInt();
            if (choice == 0) {
                menu();
                valid = true;
            } else if (choice == 1) {
                System.exit(0);
            }

        } while (valid != true);
    }
}

//need location & orderId & delivery date

