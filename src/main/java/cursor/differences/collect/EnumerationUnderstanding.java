package cursor.differences.collect;

import java.util.Enumeration;
import java.util.Vector;

// Cursor
// 1. Enumeration
// 2. Iterator
// 3. ListIterator

// To get objects one by one we need to cursors.

public class EnumerationUnderstanding {

    
    //how to get enumerations object
    //by using elements method which is present in the vector
    
    
    public EnumerationUnderstanding() {
        //vector is present in java.util package
        Vector v = new Vector();
        Enumeration enumerations = v .elements();
    }

    public static void main(String[] args) {
       System.out.println("Enumeration Understanding");

    }

}
