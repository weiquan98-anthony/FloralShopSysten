/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentd;

/**
 *
 * @author User
 */
public class Person {
    int custID;
    String custName;
    String custAdd;
    String custPhone;
    String custEmail;
    String custIdentity;

    public Person(int custID, String custName, String custAdd, String custPhone, String custEmail, String custIdentity) {
        this.custID = custID;
        this.custName = custName;
        this.custAdd = custAdd;
        this.custPhone = custPhone;
        this.custEmail = custEmail;
        this.custIdentity = custIdentity;
    }

  

    Person() {
      
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

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustIdentity() {
        return custIdentity;
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

    @Override
    public String toString() {
        return "custID=CC100" + custID + ", custName=" + custName + ", custAdd=" + custAdd + ", custPhone=" + custPhone + ", custEmail=" + custEmail + ", custIdentity=" + custIdentity;
    }
}
