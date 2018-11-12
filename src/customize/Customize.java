/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customize;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Kai
 */
public class Customize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
            }
        }while(valid != true);
        
        currentCust.setCustomList(customList);
        System.out.println("Congratulations " + currentCust.name +
                ", your Custom Floral Arrangement has been saved.");
    }
    
}
