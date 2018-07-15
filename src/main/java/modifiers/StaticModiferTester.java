package modifiers;

/* We cannot access instance members directly from static areas
 * 
 * But we can access from instance area directly.
 * 
 * We can access static members from both static and instance area directly.
 * 
 * Static modifier:
 * ******* 
 * Rule #1: Where it can be used
 * *******
 * It can declared for inner class, methods and variables.
 * We cannot declare top level class with static modifier but inner classes as static. in
 * that they are called static nested classes.
 * 
 * *******
 * Rule #2
 * *******
 * From where it can be accessed.
 * From static methods we cannot access instance members directly.
 * However we can access static methods from anywhere which includes instance methods and static
 * methods.
 * 
 * public class A
{
    static int x = 10;
    int y = 20;
    public static void main(String args[])
	{
		Test t1 = new Test();
		t1.x = 888;
		t1.y = 999;
		
		Test t2 = new Test();
		System.out.println(t2.x);//888
		System.out.println(t2.y);//20
	}
}
 * 
 * Static and instance variables can be over-ridden successfully by local variables
 * public class A
{
    int x = 10;
    static int y = 20;
    public static void main(String args[])
	{ int x = 9;
	int y = 1;
	}
} //This will not lead to compile time error.
 * 
 * 
 * *******
 * Rule #3
 * *******
 * 
 * Overloading of static methods allowed including main method. 
 * However JVM will be able to call main(String[] args) only. The other methods will become
 * just like normal method calls.
 * 
 * 
 * public class A
{
    
    public static void main(String[] args){
        System.out.println("String[] args");
        int []a = {1,2,3,4};
        main(a);
    }
	
	
    public static void main(int[] args){
        System.out.println("int[] args");
    }
	
}
Output: 
String[] args
int[] args
 * 
 * *******
 * Rule #4
 * *******
 * Inheritance concept applicable for static methods include main method.
 * 
 * class P{
 * public static void main(String []args){
 * 	System.out.println("Parent main method");
 * }
 * }
 * 
 * class C extends P{
 * }
 * save the program as P.java.
 * When we compile the code then two .class files will be generated 
 * ie P.class and C.class files
 * 
 * if we execute P.class then output shall "Parent main method'
 * if we execue C.class then also output shall be "Parent main method" because if the child
 * does not contain the main method then parent main method shall be called.
 * 
 * Thus prooving the fact that static method follows inheritance and main method can also 
 * be inherited.
 * 
 * *******
 * Rule #5
 * *******
 * It seems over-riding but method hiding.
 * 
 * class P{
 * public static void main(String []args){
 * 	System.out.println("Parent main method");
 * }
 * }
 * 
 * class C extends P{
 * public static void main(String []args){
 * 	System.out.println("Child main method");
 * }
 * }
 * 
 * if we execute P.class then output shall "Parent main method'
 * if we execute C.class then also output shall be "Child main method"
 * 
 * For static methods overloading and inheritance concepts are applicable. But over-riding
 * concepts are not applicable.
 * 
 * But instead of over-riding, method hiding concepts is applicable.
 * 
 * It is shown in the demo program below through testing.
 * 
 * *******
 * Rule #6
 * ******* 
 * Abstract static combination is illegal for methods.
 * static methods compulosary should have implementation. abstract methods should not have 
 * implelementation.
 * 
 * *******
 * Rule #7
 * *******
 * For class (or static) methods, the method according to the type of reference is called, 
 * not according to the abject being referred, 
 * which means method call is decided at compile time
 * 
 * *******
 * Rule #8
 * *******
 * For instance (or non-static) methods, the method is called according to the type 
 * of object being referred, not according to the type of reference, 
 * which means method calls is decided at run time.
 * 
 * *******
 * Rule #9
 * *******
 * An instance method cannot override a static method, and a static method cannot 
 * hide an instance method. 
 * For example, the following program has two compiler errors.
 *  Java program to show that if static methods are redefined by
   a derived class, then it is not overriding but hidding. 
 
// Superclass
class Base {
     
    // Static method in base class which will be hidden in subclass 
    public static void display() {
        System.out.println("Static or class method from Base");
    }
     
     // Non-static method which will be overridden in derived class 
     public void print()  {
         System.out.println("Non-static or Instance method from Base");
    }
}
 
// Subclass
class Derived extends Base {
     
    // Static is removed here (Causes Compiler Error) 
    public void display() {
        System.out.println("Non-static method from Derived");
    }
     
    // Static is added here (Causes Compiler Error) 
    public static void print() {
        System.out.println("Static method from Derived");
   }
}
 * 
 * Compiler error:
 * error: display() in Derived cannot override display() in Base
    public void display() {
                ^
  overridden method is static
prog.java:45: error: print() in Derived cannot override print() in Base
    public static void print() {
                       ^
  overriding method is static
2 errors
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class StaticModiferTester {

	public static void main(String[] args) {
		Base obj1 = new Derived();

		// As per overriding rules this should call to class Derive's static
		// overridden method. Since static method can not be overridden, it
		// calls Base's display()
		obj1.display();

		// Here overriding works and Derive's print() is called
		obj1.print();

	}

}

/*
 * Java program to show that if static method is redefined by a derived class,
 * then it is not overriding.
 */

// Superclass
class Base {

	// Static method in base class which will be hidden in subclass
	public static void display() {
		System.out.println("Static or class method from Base");
	}

	// Non-static method which will be overridden in derived class
	public void print() {
		System.out.println("Non-static or Instance method from Base");
	}
}

// Subclass
class Derived extends Base {

	// This method hides display() in Base
	public static void display() {
		System.out.println("Static or class method from Derived");
	}

	// This method overrides print() in Base
	public void print() {
		System.out.println("Non-static or Instance method from Derived");
	}
}