package wrapper;

public class AutoBoxingOverloading {

	// Order in which overloaded methods shall be executed

	// Widening ---> Highest Priority
	// AutoBoxing
	// Number Version (This concludes that it follows Inheritance heirarchy before selecting.
	// Object Version (int to Integer(AutoBoxing) ---> Object (Widening)
	// Var Args ---> Least Priority
	// method executed

	public static void autoBoxing(int... x) {
		System.out.println("Var -args Executed");
	}

//	public static void autoBoxing(Integer m1) {
//		System.out.println("AutoBoxing Executed");
//	}

//	public static void autoBoxing(long m1) {
//		System.out.println("Widening Executed");
//	}
	
	public static void autoBoxing(Object o) {
		System.out.println("Object version Executed");
	}
	
	
	public static void autoBoxing(Number o) {
		System.out.println("Number version Executed");
	}

	// This method will lead to compilation error as there is no
	// concept where in a primitive int type can be migrated to Long datatype
	// widening only happens between primitive type but there is no relation between
	// the Integer to Long
	// public static void autoBoxing(Long m1) {
	// System.out.println("AutoBoxing Widening Executed");
	// }

	public static void main(String[] args) {
		int x = 10;
		autoBoxing(10);
	}

}
