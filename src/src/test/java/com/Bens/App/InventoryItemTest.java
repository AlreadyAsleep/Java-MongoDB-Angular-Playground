package com.Bens.App;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryItemTest {

    /**
     * Constructor test
     */
    @Test
    public void constructorTest() {
        InventoryItem item = new InventoryItem("test1", "test2", "test3", "test4");
    }

    /**
     * Getters tests
     */
    @Test
    public void getIDTest() {
        InventoryItem item = new InventoryItem("test1", "test2", "test3", "test4");
        assertEquals(item.getId(), "test1");
    }

    @Test
    public void getNameTest(){
        InventoryItem item = new InventoryItem("test1", "test2", "test3", "test4");
        assertEquals(item.getName(), "test2");
    }

    @Test
    public void getTimeStammpTest(){
        InventoryItem item = new InventoryItem("test1", "test2", "test3", "test4");
        assertEquals(item.getTimeStamp(), "test3");
    }

    @Test
    public void getDescriptionTest(){
        InventoryItem item = new InventoryItem("test1", "test2", "test3", "test4");
        assertEquals(item.getDescription(), "test4");
    }

    /**
     * String method test
     */
    @Test
    public void toStringTest(){
        InventoryItem item = new InventoryItem("test1", "test2", "test3", "test4");
        String expected = "{\n _id:test1,\nname:test2,\ntimeStamp:test3,\ndescription:test4\n}";
        String actual = item.toString();
        assertEquals(expected, actual);
    }


}
