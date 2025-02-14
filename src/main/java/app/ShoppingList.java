package app;

import java.util.Scanner;

import utils.DynamicArrayList;

/**
 *
 * @author michelle Contributed By Cal Woods
 */
public class ShoppingList {
    public static void main(String[] args) {
        //Initialise Scanner to System.in(input)
        Scanner sc = new Scanner(System.in);


        //Print message
        System.out.println("Welcome to the ShoppingList app. You will be repeatedly asked to enter item names into the shopping list. When finished, you will be offered a menu with various options until you decide to exit this app.\nCreating a blank DynamicArrayList instance & printing it's contents");

        //Declare DynamicArrayList instance using the default blank constructor
        DynamicArrayList dynamicList = new DynamicArrayList();

        //Print blank lines
        System.out.println("\n");

        //print ask how many entries the user would like to make into dynamicList
        System.out.print("How many items would you like to add to the list? ");
        int times = sc.nextInt();

        //Clear sc buffer
        sc.nextLine();
        
        //Print message
        System.out.println("\nYou will now be repeatedly prompted the number of times you specified. On each request, type the name of an item to add to the list, all will be displayed at the end.");

        //Initialise for loop to iterate chosen number of times
        for (int i = 0; i < times; i++) {
            System.out.print("\nPlease type an item to add to shopping list: ");
        
            //Declare String to store response
            String response = sc.nextLine();

            //call 'add()' method to add response to dynamicList
            dynamicList.add(response);
        }

        //Display 'dynamicList'
        printDynamicArrayList(dynamicList);
        boolean menuLoop = true;

        
        while(menuLoop) {
            //Print menu options 'menu()'
            menu();

            System.out.print("Choose a number to select it's corresponding option: ");

            String option = sc.next();
    
            if(option.equals("0")) {
                menuLoop = false;
            }
        }
    }

    /**
     * Prints all elements in a given DynamicArrayList
     * @param list Given DynamicArrayList
     * @return void Nothing
     * 
     */
    private static void printDynamicArrayList(DynamicArrayList list) {
        //Print dynamicList using for loop
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    /**
     * Displays menu options until 0 is pressed
     * @param sc A Scanner object to use
     * @param loopCondition A boolean that controls loop
     */
    public static void menu() {
        System.out.println("0) Exit\n1) Add to DynamicArrayList\n2)Remove from DynamicArrayList\n3)Remove all occurrences of a value from DynamicArrayList\n");

    }
}
