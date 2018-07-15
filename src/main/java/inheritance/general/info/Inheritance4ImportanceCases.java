package inheritance.general.info;

//Is the following declaration allowed

//These are examples of Cycle Inheritance and not allowed in Java ofcourse it is not required.

/*
Case A:
class A extends A{
	
}


Case B:
class B1 extends A1{
	
}

Case C:
class A1 extends B1{
	
}

*/

public class Inheritance4ImportanceCases {

	public static void main(String[] args) {
		// Case 1:

		// Parent reference and parent object
		// Can access parent specific method
		// cannot access child specific method as parent is not aware of it. If we try
		// to access
		// it will lead to compilation error
		//
		// Parent p1 = new Parent();
		// p1.display();
		// p1.parentMethod();

		// Case 2: parent reference child object
		System.out.println("Case 2: parent reference child object");
		Parent p2 = new Child();
		p2.display(); // Child specific method will be called if the child method has overridden
		// the parent method. This is example of Polymorphism
		p2.parentMethod();
		// p2.childMethod(); --> This statement will lead to compilation error
		// Through parent reference child specific methods cannot be accessed which is
		// not present
		// in the parent.
		// Only methods which are present in the parent will be accessible to the parent
		// reference
		// which has been overridden

		// Case 3: Child reference parent Object
		// Child c1 = new Parent();
		// This will result in compilation error stating incompatible Types: Found
		// parent
		// required child.

		// case 4:
		// Child reference and child Object
		System.out.println("case 4: Child reference and child Object ");

		// Can access parent methods by default
		// can access child methods without any issue.
		// The object type being assigned will dictate whether the child method shall be
		// called
		// or the parent method will be called.

		// Constructors shall be called in the order of parent to child to initialize
		// Objects
		// however Object shall not be created
		Child c2 = new Child();

		c2.display();
		c2.parentMethod();
		c2.childMethod();

		// Conclusions :
		// Through Parent reference we can access only parent methods + parent methods
		// in child
		// which has been overridden. This is how we achieve Polymorphism

		// Through child reference we can access both parent methods and child methods.
	}

}

// If our class doesnot extend any other class then our class is direct class of
// Object
// However if the class extends any other class then the class is indirect child
// class of Object
// This shows multi-level inheritance

// Interfaces can extend any number of interfaces simultaneously. Hence Java
// Provides
// Support for Multiple inheritance with respect to Interfaces.

class Parent {

	public Parent() {
		System.out.println("Parent Constructor called");
	}

	public void display() {
		System.out.println("Parent Display Method called");
	}

	public void parentMethod() {
		System.out.println("Parent Method called");
	}
}

class Child extends Parent {

	public Child() {
		System.out.println("Child Constructor called");
	}

	public void display() {
		System.out.println("Child Display Method called");
	}

	public void childMethod() {
		System.out.println("child Method called");
	}

}

// Java multiple inheritance leads to ambiguity problem which is also called the
// diamond problem
// HEnce mutiple inheritance not allowed to Java with respect to classes

// Example

class FirstParent {

	public void display() {

	}
}

class SecondParent {
	public void display() {

	}
}

// If the following code would have been allowed. Then the child class
// would be calling which display method leads to ambiguity hence
// multiple inheritance not allowed.
// class MultipleParentChild extends FirstParent , SecondParent{
// //
// }

// However with respect to interfaces multiple inheritance is allowed.

interface FirstParentInterface {
	public void display();

}

interface SecondParentInterface {
	public void display();
}

interface MultipleChildInterface extends FirstParentInterface, SecondParentInterface {

}

class childMultipleChildInterface implements MultipleChildInterface {

	// Since this is a unqiue implementation hence there is no ambiguity problem
	// Hence multiple inheritance is allowed with respect to interfaces

	// Even though multiple method declarations are available but there is only one
	// implementation. Thus there is no chance of ambiguity problem in interfaces
	public void display() {
		// TODO Auto-generated method stub

	}

}