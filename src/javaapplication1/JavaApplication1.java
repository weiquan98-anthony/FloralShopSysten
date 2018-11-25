/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class JavaApplication1{
    
    public static List<Item> itemsList = new LinkedList<Item>(); 

    public static CatalogMaintenance catalogMaintenance = new CatalogMaintenance();

    public static void main(String[] args) {
        itemsList.add(new Item(1,"Sunset Roses", 75, 0, "Bouquet"));
        itemsList.add(new Item(2,"Great Eastern Daisies", 89, 0, "Bouquet")); 
        itemsList.add(new Item(3,"Beyond Purple", 88, 10, "Flower Baskets")); 
        itemsList.add(new Item(4,"Basket Daisy", 99, 8, "Flower Baskets")); 
        itemsList.add(new Item(5,"Premium Flower Stand", 95, 6, "Flower Stands")); 
        catalogMaintenance.CatalogMaintain();
    }
}