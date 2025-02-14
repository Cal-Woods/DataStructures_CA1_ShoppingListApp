/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author michelle
 */
public class DynamicArrayListRemoveTests {

    public DynamicArrayListRemoveTests() {
    }

  /**
     * Test of removeAll method to try and remove something not present.
     */
    @Test
    public void testRemoveAll_RemovingSomethingNotPresent() {
        System.out.println("Testing the removeAll method to remove something that doesn't appear");
        String text = "Entry Three";
        String [] data = {"Entry Zero", "Entry One", "Entry Two"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String s: data) {
            instance.add(s);
        }
        
        boolean expResult = false;
        boolean result = instance.removeAll(text);
        assertEquals(expResult, result);
        int expSize = data.length;
        assertEquals(expSize, instance.size());

        for(int i = 0; i < instance.size(); i++){
            assertEquals(data[i], instance.get(i));
        }
    }    
    
    /**
     * Test of removeAll method to remove one instance.
     */
    @Test
    public void testRemoveAll_RemovingOneInstance() {
        System.out.println("Testing the removeAll method to remove something that appears once");
        String text = "Entry One";
        String [] data = {"Entry Zero", "Entry One", "Entry Two", "Entry Three"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String s: data) {
            instance.add(s);
        }
        
        boolean expResult = true;
        boolean result = instance.removeAll(text);
        assertEquals(expResult, result);

        int expSize = data.length - 1;
        assertEquals(expSize, instance.size());

        String [] updatedData = {"Entry Zero", "Entry Two", "Entry Three"};
        for(int i = 0; i < instance.size(); i++){
            assertEquals(updatedData[i], instance.get(i));
        }
    }


    /**
     * Test of removeAll method, where supplied value is null.
     */
    @Test
    public void testRemoveAll_NullParameter() {
        System.out.println("Testing the removeAll method where null is supplied as a parameter");
        String text = null;
        String [] data = {"Entry Zero", "Entry One", "Entry Two", "Entry Three"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String s: data) {
            instance.add(s);
        }

        assertThrows(IllegalArgumentException.class, () -> {
            instance.removeAll(null);
        });

        int expSize = data.length;
        assertEquals(expSize, instance.size());

        for(int i = 0; i < instance.size(); i++){
            assertEquals(data[i], instance.get(i));
        }
    }

    /**
     * Test of removeAll method to remove multiple instances.
     */
    @Test
    public void testRemoveAll_RemovingMultipleInstances() {
        System.out.println("Testing the removeAll method to remove something that appears multiple instances");
        String text = "Entry Zero";
        String [] data = {"Entry Zero", "Entry One", "Entry Zero", "Entry Zero"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String s: data) {
            instance.add(s);
        }
        
        boolean expResult = true;
        boolean result = instance.removeAll(text);
        assertEquals(expResult, result);

        int expSize = data.length - 3;
        assertEquals(expSize, instance.size());

        String [] updatedData = {"Entry One"};
        for(int i = 0; i < instance.size(); i++){
            assertEquals(updatedData[i], instance.get(i));
        }
    }

    /**
     * Test of remove text method, where no instance appears.
     */
//     @Test
//     public void testRemoveText_NoInstancesPresent() {
//         System.out.println("Testing the remove text method where no matches are present");
//         String text = "gamma";
//         String [] data = {"alpha", "Entry Zero", "Entry One", "beta"};
//         DynamicArrayList instance = new DynamicArrayList();
//         for(String s: data) {
//             instance.add(s);
//         }

//         boolean expResult = false;
//         boolean result = instance.remove(text);
//         assertEquals(expResult, result);

//         int expSize = data.length;
//         assertEquals(expSize, instance.size());

//         for(int i = 0; i < instance.size(); i++){
//             assertEquals(data[i], instance.get(i));
//         }
//     }

//     /**
//      * Test of remove text method, where one instance occurs.
//      */
//     @Test
//     public void testRemoveText_OneInstanceInArray() {
//         System.out.println("Testing the remove text method, where one instance exists");
//         String text = "alpha";
//         String [] data = {"Entry Zero", "Entry One", "alpha", "beta"};
//         DynamicArrayList instance = new DynamicArrayList();
//         for(String s: data) {
//             instance.add(s);
//         }

//         boolean expResult = true;
//         boolean result = instance.remove(text);
//         assertEquals(expResult, result);

//         int expSize = data.length - 1;
//         assertEquals(expSize, instance.size());

//         String [] updatedData = {"Entry Zero", "Entry One", "beta"};
//         for(int i = 0; i < instance.size(); i++){
//             assertEquals(updatedData[i], instance.get(i));
//         }
//     }

//     /**
//      * Test of remove text method, where multiple instances occur.
//      */
//     @Test
//     public void testRemoveText_MultipleInstancesInArray() {
//         System.out.println("Testing the remove text method, where multiple instances exist");
//         String text = "alpha";
//         String [] data = {"Entry Zero", "Entry One", "beta", "alpha", "alpha", "alpha"};
//         DynamicArrayList instance = new DynamicArrayList();
//         for(String s: data) {
//             instance.add(s);
//         }

//         boolean expResult = true;
//         boolean result = instance.remove(text);
//         assertEquals(expResult, result);

//         int expSize = data.length - 1;
//         assertEquals(expSize, instance.size());

//         String [] updatedData = {"Entry Zero", "Entry One", "beta", "alpha", "alpha"};
//         for(int i = 0; i < instance.size(); i++){
//            assertEquals(updatedData[i], instance.get(i));
//         }
//     }

//     /**
//      * Test of remove text method, where multiple instances occur in different case.
//      */
//     @Test
//     public void testRemoveText_MultipleInstancesInArray_ConfirmingCaseSensitivity() {
//         System.out.println("Testing the remove text method, where multiple instances exist");
//         String text = "alpha";
//         String [] data = {"Entry Zero", "Entry One", "beta", "ALPHA", "alpha", "alpha"};
//         DynamicArrayList instance = new DynamicArrayList();
//         for(String s: data) {
//             instance.add(s);
//         }

//         boolean expResult = true;
//         boolean result = instance.remove(text);
//         assertEquals(expResult, result);

//         int expSize = data.length - 1;
//         assertEquals(expSize, instance.size());

//         String [] updatedData = {"Entry Zero", "Entry One", "beta", "ALPHA", "alpha"};
//         for(int i = 0; i < instance.size(); i++){
//             assertEquals(updatedData[i], instance.get(i));
//         }
//     }

//     /**
//      * Test of remove text method, where value to be deleted is null.
//      */
//     @Test
//     public void testRemoveText_NullValue() {
//         System.out.println("Testing the remove text method to remove something where value to be removed is " +
//                 "null");
//         DynamicArrayList instance = new DynamicArrayList();
//         instance.add("Entry Zero");
//         instance.add("Entry One");
//         instance.add("Entry Two");

//         assertThrows(IllegalArgumentException.class, () -> {
//             instance.remove(null);
//         });
//     }
}