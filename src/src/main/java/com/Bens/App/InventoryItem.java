package com.Bens.App;

/**
 * This class represents an inventory item in our application
 *  It has four private members: id, name, timeStamp and description
 */
public class InventoryItem {

    private String id;          // an id to query for (will be "_id" on Mongo
    private String name;        // the name of the item
    private String timeStamp;   // the date and time the item was added
    private String description; // a short description of the item

    public InventoryItem(String id, String name, String timeStamp, String description) {
        this.id = id;
        this.name = name;
        this.timeStamp = timeStamp;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString()
    {
        return "{\n _id:" + id
                + ",\nname:" + name
                + ",\ntimeStamp:" + timeStamp
                + ",\ndescription:" + description
                + "\n}";
    }

}
