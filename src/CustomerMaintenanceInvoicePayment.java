/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class CustomerMaintenanceInvoicePayment {
//         public static List<CorporateCustomer> ccList=new ArrayList<>();
//         public static List<IndividualCustomer> icList=new ArrayList<>();
         public static LinkedList<CatalogOrder> OrderList = new LinkedList<>();
         public static List<Item> itemsList = new LinkedList<>(); 
         public static LinkedList<Item> orderedItems1 = new LinkedList<>();
         public static LinkedList<Integer> quantityItem = new LinkedList<>();
   
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timestamp time = new Timestamp(Calendar.getInstance().getTime().getTime());
        Item items1 = new Item(1,"Sunset Roses", 75, 2, "Bouquet");
        Item items2 = new Item(2,"Great Eastern Daisies", 89, 3, "Bouquet"); 
     
        itemsList.add(items1);
        itemsList.add(items2); 
      
        quantityItem.add(1);
        orderedItems1.add(items2);
//        ccList.add(new CorporateCustomer(1, "Jalan Sg2", "0123456788", "j@bhd.com","cc", 55300, "Setapak", "KL", 888, "J.BHD", "a",0, 0, 0));
//        ccList.add(new CorporateCustomer(2, "Jalan Sg3", "0123456788", "A@bhd.com","cc", 55300, "Setapak", "KL", 666, "A.BHD", "a",0, 0, 0));
        CatalogOrder hardCoded = new CatalogOrder(1, 1,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, 12, 2), "1", quantityItem, orderedItems1, 50.0);
        CatalogOrder hardCoded2 = new CatalogOrder(2, 2,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, 12, 2), "1", quantityItem, orderedItems1, 50.0);
        CatalogOrder hardCoded3 = new CatalogOrder(3, 3,  LocalTime.now(),LocalDate.now(), "Pick-Up", "Unpaid", LocalDate.of(2018, 12, 2), "1", quantityItem, orderedItems1, 50.0);
      
        OrderList.add(hardCoded);
        OrderList.add(hardCoded2);
        OrderList.add(hardCoded3);
        methodCMIP customerMaintenance=new methodCMIP();
        customerMaintenance.menu();
    }
     
    
}
