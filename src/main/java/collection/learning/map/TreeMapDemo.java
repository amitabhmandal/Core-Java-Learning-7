package collection.learning.map;

import java.util.TreeMap;

/* Underlying Data Structure: Red Black Tree
 * 
 * Insertion Order: Not preserved
 * 
 * Insertion Order is governed by Sorted order of Keys and not values
 * 
 * Duplicate Keys not allowe but duplicate values allowed
 * 
 * Heterogenous Objects : 
 * If we are depending on default natural sorting order then the keys should be 
 * homogenous and comparable
 * 
 * If we are defining our own sorting order then the keys need not be comparable 
 * and need not be homogenous
 * 
 * NO RESTRICTIONS OF VALUES.
 * 
 */

public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap m = new TreeMap();
        // Example of keys should be homogenous and values can be heterogenous
        m.put(100, "a");
        m.put(101, "b");
        m.put(102, "c");
        m.put(102, 106);

        // Here Key is not homogenous hence it wil result in Run Time Exception
        /*
        Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        at java.lang.String.compareTo(String.java:108)
        at java.util.TreeMap.put(TreeMap.java:560)
        at collection.learning.map.TreeMapDemo.main(TreeMapDemo.java:33)
        */
        
        //Thus heterogenous keys then it will result in ClassCastException which is the 
        //The reason is that we are dependent on default natural sorting order
        //Hence we had been inserting integers
        //Now if we try to insert strings into the TreeMap
        //then it will result in the following exception
        
        //m.put("FFF", 106);
        m.put(null, 106);
        System.out.println(m);

    }

}
