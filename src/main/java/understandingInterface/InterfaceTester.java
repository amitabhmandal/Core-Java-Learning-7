package understandingInterface;

/*
 * *******
 * Rule #1
 * *******
 * We can’t create instance(interface can’t be instantiated) of interface 
 * but we can make reference of it that refers to the Object of its implementing class
 * 
 * 
 * *******
 * Rule #2
 * *******
 * A class can implement more than one interface.
 * 
 * 
 * *******
 * Rule #3
 * *******
 * An interface can extends another interface or interfaces (more than one interface) .
 * 
 * 
 * *******
 * Rule #4
 * *******
 * A class that implements interface must implements all the methods in interface
 * 
 * 
 * *******
 * Rule #5
 * *******
 * All the methods are public and abstract all methods in an interface are public 
 * even if we do not specify public with method names. 
 * and all the fields are public, static, and final. Therefore, data fields must be initialized.
 * 
 * *******
 * Rule #5
 * *******
 * It is used to achieve multiple inheritance.
 * 
 * *******
 * Rule #6
 * *******
 * It is used to achieve loose coupling.
 *
 * 
 * *******
 * Rule #7
 * *******
 * New features added in interfaces in JDK 9 
 * From Java 9 onwards, interfaces can contain following also
 * Static methods
 * Private methods
 * Private Static methods
 * 
 * *******
 * Rule #8
 * *******
 * Interface in a class:
 * 
 * we can declare an interface as a member of a class or interface that is called nesting
 * of interfaces.
 * Interfaces (or classes) can have only public and default access specifiers 
 * when declared outside any other class (Refer this for details).
 * This interface declared in a class can either be default, public, protected not private.
 * 
 * While implementing the interface, we mention the interface as 
 * c_name.i_name where c_name is the name of the class 
 * in which it is nested and i_name is the name of the interface itself.
 * 
 * 	 * The access specifier in above example is default. We can assign public,
	 * protected or private also. Below is an example of protected. In this
	 * particular example, if we change access specifier to private, we get compiler
	 * error because a derived class tries to access it.
 * 
 * *******
 * Rule #9
 * ******* 
 * Interface in another Interface
 * 
 * An interface can be declared inside another interface also. 
 * We mention the interface as i_name1.i_name2 where i_name1 is the name of the interface 
 * in which it is nested and i_name2 is the name of the interface to be implemented.
 * 
 * Within an interface only public members are allowed. Hence if we try to add anything
 * protected or public it will lead to compile time error.
 * 
 * interface Test
	{
	    protected interface Yes
	    {
	        void show();
	    }
	}
 * compile time error: 
 * illegal combination of modifiers: public and protected
   protected interface Yes
 * 
 * 
 * 
 * ********
 * Rule #10
 * ********
 * Difference between Abstract class and Interface
 * 
 * Type of methods: Interface can have only abstract methods. Abstract class can have abstract and non-abstract methods. 
   From Java 8, it can have default and static methods also.
 * 
 * Final Variables: Variables declared in a Java interface are by default final. 
 * An abstract class may contain non-final variables.
 * 
 * Type of variables: Abstract class can have final, non-final, static and non-static variables. 
 * Interface has only static and final variables.
 * 
 * Implementation: Abstract class can provide the implementation of interface.	
 * Interface can’t provide the implementation of abstract class.
 * 
 * Inheritance vs Abstraction: A Java interface can be implemented using keyword 
 * “implements” and abstract class can be extended using keyword “extends”.
 * 
 * Multiple implementation: An interface can extend another Java interface only, 
 * an abstract class can extend another Java class and implement multiple Java interfaces.
 * 
 * Accessibility of Data Members: Members of a Java interface are public by default. 
 * A Java abstract class can have class members like private, protected, etc.
 * 
 * ********
 * Rule #11
 * ********
 * Marker interface in Java
 * It is an empty interface (no field or methods). Examples of marker interface are Serializable, 
 * Clonnable and Remote interface. All these interfaces are empty interfaces.
 * 
 * 
 * 
 * ********
 * Rule #12
 * ********
 * 
 * 
 * 
 * *******
 * Rule #7
 * *******
 * 
 */
public class InterfaceTester {

	public static void main(String[] args) {
		OuterClassContainingDefaultInterface.InterfaceInsideClass obj;
		TestClassInterfaceInsideClass t = new TestClassInterfaceInsideClass();
		obj = t;
		obj.show();

		OuterInterface.InnerInterface innerInterface;
		ChildofInnerInterface childOfInnerInterface = new ChildofInnerInterface();

		innerInterface = childOfInnerInterface;

		innerInterface.show();
	}

}

class OuterClassContainingDefaultInterface {
	/*
	 * The access specifier in above example is default. We can assign public,
	 * protected or private also. Below is an example of protected. In this
	 * particular example, if we change access specifier to private, we get compiler
	 * error because a derived class tries to access it.
	 */

	interface InterfaceInsideClass {
		void show();
	}
}

class TestClassInterfaceInsideClass implements OuterClassContainingDefaultInterface.InterfaceInsideClass {
	public void show() {
		System.out.println("Method of Interface inside class");
	}
}

interface OuterInterface {
	interface InnerInterface

	{

		/*
		 * Access specifier is public even if we have not written public. If we try to
		 * change access specifier of interface to anything other than public, we get
		 * compiler error. Remember, interface members can only be public..
		 */
		void show();
	}
}

class ChildofInnerInterface implements OuterInterface.InnerInterface {

	public void show() {
		System.out.println("Method of an Interface Inside Interface");

	}

}
