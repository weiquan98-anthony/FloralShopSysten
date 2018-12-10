/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Alex
 */
public class CatalogMaintenance implements ItemInterface{
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;
    
    private ArrayList<Item> stockList = new ArrayList<>();
   
    public static FLORALMAIN cust = new FLORALMAIN();
    public void CatalogMaintain(){
        Scanner s = new Scanner(System.in);
        
        int option;
        int count = 0;
        int catalogmenucount = 0;
        int startcount=0;
        
//        for(int i =0; i<cust.itemsList.size(); i++){
//            if(cust.itemsList.get(i).getQuantity()<0){
//                stockList.add(cust.itemsList.get(i));
//            }
//        }
        System.out.println("*******NOTICE**********");
        System.out.println("Following items are out of stock!!");
        System.out.println("No.\t  Item\t\t\t" + "   Quantity");
        System.out.println("******************************************************");
        for(int j =0; j<cust.itemsList.size(); j++){
            if(cust.itemsList.get(j).getQuantity()<=0){
                System.out.printf("%d.%22s\t\t%-25d\n\n", startcount, cust.itemsList.get(j).getName(), cust.itemsList.get(j).getQuantity());
            }
            startcount++;
        }
        
        do{
            if(count>=1){
                System.out.println("Wrong number entered!Please enter again");
            }
            System.out.println("Menu: ");
            System.out.println("1.Catalogue Maintenance");
            System.out.println("2.Back to Main Menu");
            System.out.println("3.Exit");
            System.out.println("Please Enter your choice : ");
            option = s.nextInt();
            if(option == 1){
                do{
                    if(catalogmenucount>=1){
                        System.out.println("Wrong number entered!Please enter again");
                    }
                    System.out.println("1.View Catalogue");
                    System.out.println("2.Add Item");
                    System.out.println("3.Update Stock");
                    System.out.println("4.Delete Item");
                    System.out.println("5.Create Promotion");
                    System.out.println("6.View Promotion");
                    System.out.println("7.Exit");
                    System.out.println("Please Enter your choice : ");
                    option = s.nextInt();

                    if(option == 1){
                        showItemList();
                        a = true;
                    }else if(option == 2){
                        addItem();
                        a = true;
                    }else if(option == 3){
                        updateStock();
                        a = true;
                    }else if(option == 4){
                        deleteStock();
                        a = true;
                    }else if(option == 5){
                        promotion();
                        a = true;
                    }else if(option==6){
                        viewPromotion();
                        a = true;
                    }else if(option == 7){
                        System.exit(0);
                    }
                    catalogmenucount++;
                }while(a!=true);
                
            }else if(option == 2){
            }else if(option == 3){
                System.exit(0);
            }
            
            count++;
        }while(a!=true);
    }
    
    public void showList(){
        int No =0;
        System.out.println("No. Item\t\t\t" + "   Quantity");
        System.out.println("*********************************************");
            for(int i =0; i<cust.itemsList.size(); i++){
            if(!cust.itemsList.get(i).getName().equals(" ")){
                No++;
                
                System.out.printf("%-3d %-20s \t\t%-2d \n", No, cust.itemsList.get(i).getName(), cust.itemsList.get(i).getQuantity());
            }
        }
    }
    
    public void showItemList(){
        int count = 0;
        int No =0;
        System.out.println("No. Item\t\t\t" + "  Price\t\t    " + "Quantity\t\t" + "Category");
        System.out.println("***************************************************************************************");
        for(int i =0; i<cust.itemsList.size(); i++){
            if(!cust.itemsList.get(i).getName().equals(" ")){
                No++;
                System.out.printf("%-3d %-20s \t  RM%.2f %12d %25s \n\n", No, cust.itemsList.get(i).getName(), cust.itemsList.get(i).getPrice(), cust.itemsList.get(i).getQuantity(),cust.itemsList.get(i).getCategory());
            }
        }
        System.out.println("**************************************************************");
           
        do{ 
            if(count>=1){
                System.out.println("Wrong number entered!");
            }
            System.out.println("1.Return to Main Menu");
            System.out.println("2.Exit");
            System.out.println("Please choose an option e.g. 2 to exit");
            Scanner s = new Scanner(System.in);
            int c = s.nextInt(); 
        
            if(c==1){
                a = true;
                CatalogMaintain();
            }else if(c==2){
                System.exit(0);
            }
            count++;
        }while(a!=true);
    }
    
    
    public void addItem(){
        Item items = new Item();
        Scanner s = new Scanner(System.in);
        int count = 0;
        int tempId =0;
        int choice = 0;
        int categorychoice = 0;
        int catcount = 0;
        
        System.out.print("ID:");
        for(int i=0; i<cust.itemsList.size(); i++){
            if(cust.itemsList.get(i).getName().equals(" ")){
                tempId = cust.itemsList.get(i).getId();
                System.out.println(tempId);
                System.out.println("Enter new item name: ");
                cust.itemsList.get(i).setName(s.next());
                System.out.println("Enter price: ");
                cust.itemsList.get(i).setPrice(s.nextInt());
                System.out.println("Enter quantity:");
                cust.itemsList.get(i).setQuantity(s.nextInt());
                System.out.println("Choose category \n 1.Bouquet\n2.Flower Baskets\n3.Flower Stands:");
                
                do{
                    if(catcount>=1){
                        System.out.println("Wrong number entered!");
                    }
                    System.out.println("Choose category \n 1.Bouquet\n2.Flower Baskets\n3.Flower Stands:");
                    categorychoice = s.nextInt(); 
                    if(categorychoice== 1){
                        cust.itemsList.get(i).setCategory("Bouquet");
                        a = true;
                }else if(categorychoice== 2){
                    cust.itemsList.get(i).setCategory("Flower Baskets");
                    a = true;
                }else if(categorychoice== 3){
                    cust.itemsList.get(i).setCategory("Flower Stands");
                    a = true;
                }
                    catcount++;

                }while(a!=true);

                System.out.println("\n");
                b = true;
            }
        }

        if(b != true ){
            items.setId(cust.itemsList.size()+1);
            System.out.println(items.getId());
            System.out.println("Enter new item name: ");
            items.setName(s.next());
            System.out.println("Enter price: ");
            items.setPrice(s.nextInt());
            System.out.println("Enter quantity:");
            items.setQuantity(s.nextInt());
            do{
                    if(catcount>=1){
                        System.out.println("Wrong number entered!");
                    }
                    System.out.println("Choose category \n 1.Bouquet\n2.Flower Baskets\n3.Flower Stands:");
                    categorychoice = s.nextInt();
                    if(categorychoice== 1){
                    items.setCategory("Bouquet");
                    a= true;
                }else if(categorychoice== 2){
                    items.setCategory("Flower Baskets");
                    a=true;
                }else if(categorychoice== 3){
                    items.setCategory("Flower Stands");
                    a = true;
                }
                    catcount++;

                }while(a!=true);
            System.out.println("\n");
            cust.itemsList.add(items);
        }
        System.out.println("New item successfully added!\n");
        System.out.println("New list");
        
        showList();
        do{
            if(count>=1){
                System.out.println("Wrong number entered!");
            }
            System.out.println("1.Return to Main Menu");
            System.out.println("2.Exit");
            System.out.println("Please choose an option e.g. 2 to exit");
            choice = s.nextInt(); 
            if(choice==1){
                CatalogMaintain();
                a = true;
            }else if(choice==2){
                System.exit(0);
            }
            count++;
        }while(a!=true);
    }
    
    public void updateStock(){
        int choice =0;
        int count =0;
        showList();
        System.out.println("Select item by number to update stock: e.g. 1 for Roses. 0 return to main menu");
        Scanner b = new Scanner(System.in);
        choice = b.nextInt();
        boolean checking =false;
        for(int i=0; i<cust.itemsList.size(); i++){
            if(cust.itemsList.get(i).getId() == choice){
                System.out.println("Enter quantity");
                Scanner stock = new Scanner(System.in);
                int newQ = stock.nextInt();
                cust.itemsList.get(i).setQuantity(newQ);
                System.out.println("Stock have been updated!\n");
                checking = true;
                do{
                    if(count>=1){
                        System.out.println("Wrong number entered!");
                    }
                    System.out.println("1.Return to Main Menu");
                    System.out.println("2.Exit");
                    System.out.println("Please choose an option e.g. 2 to exit");
                    Scanner s = new Scanner(System.in);
                    choice = s.nextInt(); 
                    if(choice==1){
                        CatalogMaintain();
                        a = true;
                    }else if(choice==2){
                        System.exit(0);
                    }
                    count++;

                }while(a!=true);
                
            }else if(choice ==0){
                CatalogMaintain();
            }
        }
    }
    
    public void deleteStock(){
        int choice =0;
        int count =0;
        showList();
        System.out.println("Select item by number to delete stock: e.g. 1 for Roses. 0 return to main menu");
        Scanner b = new Scanner(System.in);
        choice = b.nextInt();
        boolean checking =false;
        for(int i=0; i<cust.itemsList.size(); i++){
            if(cust.itemsList.get(i).getId() == choice){
               cust.itemsList.get(i).setName(" ");
                cust.itemsList.get(i).setPrice(0);
                cust.itemsList.get(i).setQuantity(0);
                System.out.println("Item have been deleted!\n");
                checking = true;
                do{

                    if(count>=1){
                        System.out.println("Wrong number entered!");
                    }
                    System.out.println("1.Return to Main Menu");
                    System.out.println("2.Exit");
                    System.out.println("Please choose an option e.g. 2 to exit");
                    Scanner s = new Scanner(System.in);
                    choice = s.nextInt(); 
                    if(choice==1){
                        CatalogMaintain();
                        a = true;
                    }else if(choice==2){
                        System.exit(0);
                    }
                    count++;

                }while(a!=true);
                
            }else if(choice ==0){
                CatalogMaintain();
            }
    }
        if(checking!= true){
            do{
                System.out.println("Invalid item\n");
                System.out.println("1.Return to Main Menu");
                System.out.println("2.Exit");
                System.out.println("Please choose an option e.g. 2 to exit");
                Scanner s = new Scanner(System.in);
                choice = s.nextInt(); 
                if(choice==1){
                    CatalogMaintain();
                    a = true;
                }else if(choice==2){
                    System.exit(0);
                }
            }while(a != true);
        }
        
        
//                if(choice==1){
//                    System.out.println("Enter quantity");
//                    Scanner stock = new Scanner(System.in);
//                    int newQ = stock.nextInt();
//                    itemsList.get(0).setQuantity(newQ);
//                    showList();
//
//                }else if(choice==2){
//                    System.out.println("Enter quantity");
//                    itemsList.get(1).setQuantity(a.nextInt());
//                   showList();
//                }
    }
    
    public void promotion(){
        Promotion promo = new Promotion();
        Scanner s = new Scanner(System.in);
        String text = null;
        String text1 = null;
        int promocount = 0;
        
        System.out.print("ID:");

        promo.setId(cust.promoList.size()+1);
        System.out.println(promo.getId());
        System.out.println("Enter Promotion title: ");
        promo.setTitle(s.next());
        System.out.println("Enter start date e.g. 2018-12-10: ");
        text = s.next();
        promo.setStartdaDate(LocalDate.parse(text));
        System.out.println("Enter end date e.g. 2018-12-31: ");
        text1 = s.next();
        promo.setEndDate(LocalDate.parse(text1));
        cust.promoList.add(promo);
        
        System.out.println("New promotion successfully created!\n");
        
        do{
            if(promocount>=1){
                System.out.println("Wrong number entered!");
            }
            System.out.println("1.Return to Main Menu");
            System.out.println("2.Exit");
            System.out.println("Please choose an option e.g. 2 to exit");
            promocount = s.nextInt(); 
            if(promocount==1){
                CatalogMaintain();
                a = true;
            }else if(promocount==2){
                System.exit(0);
            }
            promocount++;
        }while(a!=true);
        
        
    }
    
    public void viewPromotion(){
        boolean d = false;
        Scanner vp = new Scanner(System.in);
        Item item = new Item();
        int num = 0;
        int viewcount = 0;
        int vpchoice = 0;
        int afterchoice = 0;
        
        
        System.out.println("No.\tPromotion");
        System.out.println("***************************************************************************************");
        for(int k =0; k<cust.promoList.size(); k++){
            num++;
            System.out.println(num + "\t" + cust.promoList.get(k).getTitle());
            for(int ab = 0; ab<cust.itemPromotionList.size(); ab++){
                System.out.println(cust.itemPromotionList.get(ab).getName());
            }
        }
        
        do{
            if(viewcount>=1){
                System.out.println("Wrong number entered!");
            }
            System.out.println("Choose promotion number to add items");
            viewcount = vp.nextInt();
            if(viewcount==1){
                
                a = true;
                showList();
                System.out.println("Select items to be added");
                vpchoice = vp.nextInt();
                do{
                    if(vpchoice == 1){
                        cust.itemPromotionList.add(cust.a());
                        c = true;
                        System.out.println("Item succesfully added into the promotion!");
                        while(d!= true){
                            System.out.println("1. Add again");
                            System.out.println("2. Return to main menu");
                            System.out.println("3. Exit");
                            afterchoice = vp.nextInt();
                            if(afterchoice == 1){
                                viewPromotion();
                                d = true;
                            }else if(afterchoice == 2){
                                CatalogMaintain();
                                d = true;
                            }else if(afterchoice == 3){
                                System.exit(0);
                            }
                        }
                    }else if(vpchoice == 2){
                        cust.itemPromotionList.add(cust.b());
                        c = true;
                        while(d!= true){
                            System.out.println("1. Add again");
                            System.out.println("2. Return to main menu");
                            System.out.println("3. Exit");
                            afterchoice = vp.nextInt();
                            if(afterchoice == 1){
                                viewPromotion();
                                d = true;
                            }else if(afterchoice == 2){
                                CatalogMaintain();
                                d = true;
                            }else if(afterchoice == 3){
                                System.exit(0);
                            }
                        }
                    }else if(vpchoice == 3){
                        cust.itemPromotionList.add(cust.c());
                        c = true;
                        while(d!= true){
                            System.out.println("1. Add again");
                            System.out.println("2. Return to main menu");
                            System.out.println("3. Exit");
                            afterchoice = vp.nextInt();
                            if(afterchoice == 1){
                                viewPromotion();
                                d = true;
                            }else if(afterchoice == 2){
                                CatalogMaintain();
                                d = true;
                            }else if(afterchoice == 3){
                                System.exit(0);
                            }
                        }
                    }else if(vpchoice == 4){
                        cust.itemPromotionList.add(cust.d());
                        c = true;
                        while(d!= true){
                            System.out.println("1. Add again");
                            System.out.println("2. Return to main menu");
                            System.out.println("3. Exit");
                            afterchoice = vp.nextInt();
                            if(afterchoice == 1){
                                viewPromotion();
                                d = true;
                            }else if(afterchoice == 2){
                                CatalogMaintain();
                                d = true;
                            }else if(afterchoice == 3){
                                System.exit(0);
                            }
                        }
                    }else if(vpchoice == 5){
                        cust.itemPromotionList.add(cust.e());
                        c = true;
                        while(d!= true){
                            System.out.println("1. Add again");
                            System.out.println("2. Return to main menu");
                            System.out.println("3. Exit");
                            afterchoice = vp.nextInt();
                            if(afterchoice == 1){
                                viewPromotion();
                                d = true;
                            }else if(afterchoice == 2){
                                CatalogMaintain();
                                d = true;
                            }else if(afterchoice == 3){
                                System.exit(0);
                            }
                        }
                    }
                }while(c!= true);
  
            viewcount++;
        }}while(a!=true);
    }
}
