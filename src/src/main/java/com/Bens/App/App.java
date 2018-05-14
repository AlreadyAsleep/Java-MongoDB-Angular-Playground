package com.Bens.App;


import java.util.*;
import java.time.*;
/**
 * This is the driver for our application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String id;
        String name;
        LocalDateTime time;
        String description;
        InventoryItem item;
        InventoryAdder adder = InventoryAdder.GetAdder();

        Scanner stdin = new Scanner(System.in);
        do
        {
            System.out.println("BensApp Inventory Controller v0.1");
            System.out.print("Enter item ID number: ");
            id = stdin.next();
            System.out.print("Enter item name: ");
            name = stdin.next();
            time = LocalDateTime.now();
            System.out.print("Enter item description: ");
            description = stdin.nextLine();
            item = new InventoryItem(id, name, time.toString(), description);
            System.out.println(item.toString());
            System.out.print("Add this item?(y/n) ");
            if(!stdin.next().toLowerCase().equals("y"));
                adder.addInventoryObject(item);
            System.out.print("Continue(y/n): ");
            if(!stdin.next().toLowerCase().equals("y"))
                break;
        }while(true);
        System.out.println("Goodbye!");
    }
}
