/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CorporateCustomer extends Person{
    double creditLimit;
    String companyName;
    double debt=0;
    String status;
    double remainLimit;
    double payment=0;

    public CorporateCustomer( int custID, String custAdd, String custPhone, String custEmail, String custIdentity, int postCode, String state, String town,double creditLimit, String companyName, String status,double remainLimit,double debt,double payment) {
        super(custID, custAdd, custPhone, custEmail, custIdentity, postCode, state, town);
        this.creditLimit = creditLimit;
        this.companyName = companyName;
        this.debt=debt;
        this.status = status;
        this.remainLimit=remainLimit;
        this.payment=payment;
    }


    public String getCompanyName() {
        return companyName;
    }

   

    public CorporateCustomer(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    
    CorporateCustomer() {
       
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public int getCustID() {
        return custID;
    }

   

    public String getCustAdd() {
        return custAdd;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public String getCustIdentity() {
        return custIdentity;
    }

    public double getDebt() {
        return debt;
    }

    public String getStatus() {
        return status;
    }

    public double getRemainLimit() {
        return remainLimit;
    }

    public double getPayment() {
        return payment;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setCustAdd(String custAdd) {
        this.custAdd = custAdd;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public void setCustIdentity(String custIdentity) {
        this.custIdentity = custIdentity;
    }
    private static final Logger LOG = Logger.getLogger(CorporateCustomer.class.getName());

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDebt(double subTotal) {
        this.debt =subTotal;
        
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double setRemainLimit(double remainLimit) {
        this.remainLimit = remainLimit;
        remainLimit=creditLimit-debt;
        return remainLimit;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
    

    @Override
    public String toString() {
        return super.toString() +"\t" +"\t" +"RM"+creditLimit +"\t" +"\t" +companyName+"\t" +"\t"+debt+"\t" +"\t"+ remainLimit+status+payment;
    }
    
   
}
