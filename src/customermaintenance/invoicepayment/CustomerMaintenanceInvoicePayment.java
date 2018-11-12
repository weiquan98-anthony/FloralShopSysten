/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customermaintenance.invoicepayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CustomerMaintenanceInvoicePayment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         menu();
         
        
    }
    static void addCustomer()
    {
         Scanner input= new Scanner(System.in);
         CorporateCustomer cc=new CorporateCustomer();
         IndividualCustomer ic=new IndividualCustomer();
         List<CorporateCustomer> ccList=new ArrayList<>();
         List<IndividualCustomer> icList=new ArrayList<>();
//         for(int i=0; i<11; i++){
//             cc = new CorporateCustomer(100,ccList.size()+1 , "asd", "asd", "asd", "asd", "asd");
//             ccList.add(cc);
//         }
         CorporateCustomer cc0 = new CorporateCustomer(123,"blablabla", 0,"blablabla", "blablabla", "blablabla", "blablabla", "blablabla");
         ccList.add(cc0);
         
        System.out.println("****************Register Customer*************");
        
        System.out.print("Customer Identity( CC /IC ):");
        String identity=input.nextLine();
        
        if(identity.equals("cc")|| identity.equals("CC"))
        {
            cc.setCustIdentity(identity);
            
            System.out.print("Credit Limit:");
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
            System.out.println("****************Thanks*************");
            
                    for(int i=0; i<ccList.size(); i++){
                        System.out.println(ccList.get(i).toString());
                    }
        }
            else if(identity.equals("ic")|| identity.equals("IC")){

                ic.setCustIdentity(identity);
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
                System.out.println("****************Thanks*************");
                 for(int i=0; i<icList.size(); i++){
                System.out.println(icList.get(i).toString());
                
            }
        
         
        
        }
    }
    
    static void menu()
    {
      System.out.println("*********Menu***************");
         System.out.println("1.RegisterCustomer:");
         System.out.println("2.ViewCustomer:");
         System.out.println("3.InvoicePayment:");
      System.out.println("*****************************");
      Scanner menu=new Scanner(System.in);
         System.out.print("Please select ur option:");
        int select=menu.nextInt();
        if(select==1)
        {
            addCustomer();
        }
        
         System.out.print("Do you wnt to continue add customer?(1=yes/2=no)");
         int respond = menu.nextInt();
         if(respond== 1)
         {
             addCustomer();
         }
                 
         else if(respond==2)
         {
             menu();
         }
    }
}
