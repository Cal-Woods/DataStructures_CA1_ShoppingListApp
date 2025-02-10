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
}
