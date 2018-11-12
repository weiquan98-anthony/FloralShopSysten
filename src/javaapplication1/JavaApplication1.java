/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class JavaApplication1 {
    
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
            System.out.println("4.Exit");
            System.out.println("Please Enter your choice : ");
            option = s.nextInt();
            if(option == 1){
                showItemList();
                
            }else if(option == 2){
                addItem();
            }else if(option == 3){
                updateStock();
            }
            else if(option == 4){
                System.exit(0);
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
        int a = s.nextInt(); 
        if(a==1){
            menu();
        }else if(a==2){
            System.exit(0);
        }
    }
    
    
    public static void updateStock(){
        int choice =0;
        showList();
        System.out.println("Select item by number to update stock: e.g. 1");
        Scanner a = new Scanner(System.in);
        choice = a.nextInt();
        boolean checking =false;
        for(int i=0; i<itemsList.size(); i++){
            if(itemsList.get(i).getId() == choice){
                System.out.println("Enter quantity");
                Scanner stock = new Scanner(System.in);
                int newQ = stock.nextInt();
                itemsList.get(i).setQuantity(newQ);
                System.out.println("Stock have been updated!\n");
                checking = true;
                
                System.out.println("1.Return to Main Menu");
                System.out.println("2.Exit");
                Scanner s = new Scanner(System.in);
                choice = s.nextInt(); 
                if(choice==1){
                    menu();
                }else if(choice==2){
                    System.exit(0);
                }
            }
    }
        if(checking!= true){
            System.out.println("Invalid item\n");
            System.out.println("1.Return to Main Menu");
            System.out.println("2.Exit");
            Scanner s = new Scanner(System.in);
            choice = s.nextInt(); 
            if(choice==1){
                menu();
            }else if(choice==2){
                System.exit(0);
            }
        }
        
        
//                if(choice==1){
//                    System.out.println("Enter quantity");
//                    Scanner stock = new Scanner(System.in);
//                    int newQ = stock.nextInt();
//                    itemsList.get(0).setQuantity(newQ);
//                    showList();
//
//                }else if(choice==2){
//                    System.out.println("Enter quantity");
//                    itemsList.get(1).setQuantity(a.nextInt());
//                   showList();
//                }
    }
    
    public static void showList(){
        System.out.println("No. Item\t\t" + "Quantity");
        System.out.println("==========================================");
            for(int i =0; i<itemsList.size(); i++){
                System.out.printf("%-3d %-8s \t\t%-2d \n", i+1, itemsList.get(i).getName(), itemsList.get(i).getQuantity());
            }
        
    }
    
    public static void showItemList(){
        System.out.println("No. Item\t" + "  Price\t\t" + "Quantity");
        System.out.println("=====================================================");
            for(int i =0; i<itemsList.size(); i++){
                System.out.printf("%-3d %-10s \t  RM%.2f %8d \n", i+1, itemsList.get(i).getName(), itemsList.get(i).getPrice(), itemsList.get(i).getQuantity());
            }
        System.out.println("1.Return to Main Menu");
        System.out.println("2.Exit");
        Scanner s = new Scanner(System.in);
        int a = s.nextInt(); 
        if(a==1){
            menu();
        }else if(a==2){
            System.exit(0);
        }
    }
}
