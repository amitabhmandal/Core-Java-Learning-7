package collection.learning.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/* Internal Data Structure: Hashtable datastructure
 * 
 * Insertion order is not preserved. It is based on hashCode of keys
 * 
 * Duplicate keys not allowed. Values can be duplicated
 * 
 * Heterogenous types allowed for both key and values
 * 
 * null not applicable for the key and not applicable for the value.
 * 
 * Implements serializable and cloneable but not Random Access
 * 
 * Every method present in hashtable is synchronized 
 * 
 * Hashtable object is thread safe.
 * 
 * It is best suited if the operation is search
 * 
 * 
 * 
 * 
 * 
 */
public class HashrableDemo {

    public static void main(String[] args) {
        defaultConstructors();

    }

    public static void defaultConstructors() {
        // Default capacity = 11 , default load factor =0.75
        Hashtable h1 = new Hashtable();

        // Default capacity = user defined int capacity , default load factor =0.75
        Hashtable h2 = new Hashtable(4);

        // Default capacity = 32 , user defined load factor =0.75
        Hashtable h3 = new Hashtable(32, 0.6f);

        // interconversion between map objects
        Map m = new HashMap();
        Hashtable h4 = new Hashtable(m);

    }
}
