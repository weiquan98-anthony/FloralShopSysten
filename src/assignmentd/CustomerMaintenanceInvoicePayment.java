/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CustomerMaintenanceInvoicePayment {
        public static List<CorporateCustomer> ccList=new ArrayList<>();
        public static  List<IndividualCustomer> icList=new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        
      menu();
         
        
    }
    
     public static void addCustomer()
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
    
    public static void menu()
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
                        menu();
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
