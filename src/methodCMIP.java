/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class methodCMIP implements customermaintenanceInvoiceInterface{
    public static FLORALMAIN cust = new FLORALMAIN();
     public  void addCustomer()
    {
        
        
         Scanner input= new Scanner(System.in);
         CorporateCustomer cc =new CorporateCustomer();
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
                cc.setCustID(cust.ccList.size()+1);
                if(cust.ccList.size()<10){
                    System.out.println("CC00"+cc.getCustID());
                }
                else if(cust.ccList.size()>=10 && cust.ccList.size()<=99){
                    System.out.println("CC0"+cc.getCustID());
                }
            
                System.out.print("Company Name:");
                String  cName=input.next();
                cc.setCompanyName(cName);

                System.out.print("Customer Address:");
                String add=input.next();
                cc.setCustAdd(add);
                
                System.out.print("postCode:");
                int pc=input.nextInt();
                cc.setPostCode(pc);
                
                System.out.print("State:");
                String state=input.next();
                cc.setState(state);
                
                System.out.print("Town:");
                String town=input.next();
                cc.setTown(town);

                System.out.print("Customer PhoneNum:");
                String phoneNo=input.next();
                cc.setCustPhone(phoneNo);

                System.out.print("Customer Email:");
                String email=input.next();
                cc.setCustEmail(email);

                cust.ccList.add(cc);
                
                System.out.println("****************Registered successful*************");
               
                 System.out.println("=============Cooporate Customer================================");
                 System.out.printf(" custID "+"\t"+"custCompany"+"\t"+ "custAddress "+"\t"+"Post Code"+"\t"+"State  "+"\t\t"+"Town Area"+"\t"+" custPhone"+"\t"+"custEmail "+"\t"+"custIdentity"+"\t"+"Creditlimit");
                 System.out.printf("\n "+"CC00"+"%d %15s %15s %15d %15s %15s %15s %15s %15s"+"\t\t" +"RM"+"%3.2f \n",cc.getCustID(),cc.getCompanyName(),cc.getCustAdd(),cc.getPostCode(),cc.getState(),cc.getTown(),cc.getCustPhone(),cc.getCustEmail(),cc.getCustIdentity(),cc.getCreditLimit());
               
                a = true;
            }
            else if(identity==2){
                ic.setCustIdentity("IC");
                System.out.print("Customer ID:");
                ic.setCustID(cust.icList.size()+1); 
                if(cust.icList.size()<10){
                    System.out.println("IC00"+ic.getCustID());
                }
                else if(cust.icList.size()>=10 && cust.icList.size()<=99){
                    System.out.println("IC0"+cc.getCustID());
                }

                System.out.print("Customer Name:");
                String  name=input.next();
                ic.setCustName(name);

                System.out.print("Customer Address:");
                String add=input.next();
                ic.setCustAdd(add);

                System.out.print("postCode:");
                int pc=input.nextInt();
                ic.setPostCode(pc);
                
                System.out.print("State:");
                String state=input.next();
                ic.setState(state);
                
                System.out.print("Town:");
                String town=input.next();
                ic.setTown(town);
                
                System.out.print("Customer PhoneNum:");
                String phoneNo=input.next();
                ic.setCustPhone(phoneNo);

                System.out.print("Customer Email:");
                String email=input.next();
                ic.setCustEmail(email);
                
                cust.icList.add(ic);
                
                 System.out.println("****************Registered successful*************");
                 System.out.println("=============Individual Customer================================");
                 System.out.printf(" custID "+"\t"+"custName"+"\t"+ "custAddress "+"\t"+"Post Code"+"\t"+"State "+"\t"+"Town Area"+"\t"+"Cust Phone"+"\t"+"custEmail "+"\t"+"custIdentity");
                 System.out.printf("\n "+"IC00"+"%d %15s %15s %10d %15s %15s %15s %15s %15s\n",ic.getCustID(),ic.getCustName(),ic.getCustAdd(),ic.getPostCode(),ic.getState(),ic.getTown(),ic.getCustPhone(),ic.getCustEmail(),ic.getCustIdentity());
                 a = true;
            }   
        }while(a!=true);
    } 
    public int menu()
    {
        Scanner menu=new Scanner(System.in);
        int select;
        boolean a = false;
        do{
            System.out.println("*********Menu***************");
            System.out.println("1.RegisterCustomer:");
            System.out.println("2.ViewCustomer:");
            System.out.println("3.ViewInvoicePayment:");
            System.out.println("4.GenerateMonthlyInvoicePayment:");
            System.out.println("5.setMonthlyCredit");
            System.out.println("6. Exit to Main Menu:");
            System.out.println("*****************************");
            
            System.out.print("Please select ur option:");
            select = menu.nextInt();
            
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
              int respond;  
                do{
                System.out.print("Do you want back to menu?(1=yes):");
                respond = menu.nextInt();
                    if(respond== 1)
                    {
                        menu();
                    }
                    a = true;
                }while(respond ==1);
            }
            
            else if(select==3)
            {
                viewInvoice();          
                int respond;
                do{
                System.out.print("Do you want to continue view customer Invouice?(1=yes/2=no):");
                respond = menu.nextInt();
                    if(respond== 1)
                    {
                        viewInvoice();
                    }

                    else if(respond==2)
                    {
                        menu();
                    }
                    a = true;
                }while(respond ==1);
            }
            
            else if(select ==4)
            {
                generateMonthlyInvoice();
                int respond;  
                do{
                System.out.print("Do you want back to menu?(1=yes):");
                respond = menu.nextInt();
                    if(respond== 1)
                    {
                        menu();
                    }
                    a = true;
                }while(respond ==1);
            }
                
                 else if(select ==5)
            {
                setMonthlyCredit();
                int respond;  
                do{
                System.out.print("Do you want back to menu?(1=yes):");
                respond = menu.nextInt();
                    if(respond== 1)
                    {
                        menu();
                    }
                    a = true;
                }while(respond ==1);
               
            }
                 else if(select == 6){
                a = true;
                int b = select;
            }
        return select;
            
        }while(a!=true);
        
    }
    public void viewCustomer()
    {
        System.out.println("-------------------------------------------------------CORPORATE CUSTOMER---------------------------------------------------------------------------------------");
        System.out.printf(" custID "+"\t"+"custCompany"+"\t"+ "customer Address "+"\t"+"Post Code"+"\t"+"State \t"+"\t"+"Town Area"+"\t"+" cust PhoneNo"+"\t"+"customerEmail "+"\t"+"custIdentity"+"\t"+"Creditlimit(RM)");
        
        for(int i=0;i<cust.ccList.size();i++)
        {
            System.out.printf("\n "+(i+1)+"."+"CC00"+"%d %15s %20s %18d %13s %15s %20s %15s %10s"+"\t\t" +"RM"+"%3.2f ",cust.ccList.get(i).getCustID(),cust.ccList.get(i).getCompanyName(),cust.ccList.get(i).getCustAdd(),cust.ccList.get(i).getPostCode(),cust.ccList.get(i).getState(),cust.ccList.get(i).getTown(),cust.ccList.get(i).getCustPhone(),cust.ccList.get(i).getCustEmail(),cust.ccList.get(i).getCustIdentity(),cust.ccList.get(i).getCreditLimit());
        }
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
        
        System.out.println("----------------------------------------------------------INDIVIDUAL CUSTOMER---------------------------------------------------------------------------------------");
        System.out.printf(" custID "+"\t"+"custName"+"\t"+ "custAddress "+"\t"+"postCode"+"\t"+"State"+"\t"+"Town"+"\t"+" custPhone"+"\t"+"custEmail "+"\t"+"custIdentity");

          for(int i=0;i<cust.icList.size();i++)
        {
            System.out.printf("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("IC00"+"%d %15s %15s %10d %15s %15s %15s %15s %15s\n",cust.icList.get(i).getCustID(),cust.icList.get(i).getCustName(),cust.icList.get(i).getCustAdd(),cust.icList.get(i).getPostCode(),cust.icList.get(i).getState(),cust.icList.get(i).getTown(),cust.icList.get(i).getCustPhone(),cust.icList.get(i).getCustEmail(),cust.icList.get(i).getCustIdentity());

        }
           System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
    }
     public void viewInvoice()
    { 
       
        boolean a = false;
        do{
       Scanner input= new Scanner(System.in);
       int select;
        System.out.println("-----------------------------------------------CORPORATE CUSTOMER------------------------------------------------------------------------------------------------------");
        System.out.printf(" custID "+"\t"+"custCompany"+"\t"+ "customer Address "+"\t"+"Post Code"+"\t"+"State \t"+"\t"+"Town Area"+"\t"+" cust PhoneNo"+"\t"+"customerEmail "+"\t"+"custIdentity"+"\t"+"Creditlimit(RM)");
        
        for(int i=0;i<cust.ccList.size();i++)
        {
           System.out.printf("\n "+(i+1)+"."+"CC00"+"%d %15s %20s %18d %13s %15s %20s %15s %10s"+"\t\t" +" RM"+"%5.2f ",cust.ccList.get(i).getCustID(),cust.ccList.get(i).getCompanyName(),cust.ccList.get(i).getCustAdd(),cust.ccList.get(i).getPostCode(),cust.ccList.get(i).getState(),cust.ccList.get(i).getTown(),cust.ccList.get(i).getCustPhone(),cust.ccList.get(i).getCustEmail(),cust.ccList.get(i).getCustIdentity(),cust.ccList.get(i).getCreditLimit());      
        }
         System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
         System.out.printf("Select number to view payment invoice:");
        select=input.nextInt();
        System.out.printf("\n=============================================INVOICE==============================================\n");
        System.out.printf("Invoice ID : I00%d \n",select);
        System.out.print("");
        CorporateCustomer currentCust = new CorporateCustomer();
        for(int i=0;i<cust.ccList.size();i++)
        {
            if(select==cust.ccList.get(i).getCustID())
            {
             currentCust = cust.ccList.get(i);
            }
        }
        
          for(int j=0;j<cust.OrderList.size();j++)
               {
                   if(cust.OrderList.get(j).getCustID()==currentCust.getCustID())
               {
                   double remain =currentCust.getCreditLimit()-cust.OrderList.get(j).getSubtotal();
                   currentCust.remainLimit = remain;
                   System.out.printf("Company Name*"+"\t"+"Order Id*"+"\t"+"Customer Id*"+"\t"+"Credit Limit*" +"\t"+" CustomerDebt \t"+"RemainCreLimit\t"+"\n");
                   System.out.printf("%8s \t"+"O00"+"%-15d "+"CC00"+"%-10d  RM%4.2f \t RM%4.2f\t RM%4.2f \n",currentCust.getCompanyName(),cust.OrderList.get(j).getOrderID(),currentCust.getCustID(),currentCust.getCreditLimit(),cust.OrderList.get(j).getSubtotal(),currentCust.getRemainLimit());
                  // System.out.println(currentCust.getCompanyName() +"\t"+ OrderList.get(j).getOrderID() +"\t"+ currentCust.getCustID() +"\t"+ OrderList.get(j).getSubtotal());
                                 
                  System.out.println("---------------PURCHASE HISTORY----------------");
                  System.out.println("Items List* "+"\t" +"Quantity*");
                     
                  for(int i=0;i<cust.OrderList.get(j).getOrderedItems().size();i++)
                  {
                      System.out.print((i+1)+".  "+cust.OrderList.get(j).getOrderedItems().get(i).getName()+"\t");
                      System.out.println(cust.OrderList.get(j).getItemQuantity().get(i).intValue());
                  }
               }
                   
               }
                System.out.printf("=============================================INVOICE==============================================\n");
        a=true;
    }while(a!=true);
    }
     public void generateMonthlyInvoice()
    {
         boolean a = false;
        do{
        int countaa =0;
        Scanner input= new Scanner(System.in);
        System.out.print("Choose a month:");
        int month=input.nextInt();
        System.out.printf("=========================================MONTHLY INVOICE=================================\n\n");
       for(int i=0;i<cust.OrderList.size() ;i++)
       {    
        
           if(month==(cust.OrderList.get(i).getOrderDate().getMonthValue()))
           {
               countaa++;
                for(int j=0;j<cust.ccList.size();j++)
                 {
                     
                        if(cust.OrderList.get(i).getCustID()==cust.ccList.get(j).getCustID())
                        {
                           double remain =cust.ccList.get(j).getCreditLimit()-cust.OrderList.get(i).getSubtotal();
                            System.out.println("************************************************************************************************");
                            System.out.printf("Company Name*"+"\t"+"Order Id*"+"\t"+"Customer Id*"+"\t"+"Credit Limit*" +"\t"+" CustomerDebt \t"+"RemainCreLimit\t"+"\n");
                            System.out.printf("%8s \t"+"O00"+"%-15d "+"CC00"+"%-10d  RM%4.2f \t RM%4.2f\t RM%4.2f \n",cust.ccList.get(j).getCompanyName(),cust.OrderList.get(i).getOrderID(),cust.ccList.get(j).getCustID(),cust.ccList.get(j).getCreditLimit(),cust.OrderList.get(i).getSubtotal(),remain);
                  
                                 
                            System.out.printf("\n----Purchase History--\n");
                            System.out.println("Items List* "+"\t" +"Quantity*");
                           
                            for(int k=0;k<cust.OrderList.get(i).getOrderedItems().size();k++)
                            {
                                System.out.print((k+1)+".  "+cust.OrderList.get(i).getOrderedItems().get(k).getName()+"\t");
                                System.out.println(cust.OrderList.get(i).getItemQuantity().get(k).intValue());
                            }
                            System.out.println("************************************************************************************************\n\n");
                            }
                        }         
                 }
           

           }
           if(countaa<1){
               System.out.println("Sorry There is no invoice in selected month\n");
           }
       
        System.out.printf("=========================================MONTHLY INVOICE=================================\n\n");
        a=true;
    }while(a!=true);
    }
     public void setMonthlyCredit()
     {
         CorporateCustomer currentCust = new CorporateCustomer();
      //   double debt =currentCust.creditLimit -currentCust.remainLimit;
       //  currentCust.debt =debt;
         
         for(int i=0;i<cust.ccList.size();i++)
         {
             
             int ccID = cust.ccList.get(i).getCustID(); //get id from corporate customer
             for(int j=0; j<cust.paymentList.size(); j++){
                 
                 if(ccID == cust.paymentList.get(j).getCustId()){ //compare with paymentlist cust id
                     
                     currentCust = cust.ccList.get(i);
                     
                     for(int k =0; k<cust.orderList.size(); k++){ 
                         
                         if(currentCust.getCustID() == cust.orderList.get(k).getCustID()){ //compare order list cust id with current cust
                             
                      currentCust.debt = cust.orderList.get(k).getSubtotal();
                                
                         if(LocalDate.now().equals(LocalDate.of(2018, Month.JANUARY, 7)))
                         {
                              if(cust.paymentList.get(j).getUserPayAmount() == cust.ccList.get(i).getDebt()){
                                cust.ccList.get(i).setStatus("Finish-Paid");
                                System.out.println("************************************************************************************************");
                                System.out.printf("Company Name*"+"\t"+"\t"+"Customer Id*"+"\t"+"Credit Limit*" +"\t"+" CustomerDebt \t"+"CustomerPay\t"+"Status \t"+"\n");
                                System.out.printf("%8s \t"+"CC00"+"%-10d  RM%4.2f \t RM%.2f\t RM%.2f\t %30s \n",currentCust.getCompanyName(),currentCust.getCustID(),currentCust.getCreditLimit(),currentCust.getDebt() ,cust.paymentList.get(j).getUserPayAmount(),cust.ccList.get(i).getStatus());
                              }
                              else if(cust.paymentList.get(j).getUserPayAmount() != cust.ccList.get(i).getDebt())
                              {
                                cust.ccList.get(i).setStatus("Non-Finish-Paid");
                                System.out.println("************************************************************************************************");
                                System.out.printf("Company Name*"+"\t"+"\t"+"Customer Id*"+"\t"+"Credit Limit*" +"\t"+" CustomerDebt \t"+"CustomerPay\t"+"Status \t"+"\n");
                                System.out.printf("%8s \t"+"CC00"+"%-10d  RM%4.2f \t RM%.2f\t RM%.2f\t %30s \n",currentCust.getCompanyName(),currentCust.getCustID(),currentCust.getCreditLimit(),currentCust.getDebt(),cust.paymentList.get(j).getUserPayAmount(),cust.ccList.get(i).getStatus());
                              }
                              
                          }
                         else if(LocalDate.now().equals(LocalDate.of(2018, Month.JANUARY, 7))==false)
                         {
                             if(cust.paymentList.get(j).getUserPayAmount() == cust.ccList.get(i).getDebt()){
                                currentCust.setStatus("Debt is 0 but pending update");
                                System.out.println("************************************************************************************************");
                                System.out.printf("Company Name*"+"\t"+"\t"+"Customer Id*"+"\t"+"Credit Limit*" +"\t"+" CustomerDebt \t"+"CustomerPay\t"+"Status \t"+"\n");
                                System.out.printf("%8s \t"+"CC00"+"%-10d  RM%4.2f \t RM%.2f\t RM%.2f\t %30s \n",currentCust.getCompanyName(),currentCust.getCustID(),currentCust.getCreditLimit(),currentCust.getDebt(),cust.paymentList.get(j).getUserPayAmount(),currentCust.getStatus());
                              }
                              else if(cust.paymentList.get(j).getUserPayAmount() != cust.ccList.get(i).getDebt())
                              {
                                currentCust.setStatus("Pending payment");
                                System.out.println("************************************************************************************************");
                                System.out.printf("Company Name*"+"\t"+"\t"+"Customer Id*"+"\t"+"Credit Limit*" +"\t"+" CustomerDebt \t"+"CustomerPay\t"+"Status \t"+"\n");
                                System.out.printf("%8s \t"+"CC00"+"%-10d  RM%4.2f \t RM%.2f\t RM%.2f\t %30s \n",currentCust.getCompanyName(),currentCust.getCustID(),currentCust.getCreditLimit(),currentCust.getDebt(),cust.paymentList.get(j).getUserPayAmount(),currentCust.getStatus());
                              }
                         }
                      
                         } 
                         else
                         {
                             
                         }
                 }
             }
         }
             }}}
     

     