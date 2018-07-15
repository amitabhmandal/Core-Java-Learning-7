package references;
/* This is the default type/class of Reference Object.
 * 
 * Any object which has an active strong reference are not eligible for garbage collection.
 * 
 * The object is garbage collected only when the variable which was 
 * strongly referenced points to null.
 * 
 * MyClass obj = new MyClass ();
 * 
 * Here ‘obj’ object is strong reference to newly created instance of MyClass, 
 * currently obj is active object so can’t be garbage collected.
 * 
 * obj = null;
 * 
 * //'obj' object is no longer referencing to the instance. 
 * 
 * So the 'MyClass type object is now available for garbage collection.
 * 
 */

public class StrongRefernceDemo {

    public static void main(String[] args) {
        // Strong Reference - by default
        StrongRefernceDemo sfD = new StrongRefernceDemo();
        
        //now elligible for garbage collection
        sfD = null;
    }

}
