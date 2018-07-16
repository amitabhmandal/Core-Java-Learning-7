package collection.learning.map;
/*
* @@@@@@@
* HashMap
* @@@@@@@
* 
* DataStructure -->
* Underlying data structure is Hashtable
* 
* Insertion Order -->
* Insertion order is not preserved and it is based on hashCode of Keys.
* 
* Duplicate Keys -->
* Duplicate keys not allowed but duplicate values allowed
* 
* Heterogeneous Support -->
* Heterogeneous objects are allowed for both key and value.
* 
* Null Keys -->
* Null can be inserted only once for Key however multiple time for values
* 
* Interfaces it supports -->
* Implements Serializable and CLoneable but not Random Access
* 
* Use a HashMap if you don’t need to visit the keys in sorted order.
* HashMap is implemented as a hash table, and there is no ordering on keys or values. 
* 
* It allows Null Keys(only once) and multiple Null values
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
* Only one null key can be inserted.
* 
* Multiple null values can be inserted
* 
* Difference between HashMap and Hashtable
* It is almost the same except in case of hashmap it allows unsynchronized methods and allows
* null keys when compared with Hashtable
* 
* Default hashCode implementation of hashmap
    public int hashCode() {
        int h = 0;
        Iterator<Entry<K,V>> i = entrySet().iterator();
        while (i.hasNext())
            h += i.next().hashCode();
        return h;
    }
* 
* 
* What are the differences between HashMap and TreeMap?

HashMap implements Map interface while TreeMap implements SortedMap interface. A Sorted Map interface is a child of Map.
HashMap implements Hashing, while TreeMap implements Red-Black Tree(a Self Balancing Binary Search Tree). Therefore all differences between Hashing and Balanced Binary Search Tree apply here.
Both HashMap and TreeMap have their counterparts HashSet and TreeSet. HashSet and TreeSet 
implement Set interface. In HashSet and TreeSet, we have only key, no value, these are 
mainly used to see presence/absence in a set. For above problem, we can’t use 
HashSet (or TreeSet) as we can’t store counts. An example problem where we would 
prefer HashSet (or TreeSet) over HashMap (or TreeMap) is to print all distinct elements 
in an array.

What are differences between HashMap and HashTable in Java?

HashMap is non synchronized. It is not-thread safe and can’t be shared between many threads 
without proper synchronization code whereas Hashtable is synchronized. It is thread-safe 
and can be shared with many threads.
HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any
 null key or value.
HashMap is generally preferred over HashTable if thread synchronization is not needed
HashMap is an advanced version and improvement on the Hashtable. HashMap was created 
later.


What are differences between HashMap and HashSet?

HashMap stores key value pairs (for example records of students as value and roll number 
as key) and HashSet stores only keys (for example a set if integers).
HashSet internally uses HashMap to store keys

*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        nullKeyInsertionCheck();
        fourConstructors();
        heterogenousExample();

        importantMethodsExample();

        copyOneHashMapFromAnother();

        getMethodNullWhenKeyNotPresent();

        checkKeyExample();

        keySetExample();

        clearDemo();

        cloneDemo();

        containsValueDemo();

        entrySetDemo();

        keySetDemo();

        synchronizeDemo();

        serializeDemo();
        
        checkSizeIncreaseDemo();
    }

    public static void checkSizeIncreaseDemo() {
        HashMap m = new HashMap();
        
        m.put(1, 0);
        m.put(2, 0);
        m.put(3, 0);
        m.put(4, 0);
        m.put(5, 0);
        m.put(6, 0);
        m.put(7, 0);
        m.put(8, 0);
        m.put(9, 0);
        m.put(10, 0);
        m.put(11, 0);
        m.put(12, 0);
        m.put(13, 0);
        m.put(14, 0);
        m.put(15, 0);
        m.put(16, 0);
        
        System.out.println("Size of Map = " + m.size());
        m.put(17, 0);
        m.put(18, 0);
        m.put(19, 0);
        m.put(20, 0);
        System.out.println("Size of Map = " + m.size());
    }
    public static void serializeDemo() {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        // Adding elements to HashMap
        hmap.put(11, "AB");
        hmap.put(2, "CD");
        hmap.put(33, "EF");
        hmap.put(9, "GH");
        hmap.put(3, "IJ");
        try {
            FileOutputStream fos = new FileOutputStream("hashmap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hmap);
            oos.close();
            fos.close();
            System.out.printf("Serialized HashMap data is saved in hashmap.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void synchronizeDemo() {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(2, "Anil");
        hmap.put(44, "Ajit");
        hmap.put(1, "Brad");
        hmap.put(4, "Sachin");
        hmap.put(88, "XYZ");

        Map map = Collections.synchronizedMap(hmap);
        Set set = map.entrySet();
        synchronized (map) {
            Iterator i = set.iterator();
            // Display elements
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
        }
    }

    public static void keySetDemo() {
        HashMap hashmapobj1 = new HashMap();

        hashmapobj1.put(1001, "I");

        hashmapobj1.put(1002, "Love");

        hashmapobj1.put(1003, "Java");

        // seting the keyset

        Set keyset = hashmapobj1.keySet();

        // check key set values

        System.out.println("Key values are: " + keyset);
    }

    public static void entrySetDemo() {
        HashMap hashmapobj1 = new HashMap();

        hashmapobj1.put(1001, "I");

        hashmapobj1.put(1002, "Love");

        hashmapobj1.put(1003, "Java");

        // create set of hashmap

        Set set = hashmapobj1.entrySet();

        System.out.println("Set values: " + set);
    }

    public static void containsValueDemo() {

        HashMap hashmapobj1 = new HashMap();

        hashmapobj1.put(1001, "I");

        hashmapobj1.put(1002, "Love");

        hashmapobj1.put(1003, "Java");

        // check existence of value 'I'

        System.out.println("Check if value 'I' exists: " + hashmapobj1.containsValue("I"));

        // check existence of value 'India'

        System.out.println("Check if value 'India' exists: " + hashmapobj1.containsValue("India"));
    }

    public static void cloneDemo() {
        // create a hashmap

        HashMap hashmapobj1 = new HashMap();

        hashmapobj1.put(1001, "I");

        hashmapobj1.put(1002, "Love");

        hashmapobj1.put(1003, "Java");

        // Creating a new hashmap

        HashMap hashmapobj2 = new HashMap();

        // Using clone method

        hashmapobj2 = (HashMap) hashmapobj1.clone();

        System.out.println("Cloned 2nd Map: " + hashmapobj2);

        hashmapobj2.clear();
        System.out.println("Cloned 2nd Map after clear: " + hashmapobj2);
        System.out.println("1st Map without clear being called: " + hashmapobj1);

        System.out.println("1st Map Address: " + hashmapobj1.hashCode() + " 2nd Map Address" + hashmapobj2.hashCode());
    }

    public static void clearDemo() {
        // create a hashmap

        HashMap hashmapobj = new HashMap();

        hashmapobj.put(1001, "I");

        hashmapobj.put(1002, "Love");

        hashmapobj.put(1003, "Java");

        // using size() method

        System.out.println(" Size of hashmap is " + hashmapobj.size());
        System.out.println(" HashCode of  hashmap is before clear()" + hashmapobj.hashCode());

        // using clear() method

        hashmapobj.clear();

        // using size() method after clearing the hashmap
        System.out.println(" HashCode of  hashmap is After clear()" + hashmapobj.hashCode());

        System.out.println(" Size of hashmap after clearing is " + hashmapobj.size());
    }

    public static void keySetExample() {
        // Create a HashMap
        HashMap<String, String> hmap = new HashMap<String, String>();

        // Adding few elements
        hmap.put("Key1", "Jack");
        hmap.put("Key2", "Rock");
        hmap.put("Key3", "Rick");
        hmap.put("Key4", "Smith");
        hmap.put("Key5", "Will");

        // Getting Set of HashMap keys
        /* public Set<K> keySet(): Returns a Set view of the keys contained
         * in this map. The set is backed by the map, so changes to the map 
         * are reflected in the set, and vice-versa. 
         */
        Set<String> keys = hmap.keySet();

        System.out.println("Set of Keys contains: ");

        /* If your HashMap has integer keys then specify the iterator like
         * this: Iterator<Integer> it = keys.iterator();
         */
        Iterator<String> it = keys.iterator();
        // Displaying keys. Output will not be in any particular order
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void checkKeyExample() {
        // Creating a HashMap of int keys and String values
        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();

        // Adding Key and Value pairs to HashMap
        hashmap.put(11, "Chaitanya");
        hashmap.put(22, "Pratap");
        hashmap.put(33, "Singh");
        hashmap.put(44, "Rajesh");
        hashmap.put(55, "Kate");

        // Checking Key Existence
        boolean flag = hashmap.containsKey(22);
        System.out.println("Key 22 exists in HashMap? : " + flag);

        boolean flag2 = hashmap.containsKey(55);
        System.out.println("Key 55 exists in HashMap? : " + flag2);

        boolean flag3 = hashmap.containsKey(99);
        System.out.println("Key 99 exists in HashMap? : " + flag3);
    }

    public static void getMethodNullWhenKeyNotPresent() {
        // Create a HashMap
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        // add elements to HashMap
        hmap.put(1, "AA");
        hmap.put(2, "BB");
        hmap.put(3, "CC");
        hmap.put(4, "DD");

        // Getting values from HashMap
        String val = hmap.get(4);
        System.out.println("The Value mapped to Key 4 is:" + val);

        /* Here Key "5" is not mapped to any value so this 
         * operation returns null.
         */
        String val2 = hmap.get(5);
        System.out.println("The Value mapped to Key 5 is:" + val2);
    }

    public static void copyOneHashMapFromAnother() {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        // add elements to HashMap
        hmap.put(1, "AA");
        hmap.put(2, "BB");
        hmap.put(3, "CC");
        hmap.put(4, "DD");

        // Create another HashMap
        HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();

        // Adding elements to the recently created HashMap
        hmap2.put(11, "Hello");
        hmap2.put(22, "Hi");

        // Copying one HashMap "hmap" to another HashMap "hmap2"
        hmap2.putAll(hmap);

        // Displaying HashMap "hmap2" content
        System.out.println("HashMap 2 contains: " + hmap2);
    }

    public static void importantMethodsExample() {
        /* This is how to declare HashMap */
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        /*Adding elements to HashMap*/
        hmap.put(12, "Chaitanya");
        hmap.put(2, "Rahul");
        hmap.put(7, "Singh");
        hmap.put(49, "Ajeet");
        hmap.put(3, "Anuj");

        /* Display content using Iterator*/
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

        /* Get values based on key*/
        String var = hmap.get(2);
        System.out.println("Value at index 2 is: " + var);

        /* Remove values based on key*/
        hmap.remove(3);
        System.out.println("Map key and values after removal:");
        Set set2 = hmap.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterator2.next();
            System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
            System.out.println(mentry2.getValue());
        }
    }

    public static void heterogenousExample() {
        HashMap m = new HashMap();
        m.put(1, "amitabh");
        m.put("mandal", "boy");

        System.out.println("heterogenous Example: " + m);

    }

    public static void fourConstructors() {

        Map m = new HashMap();

        // static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
        // static final int MAXIMUM_CAPACITY = 1 << 30;
        // static final float DEFAULT_LOAD_FACTOR = 0.75f;
        // first constructor : default capacity = 16 / default fill ratio = 0.75
        HashMap h1 = new HashMap();

        // Second constructor : int capacity = specified / default fill ratio = 0.75
        HashMap h2 = new HashMap(6);

        // Third constructor : int capacity = specified / specified fill ratio = 0.80
        HashMap h3 = new HashMap(6, 0.80f);

        // Fourth constructor : Can work on interconversion of Other Map Objects
        HashMap h4 = new HashMap(m);

    }

    public static void nullKeyInsertionCheck() {

        // Hence only one null key is allowed
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(null, 1);
        System.out.println(hashMap);

        // Duplicate Keys not allowed

        // Duplicate values allowed
        System.out.println(hashMap.put(null, 1));
        System.out.println(hashMap);
        System.out.println(hashMap.put(null, 2));
        System.out.println(hashMap);
        System.out.println(hashMap.put(null, 3));
        System.out.println(hashMap);

        // Insertion order is not preserved as it using hashCode of Keys and not values.

        System.out.println(hashMap.put(1, 3));
        System.out.println(hashMap.put(2, 3));
        System.out.println(hashMap.put(100, 3));
        System.out.println(hashMap.put(3, 3));
        System.out.println(hashMap.put(-1, 3));
        System.out.println(hashMap.put(4, 3));
        System.out.println(hashMap.put(5, null));
        System.out.println(hashMap.put(600, null));
        System.out.println(hashMap);

        // HashMap best suited for frequent search operations hence it should be used there
        // It implements serializable and cloneable but not Random Access

    }
}
