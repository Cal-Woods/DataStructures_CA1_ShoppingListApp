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
public class DynamicArrayListAddTests {

    public DynamicArrayListAddTests() {
    }

    /**
     * Test of add method at valid position.
     */
    /*@Test
    public void testAddAtPos_ValidPosition() {
        System.out.println("Testing adding a String to a valid position within a list.");
        String [] data = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        String newValue = "Blue";
        int pos = 4;
        instance.add(newValue, pos);
        String [] expListContents = {"Yellow", "Leather", "Yellow", "Leather", "Blue", "Red", "Balloon"};
        for(int i = pos; i < instance.size(); i++){
            String expResult = expListContents[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }*/

    /**
     * Test of add method at valid position.
     */
    /*@Test
    public void testAddAtPos_ValidPosition_SizeOfList() {
        System.out.println("Testing adding a String to a valid position within a list (The slot after the end of the " +
                "list)" +
                ".");
        String [] data = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        String newValue = "Blue";
        int pos = 6;
        instance.add(newValue, pos);
        String [] expListContents = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon", "Blue"};
        for(int i = pos; i < instance.size(); i++){
            String expResult = expListContents[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }*/

    /**
     * Test of add method at valid position (where list is empty).
     */
    /*@Test
    public void testAddAtPos_ValidPosition_SizeOfList_EmptyList() {
        System.out.println("Testing adding a String to a valid position within a list (where the list is empty)" +
                ".");
        String [] data = {};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        String newValue = "Blue";
        int pos = 0;
        instance.add(newValue, pos);
        String [] expListContents = {"Blue"};
        for(int i = pos; i < instance.size(); i++){
            String expResult = expListContents[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }*/

    /**
     * Test of add method at invalid position (negative number).
     */
    /*@Test
    public void testAddAtPos_InvalidPosition_Negative() {
        System.out.println("Testing adding a String to an invalid position within a list (negative number).");
        String [] data = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.add("Blue", -1);
        });
    }*/

    /**
     * Test of add method at invalid position (longer than length of list).
     */
    /*@Test
    public void testAddAtPos_InvalidPosition_TooBig() {
        System.out.println("Testing adding a String to an invalid position within a list (number is greater than the " +
                "length of the list)" +
                ".");
        String [] data = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.add("Blue", 7);
        });
    }*/

    /**
     * Test of addAll method with empty list, where it does not need to grow.
     */
    @Test
    public void testAddAll_NeedsToGrow_EmptyList() {
        System.out.println("Testing adding all elements of an array where the list is empty and needs to grow");
        String [] data = new String[15];
        for(int i = 0; i < data.length; i++){
            data[i] = "Item " + i;
        }

        DynamicArrayList instance = new DynamicArrayList();
        instance.addAll(data);
        assertEquals(data.length, instance.size());
        for(int i = 0; i < instance.size(); i++){
            assertEquals(data[i], instance.get(i));
        }
    }
    /**
     * Test of addAll method with empty list, where it does not need to grow.
     */
    @Test
    public void testAddAll_NoNeedToGrow() {
        System.out.println("Testing adding all elements of an array where the list is empty and does not need to grow");
        String [] data = new String[5];
        for(int i = 0; i < data.length; i++){
            data[i] = "Item " + i;
        }

        DynamicArrayList instance = new DynamicArrayList();
        instance.addAll(data);
        assertEquals(data.length, instance.size());
        for(int i = 0; i < instance.size(); i++){
            assertEquals(data[i], instance.get(i));
        }
    }

    /**
     * Test of addAll method with non-empty list, where it needs to grow.
     */
    @Test
    public void testAddAll_NeedsToGrow_NonEmptyList() {
        System.out.println("Testing adding all elements of an array where the list is non-empty and needs to " +
                "grow");
        String [] data = new String[15];
        for(int i = 0; i < data.length; i++){
            data[i] = "Item " + i;
        }

        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Hello");
        instance.add("Hi");
        instance.addAll(data);

        assertEquals(data.length+2, instance.size());

        assertEquals("Hello", instance.get(0));
        assertEquals("Hi", instance.get(1));
        for(int i = 0; i < data.length; i++){
            assertEquals(data[i], instance.get(i+2));
        }
    }

    /**
     * Test of addAll method with empty list, where it does not need to grow.
     */
    @Test
    public void testAddAll_ExistingList() {
        System.out.println("Testing adding all elements of an array where the list is non-empty and does not need to " +
                "grow");
        String [] data = new String[5];
        for(int i = 0; i < data.length; i++){
            data[i] = "Item " + i;
        }

        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Hello");
        instance.add("Hi");
        instance.addAll(data);

        assertEquals(data.length+2, instance.size());

        assertEquals("Hello", instance.get(0));
        assertEquals("Hi", instance.get(1));
        for(int i = 0; i < data.length; i++){
            assertEquals(data[i], instance.get(i+2));
        }
    }

    /**
     * Test of set method with valid parameters.
     */
    /*@Test
    public void testSet_ValidParameters() {
        System.out.println("Testing set method with valid parameters");
        int pos = 0;
        String text = "New first element";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("First element");
        instance.add("Second element");
        instance.add("Third element");
        instance.add("Fourth element");
        String expResult = "First element";

        String result = instance.set(pos, text);
        // Confirm method returns correctly
        assertEquals(expResult, result);
        // Confirm data was changed
        assertEquals(text, instance.get(0));
        // Confirm size doesn't decrease
        assertEquals(4, instance.size());
        // Confirm other elements are not changed
        assertEquals("Second element", instance.get(1));
        assertEquals("Third element", instance.get(2));
        assertEquals("Fourth element", instance.get(3));
    }*/

    /**
     * Test of set method with invalid parameters (position less than 0).
     */
    /*@Test
    public void testSet_InvalidParameters_BreakingLowerBound() {
        System.out.println("Testing set method with invalid parameters (position less than 0)");
        int pos = -1;
        String text = "New first element";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("First element");
        instance.add("Second element");
        instance.add("Third element");
        instance.add("Fourth element");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.set(pos, text);
        });
    }*/

    /**
     * Test of set method with invalid parameters (position greater than size).
     */
    /*@Test
    public void testSet_InvalidParameters_BreakingUpperBound_GreaterThanSize() {
        System.out.println("Testing set method with invalid parameters (position greater than size)");
        int pos = 5;
        String text = "New first element";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("First element");
        instance.add("Second element");
        instance.add("Third element");
        instance.add("Fourth element");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.set(pos, text);
        });
    }*/

    /**
     * Test of set method with invalid parameters (position equal to size).
     */
    /*@Test
    public void testSet_InvalidParameters_BreakingUpperBound_EqualToSize() {
        System.out.println("Testing set method with invalid parameters (position equal to size)");
        int pos = 4;
        String text = "New first element";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("First element");
        instance.add("Second element");
        instance.add("Third element");
        instance.add("Fourth element");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.set(pos, text);
        });
    }*/
}