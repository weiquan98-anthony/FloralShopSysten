
import java.time.LocalDate;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Promotion {
    private int id;
    private String title;
    private LocalDate startdaDate;
    private LocalDate endDate;
    private LinkedList<Item> promoItemList = new LinkedList<>();

    public Promotion(int id, String title, LocalDate startdaDate, LocalDate endDate, LinkedList<Item> promoItemList) {
        this.id = id;
        this.title = title;
        this.startdaDate = startdaDate;
        this.endDate = endDate;
        this.promoItemList = promoItemList;
    }

    public Promotion() {
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartdaDate() {
        return startdaDate;
    }

    public void setStartdaDate(LocalDate startdaDate) {
        this.startdaDate = startdaDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LinkedList<Item> getPromoItemList() {
        return promoItemList;
    }

    public void setPromoItemList(LinkedList<Item> promoItemList) {
        this.promoItemList = promoItemList;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", title=" + title + ", startdaDate=" + startdaDate + ", endDate=" + endDate + ", promoItemList=" + promoItemList + '}';
    }
}
