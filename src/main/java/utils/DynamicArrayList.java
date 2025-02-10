package utils;

/**
 * An implementation of a DynamicArray list.
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
     * Gets the number of elements added to a list.
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

    /**
     * Gives a value at a given position within the bounds of instance size.
     * @param position Given position in DynamicArrayList
     * @return The value at the given position
     *
     * @throws IndexOutOfBoundsException If given position is less than 0 or greter than size of DynamicArrayList.
     */
    public String get(int position) {
        //Validation - Check for a position less than 0 as it is not a valid position in an array, or a position greater than numElements as anything beyond this is invalid
        if(position < 0 || position >= this.numElements) {
            //Throw an Exception telling the user that the given position is not valid
            throw new IndexOutOfBoundsException("Given position is NOT valid!");
        }

        //Return array value at given position
        return this.data[position];
    }

    /**
     * Tries to find the position of a given value in DynamicArrayList instance.
     * @param value Given String value
     * @return an int position in DynamicArrayList or -1 if value not present.
     */
    public int indexOf(String value) {
        //Validation - if given string value is null or value.length() is 0, return -1
        if(value == null || value.length() == 0) return -1;
        for(int i = 0; i < this.numElements; i++) {
            if(this.data[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }
}