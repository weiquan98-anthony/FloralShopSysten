/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class AssignmentD {

    
    
    
    /**
     * @param args the command line arguments
     */
    // 28/11/2018 3:36AM
    public static FLORALMAIN cust = new FLORALMAIN();
    // 28/11/2018 3:36AM
    
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
     static LinkedList<Payment> paymentList = new LinkedList<>();
       static LinkedList<Payment> tempList = new LinkedList<>();


    public void assignmentd() {
        // TODO code application logic  

      
        orderedItems.add(new Item(1,"Sunset Roses", 75, 2, "Bouquet"));
        orderedItems.add(new Item(2,"Great Eastern Daisies", 89, 3, "Bouquet")); 
        orderedItems.add(new Item(3,"Beyond Purple", 88, 10, "Flower Baskets")); 
        orderedItems.add(new Item(4,"Basket Daisy", 99, 8, "Flower Baskets")); 
        orderedItems.add(new Item(5,"Premium Flower Stand", 95, 6, "Flower Stands")); 
        itemQuantity.add(2);
        itemQuantity.add(3);

         orderList.add(new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 28), "1", itemQuantity, orderedItems, 50.0));
        orderList.add(new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 28), "1", itemQuantity, orderedItems, 50.0));
         orderList.add(new CatalogOrder(3, 3,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 28), "1", itemQuantity, orderedItems, 50.0));
        //hardcode
//        iCustomer.add(new IndividualCustomer("Jason", 1, "99, Lorong abc", "012345678", "abc@gmail.com", "Individual", 43300,"Kuala Lumpur", "Cheras"));
//        iCustomer.add(new IndividualCustomer("Tf", 2, "99, Lorong abcdef", "012345678", "abcdef@gmail.com", "Individual", 43300,"Kuala Lumpur", "Cheras"));
        iCustomerOrder.add(new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 28), "1", itemQuantity, orderedItems, 50.0));
        iCustomerOrder.add(new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Cash on Delivery", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 28), "1", itemQuantity, orderedItems, 50.0));
         iCustomerOrder.add(new CatalogOrder(3, 3,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.NOVEMBER, 28), "1", itemQuantity, orderedItems, 50.0));
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
                for (int j = 0; j < cust.iCustomer.size(); j++) {
                    if (custId == cust.iCustomer.get(j).getCustID()) {
                        if (cust.iCustomer.get(j).getPostCode() == 43200 || cust.iCustomer.get(j).getPostCode() == 43300 || cust.iCustomer.get(j).getPostCode() == 56100) {
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
            if (LocalDate.now().equals(LocalDate.of(2018, Month.NOVEMBER, 28))) {
                for (int j = 0; j < cust.iCustomer.size(); j++) {
                    if (custId == cust.iCustomer.get(j).getCustID()) {
                        String custAdd = cust.iCustomer.get(j).getCustAdd();
                        String custTown = cust.iCustomer.get(j).getTown();
                        String custState = cust.iCustomer.get(j).getState();
                        System.out.println("Order ID: " + cherasDeliveryList.get(i).getOrderID() + "\n Order Items" + cherasDeliveryList.get(i).getOrderedItems()
                                + "\n Address: " + custAdd + "," + custTown
                                + "," + custState + "\n************************************************************************************************");

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
                if (LocalDate.now().equals(LocalDate.of(2018, Month.NOVEMBER, 28))) {
                    for (int j = 0; j < cust.iCustomer.size(); j++) {
                        if (custId == cust.iCustomer.get(j).getCustID()) {
                            String custAdd = cust.iCustomer.get(j).getCustAdd();
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

