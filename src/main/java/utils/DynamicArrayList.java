package utils;

/**
 *
 * @author michelle, Contributed by Cal Woods
 */
public class DynamicArrayList {
    //Attributes
    private String[] data;
    private int numElements;

    //Constructors
    //Default no-argument constructor
    public DynamicArrayList() {
        this.data = new String[10];
        this.numElements = 0;
    }

    /**
     * @return The number of elements in DynamicArrayList
     */
    public int size() {
        return this.numElements;
    }

    /**
     * Checks if DynamicArrayList instance has no added elements, is empty.
     * @return Boolean indicating if instance is empty
     */
    public boolean isEmpty() {
        //Check if numElements is 0, return true
        if(this.numElements == 0) return true;

        //Otherwise, return false
        return false;
    }
}