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
public class DynamicArrayListRandomTests {

    public DynamicArrayListRandomTests() {
    }

    /**
     * Test of count method using exact counting approach, with an empty list.
     */
    @Test
    public void testCount_EmptyList_Exact() {
        System.out.println("Testing count with an empty list, using exact count approach");
        DynamicArrayList instance = new DynamicArrayList();
        int expResult = 0;
        int result = instance.count("Test", false);
        assertEquals(expResult, result);
    }

    /**
     * Test of count method using exact counting approach, with a list containing some matches.
     */
    @Test
    public void testCount_ListContainingMatches_Exact() {
        System.out.println("Testing count with a list containing some matches, using exact count approach");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Hi");
        instance.add("hi");
        instance.add("hi");
        instance.add("hello");
        instance.add("Hi");
        int expResult = 2;
        int result = instance.count("hi", false);
        assertEquals(expResult, result);
    }
    /**
     * Test of count method using exact counting approach, with a list containing some matches and some nulls.
     */
    @Test
    public void testCount_ListContainingMatchesAndNulls_Exact() {
        System.out.println("Testing count with a list containing some matches, using exact count approach");

        DynamicArrayList instance = new DynamicArrayList();
        instance.add(null);
        instance.add("Hi");
        instance.add("hi");
        instance.add(null);
        instance.add("hi");
        instance.add("hello");
        instance.add(null);
        instance.add("Hi");

        int expResult = 2;
        int result = instance.count("hi", false);
        assertEquals(expResult, result);
    }

    /**
     * Test of count method using inexact counting approach, with an empty list.
     */
    @Test
    public void testCount_EmptyList_Inexact() {
        System.out.println("Testing count with an empty list, using inexact count approach");
        DynamicArrayList instance = new DynamicArrayList();
        int expResult = 0;
        int result = instance.count("Test", true);
        assertEquals(expResult, result);
    }

    /**
     * Test of count method using inexact counting approach, with a list containing some matches.
     */
    @Test
    public void testCount_ListContainingMatches_Inexact() {
        System.out.println("Testing count with a list containing some matches, using inexact count approach");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Hi");
        instance.add("hi");
        instance.add("hi");
        instance.add("hello");
        instance.add("Hi");

        int expResult = 4;
        int result = instance.count("hi", true);
        assertEquals(expResult, result);
    }

    /**
     * Test of count method using inexact counting approach, with a list containing some matches and some nulls.
     */
    @Test
    public void testCount_ListContainingMatchesAndNulls_Inexact() {
        System.out.println("Testing count with a list containing some matches, using inexact count approach");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add(null);
        instance.add("Hi");
        instance.add("hi");
        instance.add(null);
        instance.add("hi");
        instance.add("hello");
        instance.add(null);
        instance.add("Hi");

        int expResult = 4;
        int result = instance.count("hi", true);
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, performed on a populated list.
     */
    @Test
    public void testClear() {
        System.out.println("Testing clear with a populated list");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add(null);
        instance.add("Hi");
        instance.add("hi");
        instance.add(null);
        instance.add("hi");
        instance.add("hello");
        instance.add(null);
        instance.add("Hi");

        int expResult = 0;
        instance.clear();
        int result = instance.size();
        assertEquals(expResult, result);

        // Confirm it can still be added to
        String text  = "Aloha";
        instance.add(text);
        String textReturned = instance.get(0);
        assertEquals(text, textReturned);
    }

    /**
     * Test of clear method, performed on an empty list.
     */
    @Test
    public void testClear_EmptyList() {
        System.out.println("Testing clear with an empty list");
        DynamicArrayList instance = new DynamicArrayList();
        int expResult = 0;
        instance.clear();
        int result = instance.size();
        assertEquals(expResult, result);

        // Confirm it can still be added to
        String text  = "Aloha";
        instance.add(text);
        String textReturned = instance.get(0);
        assertEquals(text, textReturned);
    }

    /**
     * Test of clear method, performed on a populated list.
     */
    @Test
    public void testClone_PopulatedList() {
        System.out.println("Testing clone with a populated list");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add(null);
        instance.add("Hi");
        instance.add("hi");
        instance.add(null);
        instance.add("hi");
        instance.add("hello");
        instance.add(null);
        instance.add("Hi");
        int lastPos = instance.size();

        DynamicArrayList clone = instance.clone();

        // Confirm sizes match
        assertEquals(instance.size(), clone.size());

        // Confirm everything inside matches
        for(int i = 0; i < instance.size(); i++){
            String original = instance.get(i);
            String cloned = instance.get(i);
            assertEquals(original, cloned);
        }

        // Confirm the two are independent
        String text  = "Aloha";
        instance.add(text);
        String textReturned = instance.get(lastPos);
        assertEquals(text, textReturned);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            clone.get(lastPos);
        });
    }

    /**
     * Test of clear method, performed on an empty list.
     */
    @Test
    public void testClone_EmptyList() {
        System.out.println("Testing clone with an empty list");
        DynamicArrayList instance = new DynamicArrayList();
        int lastPos = instance.size();

        DynamicArrayList clone = instance.clone();

        // Confirm sizes match
        assertEquals(instance.size(), clone.size());

        // Confirm everything inside matches (should be empty)
        for(int i = 0; i < instance.size(); i++){
            String original = instance.get(i);
            String cloned = instance.get(i);
            assertEquals(original, cloned);
        }

        // Confirm the two are independent
        String text  = "Aloha";
        instance.add(text);
        String textReturned = instance.get(lastPos);
        assertEquals(text, textReturned);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            clone.get(lastPos);
        });
    }

    /**
     * Test of lastIndexOf method with information in the list.
     */
    @Test
    public void testLastIndexOf_TextInListOnce() {
        System.out.println("Testing the lastIndexOf method with information in the list once.");
        String text = "Entry Two";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        int expResult = 2;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastIndexOf method with multiple instances of the information in the list.
     */
    @Test
    public void testLastIndexOf_TextInList_MultipleInstances() {
        System.out.println("Testing the lastIndexOf method with information in the list multiple times.");
        String text = "Alpha";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Alpha");
        instance.add("Entry Zero");
        instance.add("Alpha");
        instance.add("Entry One");
        instance.add("Alpha");
        instance.add("Beta");

        int expResult = 4;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastIndexOf method with multiple instances of the information in the list,
     * where the case is not the same as the requested case in some of the matches.
     */
    @Test
    public void testLastIndexOf_TextInList_MultipleInstances_ConfirmingCaseSensitivity() {
        System.out.println("Testing the lastIndexOf method with information in the list multiple times, where the " +
                "case is different" +
                ".");
        String text = "Alpha";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Alpha");
        instance.add("Entry Zero");
        instance.add("Alpha");
        instance.add("Entry One");
        instance.add("alpha");
        instance.add("Beta");

        int expResult = 2;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastIndexOf method with information not in the list.
     */
    @Test
    public void testLastIndexOf_TextNotInList(){
        System.out.println("Testing the lastIndexOf method with information not in the list.");
        String text = "Entry five";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        int expResult = -1;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastIndexOf method with information not in the list, where null is parameter.
     */
    @Test
    public void testLastIndexOf_NullParameter(){
        System.out.println("Testing the lastIndexOf method with null supplied as parameter.");

        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        assertThrows(IllegalArgumentException.class, () -> {
            int result = instance.lastIndexOf(null);
        });
    }

    /**
     * Test of lastIndexOf method with multiple instances of the information in the list and the list contains nulls.
     */
    @Test
    public void testLastIndexOf_TextInList_ListContainsNulls() {
        System.out.println("Testing the lastIndexOf method with information in the list multiple times, where the " +
                "list also contains nulls" +
                ".");
        String text = "Alpha";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Alpha");
        instance.add(null);
        instance.add("Alpha");
        instance.add("Entry One");
        instance.add(null);

        int expResult = 2;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }
}