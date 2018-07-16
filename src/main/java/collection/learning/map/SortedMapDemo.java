package collection.learning.map;

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

public class SortedMapDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static void sortedMapDemo() {

        SortedMap s = new TreeMap();

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
