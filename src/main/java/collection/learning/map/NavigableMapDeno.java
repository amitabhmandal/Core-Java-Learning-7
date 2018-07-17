package collection.learning.map;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/*

NavigableMap is sub interface of SortedMap interface, so it inherits all behaviors of a 
sorted map like range view, endpoints and comparator access operations. In addition, 
the NavigableMap interface provides navigation methods.

Operations on key-value mappings (entries):
lowerEntry(K key): returns a key-value mapping associated with the greatest key strictly less than the given key.
floorEntry(K key): returns a key-value mapping entry which is associated with the greatest key less than or equal to the given key.
ceilingEntry(K key): returns an entry associated with the lest key greater than or equal to the given key.
higherEntry(K key): returns an entry associated with the least key strictly greater than the given key.

Note that all these methods return null if there is no such key.
firstEntry(): returns a key-value mapping associated with the least key in the map, or null if the map is empty.
lastEntry(): returns a key-value mapping associated with the greatest key in the map, or null if the map is empty.
descendingMap(): returns a reverse order view of the mappings contained in the map.
pollFirstEntry(): removes and returns a key-value mapping associated with the least key in the map, or null if the map is empty.
pollLastEntry(): removes and returns a key-value mapping associated with the greatest key in the map, or null if the map is empty.

Operations on keys only:
lowerKey(K key): returns the greatest key strictly less than the given key.
floorKey(K key): returns the greatest key less than or equal to the given key.
ceilingKey(K key): returns the least key greater than or equal to the given key.
higherKey(K key): returns the least key strictly greater than the given key.
descendingKeySet(): returns a NavigableSet containing the keys in reverse order.

Note that all these methods return null if there is no such key.

Furthermore, the NavigableMap interface overloads the headMap(), subMap() and tailMap() methods of the SortedMap interface, which accept additional arguments describing whether lower or upper bounds are inclusive versus exclusive:
headMap(K toKey, boolean inclusive)
subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
tailMap(K fromKey, boolean inclusive)


*/
public class NavigableMapDeno {

    public static void main(String[] args) {
        NavigableMap<Integer, String> mapHttpStatus = new TreeMap<>();
        
        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");
         
        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");
         
        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
         
         
        Set<Integer> ascendingKeys = mapHttpStatus.keySet();
         
        System.out.println("Ascending Keys: " + ascendingKeys);
         
        Set<Integer> descendingKeys = mapHttpStatus.descendingKeySet();
         
        System.out.println("Descending Keys: " + descendingKeys);
        
        NavigableMap<Integer, String> descendingMap = mapHttpStatus.descendingMap();
        
        for (Integer key : descendingMap.keySet()) {
            System.out.println(key + " => " + descendingMap.get(key));
        }
        
        Integer lowerKey = mapHttpStatus.lowerKey(401);
        System.out.println("Lower key: " + lowerKey);
         
        Integer floorKey = mapHttpStatus.floorKey(401);
        System.out.println("Floor key: " + floorKey);
         
        Integer higherKey = mapHttpStatus.higherKey(500);
        System.out.println("Higher key: " + higherKey);
         
        Integer ceilingKey = mapHttpStatus.ceilingKey(500);
        System.out.println("Ceiling key: " + ceilingKey);

        Map.Entry<Integer, String> firstEntry = mapHttpStatus.firstEntry();
        
        System.out.println("First entry: " + firstEntry.getKey() + " => " + firstEntry.getValue());
         
        Map.Entry<Integer, String> lastEntry = mapHttpStatus.lastEntry();
         
        System.out.println("Last entry: " + lastEntry.getKey() + " => " + lastEntry.getValue());
         
        Map.Entry<Integer, String> lowerEntry = mapHttpStatus.lowerEntry(401);
        System.out.println("Lower entry: " + lowerEntry.getKey() + " => " + lowerEntry.getValue());
         
        Map.Entry<Integer, String> floorEntry = mapHttpStatus.floorEntry(401);
        System.out.println("Floor entry: " + floorEntry.getKey() + " => " + floorEntry.getValue());
         
        Map.Entry<Integer, String> higherEntry = mapHttpStatus.higherEntry(500);
        System.out.println("Higher entry: " + higherEntry.getKey() + " => " + higherEntry.getValue());
         
        Map.Entry<Integer, String> ceilingEntry = mapHttpStatus.ceilingEntry(500);
        System.out.println("Ceiling entry: " + ceilingEntry.getKey() + " => " + ceilingEntry.getValue());
         
        mapHttpStatus.pollFirstEntry();
        mapHttpStatus.pollLastEntry();
         
         
        System.out.println("\nMap after first and last entries were polled:");
         
        for (Integer key : mapHttpStatus.keySet()) {
            System.out.println(key + " => " + mapHttpStatus.get(key));
        }
    }

}
