package collection.learning.map;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/*
 * A Map is an object that maps keys to values. 
 * 
 * A map cannot contain duplicate keys; 
 * 
 * each key can map to at most one value
 * 
 * Duplicate keys not allowed however duplicate values allowed.
 * 
 * Each key-value pair is called an Entry. Hence a map is also called as Collection of Entry Objects
 * 
 * Some implementations allow null key and null value (HashMap and LinkedHashMap) but some do not (TreeMap).
 * The order of a map depends on specific implementations, e.g TreeMap and LinkedHashMap have predictable order, 
 * while HashMap does not.
 * 
 * The Map interface includes methods for 
 * ================
 * basic operations
 * ================ 
 * (such as put, get, remove, containsKey, containsValue, size, and empty),
 * 
 * V put(K key, V value) - If the map previously contained a mapping for the key, the old value is 
 * replaced by the specified value and the old value is returned.
 * 
 * void putAll(Map<? extends K,? extends V> m) - 
 * 
 * 
 * V remove(Object key)
 * 
 * 
 * void putAll(Map<? extends K,? extends V> m)
 * 
 * void clear()
 * 
 * V get(Object key)
 * 
 * isEmpty()
 * 
 * int size() :  If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
 * 
 * 
 * boolean containsKey(Object key)
 * Returns true if this map contains a mapping for the specified key. More formally, 
 * returns true if and only if this map contains a mapping for a key k such that 
 * (key==null ? k==null : key.equals(k)). (There can be at most one such mapping.)
 * 
 * boolean containsValue(Object value)
 * Returns true if this map maps one or more keys to the specified value. More formally, 
 * returns true if and only if this map contains at least one mapping to a value v such 
 * that (value==null ? v==null : value.equals(v)).
 *  
 * 
 * ===============
 * bulk operations
 * =============== 
 * (such as putAll and clear)
 * 
 * ================
 * collection views
 * ================ 
 * (such as keySet, entrySet, and values).
 * 
 * 
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * The Java platform contains three general-purpose Map implementations: HashMap, TreeMap, and LinkedHashMap
 * 
 * Their behavior and performance are precisely analogous to HashSet, TreeSet, and LinkedHashSet, 
 * as described in The Set Interface section.
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 
 * =====================
 * Why and When Use Maps:
 * =====================
 * Maps are perfectly for key-value association mapping such as dictionaries. Use Maps when you want to 
 * retrieve and update elements by keys, or perform lookups by keys. 
 * 
 * Examples: 
 * A map of error codes and their descriptions.
 * A map of zip codes and cities.
 * A map of managers and employees. Each manager (key) is associated with a list of 
 * employees (value) he manages.
 * 
 * A map of classes and students. Each class (key) is associated with a list of students (value).
 * 
 * java.util.HashMap
 * java.util.Hashtable
 * java.util.EnumMap
 * java.util.IdentityHashMap
 * java.util.LinkedHashMap
 * java.util.Properties
 * java.util.TreeMap
 * java.util.WeakHashMap
 * ++++++++++++++++++++++
 * Implementation Classes [6 classes]
 * ++++++++++++++++++++++
 * 
 * @@@@@@@
 * HashMap
 * @@@@@@@
 * Use a HashMap if you don’t need to visit the keys in sorted order.
 * HashMap is implemented as a hash table, and there is no ordering on keys or values. 
 * 
 * 
 * If key of the HashMap is self-defined objects, then equals() and hashCode() contract need to be followed. 
 * The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.
 * 
 * Iteration not gauranteed in the insertion order.
 * 
 * Needs to use synchronized operations when manipulating from multiple threads.
 * 
 * 
 * Most enterprise applications populate the map once and then read it many times from many threads.
 * 
 * 
 * Allows to use Null keys. 
 * 
 * 
 * 
 * 
 * @@@@@@@@@
 * Hashtable extends abstract Dictionary
 * @@@@@@@@@
 * 
 * Hashtable is synchronized, in contrast to HashMap.
 * It is a legacy implementation.
 * If a thread safe implementation is not required then choose recommended to use HashMap
 * in place of Hashtable.
 * 
 * If a thread safe implementation is required then choose ConcurrentHashMap in place
 * of Hashtable.
 * 
 * -------------------------------------------------------
 * Why null is not allowed as a key or value in Hashtable?
 * -------------------------------------------------------
 * 
 * To successfully store and retrieve objects from a Hashtable, the objects used as 
 * keys must implement the hashCode method and the equals method.
 * 
 * Since null isn't an object, you can't call .equals() or .hashCode() on it, so the 
 * Hashtable can't compute a hash to use it as a key.
 * 
 * Neither Hashtable nor ConcurrentHashMap support null keys or values. HashMap does.
 *  The most similar option would be ConcurrentHashMap 
 *  (which is thread safe but doesn't support locking the whole table):
 *  
 *  HashTable - Does not allow null keys This is because, in put(K key, V value) method, 
 *  we have key.hashcode() which throws null pointer exception. HashTable - 
 *  Does not allow null value This is because, in put(K key, V value) method 
 *  we have if(value==null){throw new NullPointerException
 * HashTable class is implemented on hashing mechanism, that’s mean to store any 
 * key-value pair, its required hash code of key object. If key would be null, 
 * it will not able to given hash ,it will through null pointer exception and 
 * similar case for value it is throwing null if the value is null.
 * 
 * But later on it was realized that null key and value has its own importance 
 * that is why one null key and multiple null values are allowed in later implemented 
 * classes like HashMap class.
 * 
 * For hash map null keys will allow and there is a null check is there for keys if the 
 * key is null then that element will be stored in a zero location in Entry array. 
 * null key we can use for some default value. 
 * 
 * HashMap implements by considering it special
 * 
 * static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
 * 
 * By contrast, with TreeMap null keys are disallowed because supporting 
 * them would be difficult given the implications of orderings involving null.
 * 
 * Java engineers must have realized that having a null key and values has its uses 
 * like using them for default cases. So, they provided HashMap class with collection framework 
 * in Java 5 with capability of storing null key and values.

 * The put method to insert key value pair in HashMap checks for null key and stores it at the 
 * first location of the internal table array. It isn’t afraid of the null values and does not 
 * throw NullPointerException like Hashtable does.

 * Now, there can be only one null key as keys have to be unique although we can
 * have multiple null values associated with different keys.


 * All methods are threadsafe.
 * 
 * There is synchronized keyword on each public such as put get remove etc
 * 
 * overhead in an environment where Map is initialized once and then for every read operation
 * by multiple threads there shall be a blocking wait.
 * 
 * @@@@@@@@
 * EnumMap
 * @@@@@@@@
 * 
 * 
 * 
 * 
 * EnumMap is a special Map implementations for Enum keys, this is also the fundamental difference between 
 * EnumMap and another general purpose Map class e.g. HashMap or Hashtable. Unlike others EnumMap only allows 
 * Enum constants to be used as keys. If you try to store keys other than Enum than compiler will throw an error.
 * 
 * When using Enum they must be of the same type.
 * 
 * They do not allow null keys. They are not synchronized.
 * 
 * Iterators does not fail fast.
 * 
 * 
 * 
 * EnumMap is specialized Map implementation designed and optimized for using Java Enum as key.
 * Since enum can represent a type (like class or interface)  in Java and it can also override equals() and hashCode()
 * It can be used inside HashMap or any other collection but using  EnumMap brings implementation specific benefits 
 * which are done for enum keys, 
 * 
 * In short EnumMap is optimized Map implementation exclusively for enum keys .
 * 
 * So if you are thinking of an high-performance Map, EnumMap could be a decent choice for enumeration data. 
 * 
 * EnumMap is optimized for enums to store in a map
 * 
 * EnumMap internally uses array and provide constant time performance for common methods like get() and put().
 * 
 * You can only use Enum as a key in EnumMap whereas in HashMap you can use any object including Enum
 * 
 * As EnumMap is optimized for enum keys , so it’s performance is better than HashMap when use Enum key as object
 * 
 * One more difference is that Enummap dont use hascode() method to store the keys and values so there is no collision.
 * 
 * ContainsKey. This is an important method on EnumMap. It receives one argument, of the specified enum's type. 
 * It returns true, if found, and false, if the key is not present.
 * 
 * 
 * Use EnumMap if you are using Enum constants as keys. It will probably take less memory and give better performance 
 * than HashMap or any other general purpose Map. 
 * It also has a good chance to be upgraded or replaced by another more performant implementation.
 * 
 * Lookups based on enum keys are consistently faster. 
 * The code is optimized. In programs with enum keys, EnumMap is a definite win.
 * 
 * The EnumMap is faster for lookups than a HashMap with enum keys. In this benchmark, 
 * I found EnumMap is a bit less than twice as fast on simple lookups.
 * So: A program that uses enum keys in a HashMap (or other collection) will benefit from EnumMap. The benefits are clear.
 * 
 * The main difference between EnumMap and HashMap is that EnumMap is a specialized Map 
 * implementation exclusively for Enum as key. Using Enum as key allows doing some implementation level 
 * optimization for high performance which is generally not possible with other objects as key. 
 * 
 *  Unlike HashMap, EnumMap is not applicable for every case but it's best suited when you have Enum as key.
 * 
 * All keys used in EnumMap must be  from same Enum type which is specified while creating EnumMap in Java. 
 * For example if you can not use different enum instances from two different enum.
 * 
 * EnumMap is ordered collection and they are maintained in the natural order of their 
 * keys( natural order of keys means  the order on which enum constant are declared inside enum type ). 
 * you can verify this while Iterating over an EnumMap in Java.
 * 
 * Iterators of EnumMap are fail-fast Iterator , much like of ConcurrentHashMap and doesn't throw 
 * ConcurrentModificationException and may not show effect of any modification on EnumMap during Iteration process.
 * 
 * You can not insert null keys inside EnumMap in Java.  EnumMap doesn't allow null key and throw 
 * NullPointerException, at same time null values are permitted.
 * 
 * EnumMap is not synchronized and it has to be synchronized manually before using it in a concurrent or 
 * multi-threaded environment. like synchronized Map in Java  you can also make EnumMap 
 * synchronized by using Collections.synchronizedMap() method and as per javadoc this should be 
 * done while creating EnumMap in java to avoid accidental non synchronized access.
 * 
 * One more thing which can be considered as the difference between HashMap and EnumMap
 *  is the probability of Collision. Since Enum is internally maintained as array and 
 *  they are stored in their natural order using ordinal(), as shown in following code
 *   which is taken from put() method of EnumMap

    int index = ((Enum)key).ordinal();
    Object oldValue = vals[index];
    vals[index] = maskNull(value);
 * 
 * Since EnumMap doesn't call hashCode method on keys, there is no chance of collision.
 * 
 * 
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

 * @@@@@@@@@@
 * Properties
 * @@@@@@@@@@
 * 
 * 
 * 
 * @@@@@@@
 * TreeMap
 * @@@@@@@
 * 
 * It implements navigable map and sorted map interface. Hence TreeMap is the default implementation of sorted map
 * and navigable map.
 * 
 * Iteration is gauranteed in the natural sorting order.
 * 
 * Either the keys should implement Comparator interface or the TreeMap constructor should provide an explicit
 * Comparator in the constructor.
 * 
 * Navigable map interface provides method that can return closes match to the key(floorEntry())
 * 
 * Example: java.lang.String can be used as keys. Hence the TreeMap would automatically sort them in natural sorting order.
 * Displaying country names/capital TreeMap in a sorted order. We will not have to worry about it. 
 * The TreeMap would automatically sort it in natural sorting order.
 * 
 * 
 * 
 * 
 * TreeMap is implemented based on red-black tree structure, and it is ordered by the key. 
 * 
 * This Map implementation usually acts as a bucketed hash table, but when buckets get too large, 
 * they get transformed into nodes of TreeNodes, each structured similarly to those in java.util.TreeMap.
 * 
 * On the other hand, TreeMap extends AbstractMap class and implements NavigableMap interface. 
 * A TreeMap stores map elements in a Red-Black tree, which is a Self-Balancing Binary Search Tree.
 * 
 * 
 * HashMap doesn’t provide any guarantee over the way the elements are arranged in the Map.

 * It means, we can’t assume any order while iterating over keys and values of a HashMap:
 * 
 * However, items in a TreeMap are sorted according to their natural order.
 * 
 * If TreeMap objects cannot be sorted according to natural order then we may make use of a 
 * Comparator or Comparable to define the order in which the elements are arranged within the Map:
 * 
 * HashMap allows storing at most one null key and many null values.
 * 
 * However, TreeMap doesn’t allow a null key but may contain many null values.
 * 
 * A null key isn’t allowed because the compareTo() or the compare() method throws a NullPointerException:
 * If we’re using a TreeMap with a user-defined Comparator, then it depends on the implementation of the 
 * compare() method how null values get handled.
 * 
 * 
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Collections.synchronizedMap(aMap)
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * A convenient decorator to create fully synchronized map
 * 
 * Return type is Collections.SynchronizedMap instance. It wraps around passed map interface and marks all map
 * methods as synchronized effectively making it similar to Hashtable.
 * 
 * 
 * 
 * @@@@@@@@@@@
 * WeakHashMap
 * @@@@@@@@@@@
 * 
 * WeakHashMap is a hashtable-based implementation of the Map interface, with keys that are of a WeakReference type
 * 
 * An entry in a WeakHashMap will automatically be removed when its key is no longer in ordinary use, 
 * meaning that there is no single Reference that point to that key.
 * 
 * When the garbage collection (GC) process discards a key, its entry is effectively removed from the map, 
 * so this class behaves somewhat differently from other Map implementations.
 * 
 * 
 * Keys inserted gets wrapped in java.lang.ref.WeakReference
 * 
 * Useful only if the desired lifetime of cache entries is determined by external reference to the key not value.
 * 
 *  
 * 
 * ----------------
 * Strong Reference:
 * ----------------
 * The strong reference is the most common type of Reference that we use in our day to day programming:
 * Integer prime = 1;
 * 
 * The variable prime has a strong reference to an Integer object with value 1. 
 * Any object which has a strong reference pointing to it is not eligible for GC.
 * 
 * ---------------
 * Soft References
 * ---------------
 * Simply put, an object that has a SoftReference pointing to it won’t be 
 * garbage collected until the JVM absolutely needs memory.
 * 
 * Let’s see how we can create a SoftReference in Java:
 * 
 * Integer prime = 1;  
 * SoftReference<Integer> soft = new SoftReference<Integer>(prime); 
 * prime = null;
 * The prime object has a strong reference pointing to it.
 * 
 * Next, we are wrapping prime strong reference into a soft reference. After making that strong reference null, 
 * a prime object is eligible for GC 
 * but will be collected only when JVM absolutely needs memory.
 * 
 * ---------------
 * Weak References
 * ---------------
 * The objects that are referenced only by weak references are garbage collected eagerly; 
 * the GC won’t wait until it needs memory in that case.
 * We can create a WeakReference in Java in the following way:
 * 
 * Integer prime = 1;  
 * WeakReference<Integer> soft = new WeakReference<Integer>(prime); 
 * prime = null;
 * 
 * When we made a prime reference null, the prime object will be garbage collected in the next GC cycle, 
 * as there is no other strong reference pointing to it.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * References of a WeakReference type are used as keys in WeakHashMap
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * WeakHashMap as an Efficient Memory Cache
 * Let’s say that we want to build a cache that keeps big image objects as values, and image names as keys. 
 * We want to pick a proper map implementation for solving that problem.
 * 
 * Using a simple HashMap will not be a good choice because the value objects may occupy a lot of memory. 
 * What’s more, they’ll never be reclaimed from the cache by a GC process, 
 * even when they are not in use in our application anymore.
 * 
 * Ideally, we want a Map implementation that allows GC to automatically delete unused objects. 
 * When a key of a big image object is not in use in our application in any place, that entry will be deleted from memory.
 * 
 * Fortunately, the WeakHashMap has exactly these characteristics. Let’s test our WeakHashMap and see how it behaves:
 * 
 * 
 * 
 * 
 * The fundamental difference between WeakHashMap and other Map classes like HashMap, IdentityHashMap and EnumMap 
 * is that its keys are WeakReferences, which means both key and value becomes eligible to garbage collection 
 * if a key is no longer referenced from elsewhere in the program.
 * 
 * This property makes WeakHashMap a good candidate for using as Cache in memory constraint 
 * environment because Map itself will take care of removing unused Mapping.
 * 
 * You can use WeakHashMap if you are storing mapping in a memory constraint environment and you are ok 
 * with keys disappearing suddenly. Since WeakHashMap uses keys with WeakReference they become eligible for GC 
 * once the external reference to the key is removed. It's often used as Cache in Java.
 * 
 * ^^^^^^^^^^
 * Interfaces
 * ^^^^^^^^^^ 
 * Map <- Sorted Map <-NavigableMap
 * 
 * 
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * Working of Fail fast Iterator
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * 
 * ------------------------
 * Concurrent Modification: 
 * ------------------------
 * Concurrent Modification: Concurrent Modification in programming means to modify an object 
 * concurrently when another task is already running over it. For example, in Java to modify 
 * a collection when another thread is iterating over it. Some Iterator implementations 
 * (including those of all the general purpose collection implementations provided by the JRE) 
 * may choose to throw ConcurrentModificationException if this behavior is detected.
 * 
 * 
 * //Concurrent modification exception need not happen only in multiple thread. It can happen in the same thread
 * 
 */

class Employee {

    String name;

    public Employee(String nm) {
        this.name = nm;
    }
}

class HashMapKeyNullValue {

    Employee e1;

    public void displayHashMapKeyNullValue() {

        Employee e2 = null;
        Map map = new HashMap();

        map.put(e2, "25");
        System.out.println("Getting the Value When e2 is set as KEY");
        System.out.println("e2 : " + map.get(e2));
        System.out.println("e1 : " + map.get(e1));
        System.out.println("null : " + map.get(null));

        map.put(e1, "");
        System.out.println("Getting the Value when e1 is set as KEY");
        System.out.println("e2 : " + map.get(e2));
        System.out.println("e1 : " + map.get(e1));
        System.out.println("null : " + map.get(null));

        map.put(null, null); // null as key and null as value
        System.out.println("Getting the Value when setting null as KEY and null as value");
        System.out.println("e2 : " + map.get(e2));
        System.out.println("e1 : " + map.get(e1));
        System.out.println("null : " + map.get(null));

        map.put(null, "30");
        System.out.println("Getting the Value when setting only null as KEY");
        System.out.println("e2 : " + map.get(e2));
        System.out.println("e1 : " + map.get(e1));
        System.out.println("null : " + map.get(null));
    }
}

class HashMapTester {

    public static void hashMapDemoWhenEqualsContractNotImplemented() {
        DogWithoutEqualsContract d1 = new DogWithoutEqualsContract("red");
        DogWithoutEqualsContract d2 = new DogWithoutEqualsContract("black");
        DogWithoutEqualsContract d3 = new DogWithoutEqualsContract("white");
        DogWithoutEqualsContract d4 = new DogWithoutEqualsContract("white");
        HashMap<DogWithoutEqualsContract, Integer> hashMap = new HashMap<DogWithoutEqualsContract, Integer>();
        hashMap.put(d1, 10);
        hashMap.put(d2, 15);
        hashMap.put(d3, 5);
        hashMap.put(d4, 20);
        // print size
        System.out.println(hashMap.size());
        // loop HashMap
        for (Entry<DogWithoutEqualsContract, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()
                .toString() + " - " + entry.getValue());
        }
    }

    public static void hashMapDemoWhenEqualsContractImplemented() {
        DogWithEqualsContractImplemented d1 = new DogWithEqualsContractImplemented("red");
        DogWithEqualsContractImplemented d2 = new DogWithEqualsContractImplemented("black");
        DogWithEqualsContractImplemented d3 = new DogWithEqualsContractImplemented("white");
        DogWithEqualsContractImplemented d4 = new DogWithEqualsContractImplemented("white");
        HashMap<DogWithEqualsContractImplemented, Integer> hashMap = new HashMap<DogWithEqualsContractImplemented, Integer>();
        hashMap.put(d1, 10);
        hashMap.put(d2, 15);
        hashMap.put(d3, 5);
        hashMap.put(d4, 20);
        // print size
        System.out.println(hashMap.size());
        // loop HashMap
        for (Entry<DogWithEqualsContractImplemented, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()
                .toString() + " - " + entry.getValue());
        }

    }
}

class DogWithEqualsContractImplemented {
    String color;

    DogWithEqualsContractImplemented(String c) {
        color = c;
    }

    public boolean equals(Object o) {
        return ((DogWithEqualsContractImplemented) o).color == this.color;
    }

    public int hashCode() {
        return color.length();
    }

    public String toString() {
        return color + " dog";
    }
}

class DogWithEqualsContractImplementedComparableImplemented implements Comparable {
    String color;
    int size;

    DogWithEqualsContractImplementedComparableImplemented(String c, int s) {
        color = c;
        size = s;
    }

    public boolean equals(Object o) {
        return ((DogWithEqualsContractImplementedComparableImplemented) o).color == this.color;
    }

    public int hashCode() {
        return color.length();
    }

    public String toString() {
        return color + " dog";
    }

    @Override
    public int compareTo(Object o) {
        return ((DogWithEqualsContractImplementedComparableImplemented) o).size - this.size;
    }
}

class DogWithoutEqualsContract {
    String color;

    DogWithoutEqualsContract(String c) {
        color = c;
    }

    public String toString() {
        return color + " dog";
    }
}

class TreeMapTester {
    public static void treeMapDemoWhenComparableNotImplemented() {

        DogWithEqualsContractImplemented d1 = new DogWithEqualsContractImplemented("red");
        DogWithEqualsContractImplemented d2 = new DogWithEqualsContractImplemented("black");
        DogWithEqualsContractImplemented d3 = new DogWithEqualsContractImplemented("white");
        DogWithEqualsContractImplemented d4 = new DogWithEqualsContractImplemented("white");
        TreeMap<DogWithEqualsContractImplemented, Integer> treeMap = new TreeMap<DogWithEqualsContractImplemented, Integer>();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
        // print size
        System.out.println(treeMap.size());
        // loop HashMap
        for (Entry<DogWithEqualsContractImplemented, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey()
                .toString() + " - " + entry.getValue());
        }

    }

    public static void treeMapDemoWhenComparableImplemented() {

        DogWithEqualsContractImplementedComparableImplemented d1 = new DogWithEqualsContractImplementedComparableImplemented("red", 30);
        DogWithEqualsContractImplementedComparableImplemented d2 = new DogWithEqualsContractImplementedComparableImplemented("black", 20);
        DogWithEqualsContractImplementedComparableImplemented d3 = new DogWithEqualsContractImplementedComparableImplemented("white", 10);
        DogWithEqualsContractImplementedComparableImplemented d4 = new DogWithEqualsContractImplementedComparableImplemented("white", 10);
        TreeMap<DogWithEqualsContractImplementedComparableImplemented, Integer> treeMap = new TreeMap<DogWithEqualsContractImplementedComparableImplemented, Integer>();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
        // print size
        System.out.println(treeMap.size());
        // loop HashMap
        for (Entry<DogWithEqualsContractImplementedComparableImplemented, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey()
                .toString() + " - " + entry.getValue());
        }

    }

}

class EnumMapTester {
    enum Importance {
        Low, Medium, High, Critical
    }

    enum Size {
        Small, Normal, Large
    }

    public static void enumMapExample() {
        // Create an EnumMap.
        EnumMap<Importance, String> e = new EnumMap<>(Importance.class);
        e.put(Importance.Low, "=Low");
        e.put(Importance.High, "=High");

        // Get values from the map.
        String value1 = e.get(Importance.Low);
        String value2 = e.get(Importance.High);

        System.out.println(value1);
        System.out.println(value2);
    }

    public static void performanceGainExample() throws Exception {
        EnumMap<Importance, String> e = new EnumMap<>(Importance.class);
        e.put(Importance.Low, "=Low");
        e.put(Importance.High, "=High");

        HashMap<Importance, String> h = new HashMap<>();
        h.put(Importance.Low, "=Low");
        h.put(Importance.High, "=High");

        long t1 = System.currentTimeMillis();

        // ... Check EnumMap.
        for (int i = 0; i < 10000000; i++) {
            if (!e.containsKey(Importance.Low)) {
                throw new Exception();
            }
        }

        long t2 = System.currentTimeMillis();

        // ... Check HashMap.
        for (int i = 0; i < 10000000; i++) {
            if (!h.containsKey(Importance.Low)) {
                throw new Exception();
            }
        }

        long t3 = System.currentTimeMillis();

        // ... Times.
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
    }

    public static void containsKeyExample() {
        EnumMap<Importance, String> e = new EnumMap<>(Importance.class);
        e.put(Importance.Critical, "=Critical");
        e.put(Importance.High, "=High");

        // This is not present.
        System.out.println(e.containsKey(Importance.Low));

        // This is present in the EnumMap.
        if (e.containsKey(Importance.Critical)) {
            System.out.println(1);
        }
    }

    public static void keySetExample() {

        EnumMap<Size, Integer> e = new EnumMap<>(Size.class);
        e.put(Size.Small, 10);
        e.put(Size.Normal, 20);

        // Get keys and loop over them.
        Set<Size> set = e.keySet();
        for (Size s : set) {
            System.out.println(s);
        }
    }

}

class IdentityHashMapTester {

    public static void identityHashMapExamples() {
        IdentityHashMap<String, String> identityMap = new IdentityHashMap<String, String>();

        identityMap.put("sony", "bravia");
        identityMap.put(new String("sony"), "mobile");

        // size of identityMap should be 2 here because two strings are different objects
        System.out.println("Size of IdentityHashMap: " + identityMap.size());
        System.out.println("IdentityHashMap: " + identityMap);

        identityMap.put("sony", "videogame");

        // size of identityMap still should be 2 because "sony" and "sony" is same object
        System.out.println("Size of IdentityHashMap: " + identityMap.size());
        System.out.println("IdentityHashMap: " + identityMap);

        identityMap.put("sony", "trouble");

        // size of identityMap still should be 2 because "sony" and "sony" is same object
        System.out.println("Size of IdentityHashMap: " + identityMap.size());
        System.out.println("IdentityHashMap: " + identityMap);
    }

    public static void testOrder() {
        final Map<String, String> map = new IdentityHashMap<String, String>();
        for (int i = 0; i < 10; ++i)
            map.put("Line #" + i, "Value #" + i);
        for (final String key : map.keySet())
            System.out.println(key);
    }

}

class LinkedHashMapTester {

    public static void linkedHashMapDemoWithEqualsContractImplemented() {
        DogWithEqualsContractImplemented d1 = new DogWithEqualsContractImplemented("red");
        DogWithEqualsContractImplemented d2 = new DogWithEqualsContractImplemented("black");
        DogWithEqualsContractImplemented d3 = new DogWithEqualsContractImplemented("white");
        DogWithEqualsContractImplemented d4 = new DogWithEqualsContractImplemented("white");
        LinkedHashMap<DogWithEqualsContractImplemented, Integer> linkedHashMap = new LinkedHashMap<DogWithEqualsContractImplemented, Integer>();
        linkedHashMap.put(d1, 10);
        linkedHashMap.put(d2, 15);
        linkedHashMap.put(d3, 5);
        linkedHashMap.put(d4, 20);
        for (Entry<DogWithEqualsContractImplemented, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}

class Order {
    int orderId;
    String details;

    public Order(int orderid, String details) {
        this.orderId = orderid;
        this.details = details;
    }
}

class WeakHashMapTester {

    public static void weakHashMapDemo() {

        Map<Order, Integer> order = new WeakHashMap<>();

        order.put(new Order(1, "Bat"), 100);
        order.put(new Order(2, "Cat"), 200);
        order.put(new Order(3, "Hat"), 300);

        // These objects of order instances does not have any strong reference from any other place besides the
        // weakhashMap reference hence garbage collector when run is free to reclaim the weak references;
        System.out.println("Before Garbage collection size of map " + order.size());

        System.gc();
        for (int i = 0; i < 10000; i++) {

            if (order.size() != 0) {
                System.out.println("At iteration " + i + " the map still holds the reference on someDataObject");
            } else {
                System.out.println("somDataObject has finally been garbage collected at iteration " + i + ", hence the map is now empty");
                break;
            }
        }

        System.out.println("After Garbage collection size of map " + order.size());

    }

}

public class MapTester {

    public static void main(String[] args) throws Exception {
        IdentityHashMapTester.identityHashMapExamples();
        IdentityHashMapTester.testOrder();
        EnumMapTester.enumMapExample();
        EnumMapTester.performanceGainExample();


        // The following code results in exception since the object does not implement a comparable interface
        // Exception in thread "main" java.lang.ClassCastException: collection.learning.DogWithEqualsContractImplemented
        // cannot be cast to java.lang.Comparable
        // at java.util.TreeMap.compare(TreeMap.java:1188)
        // at java.util.TreeMap.put(TreeMap.java:531)
        // at collection.learning.TreeMapTester.treeMapDemoWhenComparableNotImplemented(MapTester.java:432)
        // at collection.learning.MapTester.main(MapTester.java:572)

        // TreeMapTester.treeMapDemoWhenComparableNotImplemented();

        // When comparable has been implemented
        TreeMapTester.treeMapDemoWhenComparableImplemented();

        LinkedHashMapTester.linkedHashMapDemoWithEqualsContractImplemented();

        System.out.println("HashMap Key Value Not Examples");
        HashMapKeyNullValue hashMapKeyNullValue = new HashMapKeyNullValue();
        hashMapKeyNullValue.displayHashMapKeyNullValue();

        // fast fast iterator example
        // FailfastIterator.fastFastIteratorDemo();

        // weakHashMap reference
        WeakHashMapTester.weakHashMapDemo();

    }

}

class FailfastIterator {

    public static void fastFastIteratorDemo() {
        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        Iterator iterator = cityCode.keySet()
            .iterator();

        while (iterator.hasNext()) {
            System.out.println(cityCode.get(iterator.next()));

            // adding an element to Map
            // exception will be thrown on next call
            // of next() method.
            cityCode.put("Istanbul", "Turkey");
        }
    }
}
