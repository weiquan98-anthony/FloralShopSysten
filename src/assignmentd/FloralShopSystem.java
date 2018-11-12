/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentd;

import static assignmentd.CustomerMaintenanceInvoicePayment.addCustomer;
import static assignmentd.CustomerMaintenanceInvoicePayment.ccList;
import static assignmentd.CustomerMaintenanceInvoicePayment.icList;
import static assignmentd.CustomerMaintenanceInvoicePayment.menu;
import static assignmentd.CustomerMaintenanceInvoicePayment.viewCustomer;
import static assignmentd.Test.itemsList;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author admin
 */
public class FloralShopSystem {
        public static LinkedList<Payment> paymentList = new LinkedList<>();
        public static LinkedList<Payment> tempList = new LinkedList<>();
        public static List<CorporateCustomer> ccList=new ArrayList<>();
        public static  List<IndividualCustomer> icList=new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static List<Item> itemsList = new LinkedList<>(); 
    
    public static void main(String[] args){
        int menuOp = 0;
        do{
        Scanner s1 = new Scanner(System.in);
        System.out.println("Please select system function : ");
        System.out.println("1.) Catalog Maintainance");
        System.out.println("2.) Customer Maintainance and Invoice Payment");
        System.out.println("3.) Catalog Order");
        System.out.println("4.) Pick-up/Delivery and Payment Management");
        System.out.println("5.) Customized Floral Arrangements");
        System.out.println("6.) Exit");
        
        menuOp = s1.nextInt();
        
        if(menuOp==1){
            catalogMaintanance();
        }
        else if (menuOp==2){
        CustMenu();
        
        }
        else if (menuOp==3){
        catalogOrder();
        
        }
        else if (menuOp==4){
        pickUpDelivery();
        
        }
        else if (menuOp==5){
            CustomizeFlower();
        }
        
        else if(menuOp==6){
            System.exit(0);
        }
        
        }while(menuOp!=6);
        
    
    }
    
    public static void CustomizeFlower(){
        Scanner scan = new Scanner(System.in);
        
        Stack<Integer> customList = new Stack<>();
        Customer currentCust = new Customer();
        currentCust.setName("Jason");
        
        int choice;
        boolean valid = false;
        
        //Step 1
        do{
            System.out.println("Step one: Select flower arrangement style. \n"
                + "1. Traditional \n"
                + "2. Oriental \n"
                + "3. Modern");
            choice = scan.nextInt();
            if(choice==1 || choice==2 || choice==3){
                customList.add(choice);
                valid = true;
            }else{
                System.out.println("Please enter choices given.");
            }    
        }while(valid != true);
        
        //Step 2
        do{
            System.out.println("Step two: Select flower arrangment size. \n"
                + "1. Large \n"
                + "2. Medium \n"
                + "3. Small");
            choice = scan.nextInt();
            if(choice==1 || choice==2 || choice==3){
                customList.add(choice);
                valid = true;
            }else{
                System.out.println("Please enter choices given.");
            }
        }while(valid != true);
        
        //Step 3
        do{
            System.out.println("Step three: Select flowers. \n"
                + "1. Jasmine \n"
                + "2. Lily \n"
                + "3. Rose");
            choice = scan.nextInt();
            if(choice==1 || choice==2 || choice==3){
                customList.add(choice);
                valid = true;
            }else{
                System.out.println("Please enter choices given.");
            }
        }while(valid != true);
        
        //Step 4
        do{
            System.out.println("Step four: Select accessories. \n"
                + "1. Jeweled Pins \n"
                + "2. Wispy Feathers \n"
                + "3. Fabric Butterfly");
            choice = scan.nextInt();
            if(choice==1 || choice==2 || choice==3){
                customList.add(choice);
                valid = true;
            }else{
                System.out.println("Please enter choices given.");
            }
        }while(valid != true);
        
        currentCust.setCustomList(customList);
        
        do{
            System.out.println("Select your priortity: \n"
                + "1. Express \n"
                + "2. Normal \n"
                + "3. Flexible");
            choice = scan.nextInt();
            if(choice==1 || choice==2 || choice==3){
                customList.add(choice);
                valid = true;
            }else{
                System.out.println("Please enter choices given.");
            }
        }while(valid != true);
        
        currentCust.setCustomList(customList);
        System.out.println("Congratulations " + currentCust.name +
                ", your Custom Floral Arrangement has been saved.");
    }
    
     public static void pickUpDelivery() {
        // TODO code application logic 
      
        int choice = 0;
        System.out.println("*****Please select your choice: *****" + "\n" + "1. Order Pick Up List" + "\n2. Update Payment Status");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();

        while(choice!= 1 && choice!=2){
        System.out.println("*****Please select your choice(1-4): *****" + "\n" + "1. Order Pick Up List" + "\n2. Update Payment Status"); 
        choice = scan.nextInt();
        
        
        }
        if(choice == 1){
        listOrder();
        }else if(choice ==2){
            tempList = updatePaymentStaus();
            
            for (int i=0;i<tempList.size();i++){
                paymentList.add(tempList.get(i));
            }                  
        }
    }
    
    //("Order001", "S001", "C001", currentTimestamp, orderedItems, "Pick Up", itemQuantity));
    public static void listOrder(){
       
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        LinkedList<CatalogOrder> orderList = new LinkedList<>();
        
        LinkedList<Item> orderedItems = new LinkedList<>();
        orderedItems.add(new Item(001, "Sunflower", 23.88, 20));
        LinkedList<Integer> itemQuantity = new LinkedList<>();
        itemQuantity.add(2);
        
        
        
        orderList.add(new CatalogOrder("Order001", "S001", "C001", currentTimestamp, orderedItems, "Pick Up", itemQuantity, "Unpaid"));
        System.out.println("*****Order Pick Up List for Today: *****" + "\n");
        System.out.println();
        
        for(int i=0; i<orderList.size(); i++){
            if(orderList.get(i).getDeliveryMethod().equals("Pick Up"))
            System.out.println(orderList.size() + 1 + "Order ID: "  + orderList.get(i).getOrderID() + "\n" + 
                    "Customer ID: " + orderList.get(i).getCustID() + "\n" 
                                + "Order Time: " + currentTimestamp + "\n" + "Item: " + orderedItems.get(i).getName() + "\n*****************************");
        }
        
        
    }
    
    public static LinkedList<Payment> updatePaymentStaus(){
         LinkedList<Payment> paymentList = new LinkedList<>();
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        LinkedList<CatalogOrder> orderList = new LinkedList<>();
        
        LinkedList<Item> orderedItems = new LinkedList<>();
        orderedItems.add(new Item(001, "Sunflower", 23.88, 20));
        orderedItems.add(new Item(002, "Hibiscus", 25.88, 10));
        LinkedList<Integer> itemQuantity = new LinkedList<>();
        itemQuantity.add(2);
        itemQuantity.add(3);
        
        
        
        orderList.add(new CatalogOrder("Order001", "S001", "C001", currentTimestamp, orderedItems, "Pick Up", itemQuantity, "Unpaid"));
        orderList.add(new CatalogOrder("Order002", "S002", "C002", currentTimestamp, orderedItems, "Cash on Delivery", itemQuantity, "Unpaid"));
        System.out.println("*****Order Pick Up List for Today: *****" + "\n");
        System.out.println();
        
        for(int i=0; i<orderList.size(); i++){
            System.out.println(i + 1 + ".3"
                    + " " + "Order ID: "  + orderList.get(i).getOrderID() + "\n" + 
                    "Customer ID: " + orderList.get(i).getCustID() + "\n" 
                                + "Order Time: " + currentTimestamp + "\n" + "Item: " + orderedItems.get(i).getName() + "\n"
                                + "Payment Status: " + orderList.get(i).getPaymentStatus() + "\n" + "*****************************");
           
        }
         String userInput="";
        do{
            System.out.println("Please enter the order ID that you wish to update\n Enter 0 to back to menu.");
        
        Scanner scan = new Scanner(System.in);
         userInput = "";
        userInput = scan.next();
        for(int i=0; i<orderList.size(); i++){
            if(userInput.equals(orderList.get(i).getOrderID())){
                orderList.get(i).setPaymentStatus("Paid");
                System.out.print("Order has been paid!\n");
                 Payment payment = new Payment("P0001", orderList.get(i).getOrderID(), orderList.get(i).getStaffID(), orderList.get(i).getCustID(), 22.0);
                 paymentList.add(payment);
            }
        }
        }while(!userInput.equals("0"));
        
       
        return paymentList;
        
    }
    
    static void displayPaymentDetails(){
        
    }
    static void catalogOrder(){
        double totalMoney = 0.0;
           List<Item> itemsList = new LinkedList<>(); 
           Item items1 = new Item(1,"Roses", 75.50, 8);
        Item items2 = new Item(2,"Sunflowers", 50.50, 10);
        itemsList.add(items1);
        itemsList.add(items2); 
        System.out.println("1.) Make Order \n");
        System.out.println("2 Exit \n");
        Scanner input = new Scanner(System.in);
        String n1 = input.next();
        
        if(n1.equals("1")){
        CatalogOrder order = new CatalogOrder();
        LinkedList<Item> orderedItems = new LinkedList();
        LinkedList<Integer> itemQuantity = new LinkedList();
        
        System.out.print("Please enter Order ID:   ");
        order.setOrderID(input.next());
        System.out.print("Please enter Staff ID:   ");
        order.setStaffID(input.next());
        System.out.print("Please enter Customer ID:    ");
        order.setCustID(input.next());
        order.setOrderTime(new Timestamp(Calendar.getInstance().getTime().getTime()));
        String check = "";
        do{
        System.out.print("Please select desired items :\n");
        
        for(int i=0;i<itemsList.size();i++){
            System.out.print((i+1)+".)"+itemsList.get(i).getName()+"\n");
        
        }
        int userFlower = (input.nextInt()-1);
        
        orderedItems.add(itemsList.get(userFlower));
        
       System.out.print("Please enter desired Quantity: ");
       int quantity = input.nextInt();
       itemQuantity.add(quantity);
       
       for(int i=0;i<orderedItems.size();i++){
           totalMoney += (orderedItems.get(i).getPrice() * itemQuantity.get(i));
       }
       order.setSubtotal(totalMoney);
       
       System.out.print("Order more? (Y/N)");
       check = input.next();
        }while(check.equals("Y")||check.equals("y"));
        
        order.setOrderedItems(orderedItems);
        order.setItemQuantity(itemQuantity);
        System.out.print("Please select Delivery Method : \n1.)Pick up \n2.)Cash on Delivery\n Select : ");
        String delivery = input.next();
        
        if(delivery.equals("1")){
        order.setDeliveryMethod("Pick-up");
        
        }else if(delivery.equals("2")){
        order.setDeliveryMethod("Cash on Delivery");
        
        }
        
        System.out.print(order);
        }
        
    }
    public static void catalogMaintanance() {
     
        Item items1 = new Item(1,"Roses", 75.50, 8);
        Item items2 = new Item(2,"Sunflowers", 50.50, 10);
        itemsList.add(items1);
        itemsList.add(items2); 
        menu();
    }

    public static void menu(){

        Scanner s = new Scanner(System.in);

        int option;
//        do{
            System.out.println("Menu: ");
            System.out.println("1.View Catalogue");
            System.out.println("2.Add Item");
            System.out.println("3.Update Stock");
            System.out.println("Please Enter your choice : ");
            option = s.nextInt();
            if(option == 1){
                showList();
                menu();
            }else if(option == 2){
                addItem();
                menu();
            }else if(option == 3){
                updateStock();
                menu();
            }
//        }while(option>=1||option<=3);
    }
    
    public static void addItem(){
        Item items = new Item();
        Scanner s = new Scanner(System.in);
        
        System.out.print("ID:");
        items.setId(itemsList.size()+1);
        System.out.print("Enter new item name: ");
        items.setName(s.next());
        System.out.print("Enter price: ");
        items.setPrice(s.nextInt());
        System.out.print("Enter quantity: ");
        items.setQuantity(s.nextInt());
        
        itemsList.add(items);
        
        showList();   
    }
    
    
    public static void updateStock(){
        int choice =0;
        showList();
                System.out.println("Select item by number to update stock:");
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
                if(choice==1){
                    System.out.println("Enter quantity");
                    Scanner stock = new Scanner(System.in);
                    int newQ = stock.nextInt();
                    itemsList.get(0).setQuantity(newQ);
                    showList();

                }else if(choice==2){
                    System.out.println("Enter quantity");
                    itemsList.get(1).setQuantity(a.nextInt());
                   showList();
                }
    }
    
    public static void showList(){
        System.out.println("No. Item\t\t" + "Quantity");
        System.out.println("==========================================");
            for(int i =0; i<itemsList.size(); i++){
                System.out.printf("%-3d %-8s \t\t %-2d \n", i+1, itemsList.get(i).getName(), itemsList.get(i).getQuantity());
            }
    }
    
      static void addCustomer()
    {
         Scanner input= new Scanner(System.in);
         CorporateCustomer cc=new CorporateCustomer();
         IndividualCustomer ic=new IndividualCustomer();
        
//         for(int i=0; i<11; i++){
//             cc = new CorporateCustomer(100,ccList.size()+1 , "asd", "asd", "asd", "asd", "asd");
//             ccList.add(cc);
//         }
//         CorporateCustomer cc0 = new CorporateCustomer(123,"blablabla", 1,"blablabla", "blablabla", "blablabla", "blablabla", "blablabla");
//         ccList.add(cc0);
         boolean a = false;
        do{
            System.out.println("****************Register Customer*************");

            System.out.println("--Customer Identity--");
            System.out.println("1.Corporate Customer (CC)");
            System.out.println("2.Individual Customer(IC)");
            System.out.print("Select type of customer (e.g 1):");
            int identity=input.nextInt();
        
        
        
            if(identity==1){
                cc.setCustIdentity("CC");
            
                System.out.print("Credit Limit:Rm");
                int credit=input.nextInt();
                cc.setCreditLimit(credit);

                System.out.print("Customer ID:");
                cc.setCustID(ccList.size()+1);
                if(ccList.size()<10){
                    System.out.println("CC00"+cc.getCustID());
                }
                else if(ccList.size()>=10 && ccList.size()<=99){
                    System.out.println("CC0"+cc.getCustID());
                }
            
                System.out.print("Company Name:");
                String  cName=input.next();
                cc.setCompanyName(cName);

                System.out.print("Customer Name:");
                String  name=input.next();
                cc.setCustName(name);

                System.out.print("Customer Address:");
                String add=input.next();
                cc.setCustAdd(add);

                System.out.print("Customer PhoneNum:");
                String phoneNo=input.next();
                cc.setCustPhone(phoneNo);

                System.out.print("Customer Email:");
                String email=input.next();
                cc.setCustEmail(email);

                ccList.add(cc);
                
                System.out.println("****************Registered successful*************");

                for(int i=0; i<ccList.size(); i++){
                    System.out.println(ccList.get(i).toString());
                }
                a = true;
            }
            else if(identity==2){
                ic.setCustIdentity("IC");
                System.out.print("Customer ID:");
                ic.setCustID(icList.size()+1); 
                if(icList.size()<10){
                    System.out.println("IC00"+ic.getCustID());
                }
                else if(icList.size()>=10 && icList.size()<=99){
                    System.out.println("IC0"+cc.getCustID());
                }

                System.out.print("Customer Name:");
                String  name=input.next();
                ic.setCustName(name);

                System.out.print("Customer Address:");
                String add=input.next();
                ic.setCustAdd(add);

                System.out.print("Customer PhoneNum:");
                String phoneNo=input.next();
                ic.setCustPhone(phoneNo);

                System.out.print("Customer Email:");
                String email=input.next();
                ic.setCustEmail(email);
                
                icList.add(ic);
                
                System.out.println("****************Registered successful*************");
                 for(int i=0; i<icList.size(); i++){
                System.out.println(icList.get(i).toString());
                 }   
                 a = true;
            }   
        }while(a!=true);
    }
    
    static void CustMenu()
    {
      Scanner menu=new Scanner(System.in);
        int select;
        boolean a = false;
        do{
            System.out.println("*********Menu***************");
            System.out.println("1.RegisterCustomer:");
            System.out.println("2.ViewCustomer:");
            System.out.println("3.InvoicePayment:");
            System.out.println("*****************************");
            
            System.out.print("Please select ur option:");
            select=menu.nextInt();
            
            if(select==1)
            {  
                addCustomer();
               int respond;
               
                do{
                System.out.print("Do you want to continue add customer?(1=yes/2=no):");
                respond = menu.nextInt();
                    if(respond== 1)
                    {
                        addCustomer();
                    }

                    else if(respond==2)
                    {
                       CustMenu();
                    }
                    a = true;
                }while(respond ==1);
            }
            
              
                
            else if(select ==2)
            {
               viewCustomer();
               a = true;
            }
           

            
        }while(a!=true);
    }
     public static void viewCustomer()
    {
        System.out.println("=====Coporate Customer======");
        for(int i=0;i<ccList.size();i++)
        {
            
            System.out.println(ccList.get(i).toString());
        }
       
        
         System.out.println("=====Individual Customer======");
          for(int i=0;i<icList.size();i++)
        {
            
            System.out.println(icList.get(i).toString());
        }
          System.out.println("============================");
    }
    
}
