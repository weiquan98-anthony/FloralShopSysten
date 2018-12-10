/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.org.apache.xpath.internal.functions.FuncTrue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Kai
 */
public class Customize{

    /**
     * @param args the command line arguments
     */
    
    //public static Functions<Integer> funct = new Functions<Integer>();

    
    public void CustomizeFloral() {
        // TODO code application logic here

        Scanner scan = new Scanner(System.in);
        
        Stack<Integer> customList = new Stack<>();
        Stack<Integer> cust1List = new Stack<>();
        cust1List.add(1);
        cust1List.add(1);
        cust1List.add(1);
        cust1List.add(1);
        cust1List.add(2);
        Stack<Integer> cust2List = new Stack<>();
        cust2List.add(1);
        cust2List.add(1);
        cust2List.add(1);
        cust2List.add(1);
        cust2List.add(3);
        Customer currentCust = new Customer();
        currentCust.setName("Jason");
        Customer cust1 = new Customer("Ronaldo", cust1List);
        Customer cust2 = new Customer("Messi", cust2List);
        
        int choice;
        int choice1 = 0;
        boolean valid = false;
        
//        for(int i = 0;i<cust1.getCustomList().size();i++){
//            int lastElement = cust1.getCustomList().get(i);
//            System.out.println(lastElement);
//        }
        

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
        int count1 = 0;
        while(choice!=4){
            count1++;
            do{
            System.out.println("Step three: Select flowers. \n"
                + "1. Jasmine \n"
                + "2. Lily \n"
                + "3. Rose\n"
                + "4. Exit if no more selection.");
            choice = scan.nextInt();
            if(choice==1 || choice==2 || choice==3 || choice==4){
                customList.add(choice);
                valid = true;
            }else{
                System.out.println("Please enter choices given.");
            }
            }while(valid != true);
        }
        
        
        //Step 4
        int count2 = 0;
        while(choice1!=4){
            count2++;
            do{
            System.out.println("Step four: Select accessories. \n"
                + "1. Jeweled Pins \n"
                + "2. Wispy Feathers \n"
                + "3. Fabric Butterfly \n"
                + "4. Exit if no more selection.");
            choice1 = scan.nextInt();
            if(choice1==1 || choice1==2 || choice1==3 || choice1==4){
                customList.add(choice1);
                valid = true;
            }else{
                System.out.println("Please enter choices given.");
            }
            }while(valid != true);
        }
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
        System.out.print("Congratulations " + currentCust.name +
                ", your Custom Floral Arrangement has been saved. \n"
                        + "Your custom flower arrangement are as following: \n");
        
        Stack<Integer> show = currentCust.customList;
        
        if(show.firstElement() == 1){
            System.out.println("Your flower arrangement style choice is Traditional.");
            show.remove(0);
            customList.add(1);
        }else if(show.firstElement()== 2){
            System.out.println("Your flower arrangement style choice is Oriental.");
            show.remove(0);
            customList.add(2);
        }else{
            System.out.println("Your flower arrangement style choice is Modern.");
            show.remove(0);
            customList.add(3);
        }
        
        if(show.firstElement() == 1){
            System.out.println("Your flower arrangment size is Large.");
            show.remove(0);
            customList.add(1);
        }else if(show.firstElement()== 2){
            System.out.println("Your flower arrangment size is Medium.");
            show.remove(0);
            customList.add(2);
        }else{
            System.out.println("Your flower arrangment size is Small.");
            show.remove(0);
            customList.add(3);
        }
        
        for(int i=0;i<count1;i++){
            if(show.firstElement() == 1){
                System.out.println("Your flower is Jamine.");
                show.remove(0);
                customList.add(1);
            }else if(show.firstElement()== 2){
                System.out.println("Your flower is Lily.");
                show.remove(0);
                customList.add(2);
            }else if(show.firstElement()== 3){
                System.out.println("Your flower is Rose.");
                show.remove(0);
                customList.add(3);
            }else if(show.firstElement()== 4){
                show.remove(0);
            }
        }
        
        for(int i=0;i<count2;i++){
            if(show.firstElement() == 1){
                System.out.println("Your accessories is Jeweled Pins.");
                show.remove(0);
                customList.add(1);
            }else if(show.firstElement()== 2){
                System.out.println("Your accessories is Wispy Feathers.");
                show.remove(0);
                customList.add(2);
            }else if(show.firstElement()== 3){
                System.out.println("Your accessories is Fabric Butterfly.");
                show.remove(0);
                customList.add(3);
            }else if(show.firstElement()== 4){
                show.remove(0);
            }
        }
        
        if(show.firstElement() == 1){
            System.out.println("Your priority is Express.");
            show.remove(0);
            customList.add(1);
        }else if(show.firstElement()== 2){
            System.out.println("Your priority is Normal.");
            show.remove(0);
            customList.add(2);
        }else{
            System.out.println("Your priority is Flexible.");
            show.remove(0);
            customList.add(3);
        }
        
        //funct.additem(show.firstElement());
        
        LinkedList llist = new LinkedList();
        
        int cust1Priority = cust1.getCustomList().lastElement();
        llist.add(cust1.toString());
        int cust2Priority = cust2.getCustomList().lastElement();
        if(cust2Priority > cust1Priority){
            llist.add(cust2.toString());
        }
        
        int last = currentCust.getCustomList().lastElement();
//        for(int i=0;i>currentCust.getCustomList().size();i++){
//            last = currentCust.getCustomList().get(i);
//        }
        
        if(last < cust1Priority){
            llist.add(0, currentCust);
        }else if(last > cust1Priority && last < cust2Priority){
            llist.add(1, currentCust);
        }else{
            llist.add(2, currentCust);
        }
        
        System.out.println(llist);
        
    }
        
    
}
