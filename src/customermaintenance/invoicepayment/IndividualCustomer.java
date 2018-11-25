/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customermaintenance.invoicepayment;

/**
 *
 * @author User
 */
public class IndividualCustomer extends Person{
String custName;

    public IndividualCustomer(String custName, int custID, String custAdd, String custPhone, String custEmail, String custIdentity, int postCode, String state, String town) {
        super(custID, custAdd, custPhone, custEmail, custIdentity, postCode, state, town);
        this.custName = custName;
    }
   

    public String getCustName() {
        return custName;
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

    public void setCustName(String custName) {
        this.custName = custName;
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

    public IndividualCustomer() {
    }

    @Override
    public String toString() {
        return super.toString()+custName;
    }

    
    
}
