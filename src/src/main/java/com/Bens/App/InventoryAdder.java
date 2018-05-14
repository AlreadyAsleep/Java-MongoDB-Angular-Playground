  package com.Bens.App;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * This class adds items to our inventory catalog via a MongoDB connection
 *  It is a Singleton class so changes made to any instance of the class will be reflected
 *  in every other instance.
 */
public class InventoryAdder {

    private static InventoryAdder adder;   //a cached object for Singleton purposes
    private MongoClient client;     //how we're connected to the DB
    private DB db;                  //the database
    private DBCollection coll;      //the collection we're working on

    private InventoryAdder()
    {
        //FIXME - Change this to a proper connection string and remove try/catch
        client = null;
        try {
            client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        }
        catch(UnknownHostException e) {
            System.out.println("Using local mongodb connection");
        }
        db = client.getDB("BensAppDev");
        coll = db.getCollection("Inventory");

    }

    /**
     *
     * @return InventoryAdder - A Singleton instance for performance that adds objects to the DB
     * This method returns the cached instance of the inventory adder, this is done to
     * improve performance and prevent multiple database threads
     */
    public static synchronized InventoryAdder GetAdder()
    {
        if (adder == null)
        {
            adder = new InventoryAdder();
        }
        return adder;
    }

    /**
     *
     * @param item: InventoryItem - the item to be added to the DB
     * This method inserts an Inventory Item object into the database record
     * If the record already exists then we replace it with a new one
     */
    public void addInventoryObject(InventoryItem item)
    {
        DBObject obj = coll.findOne(item.getId());
        DBObject objToAdd = new BasicDBObject().append("_id", item.getId())
                .append("name", item.getName())
                .append("timeStamp", item.getTimeStamp())
                .append("description", item.getDescription());


        if (obj != null) {
            coll.update(obj, objToAdd);
        }
        else {
            coll.insert(objToAdd);
        }
    }


}
