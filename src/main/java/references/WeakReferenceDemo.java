package references;

import java.lang.ref.WeakReference;

/* Weak Reference Objects are not the default type/class of Reference Object and 
 * they should be explicitly specified while using them.
 * 
 * This type of reference is used in WeakHashMap to reference the entry objects .
 * 
 * If JVM detects an object with only weak references (i.e. no strong or soft references
 *  linked to any object object), this object will be marked for garbage collection.
 *  
 *  To create such references java.lang.ref.WeakReference class is used.
 *  
 *  These references are used in real time applications while establishing a 
 *  DBConnection which might be cleaned up by Garbage Collector when the application 
 *  using the database gets closed.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

class Gfg {
    // code
    public void x() {
        System.out.println("Understanding Soft Reference");
    }
}

public class WeakReferenceDemo {

    public static void main(String[] args) {

        // Strong Reference
        Gfg g = new Gfg();
        g.x();

        // Creating Weak Reference to Gfg-type object to which 'g'
        // is also pointing.

        WeakReference<Gfg> weakref = new WeakReference<Gfg>(g);

        // Now, Gfg-type object to which 'g' was pointing earlier
        // is available for garbage collection.
        // But, it will be garbage collected only when JVM needs memory.
        g = null;

        // You can retrieve back the object which
        // has been weakly referenced.
        // It succesfully calls the method.
        g = weakref.get();

        g.x();
        
    }

}
