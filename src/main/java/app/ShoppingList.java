package app;

import utils.DynamicArrayList;

/**
 *
 * @author michelle Contributed By Cal Woods
 */
public class ShoppingList {
    public static void main(String[] args) {
        //Print message
        System.out.println("Welcome to the ShoppingList app.\nCreating a blank DynamicArrayList instance & printing it's contents");

        //Declare DynamicArrayList instance using the default blank constructor
        DynamicArrayList dynamicList = new DynamicArrayList();

        //Print dynamicList
        System.out.println(dynamicList);
    }
}
