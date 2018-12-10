/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Timestamp;
import java.util.LinkedList;

/**
 *
 * @author admin
 */
public class Payment{
    private Integer paymentId;
    private int orderId;
    private String staffId;
    private Integer custId;
    private double paymentAmount;
    private String paymentStatus;
    private LinkedList<Item> orderedItems = new LinkedList<>();
    private Timestamp pickupTimestamp;
    private double userPayAmount;

  
    public Payment(int paymentId, int orderId, Integer custId, double paymentAmount, String paymentStatus,LinkedList<Item> orderedItems, java.sql.Timestamp pickupTimestamp, double userPayAmount ) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.custId = custId;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.orderedItems = orderedItems;
        this.pickupTimestamp = pickupTimestamp;
        this.userPayAmount = userPayAmount;
    }

    public double getUserPayAmount() {
        return userPayAmount;
    }

    public void setUserPayAmount(double userPayAmount) {
        this.userPayAmount = userPayAmount;
    }
    
      public Timestamp getPickupTimestamp() {
        return pickupTimestamp;
    }

    public void setPickupTimestamp(Timestamp pickupTimestamp) {
        this.pickupTimestamp = pickupTimestamp;
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
    
     public LinkedList<Item> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(LinkedList<Item> orderedItems) {
        this.orderedItems = orderedItems;
    }
    
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
