
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
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
public class FLORALMAIN {

    /**
     * @param args the command line arguments
     */
    //Jason
    public static List<CorporateCustomer> ccList = new ArrayList<>();
    public static List<IndividualCustomer> icList = new ArrayList<>();
    
    //TF
    public static LinkedList<CatalogOrder> OrderList = new LinkedList<>();
    public static LinkedList<Item> categoryList = new LinkedList<>();
    public static LinkedList<Item> orderedItems1 = new LinkedList<>();
    public static LinkedList<Integer> quantityItem = new LinkedList<>();
    
    //Alex
    public static LinkedList<Item> itemsList = new LinkedList<Item>(); 
    public static LinkedList<Item> itemPromotionList = new LinkedList<>();
    public static LinkedList<Promotion> promoList = new LinkedList<>();
    
    
    //WQ
    public static LinkedList<Item> orderedItems = new LinkedList<>();
    public static LinkedList<IndividualCustomer> iCustomer = new LinkedList<>();
    public static LinkedList<CatalogOrder> orderList = new LinkedList<>();
     public static LinkedList<CatalogOrder> iCustomerOrder = new LinkedList<>();
     public static LinkedList<Payment> paymentList = new LinkedList<>();
    //  public  static LinkedList<Payment> tempList = new LinkedList<>();

    public static Scanner sc = new Scanner(System.in);
    
    //Methods calling
    public static CatalogMaintenance catalogMaintenance = new CatalogMaintenance();
    public static methodCMIP customerMaintenance=new methodCMIP();
    public static Runorder runord = new Runorder();
    public static Customize customize = new Customize();
    public static AssignmentD assd = new AssignmentD();
    
    public static Item item1 = new Item(1,"Sunset Roses", 75, 20, "Bouquet");
    public static Item item2 = new Item(2,"Great Eastern Daisies", 89, 0, "Bouquet");
    public static Item item3 = new Item(3,"Beyond Purple", 88, 10, "Flower Baskets");
    public static Item item4 = new Item(4,"Basket Daisy", 99, 8, "Flower Baskets");
    public static Item item5 = new Item(5,"Premium Flower Stand", 95, 6, "Flower Stands");
    public static void main(String[] args) {
        //Items hardcoded data
            

        
        
            
        //Order hardcoded data

        CatalogOrder hardCoded = new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, 12, 6), "1", quantityItem, orderedItems1, 50.0);
        CatalogOrder hardCoded2 = new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, 12, 6), "1", quantityItem, orderedItems1, 50.0);
        CatalogOrder hardCoded3 = new CatalogOrder(3, 3,  LocalTime.now(), LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, 12, 6), "1", quantityItem, orderedItems1, 50.0);

        
        
        //Promotion hardcoded data
        Promotion promotion1 = new Promotion(1, "Year End Sales", LocalDate.of(2018, 12, 1), LocalDate.of(2018, 12, 31), itemPromotionList);
        
        //Jason hardcoded
        ccList.add(new CorporateCustomer(6, "Jalan Sg2", "0123456788", "j@bhd.com","cc", 55300, "Setapak", "KL", 888, "J.BHD", "",0, 0, 0));
        ccList.add(new CorporateCustomer(7, "Jalan Sg3", "0123456788", "A@bhd.com","cc", 55300, "Setapak", "KL", 666, "A.BHD", "",0, 0, 0));
        ccList.add(new CorporateCustomer(5, "Jalan Sg4", "0123456788", "B@bhd.com", "cc", 55300, "Setapak", "KL", 999, "B.BHD", "", 0, 0, 0));
        

        
         //WQ hardcoded
        orderedItems.add(item1);
        orderedItems.add(item2);
        orderedItems.add(item3);
        orderedItems.add(item4);
        orderedItems.add(item5);
       
        
        quantityItem.add(4);
        
        orderList.add(new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Paid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
        orderList.add(new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
         orderList.add(new CatalogOrder(3, 3,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
         orderList.add(new CatalogOrder(4, 4,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
         orderList.add(new CatalogOrder(5, 5,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
         orderList.add(new CatalogOrder(6, 6,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 889.0));
         orderList.add(new CatalogOrder(7, 7,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 777.0));
         
        
         iCustomerOrder.add(new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
        iCustomerOrder.add(new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Cash on Delivery", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
         iCustomerOrder.add(new CatalogOrder(3, 3,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
         iCustomerOrder.add(new CatalogOrder(4, 4,  LocalTime.now(),LocalDate.now(), "Cash on Delivery", "Unpaid", LocalDate.of(2018, Month.DECEMBER, 10), "1", quantityItem, orderedItems, 50.0));
         iCustomer.add(new IndividualCustomer("Jason", 1, "99, Lorong abc", "012345678", "abc@gmail.com", "Individual", 43300,"Kuala Lumpur", "Cheras"));
        iCustomer.add(new IndividualCustomer("Tf", 2, "99, Lorong abcdef", "012345678", "abcdef@gmail.com", "Individual", 43300,"Kuala Lumpur", "Cheras"));
        iCustomer.add(new IndividualCustomer("Hazard", 4, "77, Lorong Aman", "012345678", "hazard@gmail.com", "Individual", 43300,"Kuala Lumpur", "Cheras"));
        
        
        
       //Alex hardcoded
        itemsList.add(item1);
        itemsList.add(item2); 
        itemsList.add(item3); 
        itemsList.add(item4); 
        itemsList.add(item5); 
        promoList.add(promotion1);
        
        //TF hardcoded
        quantityItem.add(4);
        categoryList.add(item1);
        categoryList.add(item2); 
        categoryList.add(item3); 
        categoryList.add(item4); 
        categoryList.add(item5);
        orderedItems1.add(item1);
        
        OrderList.add(hardCoded);
        OrderList.add(hardCoded2);
        OrderList.add(hardCoded3);
        
       
        
        //CatalogMaintenance catalogMaintenance = new CatalogMaintenance();
        int select = 0;
        int userEnter = 0;
       do{
            
            System.out.println("Floral shop system");
            System.out.println("1. Customer Maintenance");
            System.out.println("2. Catalog Maintenance");
            System.out.println("3. Order");
            System.out.println("4. Customise Floral");
            System.out.println("5. Pick-up/Delivery and Payment Management");
            System.out.println("6. Exit");
            
           userEnter  = sc.nextInt();
            if( userEnter == 1){
//                 select = customerMaintenance.menu();
                 customerMaintenance.menu();
            }else if(userEnter == 2){
                catalogMaintenance.CatalogMaintain();
                
            }else if(userEnter == 3){
                runord.Order();
                
            }
            else if(userEnter == 4){
                customize.CustomizeFloral();
             
            }else if(userEnter == 5){
                assd.assignmentd();
            }else if(userEnter == 6){
                System.exit(0);
            }

       }while(userEnter==1||userEnter==2||userEnter==3||userEnter==4||userEnter==5);
    }
    public Item a(){
        return item1;
    }
    public Item b(){
        return item2;
    }
    public Item c(){
        return item3;
    }
    public Item d(){
        return item4;
    }
    public Item e(){
        return item5;
    }
}
