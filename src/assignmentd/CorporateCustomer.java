/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentd;

import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CorporateCustomer extends Person{
    double creditLimit;
    String companyName;
    Double debt;

    public CorporateCustomer(double creditLimit, String companyName, int custID, String custName, String custAdd, String custPhone, String custEmail, String custIdentity) {
        super(custID, custName, custAdd, custPhone, custEmail, custIdentity);
        this.creditLimit = creditLimit;
        this.companyName = companyName;
    }

    public CorporateCustomer(double creditLimit, String companyName) {
        this.creditLimit = creditLimit;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

   

    public CorporateCustomer(double creditLimit) {
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

    public String getCustName() {
        return custName;
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

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    @Override
    public String toString() {
        return super.toString() + ",CreditLimit = Rm"+creditLimit +",CompanyName = "+companyName;
    }
    
   
}
