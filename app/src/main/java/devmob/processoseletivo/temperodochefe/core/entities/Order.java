package devmob.processoseletivo.temperodochefe.core.entities;

import java.util.ArrayList;

public class Order {

    private int table;
    private int total;
    private int peopleAmount;
    private String hour;
    private ArrayList<ItemMenu> items;

    public Order(int table, int total, int peopleAmount, String hour, ArrayList<ItemMenu> items) {
        this.table = table;
        this.total = total;
        this.peopleAmount = peopleAmount;
        this.hour = hour;
        this.items = items;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public ArrayList<ItemMenu> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemMenu> items) {
        this.items = items;
    }
}
