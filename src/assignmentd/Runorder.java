package assignmentd;


import static assignmentd.JavaApplication1.catalogMaintenance;
import com.sun.org.apache.xml.internal.resolver.Catalog;
import java.io.Console;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
     public static LinkedList<Item> categoryList = new LinkedList<>(); 
     public static LinkedList<Item> itemsList = new LinkedList<>(); 
     public static LinkedList<Item> orderedItems1 = new LinkedList<>();
     public static LinkedList<Integer> quantityItem = new LinkedList<>();
     

    public static CatalogMaintenance catalogMaintenance = new CatalogMaintenance();
     
     public static int seperateCID(String custID){
         String tempCust ="";
         
         for(int i=1;i<custID.length();i++){
             tempCust += custID.charAt(i);
         }
         
         return Integer.parseInt(tempCust);
     }
    
    public static void main(String[] args) throws IOException {
     
        
        categoryList.add(new Item(1,"Sunset Roses", 75, 2, "Bouquet"));
        categoryList.add(new Item(2,"Great Eastern Daisies", 89, 3, "Bouquet")); 
        categoryList.add(new Item(3,"Beyond Purple", 88, 10, "Flower Baskets")); 
        categoryList.add(new Item(4,"Basket Daisy", 99, 8, "Flower Baskets")); 
        categoryList.add(new Item(5,"Premium Flower Stand", 95, 6, "Flower Stands")); 
        LocalDate lol=null;
        
      
        quantityItem.add(4);
        orderedItems1.add(new Item(1,"Sunset Roses", 75, 0, "Bouquet"));
        CatalogOrder hardCoded = new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", lol.of(2018, 12, 2), "1", quantityItem, orderedItems1, 50.0);
        CatalogOrder hardCoded2 = new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", lol.of(2018, 12, 2), "1", quantityItem, orderedItems1, 50.0);
        CatalogOrder hardCoded3 = new CatalogOrder(3, 3,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", lol.of(2018, 12, 2), "1", quantityItem, orderedItems1, 50.0);

        
        OrderList.add(hardCoded);
        OrderList.add(hardCoded2);
        OrderList.add(hardCoded3);
        System.out.println("1.) Make Order \n");
        System.out.println("2.) Sales Order \n");
        Scanner input = new Scanner(System.in);
        String n1 = input.next();
        
        if(n1.equals("1")){
        CatalogOrder order = new CatalogOrder();
        LinkedList<Item> orderedItems = new LinkedList();
        LinkedList<Integer> itemQuantity = new LinkedList();
        
        
        order.setOrderID((OrderList.size()+1));
        System.out.print("Please enter Customer ID:    ");
        String SeperateCustID = input.next();
        
        
        
        order.setCustID(seperateCID(SeperateCustID));
        order.setOrderTime(LocalTime.now());
        order.setOrderDate(LocalDate.now());
        String check = "";
        do{
        System.out.println("Please select category of product: ");
        System.out.println("1.) Bouquet ");
        System.out.println("2.) Flower Baskets ");
        System.out.println("3.) Flower Stands ");
        System.out.print("Enter :");
        int userEnterAns = input.nextInt();
        
        
        for(int i=0;i<categoryList.size();i++){
            
            if(userEnterAns==1){
                
                if(categoryList.get(i).getCategory().equals("Bouquet")&&categoryList.get(i).getQuantity()!=0){
                    itemsList.add(categoryList.get(i));
                }
                
            }else if(userEnterAns==2){
                 if(categoryList.get(i).getCategory().equals("Flower Baskets")&&categoryList.get(i).getQuantity()!=0){
                    itemsList.add(categoryList.get(i));
                }
            
            }else if(userEnterAns==3){
                 if(categoryList.get(i).getCategory().equals("Flower Stands")&&categoryList.get(i).getQuantity()!=0){
                    itemsList.add(categoryList.get(i));
                }
            
            }
        }
            
        
        
        System.out.print("Please select desired items :\n");
        System.out.print("--------------------------------------------------------\n");
        System.out.print("Product ID\t\tProduct Name\t\tProduct Price\t\tStock\n");
        
        for(int i=0;i<itemsList.size();i++){
           System.out.print("P000"+itemsList.get(i).getId()+"\t\t\t"+itemsList.get(i).getName()+"\t\t\t"+itemsList.get(i).getPrice()+"\t\t\t"+itemsList.get(i).getQuantity()+"\n");
        
        }
        System.out.print("ProductID : ");
        String selectFloID = input.next();
        
        int userFlower = seperateCID(selectFloID);
       
       
       
         
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
              orderedItems.add(itemsList.get(userFlower-1));
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
           //Date date = new Date(year-1900, month-1, day);
           
           order.setDeliveryDate( LocalDate.of(year, month, day));
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
           //Date date = new Date(year, month, day);
           order.setDeliveryDate( LocalDate.of(year, month, day));
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
        }else if (n1.equals("2")){    
        System.out.print("Please select Product ID :\n");
        System.out.print("--------------------------------------------------------\n");
        System.out.print("Product ID\t\tProduct Name\n");
        double totalsub=0;
        for(int i=0;i<itemsList.size();i++){
           System.out.print("P000"+itemsList.get(i).getId()+"\t\t\t"+itemsList.get(i).getName()+"\n");
        
        }
        System.out.print("ProductID : ");
        
        String salesorder = input.next();
        int salesNo = seperateCID(salesorder);
        System.out.println("CustomerID\t\tProduct Name\t\tPrice\t\tQuantity\t\tSubtotal\n");
        for(int i = 0; i < OrderList.size();i++){
           
            for(int j=0;j<OrderList.get(i).getOrderedItems().size();j++){
                
                if(salesNo == OrderList.get(i).getOrderedItems().get(j).getId()){
                    System.out.print(OrderList.get(i).getCustID()+"\t\t\t");
                    System.out.print(OrderList.get(i).getOrderedItems().get(j).getName()+"\t\t");
                    System.out.print(OrderList.get(i).getOrderedItems().get(j).getPrice()+"\t\t\t");
                    System.out.print(OrderList.get(i).getItemQuantity().get(j).intValue()+"\t\t");
                    double itemPrice = OrderList.get(i).getOrderedItems().get(j).getPrice();
                    double quantity =  OrderList.get(i).getItemQuantity().get(j).doubleValue();
                    System.out.println(itemPrice*quantity);
                    totalsub = totalsub + (itemPrice*quantity);
                }
                
            }
        }
        System.out.println("Total Sales Order :RM"+totalsub);
        
        
        
        }
        
    }
    
}
