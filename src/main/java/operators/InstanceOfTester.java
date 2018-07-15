package operators;

/*
 * instanceof operator -- to check whether an object is of particular type or not?
 * r instanceof x 
 * r object reference
 * x class or interface name
 * 
 * 
 * null instanceof X always result in false.
 * 
 * 
 * 
 * 
 */
public class InstanceOfTester {

	public static void main(String[] args) {
		Thread t = new Thread();

		System.out.println(t instanceof Thread);
		System.out.println(t instanceof Object);
		System.out.println(t instanceof Runnable);

		// The following comparison will result into compiler error
		/*
		 * error: incompatible types: Thread cannot be converted to String
		 * System.out.println(t instanceof String); ^
		 * 
		 * 
		 * Hence to use instanceof operator there has to be some relationship between
		 * the objects hence they have to have a parent-child relationship or self
		 * relationship
		 */

		// System.out.println(t instanceof String);

		// * null instanceof X always result in false.
		//For any class or interface x, null instanceof x is always false.
		System.out.println(null instanceof Thread);
		System.out.println(null instanceof Object);
		System.out.println(null instanceof Runnable);

	}

}
