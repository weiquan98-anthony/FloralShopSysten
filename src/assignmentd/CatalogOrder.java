package assignmentd;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CatalogOrder {
    
    
    private String OrderID;
    private String StaffID;
    private String CustID;
    private Timestamp orderTime;
    private LinkedList<Item> orderedItems = new LinkedList<>();
    private LinkedList<Integer> itemQuantity = new LinkedList<>();
    private String DeliveryMethod;
    private String paymentStatus;
    private double subtotal;

    public CatalogOrder(String OrderID, String StaffID, String CustID, Timestamp orderTime, LinkedList<Item> orderedItems, String DeliveryMethod,LinkedList<Integer> itemQuantity, String paymentStatus ){
        this.OrderID = OrderID;
        this.StaffID = StaffID;
        this.CustID = CustID;
        this.orderTime = orderTime;
        this.orderedItems = orderedItems;
        this.DeliveryMethod = DeliveryMethod;
        this.paymentStatus = paymentStatus;

    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public CatalogOrder() {
    }
    
    public void addItems(Item Items){
        this.orderedItems.add(Items);
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "CatalogOrder{" + "OrderID=" + OrderID + ", StaffID=" + StaffID + ", CustID=" + CustID + ", orderTime=" + orderTime + ", orderedItems=" + orderedItems + ", itemQuantity=" + itemQuantity + ", DeliveryMethod=" + DeliveryMethod + '}';
    }

    
}
