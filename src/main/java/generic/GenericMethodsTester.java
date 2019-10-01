package generic;

/*
Generic Methods :: 

	If you don’t want whole class or interface to be generic, you want only some part of class as generic, 
	then generic methods will be solution for this
	
	
	The syntax for defining generic methods is as follows,
	
	<type-Parameters> return_type method_name(parameter list)
	{
	 
	}
	
	
	Generic methods can be static or non-static.
	
	Generic class as well as non-generic class can have generic methods.
	
	========================
	Constructors As Generics
	========================
	
	As we all know that constructors are like methods but without return types. Like methods, constructors also can be generic. 
	Even non-generic class can have generic constructors. Here is an example in which constructor of a non-generic 
	class is defined as generic.
	
	
	
*/

public class GenericMethodsTester {

	public void GenericMethodsTester() {

	}

	public static void main(String[] args) {
		NonGenericClass.genericMethod(new Integer(123)); // Passing Integer type as an argument

		NonGenericClass.genericMethod("I am string"); // Passing String type as an argument

		NonGenericClass.genericMethod(new Double(25.89));

		// Creating object by passing Integer as an argument

		NonGenericClass nonGen1 = new NonGenericClass(123);

		// Creating object by passing String as an argument

		NonGenericClass nonGen2 = new NonGenericClass("abc");

		// Creating object by passing Double as an argument

		NonGenericClass nonGen3 = new NonGenericClass(25.69);
	}

}

class NonGenericClass {
	static <T> void genericMethod(T t1) {
		T t2 = t1;

		System.out.println(t2);
	}

	public <T> NonGenericClass(T t1) {
		T t2 = t1;

		System.out.println(t2);
	}
}
