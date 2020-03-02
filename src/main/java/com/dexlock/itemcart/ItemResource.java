package com.dexlock.itemcart;

import io.dropwizard.jersey.PATCH;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Iterator;


@Path("/itemsList")
public class ItemResource {

    private ArrayList<Item> items = new ArrayList<Item>();
    private int flag = 0;

    private Item getItem(int itemId) {
        Item item = null;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item nextItem = iterator.next();
            if (nextItem.getId() == itemId) {
                item = nextItem;
                break;
            }
        }
        return item;
    }


    public ItemResource() {
    }

    @POST
    @Path("/add-item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public APIResponse addApi(Item newItem) {

        APIResponse api = new APIResponse();
        try {
            if (newItem.getItemName() == null) {
                newItem.setItemName(ItemAppConfig.getDefaultName());
            }
            items.add(newItem);
            api.setStatusCode(0);
            api.setMessage("Item Added");

        } catch (Exception ex) {
            api.setStatusCode(1);
            api.setMessage("Failed to add item");
        }
        return api;
    }

    @GET
    @Path("/list-items")
    @Produces(MediaType.APPLICATION_JSON)
    public ListAllItems listItems() {
        ListAllItems listObject = new ListAllItems();
        if (items.size() == 0) {
            listObject.setStatusCode(0);
            listObject.setMessage("Empty List");
        } else {
            try {
                listObject.setStatusCode(0);
                listObject.setMessage("Listing All items");
                listObject.setObject(items);
            } catch (Exception ex) {
                listObject.setStatusCode(1);
                listObject.setMessage("Failed to list objects");
            }
        }
        return listObject;
    }

    @DELETE
    @Path("/remove-item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public APIResponse removeItem(@QueryParam("itemId") int itemId) {

        APIResponse api = new APIResponse();
        Item lostItem = getItem(itemId);

        if (!items.contains(lostItem)) {
            api.setStatusCode(1);
            api.setMessage("Not Found");
        } else {
            try {
                items.remove(lostItem);
                api.setStatusCode(0);
                api.setMessage("Item deleted");
            } catch (Exception ex) {
                api.setStatusCode(1);
                api.setMessage("Bad request");
            }
        }
        return api;
    }

    @PATCH
    @Path("/update-item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public APIResponse update(UpdateItemCart updateObject) {

        APIResponse api = new APIResponse();

        Item setItem = new Item();
        setItem.setId(updateObject.getId());

        if (!items.contains(setItem)) {
            api.setStatusCode(1);
            api.setMessage("Not Found");
        } else {
            try {
                if (updateObject.getCount() < 0) {
                    api.setStatusCode(1);
                    api.setMessage("Bad Request");
                } else {
                    setItem = getItem(updateObject.getId());
                    setItem.setCount(updateObject.getCount());
                    api.setStatusCode(0);
                    api.setMessage("Updated");

                }
            } catch (Exception ex) {
                api.setStatusCode(1);
                api.setMessage("Failed to update item");
            }
        }
        return api;
    }
}