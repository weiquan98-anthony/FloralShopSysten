/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentd;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class FloralShopSystem {

    /**
     * @param args the command line arguments
     */
    public static List<Item> itemsList = new LinkedList<>(); 

    public static void main(String[] args) {
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
    
}
