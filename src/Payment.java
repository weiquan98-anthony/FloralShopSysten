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
    private String paymentId;
    private int orderId;
    private String staffId;
    private Integer custId;
    private double paymentAmount;
    private String paymentStatus;

    public Payment(String paymentId, int orderId, Integer custId, double paymentAmount, String paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.custId = custId;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
    }
    
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
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
