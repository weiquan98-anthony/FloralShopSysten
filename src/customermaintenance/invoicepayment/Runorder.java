package customermaintenance.invoicepayment;


import com.sun.org.apache.xml.internal.resolver.Catalog;
import java.io.Console;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaynas Chan
 */
public class Runorder {
 

    /**
     * @param args the command line arguments
     */
     public static LinkedList<CatalogOrder> OrderList = new LinkedList<>();
     public static List<Item> itemsList = new LinkedList<>(); 
     public static LinkedList<Item> orderedItems1 = new LinkedList<>();
     public static LinkedList<Integer> quantityItem = new LinkedList<>();
     
     
    
    public static void main(String[] args) throws IOException {
         Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime());
        Item items1 = new Item(1,"Roses", 75.50, 8);
        Item items2 = new Item(2,"Sunflowers", 50.50, 10);
        
        itemsList.add(items1);
        itemsList.add(items2); 
      
        quantityItem.add(1);
        orderedItems1.add(items2);
        CatalogOrder hardCoded = new CatalogOrder(1, 1, time, "Pick-Up", "Unpaid", time, "1", 500.0, orderedItems1, quantityItem);
        CatalogOrder hardCoded2 = new CatalogOrder(2, 2, time, "Pick-Up", "Unpaid", time, "1", 500.0, orderedItems1, quantityItem);
        CatalogOrder hardCoded3 = new CatalogOrder(3, 3, time, "Pick-Up", "Unpaid", time, "1", 500.0, orderedItems1, quantityItem);
        
        OrderList.add(hardCoded);
        OrderList.add(hardCoded2);
        OrderList.add(hardCoded3);
        
        System.out.println("1.) Make Order \n");
        System.out.println("2 Exit \n");
        Scanner input = new Scanner(System.in);
        String n1 = input.next();
        
        if(n1.equals("1")){
        CatalogOrder order = new CatalogOrder();
        LinkedList<Item> orderedItems = new LinkedList();
        LinkedList<Integer> itemQuantity = new LinkedList();
        
        
        order.setOrderID((OrderList.size()+1));
        System.out.print("Please enter Customer ID:    ");
        order.setCustID(Integer.parseInt(input.next()));
        order.setOrderTime(new Timestamp(Calendar.getInstance().getTime().getTime()));
        String check = "";
        do{
       
        System.out.print("Please select desired items :\n");
        System.out.print("--------------------------------------------------------\n");
        System.out.print("Product ID\t\tProduct Name\t\tProduct Price\t\tStock\n");
        
        for(int i=0;i<itemsList.size();i++){
            System.out.printf("%s\t\t\t%s\t\t%.2f\t\t%d\n",itemsList.get(i).getId(),itemsList.get(i).getName(),itemsList.get(i).getPrice(),itemsList.get(i).getQuantity());
        
        }
        int userFlower = (input.nextInt()-1);
       
       
       
         
       System.out.print("Please enter desired Quantity: ");
       int quantity = input.nextInt();
      
       int check2=0;       
          for(int i=0;i<orderedItems.size();i++){
                if(orderedItems.get(i)== itemsList.get(userFlower)){
                    
             int itemquantity = itemQuantity.get(i);
             itemQuantity.set(i, itemquantity+quantity);
              check2++;
            }
        }
          
          if(check2==0){
              orderedItems.add(itemsList.get(userFlower));
           itemQuantity.add(quantity);
          }
       System.out.print("Order more? (Y/N)");
       check = input.next();
        }while(check.equals("Y")||check.equals("y"));
        System.out.println("Please select desired delivery method :");
        System.out.println("1.) Cash-On Delivery");
        System.out.println("2.) Pick-Up");
        String delivery = input.next();
        if(delivery.equals("1")){
           order.setDeliveryMethod("Cash-On Delivery");
           System.out.println("Please Enter Delivery Date");
           System.out.print("Day:");
           int day = input.nextInt();
           System.out.print("Month:");
           int month = input.nextInt();
           System.out.print("Year:");
           int year = input.nextInt();
           Date date = new Date(year, month, day);
           order.setDeliveryDate(date);
           order.setDeliveryTime(null);
           
        }else{
         order.setDeliveryMethod("Pick-Up");
           System.out.println("Please Enter Pick-Up Date");
           System.out.print("Day:");
           int day = input.nextInt();
           System.out.print("Month:");
           int month = input.nextInt();
           System.out.print("Year:");
           int year = input.nextInt();
           Date date = new Date(year, month, day);
           order.setDeliveryDate(date);
           System.out.println("Please select pick-up time:");
           System.out.println("1.)9am-11am");
           System.out.println("2.)11am-13pm");
           System.out.println("3.)13pm-15pm");
           System.out.println("4.)15pm-17pm");
           order.setDeliveryTime(input.next());    
        }
         double subtotal=0;
             for(int i=0;i<orderedItems.size();i++){
            subtotal=subtotal+(orderedItems.get(i).getPrice()*itemQuantity.get(i).intValue());
           order.setSubtotal(subtotal);
        }
        
      
        
        
        order.setOrderedItems(orderedItems);
        order.setItemQuantity(itemQuantity);
        order.setOrderStatus("Unpaid");
        System.out.print(order);
        OrderList.add(order);
        }
        
    }
    
}
