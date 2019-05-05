package operators;


/* Equality Operators (== and !=)
 * 
 * We can equality operators for every primitive type including boolean without any compilation
 * error.
 * 
 * == operator if applied to objects then returns true only iff
 * they point to the same address or
 * the point to the same reference and there should be some relationship through IS-A
 * else it will result in incompatible comparison type as a compiler error 
 * 
 * Difference between == operator and equals method.
 * == operator meant for reference comparison in case of objects and value comparison in case
 * of primtives
 * 
 * equals method meant for content comparison in case of objects and cannot be used with 
 * primitives
 * 
 */

public class EqualityOperatorTester {

	public static void main(String[] args) {
	
		System.out.println(10 == 20); // true
		System.out.println('a' == 'b');
		
		//char shall be promoted to int type before comparison is done
		System.out.println('a' == 97);
		
		//'a' will be promoted to 97.0 and then comparison shall be done.
		System.out.println('a' == 97.0);
		
		//boolean can be compared
		System.out.println(false == false);
		
		
		// == operator returns true if they are pointing to the same object or same address.
		//else it would return false.
		//Thus == operator when used with objects does reference comparison
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		
		Thread t3 = t1;
		System.out.println(t1 == t2);
		System.out.println(t1 == t3);
		
		
		// == operator can only comparable type as there should be some relationship 
		//between objects
		Thread t = new Thread();
		
		Object o = new Object();
		
		String s = new String("Amitabh");
		
		//This comparison is successful as there is some relational between thread and Object
		System.out.println(t == o);
		
		//This comparison is successful as there is some relational between string and Object
		System.out.println(s == o);
		
		//Will result in compile time type
		// incomparable types: Thread and String
		
		//This comparison cannot happen as there is no relationship cannot occur as there is 
		//no relationship between thread and String
		// System.out.println(t == s);
		// ^
		// 1 error
		//System.out.println(t == s);
		
		
		//Difference between == operator and equals method
		
		String s1 = new String("Amitabh");
		String s2 = new String("Amitabh");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

		
		//For any object reference r,
		//r == null will results in false.
		
		//Null == null always true.
		System.out.println( null == null); //true
		
		String s3 = new String("mandal");
		System.out.println( s3 == null); // false
		
		String s4 = null;
		System.out.println( s4 == null); // true

	}

}
