/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customize;

import java.util.Stack;

/**
 *
 * @author Kai
 */
public class Customer {
    String name;
    Stack<Integer> customList = new Stack<>();

    public Customer() {
    }

    public Customer(String name, Stack<Integer> Clist) {
        this.customList = Clist;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stack<Integer> getCustomList() {
        return customList;
    }

    public void setCustomList(Stack<Integer> customList) {
        this.customList = customList;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", customList=" + customList + '}';
    }
    
    
}
