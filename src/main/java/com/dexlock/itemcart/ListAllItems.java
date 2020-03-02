package com.dexlock.itemcart;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListAllItems {

    private int statusCode;
    private String message;

    private ArrayList<Item> object;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Item> getObject() {
        return object;
    }

    public void setObject(ArrayList<Item> object) {
        this.object = object;
    }




}
