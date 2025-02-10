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
public class DynamicArrayListConstructorTests {

    public DynamicArrayListConstructorTests() {
    }

    /**
     * Testing the one int parameter constructor, with an invalid list size/growth factor (less
     * than 0).
     */
    @Test
    public void testIntConstructor_InvalidValue_LessThanZero(){
        System.out.println("testing parameterised constructor with an invalid value (less than 0).");
        assertThrows(IllegalArgumentException.class, () -> {
            DynamicArrayList newList = new DynamicArrayList(-1);
        });
    }
    
    /**
     * Testing the one int parameter constructor, with a valid list size/growth factor.
     */
    @Test
    public void testIntConstructor_ValidValue(){
        System.out.println("testing parameterised constructor with a valid capacity value.");
        DynamicArrayList newList = new DynamicArrayList(5);
        int expResult = 0;
        int result = newList.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing the one int parameter constructor, with an invalid list size/growth factor
     * (equal to 0).
     */
    @Test
    public void testIntConstructor_InvalidValue_EqualToZero(){
        System.out.println("testing parameterised constructor with an invalid value (equal to 0).");
        assertThrows(IllegalArgumentException.class, () -> {
            DynamicArrayList newList = new DynamicArrayList(0);
        });
    }

    /**
     * Testing the array parameter constructor, with a list shorter than initial capacity.
     */
    @Test
    public void testArrayConstructor_ValidArrayShorterThanCapacity() {
        System.out.println("testing parameterised constructor with an array of data shorter than the capacity.");
        String [] data  = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList(data);
        for(int i = 0; i < data.length; i++){
            String expResult = data[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }

    /**
     * Testing the array parameter constructor, with a list equal to initial capacity.
     */
    @Test
    public void testArrayConstructor_ValidArrayEqualToCapacity() {
        System.out.println("testing parameterised constructor with an array of data equal to the capacity.");
        String [] data  = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon", "Red", "Balloon", "Pink " +
                "Flamingo"};
        DynamicArrayList instance = new DynamicArrayList(data);
        for(int i = 0; i < data.length; i++){
            String expResult = data[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }

    /**
     * Testing the array parameter constructor, with a list greater than initial capacity.
     */
    @Test
    public void testArrayConstructor_ValidArrayGreaterThanCapacity() {
        System.out.println("testing parameterised constructor with an array of data greater than the capacity.");
        String [] data  = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon", "Red", "Balloon", "Pink " +
                "Flamingo", "Pink ", "Flamingo"};
        DynamicArrayList instance = new DynamicArrayList(data);
        for(int i = 0; i < data.length; i++){
            String expResult = data[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }

    /**
     * Testing the array parameter constructor, with a list greater than initial capacity.
     */
    @Test
    public void testArrayConstructor_EmptyArray() {
        System.out.println("testing parameterised constructor with an empty array.");
        String [] data  = {};
        DynamicArrayList instance = new DynamicArrayList(data);
        for(int i = 0; i < instance.size(); i++){
            String expResult = data[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }

    /**
     * Testing the array parameter constructor, with a null array supplied.
     */
    @Test
    public void testArrayConstructor_NullArray() {
        System.out.println("testing parameterised constructor with a null array.");
        assertThrows(IllegalArgumentException.class, () -> {
            DynamicArrayList instance = new DynamicArrayList(null);
        });
    }
}