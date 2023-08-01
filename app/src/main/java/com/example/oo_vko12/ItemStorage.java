package com.example.oo_vko12;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ItemStorage {

    private ArrayList<Item> items = new ArrayList<>();
    private static ItemStorage single_instance = null;

    public static synchronized ItemStorage getInstance() {
        //singleton
        if(single_instance == null)
            single_instance = new ItemStorage();
        return single_instance;
    }

    public void addItem(Item item) {
        //set timestamp
        item.updateTimestamp();

        //add item
        items.add(item);
    }
    public Item getItemByIndex(int index) {return items.get(index);}
    public void removeItemByIndex(int index) {items.remove(index);}
    public void removeItem(Item item) {items.remove(item);}
    public ArrayList<Item> getItems() {return this.items;}

}
