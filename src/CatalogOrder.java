

import com.sun.jmx.remote.util.OrderClassLoaders;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class CatalogOrder {
    
    private int OrderID;
    private int CustID;
    private LocalTime orderTime;
    private LocalDate orderDate;
    private LinkedList<Item> orderedItems = new LinkedList<>();
    private LinkedList<Integer> itemQuantity = new LinkedList<>();
    private String DeliveryMethod;
    private String orderStatus;
    private LocalDate deliveryDate;
    private String deliveryTime;
    private double subtotal;
    


   public CatalogOrder(){
      
   }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
   
   

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public CatalogOrder(int OrderID, int CustID, LocalTime orderTime, LocalDate orderDate, String DeliveryMethod, String orderStatus, LocalDate deliveryDate, String deliveryTime, LinkedList<Integer> itemQuantity, LinkedList<Item> orderedItems, double subtotal) {
        this.OrderID = OrderID;
        this.CustID = CustID;
        this.orderTime = orderTime;
        this.orderDate = orderDate;
        this.DeliveryMethod = DeliveryMethod;
        this.orderStatus = orderStatus;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.orderedItems = orderedItems;
        this.itemQuantity = itemQuantity;
        this.subtotal = subtotal;
    }

    
    public String getOrderListItem(){
        String temp = "";
        for(int i =0; i<orderedItems.size(); i++){
            if(i!=orderedItems.size()-1){
                temp += orderedItems.get(i).getName() + " , " ;
            }else{
                temp += orderedItems.get(i).getName() ;
            }
            
            
        }
        
        return temp;
    }
   

    public LinkedList<Integer> getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(LinkedList<Integer> itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public LinkedList<Item> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(LinkedList<Item> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public String getDeliveryMethod() {
        return DeliveryMethod;
    }

    public void setDeliveryMethod(String DeliveryMethod) {
        this.DeliveryMethod = DeliveryMethod;
    }

 
    
    public void addItems(Item Items){
        this.orderedItems.add(Items);
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }





    public int getCustID() {
        return CustID;
    }

    public void setCustID(int CustID) {
        this.CustID = CustID;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        String toStringreturn = "---------------------------------------------------\n"+
                "Order ID :"+ OrderID + "\n"+
                 "Customer ID :"+ CustID + "\n"+
              "OrderTime :"+ orderTime.toString() + "\n"+
              "Order Date :"+ orderDate.toString() + "\n"+
              "---------------------------------------------------------------";
              for(int i=0;i<orderedItems.size();i++){
                toStringreturn += "Ordered Item :"+ orderedItems.get(i).getName() + "\n"+
                 "Quantity :"+ itemQuantity.get(i).intValue() + "\n";
              }
           toStringreturn += "------------------------------------------------------------\n"+
                   "Delivery Method : "+ DeliveryMethod+"\n"+
                            "OrderStatus: "+ orderStatus+"\n"+
                            "Delivery Date : "+ deliveryDate.toString()+"\n";
           if(deliveryTime!=null){
           toStringreturn += "Delivery Time :"+deliveryTime+"\n";
           }
                           
                         toStringreturn+=  "Subtotal : "+ subtotal+"\n";
                                 
                return toStringreturn;                 
    }

   

  
    
}
