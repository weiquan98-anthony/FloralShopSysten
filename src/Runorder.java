
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
     public static List<Item> itemsList = new LinkedList<>(); 
    public static void main(String[] args) {
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
       System.out.print("Order more? (Y/N)");
       check = input.next();
        }while(check.equals("Y")||check.equals("y"));
        
        order.setOrderedItems(orderedItems);
        order.setItemQuantity(itemQuantity);
        
        System.out.print(order);
        }else {
        
        }
        
    }
    
}
