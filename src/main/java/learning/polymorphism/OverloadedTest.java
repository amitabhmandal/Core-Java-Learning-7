package learning.polymorphism;

//When methods are overloaded.
//When method having same name but different argument types.

//For Overloading the methods need not present in the same class
//They can be present in the same class.
//One can be present in the class and one can be inherited.
//Or both can be inherited

//If two methods of a class (whether both declared in the same class, or both inherited
//by a class, or one declared and one inherited) have the same name but signatures
//that are not override-equivalent, then the method name is said to be overloaded.

//In overloading method resolution is always taken care by compiler based on reference type.
//Thus it is also known as compile time polymorphism or static polymorphism or early binding.
public class OverloadedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// case 1: Primitive Type Promotions
		byte b = 1;
		PrimitiveTypePromotions.m1(10);
		PrimitiveTypePromotions.m1(10.5f);
		PrimitiveTypePromotions.m1('a');
		PrimitiveTypePromotions.m1(b);

		// case 2: Null Check Promotions
		// null is valid for String and Object type. If the match can be found
		// at child type then child will be given higher priority.
		NullChildParentHierarchy.m1(null);
		NullChildParentHierarchy.m1(new Object());
		NullChildParentHierarchy.m1("Amitabh");

		// case 3: Null handled by multiple types at the same level
		// This will lead to compilation error if the overloaded methods are string and
		// stringbuffer
		NullHandledMultipleMethod.m1(null);

		// case 4:
		Test.m1(10, 10.5f);
		Test.m1(10.5f, 10);
		// This will lead to compilation problem: Reference to m1 is ambiguous
		// Test.m1(10, 10);
		// This will lead to compilation problem: cannot find symbol compiler error
		// location
		// class Test
		// Test.m1(10.5f, 10.5f);

		// case 5: General Method Vs var-arg method
		MatchVargArg.m1(1);  //General method
		MatchVargArg.m1();   // Var Arg method 
		MatchVargArg.m1(10, 20); //Var Arg method

		
		//case 6: in case of inheritance
		InheritanceOverloadedTester InheritanceOverloadedTester = new InheritanceOverloadedTester();
		Animal animalReferenceAnimalObject = new Animal();
		Monkey monkeyReferenceMonkeyObject = new Monkey();
		Animal animalRefMonkeyObject = new Monkey();
		
		InheritanceOverloadedTester.m1(animalReferenceAnimalObject);//animal version
		InheritanceOverloadedTester.m1(monkeyReferenceMonkeyObject);//monkey version
		
		//In overloading compiler is always going to check the reference type
		//and not the actual object type hence it is going to always call the animal
		//version (((((V. IMP )))))
		InheritanceOverloadedTester.m1(animalRefMonkeyObject);//animal version
		
		
	}
}

class Animal {
	
}

class Monkey extends Animal {
	
}

class InheritanceOverloadedTester {
	public void m1(Animal a) {
		System.out.println("Animal Version called");
	}
	
	public void m1(Monkey a) {
		System.out.println("Monkey Version called");
	}
}
// case 5:
class MatchVargArg {
	public static void m1(int i) {
		System.out.println("Int Argument called = " + i);
	}
	
	//Will be able to process 0 or more arguments.
	
	//In this case the passed values can be accessed by array of Types depending on 
	//how the variable has been declared
	
	//Var Args method has least priority when being executed. It is handled in the similar
	//fashion as switch with default statements
	public static void m1(int... i) {
		System.out.println("Var Arg Called " + i);
	}
	
	//If no element is being passed and still being accessed then it will lead
	//to  java.lang.ArrayIndexOutOfBoundsException exception
	
	//If only i is set to be displayed then it will display the hashcode of the array of int
}

// case 4:
class Test {
	public static void m1(int i, float f) {
		System.out.println("int float version ");
	}

	public static void m1(float i, int f) {
		System.out.println("float int version ");
	}
}

// Case 3: If Null can be handled by multiple objects at the same level

class NullHandledMultipleMethod {
	public static void m1(String i) {
		System.out.println("String Argument called = " + i);
	}

	public static void m1(Object i) {
		System.out.println("Object Argument called = " + i);
	}

	// If both the methods are using the arguments which are at the same level then
	// it will
	// lead to ambiguity problem and will lead to compilation errors.

	// public static void m1(StringBuffer i) {
	// System.out.println("StringBuffer Argument called = " + i);
	// }
}

// Case 2: Null will be passed the child argument containing method. If it can
// handle it then
// it will do it else it be passed higher up in the hierarchy.
// This will happen only in case of child-parent relationship
class NullChildParentHierarchy {

	// Since the child class type is exact match hence the String method shall be
	// called
	// when null is being passed as input argument.
	public static void m1(String i) {
		System.out.println("String Argument called = " + i);
	}

	public static void m1(Object i) {
		System.out.println("Object Argument called = " + i);
	}

	// If both the methods are using the arguments which are at the same level then
	// it will
	// lead to ambiguity problem and will lead to compilation errors.

	// public static void m1(StringBuffer i) {
	// System.out.println("StringBuffer Argument called = " + i);
	// }
}

// Case 1: Primitive Type Promotions
class PrimitiveTypePromotions {
	// Widening conversions:
	// char->int
	// byte->short->int->long->float->double
	// Here are the Type Promotion Rules:
	//
	// All byte and short values are promoted to int.
	// If one operand is a long, the whole expression is promoted to long.
	// If one operand is a float, the entire expression is promoted to float.
	// If any of the operands is double, the result is double.

	// General Rule followed by compiler in Case of Overloading.
	// If exact method match is not there, then compiler will not raise compile time
	// error immediately.
	// Compiler will try to promote the existing argument to the next level as per
	// widening rules. This process will be continued till all possible promotions.
	// Still if the matched method is not available then we will get compile time
	// error
	//
	public static void m1(int i) {
		System.out.println("Int Argument called = " + i);
	}

	public static void m1(float i) {
		System.out.println("Float Argument called = " + i);
	}
}
