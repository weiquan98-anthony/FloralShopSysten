/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentd;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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
    
    public static void main(String[] args) {
        // TODO code application logic 
        LinkedList<Payment> paymentList = new LinkedList<>();
        LinkedList<Payment> tempList = new LinkedList<>();
        int choice = 0;
        System.out.println("*****Please select your choice: *****" + "\n" + "1. Order Pick Up List" + "\n2. Update Payment Status");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();

        while(choice!= 1 && choice!=2){
        System.out.println("*****Please select your choice(1-4): *****" + "\n" + "1. Order Pick Up List"); 
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
            System.out.println(orderList.size() + 1 + "Order ID: "  + orderList.get(i).getOrderID() + "\n" + 
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
    
}

