/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentd;

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 *
 * @author admin
 */
public class Payment{
    private String paymentId;
    private String orderId;
    private String staffId;
    private String custId;
    private String paymentAmount;

    public Payment(String paymentId, String orderId, String staffId, String custId, String paymentAmount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.staffId = staffId;
        this.custId = custId;
        this.paymentAmount = paymentAmount;
    }
    
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

}
