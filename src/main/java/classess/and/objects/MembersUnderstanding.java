package classess.and.objects;

// Static initialization block cannot access instance variables
// if it tries to do that then it will lead to compilation problems

// Static initialization blocks can access only static variables and members.

// Multiple static initialization blocks
// You can define multiple static initialization blocks within your class and the order(starting from top) 
// in which they are defined is the order in which they are executed at the time when the class loads.

// If there are two or more static/initializer blocks then they are executed in the order in which they appear in the source code.

public class MembersUnderstanding {

	public static void main(String[] args) {

		// Static Members directly accessed with Class Name
		StaticComponents.staticVariable = 20;
		StaticComponents.staticMethod();

		MembersUnderstanding m1 = new MembersUnderstanding();
		m1.toString();
	}

	static {
		System.out.println("MainClass SIB");
	}

}

// Static initialization block in inheritance

// When a class which has extended another class, is executed. 
// A static initialization block of a superclass is always executed before the static initialized block of a subclass. 
class StaticComponents {
	static int staticVariable;

	static {
		System.out.println("StaticComponents SIB");
		staticVariable = 10;
		if (staticVariable < 10) {
			throw new NullPointerException();
		}

	}

	static void staticMethod() {
		System.out.println("From StaticMethod");
		System.out.println(staticVariable);
	}

}

class B {
	static // static initialization block of A
	{
		System.out.println("Static block of B");
	}
}

class A extends B {
	static // static initialization block of B
	{
		System.out.println("Static block of A");
	}

	public static void main(String... ar) {
	}

}

class MyTest {

	static {
		System.out.println("Initialize called from SIB");
		initialize();
	}

	private static int sum;

	public static int getSum() {
		System.out.println("Initialize called from static method");
		initialize();
		return sum;
	}

	private static MyTest myTest;
	

	static {
		System.out.println("Display before Initialized");
	}
	private static boolean initialized = false;

	static {
		System.out.println("Display After Initialized "+ initialized);
	}
	
	private static void initialize() {
		if (!initialized) {
			System.out.println("Initialize called ");
			for (int i = 0; i < 100; i++)
				sum += i;
			initialized = true;
			System.out.println("sum = " + sum);
		}
	}
	
	
	public static void main(String[] args) 
    { 
		System.out.println("Before method called initialize field value " + MyTest.initialized);
        System.out.println(MyTest.getSum()); 
    } 
}

 