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
 * @author Alex
 */
public class JavaApplication1 {
    
    public static List<Item> itemsList = new LinkedList<>(); 
    public static boolean a = false;
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
        int count = 0;
        do{
            if(count>=1){
                System.out.println("Wrong number entered!");
            }
            System.out.println("Menu: ");
            System.out.println("1.View Catalogue");
            System.out.println("2.Add Item");
            System.out.println("3.Update Stock");
            System.out.println("4.Exit");
            System.out.println("Please Enter your choice : ");
            option = s.nextInt();
            if(option == 1){
                showItemList();
                a = true;
            }else if(option == 2){
                addItem();
                a = true;
            }else if(option == 3){
                updateStock();
                a = true;
            }
            else if(option == 4){
                System.exit(0);
            }
            count++;
        }while(a!=true);
    }
    
    public static void addItem(){
        Item items = new Item();
        Scanner s = new Scanner(System.in);
        int count = 0;
        int choice = 0;
        
        System.out.print("ID:");
        items.setId(itemsList.size()+1);
        System.out.println(items.getId());
        System.out.println("Enter new item name: ");
        items.setName(s.next());
        System.out.println("Enter price: ");
        items.setPrice(s.nextInt());
        System.out.println("Enter quantity:");
        items.setQuantity(s.nextInt());
        System.out.println("\n");
        itemsList.add(items);
        
        System.out.println("New item successfully added!\n");
        System.out.println("New list");
        
        showList();
        while(a!=true){
                    if(count>=1){
                        System.out.println("Wrong number entered!");
                    }
                    System.out.println("1.Return to Main Menu");
                    System.out.println("2.Exit");
                    System.out.println("Please choose an option e.g. 2 to exit");
                    choice = s.nextInt(); 
                    if(choice==1){
                        menu();
                        a = true;
                    }else if(choice==2){
                        System.exit(0);
                    }
                    count++;
                }
        
    }
    
    
    public static void updateStock(){
        int choice =0;
        int count =0;
        showList();
        System.out.println("Select item by number to update stock: e.g. 1 for Roses. 0 return to main menu");
        Scanner b = new Scanner(System.in);
        choice = b.nextInt();
        boolean checking =false;
        for(int i=0; i<itemsList.size(); i++){
            if(itemsList.get(i).getId() == choice){
                System.out.println("Enter quantity");
                Scanner stock = new Scanner(System.in);
                int newQ = stock.nextInt();
                itemsList.get(i).setQuantity(newQ);
                System.out.println("Stock have been updated!\n");
                checking = true;
//                do{
                while(a!=true){
                    if(count>=1){
                        System.out.println("Wrong number entered!");
                    }
                    System.out.println("1.Return to Main Menu");
                    System.out.println("2.Exit");
                    System.out.println("Please choose an option e.g. 2 to exit");
                    Scanner s = new Scanner(System.in);
                    choice = s.nextInt(); 
                    if(choice==1){
                        menu();
                        a = true;
                    }else if(choice==2){
                        System.exit(0);
                    }
                    count++;
                }
//                }while(a!=true);
                
            }else if(choice ==0){
                menu();
            }
    }
        if(checking!= true){
            do{
                System.out.println("Invalid item\n");
                System.out.println("1.Return to Main Menu");
                System.out.println("2.Exit");
                System.out.println("Please choose an option e.g. 2 to exit");
                Scanner s = new Scanner(System.in);
                choice = s.nextInt(); 
                if(choice==1){
                    menu();
                    a = true;
                }else if(choice==2){
                    System.exit(0);
                }
            }while(a != true);
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
        //do{
        int count = 0;
        
        System.out.println("No. Item\t" + "  Price\t\t" + "Quantity");
        System.out.println("=====================================================");
            for(int i =0; i<itemsList.size(); i++){
                System.out.printf("%-3d %-10s \t  RM%.2f %8d \n\n", i+1, itemsList.get(i).getName(), itemsList.get(i).getPrice(), itemsList.get(i).getQuantity());
            }
           
            while(a!=true){ 
                if(count>=1){
                System.out.println("Wrong number entered!");
            }
        System.out.println("1.Return to Main Menu");
        System.out.println("2.Exit");
        System.out.println("Please choose an option e.g. 2 to exit");
        Scanner s = new Scanner(System.in);
        int c = s.nextInt(); 
        
            if(c==1){
                a = true;
            menu();
        }else if(c==2){
            System.exit(0);
        }
            count++;
        }
        
    }
}
