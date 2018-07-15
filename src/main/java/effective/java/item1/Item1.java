package effective.java.item1;

/* *******************************************************************
 * CONSIDER STATIC FACTORY METHODS INSTEAD OF CONSTRUCTORS
 * *******************************************************************
 * Ways to create an Instance of Class
 * 	- Using Constructor
 * 	- Using Static Factory methods
 *  - Using Class.forName()
 *  - Using Clone
 *  - Using object deserialization
 *  
 *  *******************************************************************
 *  However in General: There is only one way to create an Object
 *  *******************************************************************
 *  Within the Java language, the only way to create an object is by calling its constructor, 
 *  be it explicitly or implicitly. Using reflection results in a call to the constructor 
 *  method, deserialization uses reflection to call the constructor, factory methods wrap 
 *  the call to the constructor to abstract the actual construction and 
 *  cloning is similarly a wrapped constructor call.
 * *******************************************************************
 * Difference between static factory and factory method design pattern
 * *******************************************************************
 * Factory method design Pattern is AKA instance factory method
 * 
 * Define an interface for creating an object, but let subclasses decide which class to 
 * instantiate. Factory Method lets a class defer instantiation to subclasses.
 * 
 * 
 * *******************************************************************
 * Advantages
 * *******************************************************************
 * 	- Unlike constructors, they have names
 *  - Unlike constructors, they are not required to create a new Object each time they are 
 *    invoked
 *  - Unlike constructors, they can return an Object of their subtype of their return type
 *  - They reduce verbosity of creating parametized type instance.
 * 
 * *******************************************************************
 *  Disadvantages
 * *******************************************************************
 * - Classes without public or protected constructors cannot be subclassed
 * - They are not readily distinguishable from other static factory methods
 * 
 * 
 *  
 *  
 *  
 *  Naming Conventions
 *  - valueOf
 *  - of
 *  - getInstance
 *  - newInstance
 *  - getType
 *  - newType
 *  
 * 
 * 
 * 
 * 
 * 
 */

public class Item1 {

	public static void main(String[] args) {
		Boolean boolean1 = new Boolean("true");
		Boolean boolean2 = new Boolean("true");
		Boolean boolean3 = new Boolean("true");

		System.out.println(System.identityHashCode(boolean1));
		System.out.println(System.identityHashCode(boolean2));
		System.out.println(System.identityHashCode(boolean3));

		/*
		 * So if you use the Boolean.valueOf() method Java will take care that there are
		 * only two Boolean objects at max, one representing true and the other
		 * representing false. If you use .valueOf(true) it will return a handle to the
		 * true-object and if you use . valueOf(false) it will return a handle to the
		 * false-object. Thus you don't create any unnecessary objects and thus they
		 * won't have to be deleted by the garbage collector
		 * 
		 * 
		 * If you use "new Boolean()" instead this doesn't work and Java will create a
		 * new Object every time. Thus you will have a ton of unnecessary objects that
		 * will probably be freed quite quickly and have to be cleaned by the garbage
		 * collector. So this costs you more memory (for all the objects), time for the
		 * allocation (when creating new Booleans) and time for the deallocation (when
		 * the objects are caught by the garbage collector), while giving you no
		 * advantages at all
		 * 
		 */
		Boolean valueOf1 = Boolean.valueOf("true");
		Boolean valueOf2 = Boolean.valueOf("true");
		Boolean valueOf3 = Boolean.valueOf("false");

		System.out.println(System.identityHashCode(valueOf1));
		System.out.println(System.identityHashCode(valueOf2));
		System.out.println(System.identityHashCode(valueOf3));

		// Unlike constructors, they can return an Object of their subtype of their
		// return type

		// Example: From the Collections.class there are many static factory methods
		//We have the freedom of returning any sub type of List
		/**
		 * Returns an unmodifiable view of the specified list. This method allows
		 * modules to provide users with "read-only" access to internal lists. Query
		 * operations on the returned list "read through" to the specified list, and
		 * attempts to modify the returned list, whether direct or via its iterator,
		 * result in an <tt>UnsupportedOperationException</tt>.
		 * <p>
		 *
		 * The returned list will be serializable if the specified list is serializable.
		 * Similarly, the returned list will implement {@link RandomAccess} if the
		 * specified list does.
		 *
		 * @param list
		 *            the list for which an unmodifiable view is to be returned.
		 * @return an unmodifiable view of the specified list.
		 * 
		 *         public static <T> List<T> unmodifiableList(List<? extends T> list) {
		 *         return (list instanceof RandomAccess ? new
		 *         UnmodifiableRandomAccessList<>(list) : new UnmodifiableList<>(list));
		 *         }
		 * 
		 */
	}

}
