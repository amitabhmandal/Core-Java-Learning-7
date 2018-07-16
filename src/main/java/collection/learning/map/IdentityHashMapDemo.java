package collection.learning.map;

import java.util.HashMap;
import java.util.IdentityHashMap;

/*

 * @@@@@@@@@@@@@@@
 * IdentityHashMap
 * @@@@@@@@@@@@@@@
 * IdentityHashMap implements Map, Serializable and Clonable interfaces and extends AbstractMap class.
 * 
 * This class is not a general-purpose Map implementation. 
 * While this class implements the Map interface, it intentionally violates Map’s general contract, 
 * which mandates the use of the equals method when comparing objects.
 * 
 * 
 * Never try to iterate IdentityHashMap if you want predictable results.
 * 
 * It is a special implementation of map.
 * which doesn't use the equals and hashcode method for comparing objects unlike
 * the implementation of Map eg HashMap.
 * 
 * This class is used when the user requires the objects to be compared via reference
 * 
 * IdentityHashMap uses the == operator to compare keys and the values which is 
 * faster compare to HashMap and suitable for places where you need reference
 * equality check instead of logical equality.
 * 
 * For hashing, System.identityHashCode(givenKey) is invoked rather than the givenKey.hashCode().
 * 
 * 
 * 
 * The fundamental difference between IdentityHashMap and other Map implementations e.g. HashMap, 
 * Hashtable, WeakHashMap or EnumMap it uses equality operator (==) to search and get the value back.
 * 
 * Since == operator only return true if the reference variables point to the same object, it's not possible to get 
 * the value with a different object even if it appear equal in all field. 
 * You must hold the reference of the key object outside the IdentityHashMap to get the value back.
 * 
 * 
 * 
 * 
 * Unlike HashMap, who uses hashcode to find bucket location, IdentityHashMap also doesn't
 * use hashCode() 
 * instead it uses System.identityHashCode(object)
 * 
 * Another key difference between IdentityHashMap and HashMap in Java is Speed. 
 * Since IdentityHashMap doesn't use equals() its 
 * comparatively faster than HashMap for object with expensive equals() and hashCode().
 * 
 * One more difference between HashMap and IdentityHashMap is Immutability of the key. 
 * One of the basic requirement to safely store Objects in HashMap is keys needs to be immutable, 
 * IdentityHashMap 
 * doesn't require keys to be immutable as it is not relied on equals and hashCode.
 * 
 * There is also a class called IdentityHashtable which is analogous to Hashtable in Java 
 * but it’s not part of standard JDK and available in com.sun... package.
 * 
 * As I said IdentityHashMap violates Map interface general contract and 
 * should only be used when reference equality makes sense
 * 
 * As per Javadoc, IdentityHashMap is suitable to keep object reference during Serialization and 
 * deep copy and can also be used  to maintain as a proxy object. 
 * 
 * Both IdentityHashMap and HashMap are  Hashtable based implementation of Map interface. 
 * IdentityHashMap is a simple linear probe hashtable  while HashMap uses chaining instead of linear probe in hashtable.
 * 
 * Initial capacity of HashMap is 16 by default .  Initial capacity of IdentityHashMap is 21 by default.
 * 
 * A typical use of this class is topology-preserving object graph transformations , such as serialization and deep copying . 
 * To perform such a transformation , a program must maintain a "node table" that keeps track of all the object references
 *  that have already been processed.The node table must not equate distinct objects even if they happen to be equal.
 * 
 * Another typical use of this class is to maintain proxy objects. For example , 
 * a debugging facility might wish to maintain a  proxy object for each object in the program being debugged.
 * 
 * Use IdentityHashMap if use needs strict equality check by using == operator. It's not a general purpose Map because it doesn't use 
 * equals() method for comparing keys, hence also breaks Map interface's contract.
 * 
 * -------------------------------------------------
 * Similarities between IdentityHashMap and HashMap
 * -------------------------------------------------
 * 
 * 1)
 * Permit null key and null values : Both HashMap and IdentityHashMap class permit null key and null values
 * 
 * 2)
 * Not synchronized : Both classes are not synchronized. Both classes must be synchronized externally.
 *  For IdentityHashMap :
 *   Map m  = Collections.synchronizedMap(new IdentityHashMap( ... ));
 *   For HashMap :
 *   Map m  = Collections.synchronizedMap(new HashMap( ... ));
 * 
 * 3)
 * Iterators returned by the iterator method : Both classes iterator method return the fail-fast iterator .
 * 
 * 4)
 * Check out in detail about the difference between fail-fast iterator and fail-safe iterator .
 * 
 * Implementation : Both are Hashtable based implementation of Map interface.
 * 
 * 
*/
public class IdentityHashMapDemo {

    public static void main(String[] args) {
        basicUnderstanding();
        existingHashMapDoes();
        identityHashMapDemo();

    }
    
    public static void identityHashMapDemo() {
        //works on the principle of == operator
        IdentityHashMap m = new IdentityHashMap();
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        
        m.put(i1, "Amitabh");
        m.put(i2, "Mandal");
        
        System.out.println(m);
        
    }
    
    public static void basicUnderstanding() {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        
        //checks memory references or address or hashCode values in case of references
        //and values in case of primitives
        System.out.println("i1 == i2 " + (i1 == i2)); // false
        
        //checks for logical equivalance ie content within the object
        System.out.println("i1.equals(i2) " + (i1.equals(i2))); //true
    }
    
    public static void existingHashMapDoes() {
        
        //Works on the principle of equals method
        //to identify duplicate keys.
        HashMap m = new HashMap();
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        
        m.put(i1, "Amitabh");
        m.put(i2, "Mandal");
        
        System.out.println(m);
    }

}
