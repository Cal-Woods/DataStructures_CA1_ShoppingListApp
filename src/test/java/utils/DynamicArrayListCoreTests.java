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
public class DynamicArrayListCoreTests {
    
    public DynamicArrayListCoreTests() {
    }

    /**
     * Testing the size method, of class DynamicArrayList.
     */
    @Test
    public void testSize_EmptyList() {
        System.out.println("testing size() with an empty list.");
        DynamicArrayList instance = new DynamicArrayList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Testing the size method, of class DynamicArrayList.
     */
    @Test
    public void testSize_PopulatedList() {
        System.out.println("testing size() with a populated list.");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry One");
        instance.add("Entry Two");
        instance.add("Entry Three");
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing valid input with get method.
     */
    @Test
    public void testGet_ValidInput() {
        System.out.println("Testing the get method with valid input.");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        String expResult = "Entry One";
        String result = instance.get(1);
        assertEquals(expResult, result);
    }
       
    /**
     * Testing invalid input (below lower bound) with get method.
     */
    @Test
    public void testGet_BreakingLowerBound() {
        System.out.println("Testing the get method with invalid input (less than 0).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(-1);
        });
    }
    
    /**
     * Testing invalid input (greater than size) with get method.
     */
    @Test
    public void testGet_BreakingUpperBound_GreaterThanSize() {
        System.out.println("Testing the get method with invalid input (greater than the length of the list).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(4);
        });
    }
    
    /**
     * Testing invalid input (equal to size) with get method.
     */
    @Test
    public void testGet_BreakingUpperBound_EqualToSize() {
        System.out.println("Testing the get method with invalid input (equal to the length of the list).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(3);
        });
    }
    
    /**
     * Test of indexOf method with information in the list.
     */
    @Test
    public void testIndexOf_TextInList() {
        System.out.println("Testing the indexOf method with information in the list.");
        String text = "Entry Two";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        int expResult = 2;
        int result = instance.indexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf method with information in the list.
     */
    @Test
    public void testIndexOf_TextNotInList(){
        System.out.println("Testing the indexOf method with information not in the list.");
        String text = "Entry five";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        int expResult = -1;
        int result = instance.indexOf(text);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of add method with empty list.
     */
    @Test
    public void testAdd_String() {
        System.out.println("Testing adding a String to the end of the list (with an empty list)");
        String text = "First element";
        DynamicArrayList instance = new DynamicArrayList();

        instance.add(text);
        String result = instance.get(0);
        assertEquals(text, result);
    }

    /**
     * Test of add method with empty list.
     */
    @Test
    public void testAdd_AddingTwoElements_String() {
        System.out.println("Testing adding two Strings to a list");
        String text = "First element";
        String text2 = "Second element";
        DynamicArrayList instance = new DynamicArrayList();

        instance.add(text);
        instance.add(text2);
        String elem2 = instance.get(1);
        assertEquals("Second element", elem2);
    }    
    
    /**
     * Test of add method where list needs to grow.
     */
    @Test
    public void testAdd_GrowingSpace_String() {
        System.out.println("Testing adding enough Strings to a list to trigger growing the array");

        DynamicArrayList instance = new DynamicArrayList();
        for(int i = 0; i < 11; i++){
             instance.add("Item " + i);
        }
        String lastItem = instance.get(10);
        assertEquals("Item 10", lastItem);
    }

    /**
     * Test of isEmpty method with an empty list.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty with an empty list");
        DynamicArrayList instance = new DynamicArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of isEmpty method with a populated list.
     */
    @Test
    public void testIsEmpty_PopulatedList() {
        System.out.println("Testing isEmpty with a populated list");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");
        
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
}