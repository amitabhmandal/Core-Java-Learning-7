package collection.learning.map;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/*

The SortedMap interface provides operations for normal Map operations and for the following:

***********  ++++++++++++++++++++++++++++++++++++++++++++++++++++
Range view — performs arbitrary range operations on the SortedMap
***********  ++++++++++++++++++++++++++++++++++++++++++++++++++++

#1
subMap(K fromKey, K toKey): Returns a view of the portion of this Map whose keys range 
from fromKey, inclusive, to toKey, exclusive.

#2
headMap(K toKey): Returns a view of the portion of this Map whose keys are strictly 
less than toKey.

#3
tailMap(K fromKey): Returns a view of the portion of this Map whose keys are greater 
than or equal to fromKey.

*********   ++++++++++++++++++++++++++++++++++++++++++++++++++
Endpoints — returns the first or the last key in the SortedMap
*********   ++++++++++++++++++++++++++++++++++++++++++++++++++
#1
firstKey(): Returns the first (lowest) key currently in this Map.

#2
lastKey(): Returns the last (highest) key currently in this Map.

+++++++++++++++++
Comparator access — returns the Comparator, if any, used to sort the map
+++++++++++++++++
comparator(): Returns the Comparator used to order the keys in this Map, or null if this Map uses the natural ordering of its keys.
*/

//Sorting is based on the key and not on the value.

public class SortedMapDemo {

    public static void main(String[] args) {
        // returns the first (lowest) key currently in the map.
        firstKeyDemo();

        // returns the last (highest) key currently in the map.
        lastKeyDemo();

        // returns a sorted map whose keys range from fromKey, inclusive, to toKey, 
        //exclusive.
        subMapDemo();
        
        //returns a sorted map whose keys are strictly less than toKey.
        headMapDemo();
        
        //returns a sorted map whose keys are greater than or equal to fromKey.
        tailMapDemo();
        
        // returns the comparator used to order the keys in the map, or returns null if this map uses the natural ordering of its keys.
        comparatorDemo();

        // custom sorting order
        customSortingOrderReverseOrder();
        
    }

    public static void customSortingOrderReverseOrder() {
        SortedMap<Integer, String> mapHttpStatus = new TreeMap<>(new ReverseComparator());
        
        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");
        mapHttpStatus.put(300, "Multiple Choices");
         
        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");
        mapHttpStatus.put(402, "Payment Required");
        mapHttpStatus.put(403, "Forbidden");
        mapHttpStatus.put(404, "Not Found");
         
        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
        mapHttpStatus.put(502, "Bad Gateway");
         
        for (Integer code : mapHttpStatus.keySet()) {
            System.out.println(code + " -> " + mapHttpStatus.get(code));
        }
    }
    
    // returns the comparator used to order the keys in the map, or returns null if this map uses the natural ordering of its keys.
    public static void comparatorDemo() {
SortedMap<Integer, String> mapHttpStatus = new TreeMap<>();
        
        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");
        mapHttpStatus.put(300, "Multiple Choices");
         
        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");
        mapHttpStatus.put(402, "Payment Required");
        mapHttpStatus.put(403, "Forbidden");
        mapHttpStatus.put(404, "Not Found");
         
        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
        mapHttpStatus.put(502, "Bad Gateway");
         
        System.out.println("All key-value pairs: ");
        
        for (Integer code : mapHttpStatus.keySet()) {
            System.out.println(code + " -> " + mapHttpStatus.get(code));
        }
         
        System.out.println();
        
        Comparator comparator = mapHttpStatus.comparator();
        
        System.out.println("Sorted by natural ordering? " + (comparator == null));
    }
    //returns a sorted map whose keys are greater than or equal to fromKey.
    public static void tailMapDemo() {
        SortedMap<Integer, String> mapHttpStatus = new TreeMap<>();
        
        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");
        mapHttpStatus.put(300, "Multiple Choices");
         
        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");
        mapHttpStatus.put(402, "Payment Required");
        mapHttpStatus.put(403, "Forbidden");
        mapHttpStatus.put(404, "Not Found");
         
        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
        mapHttpStatus.put(502, "Bad Gateway");
         
        System.out.println("All key-value pairs: ");
         
        for (Integer code : mapHttpStatus.keySet()) {
            System.out.println(code + " -> " + mapHttpStatus.get(code));
        }
         
        System.out.println();
        
        SortedMap<Integer, String> mapAbove500Status = mapHttpStatus.tailMap(500);
        
        System.out.println("Statuses > 500: ");
        
        for (Integer code : mapAbove500Status.keySet()) {
            System.out.println(code + " -> " + mapAbove500Status.get(code));
        }
        
    }
    
    //returns a sorted map whose keys are strictly less than toKey.
    public static void headMapDemo() {
        SortedMap<Integer, String> mapHttpStatus = new TreeMap<>();
        
        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");
        mapHttpStatus.put(300, "Multiple Choices");
         
        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");
        mapHttpStatus.put(402, "Payment Required");
        mapHttpStatus.put(403, "Forbidden");
        mapHttpStatus.put(404, "Not Found");
         
        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
        mapHttpStatus.put(502, "Bad Gateway");
         
        System.out.println("All key-value pairs: ");
         
        for (Integer code : mapHttpStatus.keySet()) {
            System.out.println(code + " -> " + mapHttpStatus.get(code));
        }
         
        System.out.println();
        
        SortedMap<Integer, String> mapUnder300Status = mapHttpStatus.headMap(300);
        
        System.out.println("Statuses < 300: ");
         
        for (Integer code : mapUnder300Status.keySet()) {
            System.out.println(code + " -> " + mapUnder300Status.get(code));
        }
         
        System.out.println();
        
    }
    //returns a sorted map whose keys range from fromKey, inclusive, to toKey, exclusive.
    public static void subMapDemo() {
        SortedMap<Integer, String> mapHttpStatus = new TreeMap<>();

        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");
        mapHttpStatus.put(300, "Multiple Choices");

        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");
        mapHttpStatus.put(402, "Payment Required");
        mapHttpStatus.put(403, "Forbidden");
        mapHttpStatus.put(404, "Not Found");

        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
        mapHttpStatus.put(502, "Bad Gateway");

        System.out.println("All key-value pairs: ");

        for (Integer code : mapHttpStatus.keySet()) {
            System.out.println(code + " -> " + mapHttpStatus.get(code));
        }

        System.out.println();

        SortedMap<Integer, String> map4xxStatus = mapHttpStatus.subMap(400, 500);
        
        System.out.println("4xx Statuses: ");
         
        for (Integer code : map4xxStatus.keySet()) {
            System.out.println(code + " -> " + map4xxStatus.get(code));
        }
         
        System.out.println();
        
    }
    // returns the last (highest) key currently in the map.
    public static void lastKeyDemo() {
        SortedMap<Integer, String> mapHttpStatus = new TreeMap<>();

        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");
        mapHttpStatus.put(300, "Multiple Choices");

        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");
        mapHttpStatus.put(402, "Payment Required");
        mapHttpStatus.put(403, "Forbidden");
        mapHttpStatus.put(404, "Not Found");

        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
        mapHttpStatus.put(502, "Bad Gateway");

        System.out.println("All key-value pairs: ");

        for (Integer code : mapHttpStatus.keySet()) {
            System.out.println(code + " -> " + mapHttpStatus.get(code));
        }

        System.out.println();

        Integer lastKey = mapHttpStatus.lastKey();
        String lastValue = mapHttpStatus.get(lastKey);

        System.out.println("Last status: " + lastKey + " -> " + lastValue);
        System.out.println();

    }

    // returns the first (lowest) key currently in the map.
    public static void firstKeyDemo() {
        SortedMap<Integer, String> mapHttpStatus = new TreeMap<>();

        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");
        mapHttpStatus.put(300, "Multiple Choices");

        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");
        mapHttpStatus.put(402, "Payment Required");
        mapHttpStatus.put(403, "Forbidden");
        mapHttpStatus.put(404, "Not Found");

        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
        mapHttpStatus.put(502, "Bad Gateway");

        System.out.println("All key-value pairs: ");

        for (Integer code : mapHttpStatus.keySet()) {
            System.out.println(code + " -> " + mapHttpStatus.get(code));
        }

        System.out.println();

        Integer firstKey = mapHttpStatus.firstKey();
        String firstValue = mapHttpStatus.get(firstKey);

        System.out.println("First status: " + firstKey + " -> " + firstValue);
        System.out.println();
    }

    public static void sortedMapDemo() {

        SortedMap<String, String> mapDomains = new TreeMap<>();

        mapDomains.put(".com", "International");
        mapDomains.put(".us", "United States");
        mapDomains.put(".uk", "United Kingdom");
        mapDomains.put(".jp", "Japan");
        mapDomains.put(".au", "Australia");

        System.out.println(mapDomains);

    }
}

class ReverseComparator implements Comparator<Integer> {
    public int compare(Integer num1, Integer num2) {
        return num2.compareTo(num1);
    }
}

/*
public interface SortedMap extends Map
{
    Comparator comparator();
    SortedMap subMap(K fromKey, K toKey);
    SortedMap headMap(K toKey);
    SortedMap tailMap(K fromKey);
    K firstKey();
    K lastKey();
}

*/
