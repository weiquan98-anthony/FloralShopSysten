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
    //public static LinkedList<CatalogOrder> orderList = new LinkedList<>();

   // public static LinkedList<Item> orderedItems = new LinkedList<>();
    //public static LinkedList<Payment> payment = new LinkedList<>();

    //public static LinkedList<Integer> itemQuantity = new LinkedList<>();

    //public static LinkedList<CatalogOrder> iCustomerOrder = new LinkedList<>();

    public static LinkedList<CatalogOrder> cherasDeliveryList = new LinkedList<>();
    public static LinkedList<CatalogOrder> setapakDeliveryList = new LinkedList<>();
    
    //public static LinkedList<IndividualCustomer> iCustomer = new LinkedList<>();
    public static Scanner scan = new Scanner(System.in);
    // static LinkedList<Payment> paymentList = new LinkedList<>();
      static LinkedList<Payment> tempList = new LinkedList<>();


    public void assignmentd() {
        // TODO code application logic  

      
        /*orderedItems.add(new Item(1,"Sunset Roses", 75, 2, "Bouquet"));
        orderedItems.add(new Item(2,"Great Eastern Daisies", 89, 3, "Bouquet")); 
        orderedItems.add(new Item(3,"Beyond Purple", 88, 10, "Flower Baskets")); 
        orderedItems.add(new Item(4,"Basket Daisy", 99, 8, "Flower Baskets")); 
        orderedItems.add(new Item(5,"Premium Flower Stand", 95, 6, "Flower Stands")); */
        //itemQuantity.add(2);
        //itemQuantity.add(3);

        // orderList.add(new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 6), "1", itemQuantity, orderedItems, 50.0));
       // orderList.add(new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 6), "1", itemQuantity, orderedItems, 50.0));
        // orderList.add(new CatalogOrder(3, 3,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 6), "1", itemQuantity, orderedItems, 50.0));
        //hardcode
//        iCustomer.add(new IndividualCustomer("Jason", 1, "99, Lorong abc", "012345678", "abc@gmail.com", "Individual", 43300,"Kuala Lumpur", "Cheras"));
//        iCustomer.add(new IndividualCustomer("Tf", 2, "99, Lorong abcdef", "012345678", "abcdef@gmail.com", "Individual", 43300,"Kuala Lumpur", "Cheras"));
        //iCustomerOrder.add(new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 6), "1", itemQuantity, orderedItems, 50.0));
        //iCustomerOrder.add(new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Cash on Delivery", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 6), "1", itemQuantity, orderedItems, 50.0));
        // iCustomerOrder.add(new CatalogOrder(3, 3,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 6), "1", itemQuantity, orderedItems, 50.0));
        // iCustomerOrder.add(new CatalogOrder(4, 4,  LocalTime.now(),LocalDate.now(), "Cash on Delivery", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 6), "1", itemQuantity, orderedItems, 50.0));
        menu();

    }

    public static void menu() {
        int choice = 0;
        boolean valid = false;
        do {
            System.out.println("*****Please select your choice: *****" + "\n" + "1. Order Pick Up List" + "\n2. Update Payment Status" + "\n3. Delivery List"
            +"\n 4. Payment List" + "\n 5. Check Corporate Customer Debt");

            choice = scan.nextInt();

            if (choice == 1) {
                listOrder();
                valid = true;
            } else if (choice == 2) {
               /* tempList = updatePaymentStaus();
                
                for (int i = 0; i < tempList.size(); i++) {
                    cust.paymentList.add(tempList.get(i));
                }*/
               updatePaymentStaus();
               valid = true;
            } else if (choice == 3) {
                displayDeliveryList();
                valid = true;
            }else if (choice ==4){
                displayPaymentList();
                valid = true;
            }
            
            else {
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
        for (int i = 0; i < cust.orderList.size(); i++) {
            if (cust.orderList.get(i).getDeliveryMethod().equals("Pick-Up") && cust.orderList.get(i).getOrderStatus().equals("Unpaid")){
               
                if (cust.orderList.get(i).getDeliveryTime().equals("1")) {
                    cust.orderList.get(i).setDeliveryTime("9am-11am");
                } else if (cust.orderList.get(i).getDeliveryTime().equals("2")) {
                    cust.orderList.get(i).setDeliveryTime("11am-1pm");
                } else if (cust.orderList.get(i).getDeliveryTime().equals("3")) {
                    cust.orderList.get(i).setDeliveryTime("1am-3pm");
                } else if (cust.orderList.get(i).getDeliveryTime().equals("4")) {
                    cust.orderList.get(i).setDeliveryTime("3pm-5pm");
                }
                //if order is pick up type, but already paid, then dont display
                System.out.println(i + 1 + ". " + "Order ID: " + cust.orderList.get(i).getOrderID() + "\n"
                        + "Customer ID: " + cust.orderList.get(i).getCustID() + "\n"
                        + "Pick Up Time: " + cust.orderList.get(i).getDeliveryTime() + "\n" + "Item: " + cust.orderedItems.get(i).getName()
                        + "\nOrder Time: " + cust.orderList.get(i).getOrderTime().toString()
                        + "\nOrder Date: " + cust.orderList.get(i).getOrderDate() + "\n*****************************");
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

    public static void updatePaymentStaus() {
        //LinkedList<Payment> paymentList = new LinkedList<>();
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        boolean valid = false;
        int choice = 0;

        System.out.println("*****Below are the list of order that u may update: " + "\n");
        System.out.println();

        for (int i = 0; i < cust.orderList.size(); i++) {
            if(cust.orderList.get(i).getOrderStatus().equals("Unpaid"))
            System.out.println(i + 1 + "."
                    + " " + "Order ID: " + cust.orderList.get(i).getOrderID() + "\n"
                    + "Customer ID: " + cust.orderList.get(i).getCustID() + "\n"
                    + "Order Time: " + currentTimestamp + "\n" + "Item: " + cust.orderList.get(i).getOrderListItem() + "\n"
                    + "Payment Status: " + cust.orderList.get(i).getOrderStatus() + "\n" + "*****************************");

        }
        int userInput = 0;
        double userPayAmount = 0;
        int custId = 0;
        double creditLimit = 0.00;
        double change = 0.00;
            System.out.println("Please enter the order ID that you wish to update\n Enter 0 to back to menu.");

            Scanner scan = new Scanner(System.in);

            userInput = scan.nextInt();
            for (int i = 0; i < cust.orderList.size(); i++) {
                if (userInput == cust.orderList.get(i).getOrderID()) {
                     custId = cust.orderList.get(i).getCustID();
                    for(int j=0; j<cust.ccList.size(); j++){
                        if(custId == cust.ccList.get(j).getCustID()){
                            creditLimit = cust.ccList.get(j).getCreditLimit();
                        }
                    }
                    boolean checkLimit = checkCreditLimit(cust.orderList.get(i).getSubtotal(), creditLimit);
                    if(checkLimit == true){
                    do{
                    System.out.println("Please enter the amount that you wish to pay");
                    userPayAmount = scan.nextDouble();
                    }while(userPayAmount<cust.orderList.get(i).getSubtotal());
                    
                    if(userPayAmount > cust.orderList.get(i).getSubtotal() || userPayAmount == cust.orderList.get(i).getSubtotal()){
                        userPayAmount = cust.orderList.get(i).getSubtotal();
                    }
                    
                    if(userPayAmount > cust.orderList.get(i).getSubtotal()){
                       change = userPayAmount - cust.orderList.get(i).getSubtotal();
                        System.out.println("Here's your change, " + change);
                    }
                    
                    cust.orderList.get(i).setOrderStatus("Paid");
                    System.out.print("Order has been paid!\n");
                    Payment payment = new Payment(cust.paymentList.size() + 1, cust.orderList.get(i).getOrderID(), cust.orderList.get(i).getCustID(),
                            cust.orderList.get(i).getSubtotal(), "Paid",cust.orderList.get(i).getOrderedItems(), currentTimestamp, userPayAmount);
                    
                    cust.paymentList.add(payment);
                    }else{
                        System.out.println("Sorry, you have exceeded your credit limit, so you cannot make a purchase.");
                    }

                }
            }
            
            do {
                        System.out.println("(Enter 0 to go to menu, 1 for exit)");
                        choice = scan.nextInt();
                        if (choice == 1) {
                            System.exit(0);
                        }

                    }while(choice!=0&&choice!=1);

      

    /*    if (cust.paymentList.size() == 0) {
            menu();
        }*/

      //  return cust.paymentList;

    }


    public static void displayDeliveryList() {

        int choice = 0;
        boolean valid = false;

        
        for (int i = 0; i < cust.iCustomerOrder.size(); i++) {

            Integer custId = cust.iCustomerOrder.get(i).getCustID();
            if (cust.iCustomerOrder.get(i).getDeliveryMethod() == "Cash on Delivery") {
                for (int j = 0; j < cust.iCustomer.size(); j++) {
                    if (custId == cust.iCustomer.get(j).getCustID()) {
                        if (cust.iCustomer.get(j).getPostCode() == 43200 || cust.iCustomer.get(j).getPostCode() == 43300 || cust.iCustomer.get(j).getPostCode() == 56100) {
                            cherasDeliveryList.add(cust.iCustomerOrder.get(i));
                        } else {
                            setapakDeliveryList.add(cust.iCustomerOrder.get(i));
                        }
                    }
                }
            }
        }
        System.out.println("Cheras Area Delivery List:\n");
        displayCheras();
        System.out.println("\nSetapak Area Delivery List:\n");
        displaySetapak();
        
        do {
            System.out.println("Do you want to continue?(Enter 0 to go to menu, 1 for exit)");
            choice = scan.nextInt();
           if (choice == 1) {
                System.exit(0);
            }

        } while (valid != true);
    }
    
    public static void displayCheras(){
         if (cherasDeliveryList.size() != 0) {
        for (int i = 0; i < cherasDeliveryList.size(); i++) {
            //if the date now same as delivery date of the COD
            Integer custId = cherasDeliveryList.get(i).getCustID();
            if (LocalDate.now().equals(LocalDate.of(2018, Month.DECEMBER, 10))) {
                for (int j = 0; j < cust.iCustomer.size(); j++) {
                    if (custId == cust.iCustomer.get(j).getCustID()) {
                        String custAdd = cust.iCustomer.get(j).getCustAdd();
                        String custTown = cust.iCustomer.get(j).getTown();
                        String custState = cust.iCustomer.get(j).getState();
                        System.out.println(i + 1 + ". " + "Order ID: " + cherasDeliveryList.get(i).getOrderID() + "\n" 
                                
                                + "\n Address: " + custAdd + "," + custTown
                                + "," + custState + "\n************************************************************************************************");

                    }
                }
            } else {
                System.out.println("Sorry, there is no delivery to be made today." + "\n************************************************************************************************");
            }
        }
        }
    }
    
    public static void displaySetapak(){
           if (setapakDeliveryList.size() != 0) {
            for (int i = 0; i < setapakDeliveryList.size(); i++) {
                Integer custId = setapakDeliveryList.get(i).getCustID();
                if (LocalDate.now().equals(LocalDate.of(2018, Month.DECEMBER, 10))) {
                    for (int j = 0; j < cust.iCustomer.size(); j++) {
                        if (custId == cust.iCustomer.get(j).getCustID()) {
                           String custAdd = cust.iCustomer.get(j).getCustAdd();
                        String custTown = cust.iCustomer.get(j).getTown();
                        String custState = cust.iCustomer.get(j).getState();
                            System.out.println("Order ID: " + setapakDeliveryList.get(i).getOrderID() + "\n Address: " + custAdd + "," + custTown
                                + "," + custState + "\n************************************************************************************************");

                        }
                    }
                } 
            }
        } else {
            System.out.println("Sorry, there is no delivery to be made today."
                    + "\n************************************************************************************************");
        }
    }
    public static void displayPaymentList(){
        System.out.println("The following is the list of payments that has been made: \n");
        
        for(int i = 0; i<cust.paymentList.size(); i++){
           System.out.println(i + 1 + "." + " " +
                   "Payment ID: " + "P00" + cust.paymentList.get(i).getPaymentId() + "\n" + "Order ID: " + cust.paymentList.get(i).getOrderId() + "\n" + 
                           "Payment Amount: " +  cust.paymentList.get(i).getPaymentAmount() + "\n" 
                   + "Order Item: " + cust.paymentList.get(i).getOrderListItem() + 
                    "\n" +  "Payment time: " + cust.paymentList.get(i).getPickupTimestamp());
        }
    }


    public static boolean checkCreditLimit(double subtotal, double creditLimit){
     
               if(creditLimit<subtotal){
               return false;
               }else{
                   return true;
               }          
   }
}

//need location & orderId & delivery date

