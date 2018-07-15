package modifiers;

import java.lang.reflect.Modifier;

/* Whenever we are writing our classes we can provide information to the JVM
 * 
 * For instance from 
 * where we can access the class from anywhere or not //public
 * Whether child can access the class //final
 * Whether object creation possible or not. //abstract
 * 
 * Possible Modifier
 * Public
 * Private
 * default
 * Protected
 * 
 * Final
 * Abstract
 * Static
 * Synchronized
 * 
 * Native
 * Strictfp
 * Transient
 * Volatile
 * 
 * -----------------------------------
 * Top Level Allowed Class Modifier
 * -----------------------------------
 * Public
 * 
 * Default - Can be accessible from within the same package. If tried to access the class from 
 * outside the package then it will lead to compiler error.
 * By default nothing needs to be specified.
 * Default level access is also known as package level access.
 * 
 * Abstract
 * 
 * Final - It is a modifier applicable for class, method and variable. It is applicable 
 * everywhere :)
 * Final and abstract cannot be used together.
 * 
 * Final Methods - Whatever methods parent by default available to the child through inheritance.
 * If the child not satisfied with parent method implementation then child is allowed to 
 * redefine that method based on it's requirements. This process is called over-riding.
 * If the parent method class is declared as final then we cannot over-ride that method in the 
 * child class because it's implementation is final.
 * 
 * Final Class - If the class is final. 
 * No one is allowed to extend that class. 
 * We cannot create child class. 
 * If the class cannot be extended nothing can be over-ridden. 
 * Thereby inheritance not allowed for final class. 
 * Thus we can safely conclude is all the methods in a final class is final. 
 * However within the final class the variables is not necessary final. 
 * Advantage of Using Final : We can achieve security as no one can override.
 * Disadvantage of Using Final: Inheritance not possible 
 * Disadvantage of Using Final method: Polymorphism not possible.
 * 
 * 
 * Abstract - cannot create Objects
 * It is expected that the child shall provide the complete definition through inheritance.
 * It also means that the class has some definitions however for all the methods the 
 * definition is not complete.
 * Abstract and final cannot be clubbed together. 
 * Abstract class does not mean all methods are abstract however abstract method in a class 
 * means that the abstract class has to be created.
 * Abstract is applicable for classes and methods. Abstract not applicable for variables.
 * If we are extending abstract class and the child class not able to provide implementation 
 * for each and every abstract method of parent class then we will have to declare 
 * it as abstract.
 * In class level final abstract combination is illegal.
 * Within final class we cannot have abstract methods.
 * But within abstract class we can have final methods.
 * 
 * Abstract methods:
 * Only declaration is available but not implementation.
 * Hence abstract method declaration should ends with;
 * public abstract void m1(); //valid declaration
 * public abstract void m1(){} //invalid declaration.
 * Child class is responsible to provide implementation for parent class abstract method. 
 * Biggest advantage of abstract method then it is mandatory for the child class to provide
 * implementation. If not provided abstract then child may provide implementation or not.
 * 
 * If any modifier talks about implementation then it cannot go along with abstract hence
 * the following modifiers cannot be come together with abstract method
 * - native
 * - static
 * - private 
 * - strictfp
 * - synchronized
 * - final
 * 
 * 
 * strictfp[Strict floating point] class modifier
 *  - Came in Java 1.2v
 *  - Applicable for classes and methods but not applicable in variables. Similar to abstract which
 *  is applicable only for classes and methods.
 *  
 *  strictfp is a keyword in java used for restricting floating-point calculations and ensuring same result on every 
 *  platform while performing operations in the floating-point variable.
 *  
 *  Floating point calculations are platform dependent i.e. different output(floating-point values) is achieved 
 *  when a class file is run on different platforms(16/32/64 bit processors). To solve this types of issue,
 *  strictfp keyword was introduced in JDK 1.2 version by following IEEE 754 standards for floating-point calculations.
 *  
 *  strictfp modifier is used with classes, interfaces and methods only.
 *  
 *  When a class or an interface is declared with strictfp modifier, then all methods declared in the class/interface, 
 *  and all nested types declared in the class, are implicitly strictfp.
 *  
 *  Even though at class level strictfp is implemented it can further be declared at method level like this. It will not lead
 *  to compilation error:
 *  strictfp class StrictfpClassTester{
    public strictfp void display(){
        System.out.println("Even more nothing");
        
    }
}
 *  strictfp cannot be applied for constructors.
 *  
 *  strictfp cannot be used with abstract methods. However, it can be used with abstract classes/insterfaces.
 *  
 *  Since methods of an interface are implicitly abstract, strictfp cannot be used with any method inside an interface.
 *  
 *  strictfp interface Test 
{
    double sum();
    strictfp double mul(); // compile-time error here
}

 *  
 *  
 * 
 * If anything else taken then it will lead to compile time error.
 * 
 * --------------------------------------
 * But for Inner Classes Allowed Modifier
 * -------------------------------------
 * Private
 * 
 * Protected: Protected = within package accessibility + subclass(es) outside package.
 * Only accessible inside the same package plus outside the package within child classes through inheritance only.
 *  
 * Static 
 * Along with top level class modifier which includes
 * Public
 * Default
 * Abstract
 * Final
 * Strictfp
 * 
 * -----------------------------------
 * access modifier vs access specifier
 * -----------------------------------
 * Everything in Java is Access Modifier
 * 
 * 
 * If a class is declared as Public then we can access that class from anywhere.
 * 
 * ------------------------------------------------------
 * Member modifier : Methods or Variable level modifiers
 * ------------------------------------------------------
 * 
 * ++++++++++++++++++++++++++++++++++++
 * public members (methods + variables) 
 * ++++++++++++++++++++++++++++++++++++
 * If a member is declared public then it can be accessed from anywhere but the corresponding class should be public
 * 
 * Example
 * pack1;
 * class A{
 * 	public void m1(){
 * 		System.out.println("Inside class A: method m1()");
 * 	}
 * }
 * 
 * pack2;
 * import pack1.*;
 * class B{
 * 	public static void main(String[] args){
 * 		A a = new A();
 * 		a.m1(); //This will lead to compilation error as even though the members are public but the class itself is not public
 * 		//Hence we need to check the class modifiers even before we conclude that the member is accessible from outside the
 * 		//package
 * 	}
 * }
 * 
 * ++++++++++++++++++++++++++++++++++++
 * Default members
 * ++++++++++++++++++++++++++++++++++++
 * If a member is declared as default then we can access that member only within the current package. From outside
 * of the current package we cannot access it. Hence default access is also known as package level access.
 * 
 * 
 * ++++++++++++++++++++++++++++++++++++
 * private members
 * ++++++++++++++++++++++++++++++++++++
 * If a member is private, then we can access the member only within the class.
 * Ie from outside of the class we cannot access it.
 * 
 * private abstract is also illegal. 
 * abstract method should be available to the child class to provide implementation.
 * private method is not available to the child class. Hence both contradict each other hence they are illegal combination
 * 
 * Classes or interface can not be declared as 
 * private.
 * 
 * ***********************************
 * protected members
 * ***********************************
 * If a member is declared as protected then we can access that member within the 
 * current package however outside the package we can only access through inheritance.
 * 
 * A very important rule. Only child references "of that class" can be used to access 
 * protected members 
 * outside the package. If parent reference is used then it will lead to compile time error.
 * Hence protected members if accessed outside the parent package then the child reference
 * "of that class" should be only used.
 * 
 * Protected Access Means = Default (ie within current package) + 
 * Child classes through Inheritance
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class ClassLevelModifierTester {

	public strictfp static void main(String[] args) {
		StrictfpTester sp = new StrictfpTester();
		System.out.println(sp.sum());
		checkingStrictfpConcept();

	}

	public static void checkingStrictfpConcept() {
		checkModifiers(Impl.class, "someInterfaceMethod");
		checkModifiers(Impl.class, "someClassMethod");
		checkModifiers(Impl.class, "someClassMethod2");

		checkModifiers(Impl.class.getInterfaces()[0], "someInterfaceDefaultMethod");
		checkModifiers(StrictInterface.InnerTest.class, "innerMethod");

	}

	public static void checkModifiers(Class clazz, String m) {
		try {
			int mod = clazz.getDeclaredMethod(m, new Class[0]).getModifiers();
			String res = m + " modifiers: " + Modifier.toString(mod);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}

class StrictfpTester {
	public strictfp double sum() {
		double num1 = 10e+10;
		double num2 = 6e+08;
		return (num1 + num2);
	}
}

strictfp interface StrictInterface {

	void someInterfaceMethod();

	void someInterfaceDefaultMethod();

	class InnerTest {
		public static void innerMethod() {
		}
	}
}

class Impl implements StrictInterface {

	public void someInterfaceMethod() {
	}

	public strictfp void someClassMethod() {
	}

	public void someClassMethod2() {
	}

	public void someInterfaceDefaultMethod() {
		// TODO Auto-generated method stub

	}
}

/*
 * Why an outer class can not be private
 * 
 * As we already know a field defined in a class using private keyword can only
 * be accessible within the same class and is not visible to outside world.
 * 
 * So what will happen if we will define a class private, that class will only
 * be accessible within the entity in which it is defined which in our case is
 * its package?
 * 
 * Let’s consider below example of class A
 * 
 * package com.example; class A { private int a = 10;
 * 
 * // We can access a private field by creating object of same class inside the
 * same class
 * 
 * // But realy no body creates object of a class inside the same class public
 * void usePrivateField() { A objA = new A(); System.out.println(objA.a); } }
 * 
 * Field ‘a’ is declared as private inside ‘A’ class and because of it ‘a’ field
 * becomes private to class ‘A' and can only be accessed within ‘A’.
 * 
 * Now let’s assume we are allowed to declare class ‘A’ as private, so in this
 * case class ‘A’ will become private to package ‘com.example’ and will not be
 * accessible from outside of the package.
 * 
 * So defining private access to the class will make it accessible inside the
 * same package which default keyword already do for us, Therefore there is no
 * benefit of defining a class private it will only make things ambiguous.
 * 
 * 
 */