/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public class Person {
    int custID;
    
    String custAdd;
    String custPhone;
    String custEmail;
    String custIdentity;
    int postCode;
    String state;
    String town;

    public Person(int custID, String custAdd, String custPhone, String custEmail, String custIdentity,int postCode, String state,String town) {
        this.custID = custID;  
        this.custAdd = custAdd;
        this.custPhone = custPhone;
        this.custEmail = custEmail;
        this.custIdentity = custIdentity;
        this.postCode=postCode;
        this.state=state;
        this.town=town;
    }

  

    Person() {
      
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

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustIdentity() {
        return custIdentity;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getState() {
        return state;
    }

    public String getTown() {
        return town;
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

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return  + custID +    custAdd + postCode + state + town + custPhone +custEmail + custIdentity;
    }
}
