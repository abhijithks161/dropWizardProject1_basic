package com.dexlock.itemcart;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Item {

    private int id;
    private String itemName;
    private int count;
    private int price;
    public Item() {
    }


   @JsonProperty
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @JsonProperty
    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }

    @JsonProperty
    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return id == item.id;
    }
}

